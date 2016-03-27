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
 * This is the Sort Timer class.
 * @author michelle chuong
 */
public class SortTimer {

    long comparisons;
    long moves;
    long time;

    void reset() {
        comparisons = 0;
        moves = 0;
        time = System.nanoTime();
    }

    void addComparison() {
        comparisons++;
    }
    
    void addComparisons(int n) {
        comparisons += n;
    }

    void addMove() {
        moves++;
    }
    
    void addMoves(int n) {
        moves += n;
    }

    long getComparisons() {
        return comparisons;
    }

    long getMoves() {
        return moves;
    }

    long getElapsedTime() {
        return System.nanoTime() - time;
    }
}