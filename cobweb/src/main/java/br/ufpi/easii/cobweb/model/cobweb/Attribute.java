/**
 * 
 */
package br.ufpi.easii.cobweb.model.cobweb;


/**
 * @author Ronyerison
 *
 */
public class Attribute {
	private String label;
	private String value;
	

	/**
	 * @param label
	 * @param value
	 */
	public Attribute(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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



}
