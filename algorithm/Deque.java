

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by fanji on 2016/11/14.
 */
public class Deque<Item> implements Iterable<Item> {
    /* API
           public class Deque<Item> implements Iterable<Item> {
           public Deque()                           // construct an empty deque
           public boolean isEmpty()                 // is the deque empty?
           public int size()                        // return the number of items on the deque
           public void addFirst(Item item)          // add the item to the front
           public void addLast(Item item)           // add the item to the end
           public Item removeFirst()                // remove and return the item from the front
           public Item removeLast()                 // remove and return the item from the end
           public Iterator<Item> iterator()         // return an iterator over items in order from front to end
           public static void main(String[] args)   // unit testing
            }
     */
    private  int size; // deque size
    private Node first;
    private Node last;

    private class Node{
        Item item;
        Node next;
        Node previous;
    }

    public Deque(){
        first = null;
        last = null;

        size = 0;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public int size(){
        return  size;
    }

    public void addFirst(Item item){
        if(item == null) throw new NullPointerException("item is null");
        size++;
        if(first == null){
            first = new Node();
            first.item = item;
            first.next =null;
            first.previous = null;
            last = first;
        }
        else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            first.previous = null;
            oldFirst.previous = first;
        }
    }

    public void addLast(Item item){
        if(item == null) throw new NullPointerException("item is null");
        size++;
        if(last == null){
            last = new Node();
            last.item = item;
            last.next = null;
            last.previous = null;
            first = last;
        }
        else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null; //important
            last.previous = oldLast;
            oldLast.next = last;
        }
    }

    public Item removeFirst(){
        if( isEmpty()) throw new UnsupportedOperationException();
        size--;
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Item removeLast(){
        if( isEmpty()) throw new UnsupportedOperationException();
        size--;
        Item item = last.item;
        last.previous.next = null;
        return  item;

    }
    @Override
    public Iterator<Item> iterator() {
        return new dequeIterator();
    }

    private class dequeIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(hasNext() == false) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("fan");
        deque.addLast("jiang");
        deque.addLast("qi");
        for(String s : deque){
            System.out.println(s);
        }
        /*deque.addFirst(null);
        String test1, test2;
        test1 = deque.removeFirst();
        test2 = deque.removeLast();
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(deque.size);*/
    }
}
