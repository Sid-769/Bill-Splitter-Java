import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UOLIterator<T> implements CopyableIterator<T> {
    private LinearNode<T> curr;

    public UOLIterator(LinearNode<T> curr) {
        this.curr = curr;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("iterator empty");
        }
        T data = curr.getData();
        curr = curr.getNext();
        return data;
    }

    @Override
    public CopyableIterator<T> copy() {
        return new UOLIterator<>(curr);
    }
}
