import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

/** Class to hold examples of Heap graphs and tests 
 * @author Jarred and Hussein
 * @version 3-31-2014
 */
@RunWith(JUnit4.class)
public class ExamplesHeapTest {

    // Examples of ArrayLists 
    ArrayList<Integer> myHeap = new ArrayList<Integer>();
    ArrayList<Integer> heap1 = new ArrayList<Integer>();
    ArrayList<Integer> heap2 = new ArrayList<Integer>();
    ArrayList<Integer> heap3 = new ArrayList<Integer>();
    ArrayList<Integer> heap4 = new ArrayList<Integer>();

    Comparator<Integer> comp = new ByNumber();

    // Adds the values to myHeap in the proper order
    void initHeap() {
        this.myHeap.add(null);
        this.myHeap.add(70);
        this.myHeap.add(60);
        this.myHeap.add(40);
        this.myHeap.add(35);
        this.myHeap.add(50);
    }

    // Adds the values to heap1 in the proper order
    void initHeap1() {  
        this.heap1.add(null);
        this.heap1.add(80);
        this.heap1.add(50);
        this.heap1.add(40);
        this.heap1.add(45);
        this.heap1.add(20);
        this.heap1.add(30);
    }

    // Adds the values to heap4 in the proper order
    void initMyHeap() {    
        this.heap4.add(null);
        this.heap4.add(70);
        this.heap4.add(60);
        this.heap4.add(65);
        this.heap4.add(35);
        this.heap4.add(50);
        this.heap4.add(40);
        this.heap4.add(20);
        this.heap4.add(15);
        this.heap4.add(25);
        this.heap4.add(30);
        this.heap4.add(49);
        this.heap4.add(33);
    }

    /** Testing the equals method in the Word class
     * @result Will return a boolean whether the two objects are the same
     */
    @Test
    public void testPriorityQueue() { 
        assertEquals(myHeap.equals(heap1), true);
        initHeap();
        initHeap1();
        assertEquals(myHeap.equals(heap1), false);

        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(myHeap, comp);
        pq1.insert(65);
        initMyHeap();

        assertEquals(myHeap.equals(heap4), false);
        assertEquals(pq1.isLeaf(3), false);
        assertEquals(pq1.isLeaf(4), true);
        assertEquals(pq1.higherPriorityChild(1), 3);

        assertEquals(pq1.isLeaf(3), false);
        assertEquals(pq1.higherPriorityChild(3), 6);
        assertEquals(pq1.higherPriorityChild(2), 5);
        assertEquals(pq1.higherPriorityChild(5), -1);

        PriorityQueue<Integer> pq2 = 
                new PriorityQueue<Integer>(heap4, comp);

        assertEquals(pq1.remove(), new Integer(70));
        assertEquals(pq1.remove(), new Integer(65));
        assertEquals(pq1.remove(), new Integer(60));
        assertEquals(pq1.remove(), new Integer(50));
        assertEquals(pq1.remove(), new Integer(40));
        assertEquals(pq1.remove(), new Integer(35));
        assertEquals(pq2.remove(), new Integer(70));   

        Heapsort<Integer> hs = new Heapsort<Integer>();
        ArrayList<Integer> a1 =
                new ArrayList<Integer>(Arrays.asList(5, 20, 15, 10));
        ArrayList<Integer> a2 =
                new ArrayList<Integer>(Arrays.asList(20, 15, 10, 5));
        ArrayList<Integer> a3 =
                new ArrayList<Integer>(Arrays.asList(null, 20, 10, 15, 5));
        
        PriorityQueue<Integer> pq3 = 
                new PriorityQueue<Integer>(comp);
        
        pq3.insert(5);
        pq3.insert(20);
        pq3.insert(15);
        pq3.insert(10);
        assertEquals(pq3.alist, a3);

        assertEquals(hs.heapsort(a1, comp), a2);
        

    }
}








