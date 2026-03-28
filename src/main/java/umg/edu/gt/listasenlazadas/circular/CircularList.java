package umg.edu.gt.listasenlazadas.circular;

public class CircularList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;

    public void addFirst(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
            
        }
        size++;
        tail.setNext(head);
    }

    public void addLast(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        tail.setNext(head);
    }
    
    public SimpleNode<T> getFirstNode() {
    	return head;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.getValue();
        
        if (head == tail) {
        	head = null;
            tail = null;
        } else {
        	head = head.getNext();
        	tail.setNext(head);
        }
        size--;
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

        SimpleNode<T> previous = head;
        SimpleNode<T> current = head.getNext();

        while (current != head) {
            if (isSameValue(current.getValue(), value)) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous;
                    
                }
                size--;
                tail.setNext(head);
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public boolean contains(T value) {
    	if (head == null) return false;
        SimpleNode<T> current = head;
        do{
            if (isSameValue(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
        }while (current != head);
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void delete() {
    	head = null;
    	tail = null;
    	size = 0;
    }

    /**
     * RETO 1:
     * Cuenta cuantas veces aparece un valor dentro de la lista.
     *
     * Reglas sugeridas:
     * - No usar arreglos ni librerias externas.
     * - Resolver solo con recorrido de nodos.
     * - Complejidad esperada: O(n).
     *
     * @param value valor a buscar
     * @return cantidad de ocurrencias encontradas
     */
    public int countOccurrences(T value) {
    	if (head == null) return 0;
        
        SimpleNode<T> current = head;
        
        int contador = 0;
        
        do{
        	if(isSameValue(current.getValue(), value)) {
        		contador ++;
        	}
        	current = current.getNext();
        }while ( current != head);
        return contador;
    }

    @Override
    public String toString() {
    	if (head == null) return "[]";
    	
        StringBuilder builder = new StringBuilder("[");
        SimpleNode<T> current = head;
        do{
            builder.append(current.getValue());
            if (current.getNext() != head) {
                builder.append(", ");
            }
            current = current.getNext();
        }while (current != head); 
        builder.append("]");
        return builder.toString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
