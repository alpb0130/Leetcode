import java.util.*;

/**
 * Created by alpb0130 on 1/28/16.
 * <p>
 * Coding problem from WalmartLab
 * <p>
 * Given a set, generate all subset of the set
 */
public class SubsetOfSet {
    // ArrayList as parameter
    public List<List<Integer>> getSubset(List<Integer> list) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if (list == null || list.size() == 0) return ll;
        helper(list, ll, list.size() - 1);
        return ll;
    }

    public void helper(List<Integer> list, List<List<Integer>> ll, int num) {
        if (num == 0) {
            List<Integer> temp_list_1 = new ArrayList<Integer>();
            List<Integer> temp_list_2 = new ArrayList<Integer>();
            temp_list_2.add(list.get(num));
            ll.add(temp_list_1);
            ll.add(temp_list_2);
            return;
        }
        helper(list, ll, num - 1);
        int l = ll.size();
        for (int i = 0; i < l; i++) {
            List<Integer> temp_list = new ArrayList<Integer>(ll.get(i));
            temp_list.add(list.get(num));
            ll.add(temp_list);
        }
        return;
    }

    // Set as parameter
    public Set<Set<Integer>> getSubset1(Set<Integer> set) {
        Set<Set<Integer>> ss = new HashSet<Set<Integer>>();
        if (set == null || set.size() == 0) return ss;
        Iterator<Integer> iterator = set.iterator();
        helper1(ss, iterator);
        return ss;
    }

    public void helper1(Set<Set<Integer>> ss, Iterator<Integer> iterator) {
        if (!iterator.hasNext()) return;
        if (ss.isEmpty()) {
            Set<Integer> set_1 = new HashSet<Integer>();
            Set<Integer> set_2 = new HashSet<Integer>();
            set_2.add(iterator.next());
            ss.add(set_1);
            ss.add(set_2);
        } else {
            Set<Set<Integer>> temp_ss = new HashSet<Set<Integer>>(ss);
            Iterator<Set<Integer>> iterator1 = temp_ss.iterator();
            int next = iterator.next();
            for (Iterator<Set<Integer>> iterator2 = temp_ss.iterator(); iterator2.hasNext();) {
                Set<Integer> temp_set = new HashSet<Integer>(iterator2.next());
                temp_set.add(next);
                ss.add(temp_set);
            }
        }
        helper1(ss, iterator);
        return;
    }
}
