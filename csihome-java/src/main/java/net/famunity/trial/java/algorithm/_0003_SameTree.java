package net.famunity.trial.java.algorithm;

public class _0003_SameTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3).setLeftNode(new TreeNode(2)).setRightNode(new TreeNode(5).setLeftNode(new TreeNode(4)).setRightNode(new TreeNode(6)));
        TreeNode b = new TreeNode(3).setLeftNode(new TreeNode(2)).setRightNode(new TreeNode(5).setLeftNode(new TreeNode(4)).setRightNode(new TreeNode(8)));
        TreeNode c = new TreeNode(3).setLeftNode(new TreeNode(2)).setRightNode(new TreeNode(5).setLeftNode(new TreeNode(4)).setRightNode(new TreeNode(6)));
        System.out.println(isSame(a, b)+" v.s. " + isSame(a, c));
        System.out.println("Max depth :" + maxDepth(a));
    }

    public static boolean isSame(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;

        if(a == null || b == null || (a.getVal() != b.getVal())) {
            return false;
        }

        return isSame(a.getLeftNode(), b.getLeftNode()) && isSame(a.getRightNode(), b.getRightNode());
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int iRightDepth = maxDepth(root.getRightNode());
        int iLefttDepth = maxDepth(root.getLeftNode());
        System.out.println("left vs right depth: "+iLefttDepth+" vs "+iRightDepth);
        return (iRightDepth > iLefttDepth) ? iRightDepth + 1 : iLefttDepth + 1;
    }
}

class TreeNode {
    int val;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
        return this;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public TreeNode setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
        return this;
    }
}
