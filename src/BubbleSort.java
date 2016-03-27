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
 * This is the Bubble Sort class.
 * @author michelle chuong
 */
public class BubbleSort implements SortAlgorithm {

    private SortTimer t;
    
    @Override
    public void sort(double[] a, SortTimer t) {
        this.t = t;
        for (int i = a.length - 1; i > 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                t.addComparison();
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    private void swap(double[] a, int i, int j) {
        double ai = a[i];
        a[i] = a[j];
        a[j] = ai;
        t.addMoves(3);
    }
}
