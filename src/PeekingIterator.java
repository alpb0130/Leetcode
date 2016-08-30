import java.util.Iterator;

/**
 * Created by alpb0130 on 2/2/16.
 * <p>
 * 284. Peeking Iterator
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it essentially
 * peek() at the element that will be returned by the next call to next().
 * <p>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * <p>
 * Hint:
 * Think of "looking ahead". You want to cache the next element.
 * <p>
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    // We need to get the peek value. However, we need to call next() to get peek value.
    // The next would move pointer to the next element. So we need to use a Integer variable to cache it.
    // Also use it to implement the hasnext() method
    Integer peek_value;
    Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (it.hasNext()) {
            peek_value = it.next();
        } else {
            peek_value = null;
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek_value;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ret = peek_value;
        if (it.hasNext()) {
            peek_value = it.next();
        } else {
            peek_value = null;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        if (peek_value == null)
            return false;
        return true;
    }
}