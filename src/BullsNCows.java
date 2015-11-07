import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alpb0130 on 11/6/15.
 * <p>
 * Bulls and Cows
 * <p>
 * You are playing the following Bulls and Cows game with your friend:
 * You write a 4-digit secret number and ask your friend to guess it.
 * Each time your friend guesses a number, you give a hint. The hint
 * tells your friend how many digits are in the correct positions
 * (called "bulls") and how many digits are in the wrong positions
 * (called "cows"). Your friend will use those hints to find out the
 * secret number.
 * <p>
 * For example:
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and
 * friend's guess, use A to indicate the bulls and B to indicate the cows.
 * In the above example, your function should return "1A3B".
 * <p>
 * Please note that both secret number and friend's guess may contain
 * duplicate digits, for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or
 * 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess
 * only contain digits, and their lengths are always equal.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BullsNCows {
    // Hashmap - pretty slow
    public String getHint(String secret, String guess) {
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        int bulls = 0, cows = 0;
        HashMap<Character, List<Integer>> secretMap = new HashMap<Character, List<Integer>>();
        HashMap<Character, Integer> cowMap = new HashMap<Character, Integer>();
        for (int i = 0; i < secretArray.length; i++) {
            if (!secretMap.containsKey(secretArray[i])) {
                List<Integer> posList = new ArrayList<>();
                posList.add(i);
                secretMap.put(secretArray[i], posList);
            } else {
                List<Integer> posList = secretMap.get(secretArray[i]);
                posList.add(i);
                secretMap.put(secretArray[i], posList);
            }
        }
        for (int i = 0; i < guessArray.length; i++) {
            if (secretMap.containsKey(guessArray[i])) {
                if (secretMap.get(guessArray[i]).contains(i)) {
                    bulls++;
                    secretMap.get(guessArray[i]).remove(secretMap.get(guessArray[i]).indexOf(i));
                } else {
                    if (!cowMap.containsKey(guessArray[i])) {
                        cowMap.put(guessArray[i], 1);
                    } else {
                        cowMap.put(guessArray[i], cowMap.get(guessArray[i]) + 1);
                    }
                }
            }
        }
        for (Character c : cowMap.keySet()) {
            cows+=cowMap.get(c) > secretMap.get(c).size()? secretMap.get(c).size() : cowMap.get(c);
        }
        return new String(bulls + "A" + cows + "B");
    }

    // Array
    public String getHint1(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) -'0';
            int g = guess.charAt(i) -'0';
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[g] > 0 ) cows++;
                if (count[s] < 0 ) cows++;
                count[g]--;
                count[s]++;
            }
        }
        return new String(bulls + "A" + cows + "B");
    }
}
