/**
 * 
 */
package br.ufpi.easii.cobweb.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufpi.easii.cobweb.model.cobweb.Instance;
import br.ufpi.easii.cobweb.model.cobweb.NodeInfo;
import br.ufpi.easii.cobweb.model.tree.Node;


/**
 * @author Ronyerison
 *
 */
public class CobwebAlgorithm {

	public Node<NodeInfo> run(Node<NodeInfo> root, Instance instance){
		if(isLeaf(root)){
			createNewTerminal(root, instance);
			incorporate(root, instance);
		}else{
			incorporate(root, instance);
		}
		for (Node<NodeInfo> child : root.getChildren()) {
			
		}
		
		return null;
	}
	
	private void incorporate(Node<NodeInfo> root, Instance instance) {
		// TODO Auto-generated method stub
		
	}

	private void createNewTerminal(Node<NodeInfo> root, Instance instance) {
		// TODO Auto-generated method stub
		
	}

	private boolean isLeaf(Node<NodeInfo> node){
		if(node.getChildren().isEmpty()){
			return true;
		}
		return false;
	}
	
}
