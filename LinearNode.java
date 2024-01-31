
public class LinearNode<T> {
	private LinearNode<T> next; 
	private T data;
	
	
	public LinearNode(T data, LinearNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public LinearNode() {
		this.next = null;
		this.data = null;
	}
	
	public LinearNode<T> getNext() {
		return next;
	}
	public void setNext(LinearNode<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
