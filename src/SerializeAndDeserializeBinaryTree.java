/**
 * Created by alpb0130 on 9/5/16.
 * <p>
 * Serialization is the process of converting a data structure or
 * object into a sequence of bits so that it can be stored in a
 * file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization
 * algorithm should work. You just need to ensure that a binary tree
 * can be serialized to a string and this string can be deserialized
 * to the original tree structure.
 * <p>
 * For example, you may serialize the following tree:
 *          1
 *         / \
 *       2   3
 *      / \
 *    4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ
 * serializes a binary tree. You do not necessarily need to follow
 * this format, so please be creative and come up with different
 * approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder str = new StringBuilder();
            serializeHelper(root, str);
            return str.toString();
        }

        public void serializeHelper(TreeNode root, StringBuilder str) {
            if (root == null) {
                str.append("# ");
                return;
            }
            str.append(root.val);
            str.append(" ");
            serializeHelper(root.left, str);
            serializeHelper(root.right, str);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(" ");
            int[] index = new int[1];
            return deserializeHelper(dataArray, index);
        }

        public TreeNode deserializeHelper(String[] data, int[] index) {
            if (data[index[0]].equals("#")) {
                index[0]++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(data[index[0]++]));
            root.left = deserializeHelper(data, index);
            root.right = deserializeHelper(data, index);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
