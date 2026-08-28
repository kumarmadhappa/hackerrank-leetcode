package leetcode;

import java.util.*;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> values1 = new ArrayList<>();
        ArrayList<Integer> values2 = new ArrayList<>();

        getLeafNodes(root1, values1);
        getLeafNodes(root2, values2);

        System.out.println("Leaf Values 1 "+values1);
        System.out.println("Leaf Values 2 "+values2);
        return values1.equals(values2);

    }

    private static void getLeafNodes(TreeNode root, List<Integer> values) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            values.add(root.val);
        }

        getLeafNodes(root.left, values);
        getLeafNodes(root.right, values);

    }

    public static void main(String[] args) {
        List<Integer> root1Val = Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4);
        TreeNode root1 = TreeNode.createTree(root1Val);
        System.out.println(root1);

        List<Integer> root2Val = Arrays.asList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8);
        TreeNode root2 = TreeNode.createTree(root2Val);
        System.out.println(root2);

        LeafSimilarTrees leaf = new LeafSimilarTrees();
        System.out.println(leaf.leafSimilar(root1, root2));


    }
}
