/**
 * 
 */
package br.ufpi.easii.cobweb.model.cobweb;


/**
 * @author Ronyerison
 *
 */
public class AttributeValue {
	private String attribute;
	private String value;
	private Double probability;
	
	public AttributeValue() {
	}
	
	/**
	 * @param attribute
	 * @param value
	 * @param probability
	 */
	public AttributeValue(String attribute, String value, Double probability) {
		this.attribute = attribute;
		this.value = value;
		this.probability = probability;
	}
	
	/**
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}
	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the probability
	 */
	public Double getProbability() {
		return probability;
	}
	/**
	 * @param probability the probability to set
	 */
	public void setProbability(Double probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "AttributeValue [attribute=" + attribute + ", value=" + value
				+ ", probability=" + probability + "]";
	}
	
	
}
