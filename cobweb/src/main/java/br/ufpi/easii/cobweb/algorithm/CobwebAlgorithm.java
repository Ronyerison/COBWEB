/**
 * 
 */
package br.ufpi.easii.cobweb.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufpi.easii.cobweb.model.cobweb.Instance;
import br.ufpi.easii.cobweb.model.tree.Node;


/**
 * @author Ronyerison
 *
 */
public class CobwebAlgorithm {

	public Node<Instance> buildTree(List<String[]> trainningSet){
		if (trainningSet.isEmpty()) {
			return null;
		} 
		
		return null;
	}
	
	private List<String> getDiscriminatorValues(List<String[]> trainningSet) {
		List<String> discriminatorValues = new ArrayList<String>();
		for (String[] example : trainningSet) {
			discriminatorValues.add(example[example.length - 1]);
		}
		discriminatorValues.remove(0);
		return discriminatorValues;
	}
	
	private boolean hasEqualClassification(List<String> discriminatorValues) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String key : discriminatorValues) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.replace(key, map.get(key) + 1);
			}
		}
		if (map.values().size() > 1) {
			return false;
		}
		return true;
	}
}
