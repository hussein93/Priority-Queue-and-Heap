import java.util.*;

/** to represent the class PriorityQueue
 * 
 * @author Jarred Lien, jlien15
 * @author Hussein Abou Nassif Mourad, hassuni9
 * @version 2014-3-30
 *
 */
public class PriorityQueue<T> {
    /**
     * Represents the arrayList representing the tree
     */
    ArrayList<T> alist;

    /**
     * Represents the comparator to be used for priority checks
     */
    Comparator<T> comp;

    /** Constructor for the class PriorityQueue
     * 
     * @param a which is an ArrayList
     * @param c which is a comparator
     */
    PriorityQueue(ArrayList<T> a, Comparator<T> c) {
        this.alist = a;
        this.comp = c;
    }

    PriorityQueue(Comparator<T> c) {
        this.alist = new ArrayList<T>();
        alist.add(null);
        this.comp = c;
    }

    /** returns true if the node has no children
     * 
     * @param label which is the number for the node to be checked
     * @return boolean, which determines if it's a leaf or not
     */
    boolean isLeaf(int label) {
        return ((label * 2) >= this.alist.size());
    }

    /** produces the index of its child with the highest priority
     * 
     * @param index which is the number of the child node
     * @return int, the index of the child of highest priority
     */
    int higherPriorityChild(int index) {
        // return -1 if index is a leaf
        if (this.isLeaf(index)) {
            return -1;
        }

        /** Check if it has only one child, return that index
         * 
         */
        if (index * 2 == this.alist.size() - 1) {
            return (index * 2);
        }

        /** Return index of highest priority
         * 
         */
        if (comp.compare(alist.get(index * 2), 
                alist.get((index * 2) + 1)) >= 0) {
            return index * 2;
        }
        else {
            return (index * 2 + 1);
        }
    }

    /** inserts a new node into the heap
     * 
     * @param item which is the item to be inserted inside the tree
     * @result insert node in the heap tree
     */
    void insert(T item) {
        /**
         * Add item into arrayList
         */
        this.alist.add(item);

        int i = this.alist.size() - 1;
        int count = this.alist.size() - 1;

        while(count != 0) {
            if (this.alist.size() == 3) {
                if (this.comp.compare(this.alist.get(1), this.alist.get(2))
                        >= 0) {
                    break;
                }
                else {
                    this.alist.add(1, this.alist.get(2));
                    this.alist.remove(3);
                }
            }
            if (this.alist.size() == 2) {
                break;
            }
            if (this.comp.compare(this.alist.get(i), 
                    this.alist.get(i/2)) <= 0) {
                break;
            }
            else {
                /**
                 * Temporary placeHolders for the swapping nodes
                 */
                T newLower = this.alist.get(i/2);
                T newHigher = this.alist.get(i);

                /**
                 * Remove both nodes from the array
                 */
                this.alist.remove(i/2);
                this.alist.remove(i - 1);

                /**
                 * add first (higher one) in place of the old low one
                 */
                this.alist.add(i/2, newHigher);

                /** 
                 * check if it's the last node being replaced
                 */
                if (this.alist.size() == i - 1) {
                    this.alist.add(newLower);
                    for (int x = 0; i < this.alist.size(); x++) {
                        System.out.println(this.alist.get(x));
                    }
                    i = i/2;
                    count = count - 1;
                }
                else {
                    this.alist.add(i, newLower);
                    i = i/2;
                    count = count - 1;
                }
            }
        } 
    }

    /** removes a new node from the heap
     * 
     * @result remove highest priority node in the heap tree
     */
    public T remove() {
        T temp = this.alist.get(1);
        int k = 1;
        int ck = 0;
        T newHigher;
        T newLower;

        this.alist.remove(1);
        this.alist.add(1, this.alist.get(this.alist.size() - 1));
        this.alist.remove(this.alist.size() - 1);

        while(!this.isLeaf(k)) {
            ck = this.higherPriorityChild(k);

            if (this.comp.compare(this.alist.get(k), this.alist.get(ck)) < 0) {

                newHigher = this.alist.get(ck);
                newLower = this.alist.get(k);

                this.alist.remove(k);
                this.alist.remove(ck - 1);

                this.alist.add(k, newHigher);
                this.alist.add(ck, newLower);

                k = ck;
            }
            else {
                return temp;
            }   
        }
        return temp;
    }
}

/**
 * 
 * @author Hussein and Jarred
 *
 */
class ByNumber implements Comparator<Integer> {

    /**
     * @param Integer
     * @param Integer
     * @result return comparison of two integers
     */
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}

/**
 * 
 * @author Hussein and Jarred
 *
 */
class Heapsort<T> {

    /**
     * 
     * @param alist
     * @param comp
     * @return ArrayList of type T that is the HeapSort
     */
    public ArrayList<T> heapsort(ArrayList<T> alist, Comparator<T> comp) {
        PriorityQueue<T> pq = new PriorityQueue<T>(comp);

        /**
         * Insert elements from arrayList into the priorityQueue and
         * remove from the given arrayList
         */
        while(alist.size() != 0) {
            pq.insert(alist.get(0));
            alist.remove(0);
        }

        /**
         * add into the arrayList the values of PriorityQueue
         */
        while(pq.alist.size() != 1) {
            alist.add(pq.remove());
        }

        /**
         * return the answer (modified arrayList)
         */
        return alist; 
    }

}








