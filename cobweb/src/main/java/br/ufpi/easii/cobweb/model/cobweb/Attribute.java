/**
 * 
 */
package br.ufpi.easii.cobweb.model.cobweb;

import java.util.List;
import java.util.Map;

/**
 * @author Ronyerison
 *
 */
public class Attribute {
	private String label;
	private String value;
	private List<String> discriminatorValues;
	private Map<String, AttributeValue> attributesValues;
	private String id;

	/**
	 * @param id
	 * @param label
	 * @param value
	 */
	public Attribute(String id, String label, String value) {
		this.id = id;
		this.label = label;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the discriminatorValues
	 */
	public List<String> getDiscriminatorValues() {
		return discriminatorValues;
	}

	/**
	 * @param discriminatorValues
	 *            the discriminatorValues to set
	 */
	public void setDiscriminatorValues(List<String> discriminatorValues) {
		this.discriminatorValues = discriminatorValues;
	}

	/**
	 * @return the attributesValues
	 */
	public Map<String, AttributeValue> getAttributesValues() {
		return attributesValues;
	}

	/**
	 * @param attributesValues
	 *            the attributesValues to set
	 */
	public void setAttributesValues(Map<String, AttributeValue> attributesValues) {
		this.attributesValues = attributesValues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attribute [label=" + label + ", attributesValues=" + attributesValues + "]";
	}

}
