/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
        	return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Map<Node, Node> map = new HashMap<>();
        while(!queue.isEmpty()) {
        	Node current = queue.poll();
        	Node copyNode = new Node(current.val, current.neighbors);
        	map.put(current, copyNode);
        	if(current.neighbors != null) {
        		for(Node neightbor : current.neighbors) {
        			if(neightbor != null && !map.containsKey(neightbor)) {
        				queue.offer(neightbor);
        			}
        		}
        	}
        }
        for(Node newNode : map.values()) {
        	if(newNode.neighbors != null) {
        		List<Node> newNeighbors = new ArrayList<>();
        		for(Node neighbor : newNode.neighbors) {
        			if(neighbor == null) {
        				newNeighbors.add(null);
        			} else {
        				newNeighbors.add(map.get(neighbor));
        			}
        		}
        		newNode.neighbors = newNeighbors;
        	}
        }
        return map.get(node);
    }
}
