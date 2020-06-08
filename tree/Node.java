package de.cbw.jav.tree;

public class Node {
	private final Object value;
	private final Node leftChild;
	private final Node rightChild;


	public Node (final Object value, Node leftChild, Node rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}


	public Object getValue () {
		return this.value;
	}


	public Node getLeftChild () {
		return this.leftChild;
	}


	public Node getRightChild () {
		return this.rightChild;
	}


	public String toString () {
		if (this.value == null) {
			return String.format("[%s, %s]", this.getLeftChild(), this.getRightChild());
		}

		return this.leftChild == null & this.rightChild == null ? String.format("[%s]", this.value) : String.format("[%s, %s, %s]", this.value, this.getLeftChild(), this.getRightChild());
	}
}