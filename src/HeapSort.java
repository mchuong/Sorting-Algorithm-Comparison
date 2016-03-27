/*
 * CS241-01: Data Structures and Algorithms II
 * Professor: Mandayam Srinivas
 * 
 * Programming Project #3
 * 
 * Scaling Behavior of Sorting Algorithms
 * 
 * Michelle Chuong
 */

/**
 * This is the Heap Sort class.
 * @author michelle chuong
 */
public class HeapSort implements SortAlgorithm {
    
    private SortTimer t;
    
    /**
     * Input: List of n comparable elements
     * Output: List of elements sorted in ascending order
     * @param a
     * @param t 
     */
    public void sort(double[] a, SortTimer t) {
        this.t = t;
	//convert list into heap
        DoublePriorityQueue q = new DoublePriorityQueue(a,t);
        
        for (int i = 0; i < a.length; i++) {
            //delete minimum element and add to end of new list
            a[i] = q.poll();    
	}   
    }    
}