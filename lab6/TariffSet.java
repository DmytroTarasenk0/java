import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A custom Set implementation with a Doubly Linked List structure.
 * Constrained to hold objects of type Tariff or its descendants.
 *  *
 * @param <T> Type of elements in this set (must extend Tariff).
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class TariffSet<T extends Tariff> implements Set<T> {

    /**
     * Internal Node class for the Doubly Linked List structure.
     * Each node holds the data and pointers to the next and previous nodes.
     */
    private class Node {
        T data;
        Node next;
        Node prev;

        /**
         * Node constructor.
         * @param data the element data to store in this node.
         */
        Node(T data) {
            this.data = data;
        }
    }

    private Node head; // Reference to the first node in the list
    private Node tail; // Reference to the last node in the list
    private int size;  // Current number of elements in the set

    /**
     * 1. Default constructor. Creates an empty set.
     */
    public TariffSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 2. Constructor that accepts a single element.
     *
     * @param element The initial element to add to the set.
     */
    public TariffSet(T element) {
        this();
        add(element);
    }

    /**
     * 3. Constructor that accepts a standard collection.
     *
     * @param collection The collection of elements to add to the set.
     */
    public TariffSet(Collection<? extends T> collection) {
        this();
        addAll(collection); // Uses the addAll() method
    }

    /**
     * Returns the number of elements in this set.
     * @return the size of the set.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this set contains no elements.
     * @return true if the set is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this set contains the specified element.
     * Logic involves traversing the linked list and comparing elements using {@code equals()}.
     *
     * @param o element whose presence in this set is to be tested.
     * @return true if this set contains the specified element.
     */
    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) { 
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in set from head to tail.
     * @return an iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Iterator has reached the end of the set.");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Returns an array containing all of the elements in this set.
     * @return an array of objects.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        Node current = head;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Returns an array containing all of the elements in this set; the runtime type
     * of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of this set are to be stored.
     * @return the array containing the elements of this set.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            a = (E[])java.lang.reflect.Array.newInstance(
                                a.getClass().getComponentType(), size);
        }
        
        int i = 0;
        // Copy data into the array 'a'
        for (Node current = head; current != null; current = current.next) {
            a[i++] = (E) current.data; 
        }

        // Set the element after the last element to null if the provided array is larger
        if (a.length > size) {
            a[size] = null;
        }
        
        return a;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * Implements linked list insertion logic.
     *
     * @param t element to be added to this set.
     * @return true if this set did not already contain the specified element.
     */
    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false; // Element already exists, do not add
        }
        
        Node newNode = new Node(t);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            // Doubly Linked List insertion:
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes the specified element from this set if it is present.
     * Implements linked list unlinking logic.
     *
     * @param o object to be removed from this set.
     * @return true if the set contained the specified element.
     */
    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            // Node find. Unlink it from its neighbors.
            if (current.data.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns true if this set contains all of the elements of the specified collection.
     * @param c collection to be checked for containment in this set.
     * @return true if this set contains all elements of the collection.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) return false;
        }
        return true;
    }

    /**
     * Adds all of the elements from specified collection to this set.
     *
     * @param c collection containing elements to be added to this set.
     * @return true if this set changed as a result of the call.
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) modified = true;
        }
        return modified;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     * Logic involves iterating and selectively removing nodes not found in the target collection.
     *
     * @param c collection containing elements to be retained in this set.
     * @return true if this set changed as a result of the call.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            // Save next reference before potential removal
            Node nextNode = current.next; 
            // If current element is not in collection c, remove it from the set
            if (!c.contains(current.data)) {
                remove(current.data);
                modified = true;
            }
            current = nextNode;
        }
        return modified;
    }

    /**
     * Removes all of this set's elements that are also contained in the specified collection.
     * @param c collection containing elements to be removed from this set.
     * @return true if this set changed as a result of the call.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) modified = true;
        }
        return modified;
    }

    /**
     * Removes all of the elements from this set (optional operation).
     * Resets the head, tail, and size.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Provides a readable string representation of the set's contents.
     * @return the set represented as a string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TariffSet (Size: ").append(size).append(") [\n");
        for (T item : this) { 
            sb.append("  ").append(item).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}