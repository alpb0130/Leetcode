import java.util.Stack;

/**
 * Created by alpb0130 on 9/12/16.
 * <p>
 * 388. Longest Absolute File Path
 * <p>
 * Suppose we abstract our file system by a string in the following manner:
 * <p>
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * <p>
 * dir
 * subdir1
 * subdir2
 * file.ext
 * <p>
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory
 * subdir2 containing a file file.ext.
 * <p>
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * <p>
 * dir
 * subdir1
 * file1.ext
 * subsubdir1
 * subdir2
 * subsubdir2
 * file2.ext
 * <p>
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1
 * contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 * subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 * <p>
 * We are interested in finding the longest (number of characters) absolute path to
 * a file within our file system. For example, in the second example above, the longest
 * absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not
 * including the double quotes).
 * <p>
 * Given a string representing the file system in the above format, return the length
 * of the longest absolute path to file in the abstracted file system. If there is no
 * file in the system, return 0.
 * <p>
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a . .
 * Time complexity required: O(n) where n is the size of the input string.
 * <p>
 * Notice that a/aa/aaa/file1.txt is not the longest file path,
 * if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class LongestAbsoluteFilePath {
    // Iterative.
    // Time: O (n)
    // Space: O (n)
    // Use a stack to note down current file length
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        String[] fileArr = input.split("\n");
        Stack<Integer> files = new Stack<Integer>();
        int ret = 0;
        int culSize = 0;
        for (String file : fileArr) {
            int level = file.lastIndexOf("\t") + 1;
            while (level != files.size()) culSize -= (files.pop() + 1);
            files.push(file.length() - level);
            culSize += (file.length() + 1 - level);
            if (file.contains(".")) ret = Math.max(ret, culSize - 1);
        }
        return ret;
    }
}
