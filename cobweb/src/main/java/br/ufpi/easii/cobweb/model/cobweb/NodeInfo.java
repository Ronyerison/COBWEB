/**
 * 
 */
package br.ufpi.easii.cobweb.model.cobweb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronyerison
 *
 */
public class NodeInfo {
	private List<Instance> instances;
	private Double uc;
	
	public NodeInfo() {
		instances = new ArrayList<Instance>();
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
	
}
