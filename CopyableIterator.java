
import java.util.Iterator;

public interface CopyableIterator<T> extends Iterator<T> {
	public CopyableIterator<T> copy();
}
