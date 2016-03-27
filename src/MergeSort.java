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
 * This is the Merge Sort class.
 * @author michelle chuong
 */
public class MergeSort implements SortAlgorithm {
    
    private SortTimer t;
    
    /**
     * Input: List of n comparable elements indexed 0 to n-1
     * Output: List of elements sorted in ascending order
     * @param a
     * @param t 
     */
    @Override
    public void sort(double[] a, SortTimer t) {
        this.t = t;
        //mergeSort(0, a.length-1);
        merge_Sort(a, t, 0, a.length-1);
    }
    
    /**
     * Recursive Merge Sort method.
     * @param a
     * @param t
     * @param left
     * @param right 
     */
    public void merge_Sort(double[] a, SortTimer t, int left, int right) {
        if (left < right) {
            t.addComparison();
            //set mid to the middle index in range left to right
            int middle = left + (right - left) / 2;
            //recursively mergesort elements left to middle
            merge_Sort(a, t, left, middle);
            //recursively mergesort elements middle+1 to right
            merge_Sort(a, t, middle + 1, right);
            //merge two sorted lists and return result
            merge_(a, t, left, middle, right);
        }
    }
    
    /**
     * Merge method.
     * @param a
     * @param t
     * @param left
     * @param middle
     * @param right 
     */
    public void merge_(double[] a, SortTimer t, int left, int middle, int right) {
        double[] b = new double[a.length];
        for (int i = left; i <= right; i++) {
            b[i] = a[i];
            t.addMove();
        }
        int i = left;
        int j = middle + 1;
        int k = left;
        //compare elements and add to new list
        while (i <= middle && j <= right) {
            if (b[i] <= b[j]) {
                t.addComparison();
                a[k] = b[i];
                i++;
                t.addMove();
            } else {
                a[k] = b[j];
                j++;
                t.addMove();
            }
            k++;
        }
        while (i <= middle) {
            a[k] = b[i];
            k++;
            i++;
            t.addMove();
        }
    }   
}