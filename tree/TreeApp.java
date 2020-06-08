import java.util.ArrayDeque;
import java.util.Queue;


public class TreeApp {

	public static void main (String[] args) {
		final Queue<Node> queue = new ArrayDeque<>();
		for (final String value : args) {
			final Node node = new Node(value, null, null);
			queue.add(node);
		}

		while (queue.size() > 1) {
			final Node leftNode = queue.remove();
			final Node rightNode = queue.remove();
			final Node parent = new Node(null, leftNode, rightNode);
			queue.add(parent);
		}

		final Node rootNode = queue.isEmpty() ? null : queue.element();
		System.out.println(rootNode);
	}

}
