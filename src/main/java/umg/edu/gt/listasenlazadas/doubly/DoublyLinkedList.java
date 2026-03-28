package umg.edu.gt.listasenlazadas.doubly;


public class DoublyLinkedList<T> {
	private DoublyNode<T> head;
	private DoublyNode<T> tail;
	private int size;
	
	public void addfirst(T value) {
		DoublyNode<T> newDoublyNode = new DoublyNode<>(value);
		
		if(head == null) {
			head = newDoublyNode;
			tail = newDoublyNode;
		} else {
			head.setPrev(newDoublyNode);
			newDoublyNode.setNext(head);
			head = newDoublyNode;
		}
		
		size ++;
		
	}
	
	public void addLast(T value) {
		DoublyNode<T> newDoublyNode = new DoublyNode<>(value);
		if(tail == null) {
			head = newDoublyNode;
			tail = newDoublyNode;
		} else {
			newDoublyNode.setPrev(tail);
			tail.setNext(newDoublyNode);
			tail = newDoublyNode;
			
		}
		size ++;
	}
	
	public T removeFirst() {
		if (head == null) {
			return null;
		}
		
		T value = head.getValue();
		head = head.getNext();
		
		if (head != null) {
			head.setPrev(null);
        } else {
        	tail = null;
        }
		size --;
		return value;
	}
	
	public boolean remove(T value) {
	    if (head == null) {
	        return false;
	    }

	    
	    if (isSameValue(head.getValue(), value)) {
	        removeFirst();
	        return true;
	    }

	    DoublyNode<T> current = head.getNext();

	    while (current != null) {
	        if (isSameValue(current.getValue(), value)) {
	            
	            DoublyNode<T> prevNode = current.getPrev();
	            DoublyNode<T> nextNode = current.getNext();

	            prevNode.setNext(nextNode);
	            if (nextNode != null) {
	                nextNode.setPrev(prevNode);
	            } else {
	                tail = prevNode;
	            }

	            size--;
	            return true;
	        }
	        current = current.getNext();
	    }

	    return false;
	}
	
	public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
    	head = null;
    	tail = null;
    	size = 0;
    }
    
    public int countOccurrences(T value) {

        
        DoublyNode<T> current = head;
        
        int contador = 0;
        
        while ( current != null) {
        	if(isSameValue(current.getValue(), value)) {
        		contador ++;
        	}
        	current = current.getNext();
        }
        return contador;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = head;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getNext() != null) {
                builder.append(", ");
            }
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
	
	private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
