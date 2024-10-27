package Proj2;

import Proj1.SNode;

public class StackNode {
	public Object Data;
	public SNode next;

	public StackNode(Object Data) {
		this(Data, null);
	}

	public StackNode(Object Data, SNode next) {
		this.Data = Data;
		this.next = next;
	}

	public void displayLink() {
		System.out.print(Data + " ");
	}

}
