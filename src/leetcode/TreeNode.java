package leetcode;


import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;

//Definition for a binary tree node.
public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }

    @Override
    public String toString() {
        // Deconstruct the tree in level-order.
        List<String> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                values.add("null");
                continue;
            }

            values.add(String.valueOf(current.val));
            queue.add(current.left);
            queue.add(current.right);
        }

        int last = values.size() - 1;
        while (last >= 0 && "null".equals(values.get(last))) {
            last--;
        }

        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i <= last; i++) {
            result.add(values.get(i));
        }

        return result.toString();
    }


      public static TreeNode createTree(List<Integer> nums){
          //create binary tree using List
          TreeNode root = new TreeNode(nums.get(0));
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          int i=1;
          while(!queue.isEmpty() && i<nums.size()){
              TreeNode current = queue.poll();
              addLeftRightNodes(nums.get(i++), nums.get(i++), current);
              queue.add(current.left);
              queue.add(current.right);
          }

          return root;

      }

    private static void addLeftRightNodes(Integer leftVal, Integer rightVal, TreeNode current) {
          if(leftVal!=null)
            current.left= new TreeNode(leftVal);
          if(rightVal!=null)
            current.right = new TreeNode(rightVal);

    }
}
