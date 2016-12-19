
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by fanji on 2016/11/14.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    /* API
        public class RandomizedQueue<Item> implements Iterable<Item> {
       public RandomizedQueue()                 // construct an empty randomized queue
       public boolean isEmpty()                 // is the queue empty?
       public int size()                        // return the number of items on the queue
       public void enqueue(Item item)           // add the item
       public Item dequeue()                    // remove and return a random item
       public Item sample()                     // return (but do not remove) a random item
       public Iterator<Item> iterator()         // return an independent iterator over items in random order
       public static void main(String[] args)   // unit testing
    }
     */
    private Item[] q;
    private int size;

    public RandomizedQueue() {
        q = (Item[]) new Object[1];
        size = 0;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (size == q.length) resize(2 * q.length); // resize
        q[size++] = item;

    }

    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();
        if (size > 0 && size == q.length / 4) resize(q.length / 2);
        int randomIndex = StdRandom.uniform(size);
        Item temp;
        temp = q[randomIndex];
        q[randomIndex] = q[size-1];
        q[size-1] = null;
        size--;
        return temp;
    }

    public Item sample() {
        if (size == 0) throw new NoSuchElementException();
        int randomIndex = StdRandom.uniform(size);
        Item temp;
        temp = q[randomIndex];
        return temp;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new randomQueueIterator();
    }

    private class randomQueueIterator implements Iterator<Item> {
        private int current = 0;
        private int[] shuffledIndexes = new int[size];

        public boolean hasNext() {
            if (current == 0) {
                for (int i = 0; i < size; i++)
                    shuffledIndexes[i] = i;
                StdRandom.shuffle(shuffledIndexes);
            }
            return current < size;
        }

        public Item next() {
            if (current == 0) {
                for (int i = 0; i < size; i++)
                    shuffledIndexes[i] = i;
                StdRandom.shuffle(shuffledIndexes);
            }
            if (current >= size || size() == 0) throw new java.util.NoSuchElementException();
            return q[shuffledIndexes[current++]];
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        RandomizedQueue<String> ranQueue = new RandomizedQueue<>();
        ranQueue.enqueue("fan");
        ranQueue.enqueue("jiang");
        ranQueue.enqueue("qi");
        ranQueue.enqueue("s");
        ranQueue.enqueue("b");
        String test = ranQueue.dequeue();
        /*System.out.println(test);
        System.out.println(ranQueue.sample());
        System.out.println(ranQueue.size());
        System.out.println(ranQueue.isEmpty());*/
        for (String temp : ranQueue) {
            System.out.println(temp);
        }
    }

}
