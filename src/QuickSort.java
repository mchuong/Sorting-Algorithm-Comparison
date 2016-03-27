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
 * This is the Quick Sort class.
 *
 * @author michelle chuong
 */
public class QuickSort implements SortAlgorithm {

    private SortTimer t;

    /**
     * Input: List of n comparable elements indexed 0 to n-1 Output: List of
     * elements sorted in ascending order
     *
     * @param a
     * @param t
     */
    @Override
    public void sort(double[] a, SortTimer t) {
        this.t = t;
        quickSort(a, t, 0, a.length - 1);
    }

    /**
     * Recursive Quick Sort method.
     *
     * @param a
     * @param left
     * @param right
     */
    public void quickSort(double[] a, SortTimer t, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            double pivot = a[mid];
            int pos = partition(a, t, left, right, mid);   //partition list at middle
            quickSort(a, t, left, pos - 1);  //recursively quicksort elements left to pos-1
            quickSort(a, t, pos + 1, right); //recursively quicksort elements pos+1 to right
        }
    }

    /**
     * Input: List of elements from left to right and index of pivot element
     * Output: Rearranged list: [<=pivot, pivot, >pivot]; final index of pivot
     * element
     *
     * @param a
     * @param left
     * @param right
     * @param pivotIndex
     * @return
     */
    public int partition(double[] a, SortTimer t, int left, int right, int pivotIndex) {
        swap(a, pivotIndex, right); //swap pivot with element at position right
        int pos = left; //pos represents the boundary between small and large elements
        for (int i = left; i < right; i++) {
            if (a[i] <= a[pivotIndex]) {    //element at i is <= pivot
                t.addComparison();
                swap(a, i, pos);    //swap element at i with element at pos
                pos++;  //advance pos
                t.addMoves(3);
            }
        }
        swap(a, pivotIndex, pos);   //swap element at pivot with element at pos
        return pos;
    }

    /**
     * This swap method takes two indexes in an array and swaps the elements in
     * them.
     *
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