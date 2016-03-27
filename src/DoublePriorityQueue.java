/**
 * CS 241-01: Data Structures and Algorithms II
 * Professor: Mandayam Srinivas
 *
 * Programming Project #3
 *
 * Scaling Behavior of Sorting Algorithms
 *
 * Michelle Chuong
 */

/**
 * This is the Double Priority Queue class for a generic heap-based priority
 * queue.
 *
 * @author Michelle Chuong
 */
public class DoublePriorityQueue {

    private double[] heap;	//heap array
    private int num;	//number of things in heap
    private int size;	//max size of heap
    private SortTimer t;

    /**
     * Constructor for heap contents.
     *
     * @param double[] a
     * @param SortTimer t
     */
    public DoublePriorityQueue(double[] a, SortTimer t) {
        heap = new double[a.length];
        size = a.length;
        this.t = t;
        System.arraycopy(a, 0, heap, 0, a.length);
        t.addMoves(a.length);
        heapify();
    }

    /**
     * Checks if position is a leaf.
     *
     * @param n
     * @return
     */
    public boolean isLeaf(int n) {
        return (n >= num / 2) && (n < num);
    }

    /**
     * Checks for position of left child.
     *
     * @param n
     * @return
     */
    public int leftchild(int n) {
        return 2 * n + 1;
    }

    /**
     * Checks for position of right child.
     *
     * @param n
     * @return
     */
    public int rightchild(int n) {
        return 2 * n + 2;
    }

    /**
     * Checks for position of parent.
     *
     * @param n
     * @return
     */
    public int parent(int n) {
        return (n - 1) / 2;
    }

    /**
     * Sift down node at position a as needed to restore heap property.
     *
     * @param a
     */
    private void siftdown(int a) {
        int b = a;
        int c = leftchild(b);
        t.addMoves(2);
        while (!isLeaf(b) && b > c) {
            t.addComparisons(2);
            b = c;
            t.addMove();
        }
    }

    /**
     * Percolate up node at position a as needed to restore heap property.
     *
     * @param a
     */
    private void percolate(int a) {
        int b = a;
        int c = parent(b);
        t.addMoves(2);
        while (b > 0 && b < c) {
            t.addComparisons(2);
            b = c;
            t.addMove();
        }
    }

    /**
     * Convert input array A into a heap.
     */
    public void heapify() {
        for (int i = num / 2 - 1; i >= 0; i--) {
            siftdown(i);
        }
    }

    /**
     * Returns the max element in queue.
     *
     * @return
     */
    public double peek() {
        return heap[num - 1];
    }

    /**
     * Add element e to queue and suitably reorganize queue.
     *
     * @param e
     */
    public void add(double e) {
        int a = num;
        heap[a] = e;
        t.addMoves(2);
        percolate(a);
    }

    /**
     * Delete and return max queue element and suitably reorganize queue.
     *
     * @return
     */
    public double poll() {
        double o = peek();
        num = num - 1;
        return o;
    }

    /**
     * Returns the size of the heap.
     *
     * @return
     */
    public int size() {
        return num;
    }

    @SuppressWarnings("null")
    public String toString() {
        String s = null;
        for (int i = 0; i < heap.length; i++) {
            double object = heap[i];
            s.concat(object + " ");
        }
        return s;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
