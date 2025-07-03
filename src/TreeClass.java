
public class TreeClass {

	static int count = 0;

	public static void main(String[] args) {

		Node head = new Node(30);
		insertNode(head, 20);
		insertNode(head, 40);
		insertNode(head, 10);
		insertNode(head, 50);
		insertNode(head, 60);

		printNode(head);
		secondLargest(head);
	}

	public static Node insertNode(Node node, int value) {
		if (node == null)
			return new Node(value);
		else if (node.data < value)
			node.right = insertNode(node.right, value);
		else
			node.left = insertNode(node.left, value);

		return node;
	}

	public static void printNode(Node node) {
		if (node == null)
			return;
		printNode(node.left);
		printNode(node.right);
		System.out.print(node.data + " -> ");
	}

	public static void secondSmallest(Node node) {
		if (node == null) {
			count++;
			return;
		}
		secondSmallest(node.left);
		if (count == 2)
			System.out.println("third largest : " + node.data);
		secondSmallest(node.right);
	}

}

class Node {

	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.data = data;
	}

}