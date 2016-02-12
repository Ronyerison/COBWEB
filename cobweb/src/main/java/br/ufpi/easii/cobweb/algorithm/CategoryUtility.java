package br.ufpi.easii.cobweb.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import br.ufpi.easii.cobweb.model.cobweb.Attribute;
import br.ufpi.easii.cobweb.model.cobweb.Instance;
import br.ufpi.easii.cobweb.model.cobweb.NodeInfo;
import br.ufpi.easii.cobweb.model.tree.Node;

/**
 * @author Vanderson Moura
 *
 */
public class CategoryUtility { 

	public CategoryUtility() {
	}
	
	public void calculateCategoryUtility(Node<NodeInfo> currentNode, Instance instance){
		Node<NodeInfo> root = null;
		Queue<Node<NodeInfo>> queue = new LinkedList<Node<NodeInfo>>();
		double intragroupSimilarity = 0; 
		double intergroupSimilarity = 0;
		int instancesQuantity = 0;
		
		for (Attribute attribute : instance.getAttributes()) {
			if(currentNode.getData().getMapProbability().containsKey(attribute.getValue())){
				intragroupSimilarity += currentNode.getData().getMapProbability().get(attribute.getValue()).getQuantity(); 
			}
		}
		
		if(!currentNode.isRoot()){
			root = currentNode.getParent(); 
			while(!root.isRoot()){
				root = root.getParent();
			}
		}
		
		for (Node<NodeInfo> n : root.getChildren()) {
			queue.add(n);
		}
		
		while(!queue.isEmpty()){
			Node<NodeInfo> node = queue.remove();
			instancesQuantity += node.getData().getInstances().size();
			for (Attribute attribute : instance.getAttributes()) {
				if(node.getData().getMapProbability().containsKey(attribute.getValue())){
					intergroupSimilarity += node.getData().getMapProbability().get(attribute.getValue()).getQuantity();
				}
			}
		}
		
		double uc = (2 * Math.pow(intergroupSimilarity,2) - Math.pow(intragroupSimilarity,2))/instancesQuantity;
		currentNode.getData().setUc(uc);
	}
}
