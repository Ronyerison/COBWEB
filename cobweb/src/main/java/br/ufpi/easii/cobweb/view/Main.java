/**
 * 
 */
package br.ufpi.easii.cobweb.view;

import java.util.ArrayList;
import java.util.List;

import br.ufpi.easii.cobweb.model.cobweb.Instance;
import br.ufpi.easii.cobweb.model.cobweb.NodeInfo;
import br.ufpi.easii.cobweb.model.tree.Node;


/**
 * @author WermesonReis
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Instance> instances = new ArrayList<Instance>();
		NodeInfo nodeInfo = new NodeInfo();
		for (Instance instance : instances) {
			nodeInfo.addInstance(instance);
		}
		Node<NodeInfo> node = new Node<NodeInfo>(nodeInfo);
		
	}

}
