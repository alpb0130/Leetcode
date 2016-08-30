import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alpb0130 on 2/26/16.
 */
public class MergeTwoSortedIterator {
    public Iterator<Integer> mergeIterator(Iterator<Integer> a, Iterator<Integer> b) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        if (!a.hasNext()) return b;
        if (!b.hasNext()) return a;
        int num1 = a.next();
        int num2 = b.next();
        while (a.hasNext() && b.hasNext()) {
            if (num1 < num2) {
                l.add(num1);
                num1 = a.next();
            } else {
                l.add(num2);
                num2 = b.next();
            }
        }
        if (num1 < num2) {
            l.add(num1);
            l.add(num2);
        } else {
            l.add(num2);
            l.add(num1);
        }
        while (a.hasNext())
            l.add(a.next());
        while (b.hasNext())
            l.add(b.next());
        return l.iterator();
    }
}
