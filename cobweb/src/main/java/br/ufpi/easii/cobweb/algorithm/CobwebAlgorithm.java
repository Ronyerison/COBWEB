/**
 * 
 */
package br.ufpi.easii.cobweb.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufpi.easii.cobweb.model.cobweb.Instance;
import br.ufpi.easii.cobweb.model.cobweb.NodeInfo;
import br.ufpi.easii.cobweb.model.tree.Node;

/**
 * @author Ronyerison
 *
 */
public class CobwebAlgorithm {
	
	private List<Instance> instances;
	private Iterator<Instance> iterator;
	
	public CobwebAlgorithm(List<Instance> instances) {
		this.instances = instances;
		this.iterator = this.instances.iterator();
	}

	public Node<NodeInfo> run(Node<NodeInfo> root) {
		Instance instance = getNextInstance();
		if (isLeaf(root)) {
			createNewTerminal(root, instance);
		} else {
			Node<NodeInfo> rootClone = incorporate(root, instance);
			for (Node<NodeInfo> child : root.getChildren()) {
				updateScore(child, instance);
			}
			
			List<Node<NodeInfo>> clone = cloneChildren(root.getChildren());
			Node<NodeInfo> highestChild = getHighestChild(clone, instance);
			clone.remove(highestChild);
			Node<NodeInfo> secondChild = getHighestChild(clone, instance);
			Node<NodeInfo> mergeNode = merge(highestChild, secondChild);
			Node<NodeInfo> splitNode = split(highestChild, instance);
			Node<NodeInfo> newNode = createNewTerminal(root.clone(), instance);
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Map<String, Node<NodeInfo>> map = new TreeMap(new Comparator<Node<NodeInfo>>() {

				@Override
				public int compare(Node<NodeInfo> o1, Node<NodeInfo> o2) {
					return o1.getData().getUc().compareTo(o2.getData().getUc());
				}
			});
		
			map.put("root", rootClone);
			map.put("higestChild", highestChild);
			map.put("merge", mergeNode);
			map.put("split", splitNode);
			map.put("newNode", newNode);
			
			Iterator<String> it = map.keySet().iterator();
			String key = it.next();
			
			if(key.equals("highestChild")){
				highestChild = getHighestChild(root.getChildren(), instance);
				highestChild.getData().addInstance(instance);
				run(highestChild);
			}else if(key.equals("merge")){
				highestChild = getHighestChild(root.getChildren(), instance);
				int index = root.getChildren().indexOf(secondChild);
				secondChild = root.getChildren().get(index);
				mergeNode = merge(highestChild, secondChild);
				mergeNode.getData().addInstance(instance);
				run(mergeNode);
			}else if(key.equals("split")){
				int index = root.getChildren().indexOf(highestChild);
				splitNode = split(root.getChildren().get(index), instance);
				splitNode.getData().addInstance(instance);
				run(splitNode);
			}else if (key.equals("newNode")) {
				newNode = createNewTerminal(root, instance);
				newNode.getData().addInstance(instance);
				run(newNode);
			}
			
			
		}

		return null;
	}

	private Instance getNextInstance(){
		return iterator.next();
	}
	
	private Double updateScore(Node<NodeInfo> node, Instance instance) {
		return null;
	}

	private Node<NodeInfo> getHighestChild(List<Node<NodeInfo>> children,
			Instance instance) {
		Double scoreMax = Double.MIN_VALUE;
		Node<NodeInfo> higestNode = null;
		for (Node<NodeInfo> node : children) {
			node.getData().setUc(updateScore(node, instance));
			if (node.getData().getUc() > scoreMax) {
				higestNode = node.clone();
				scoreMax = node.getData().getUc();
			}
		}
		return higestNode;
	}

	private Node<NodeInfo> incorporate(Node<NodeInfo> root, Instance instance) {
		root.getData().setUc(updateScore(root, instance));
		root.getData().addInstance(instance);
		
		return root;
	}

	private Node<NodeInfo> createNewTerminal(Node<NodeInfo> root, Instance instance) {
		List<Instance> instances = new ArrayList<Instance>();
		instances.add(instance);
		NodeInfo data = new NodeInfo(instances, 0.0);
		Node<NodeInfo> child = new Node<NodeInfo>(data);
		updateScore(child, instance);
		root.addChild(child);
		
		return child;
	}

	private Node<NodeInfo> merge(Node<NodeInfo> node1, Node<NodeInfo> node2) {
		List<Instance> instances = node1.getData().getInstances();
		instances.addAll(node2.getData().getInstances());
		NodeInfo data = new NodeInfo(instances,
				(node1.getData().getUc() + node2.getData().getUc()) / 2);
		Node<NodeInfo> root = new Node<NodeInfo>(data);
		root.addChild(node1);
		root.addChild(node2);
		return root;
	}

	private Node<NodeInfo> split(Node<NodeInfo> node, Instance instance) {
		List<Node<NodeInfo>> children = new ArrayList<Node<NodeInfo>>();
		for (Node<NodeInfo> child : node.getChildren()) {
			children.add(child.clone());
		}
		Node<NodeInfo> parent = node.getParent().clone();
		parent.removeChild(node);
		parent.getChildren().addAll(children);
		updateScore(parent, instance);
		
		return parent;
	}

	private List<Node<NodeInfo>> cloneChildren(List<Node<NodeInfo>> children) {
		List<Node<NodeInfo>> clone = new ArrayList<Node<NodeInfo>>();
		for (Node<NodeInfo> node : children) {
			clone.add(node.clone());
		}
		return clone;
	}

	private boolean isLeaf(Node<NodeInfo> node) {
		if (node.getChildren().isEmpty()) {
			return true;
		}
		return false;
	}

}
