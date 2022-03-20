class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size != 0) {
                Node itr = queue.poll();
                
                if (size >1 ){
                    itr.next = queue.peek();
                }
                size--;
                if (itr.left != null) queue.offer(itr.left);
                if (itr.right != null) queue.offer(itr.right);
            }
        }
        return root;
    }
}