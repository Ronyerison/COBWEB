/**
 * 
 */
package br.ufpi.easii.cobweb.model.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronyerison
 *
 */
public class Node<T> {
	private Node<T> parent = null;
	private T data = null;
	private List<Node<T>> children = new ArrayList<Node<T>>();

	public Node(T data) {
		this.data = data;
	}
	
	public Node(Node<T> node){
		this.parent = node.parent;
		this.data = node.data;
		this.children = node.children;
	}
	
	public Node<T> clone(){
		Node<T> clone = new Node<T>(this);
		return clone;
	}

	public Node(T data, Node<T> parent, String edgeValue) {
		this.data = data;
		this.parent = parent;
	}

	public List<Node<T>> getChildren() {
		return children;
	}

	public void setParent(Node<T> parent, String edgeValue) {
		parent.addChild(this, edgeValue);
		this.parent = parent;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void addChild(T data, String edgeValue) {
		Node<T> child = new Node<T>(data);
		this.children.add(child);
	}

	public void addChild(Node<T> child, String edgeValue) {
		this.children.add(child);
	}
	
	public boolean removeChild(Node<T> child){
		return this.children.remove(child);
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public boolean isLeaf() {
		if (this.children.size() == 0)
			return true;
		else
			return false;
	}

	public void removeParent() {
		this.parent = null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return data+"";
	}

	
}
