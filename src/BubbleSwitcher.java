/**
 * Created by alpb0130 on 2/26/16.
 * <p>
 * 319. Bulb Switcher
 * <p>
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the ith
 * round, you toggle every i bulb. For the nth round, you only toggle the last
 * bulb. Find how many bulbs are on after n rounds.
 * <p>
 * Example:
 * <p>
 * Given n = 3.
 * <p>
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 * <p>
 * So you should return 1, because there is only one bulb is on.
 */
public class BubbleSwitcher {
    // It's easy to find that if we operate a bulb even times, it would be off.
    // If we operate a bulb odd times, it would be on.
    // For every number except those whose root are integer, they must have even number of factors.
    // For example, 12: (1, 12), (2, 6), (3, 4)
    // However, for number like 16, the factor pair is:
    // 16: (1, 16), (2, 8), (4, 4), so 16 have odd number of factors.
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
