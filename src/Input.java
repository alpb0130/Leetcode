import java.util.Scanner;

/**
 * Created by alpb0130 on 9/5/16.
 *
 * Input example:
 * 5
 * 1 2 3 4 5
 */
public class Input {
    public void inputTest () {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
    }
}
