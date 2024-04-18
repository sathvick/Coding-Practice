import java.util.*;

class FindClosestValueInBst {

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    private static int findClosestValueInBst(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        }

        int currentDiff = Math.abs(target - tree.value);
        int closestDiff = Math.abs(target - closest);
        if (currentDiff < closestDiff) {
            closest = tree.value;
        }

        if (tree.value < target && tree.right != null) {
            return findClosestValueInBst(tree.right, target, closest);
        } else if (tree.value > target && tree.left != null) {
            return findClosestValueInBst(tree.left, target, closest);
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
