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
 * This is the Insertion Sort class.
 * @author michelle chuong
 */
public class InsertionSort implements SortAlgorithm {
    
    private SortTimer t;
    
    /*
     * Input: List of n comparable elements indexed 0 to n-1
     * Output: List of elements sorted in ascending order
     */
    @Override
    public void sort(double[] a, SortTimer t) {
        this.t = t;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {  //compare current value with elements i-1 to 0
                    t.addComparison();
                    swap(a, i, j);
                    t.addMoves(3);
                }
            }
        }
    }
    
    /**
     * This swap method takes two indexes in an 
     * array and swaps the elements in them.
     * @param a
     * @param i
     * @param j 
     */
    private void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}