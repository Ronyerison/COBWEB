package br.ufpi.easii.cobweb.model.cobweb;

import java.util.ArrayList;
import java.util.List;

public class Instance {
	private List<Attribute> attributes;
	
	public Instance() {
		attributes = new ArrayList<Attribute>();
	}

	/**
	 * @return the attributes
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

}
