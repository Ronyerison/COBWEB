/**
 * 
 */
package br.ufpi.easii.cobweb.model.cobweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ronyerison
 *
 */
public class NodeInfo {
	private List<Instance> instances;
	private Map<String, AttributeValue> mapProbability;
	private Double uc;
	
	public NodeInfo() {
		instances = new ArrayList<Instance>();
		mapProbability = new HashMap<String, AttributeValue>();
		uc = 0.0;
	}

	/**
	 * @param instances
	 * @param uc
	 */
	public NodeInfo(List<Instance> instances, Double uc) {
		this.instances = instances;
		this.uc = uc;
	}

	/**
	 * @return the instances
	 */
	public List<Instance> getInstances() {
		return instances;
	}

	/**
	 * @param instances the instances to set
	 */
	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	/**
	 * @return the uc
	 */
	public Double getUc() {
		return uc;
	}

	/**
	 * @param uc the uc to set
	 */
	public void setUc(Double uc) {
		this.uc = uc;
	}

	/**
	 * @return the mapProbability
	 */
	public Map<String, AttributeValue> getMapProbability() {
		return mapProbability;
	}

	/**
	 * @param mapProbability the mapProbability to set
	 */
	public void setMapProbability(Map<String, AttributeValue> mapProbability) {
		this.mapProbability = mapProbability;
	}
	
	public void addAttributeValue(AttributeValue value){
		mapProbability.put(value.getValue(), value);
	}
	
	public void addInstance(Instance instance){
		this.instances.add(instance);
		for (Attribute attribute : instance.getAttributes()) {
			AttributeValue attributeValue = new AttributeValue(attribute.getLabel(), attribute.getValue(), 0.0);
			addAttributeValue(attributeValue);
			mapProbability.get(attribute.getValue()).incrementQuantity();
		}
	}
}
