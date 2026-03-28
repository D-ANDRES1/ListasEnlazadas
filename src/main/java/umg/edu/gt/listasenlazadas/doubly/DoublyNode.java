package umg.edu.gt.listasenlazadas.doubly;

final class DoublyNode<T> {
	private final T value;
	private DoublyNode<T> next;
	private DoublyNode<T> prev;
	
	DoublyNode(T value){
		this.value = value;
	}
	
	T getValue() {
		return value;
	}
	
	DoublyNode<T> getNext() {
		return next;
	}
	
	void setNext(DoublyNode<T> next) {
		this.next = next;
	}
	
	DoublyNode<T> getPrev(){
		return prev;
	}
	
	void setPrev(DoublyNode<T> prev) {
		this.prev = prev;
	}
}
