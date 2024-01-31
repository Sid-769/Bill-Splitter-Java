
public class UniqueOrderedList<T extends Comparable<T>> implements UniqueOrderedListADT<T>, SimpleIterable<T> {

	private int size;
	private LinearNode<T> head;
	public UniqueOrderedList() {
		this.head = null;
		size = 0;
	}

	public UniqueOrderedList(T[] data) { 
		this();
		for (int i = 0; i < data.length; i++) {
			this.add(data[i]);
		}
	}
	
	public boolean contains (T element) { 

		LinearNode<T> curr = this.head;
		while (curr != null  && curr.getData().compareTo(element) <= 0)  {
			if (curr.getData().equals(element)) { 
				return true;
			} else {
				curr = curr.getNext();
			}
		}
		return false;

	}

	public boolean add(T element) { 

		if (this.contains(element)) { 
			return false;
		} else {

			if (this.head == null || this.head.getData().compareTo(element) > 0) {
				this.head = new LinearNode<T>(element,head);
			} else {
				LinearNode<T> curr = this.head;
				LinearNode<T> prev = null;

				while (curr != null && curr.getData().compareTo(element) < 0) { 
					prev = curr;
					curr = curr.getNext();
				}

				prev.setNext(new LinearNode<T> (element, curr));
			}
		}
		size+=1;
		return true;
	}
	
	public int size() {
		return this.size;
	}

	public LinearNode<T> getHead() {
		return head;
	}

	@Override
	public CopyableIterator<T> iterator() {
		return new UOLIterator<>(head);
	}

}
