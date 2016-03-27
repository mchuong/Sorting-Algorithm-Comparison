
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
 * This is the Sorter class
 *
 * @author michelle chuong
 */
public class Sorter {

    public static void main(String args[]) {
        //Sorter bubble = new Sorter('b');
        //System.out.println();
        Sorter insertion = new Sorter('i');
        System.out.println();
        Sorter merge = new Sorter('m');
        System.out.println();
        Sorter quick = new Sorter('q');
        System.out.println();
        Sorter heap = new Sorter('h');
    }

    public Sorter(char method) {
        SortAlgorithm s = null;
        SortTimer t = new SortTimer();

        switch (method) {
            case 'b':
                s = new BubbleSort();
                System.out.println("BubbleSort");
                break;
            case 'h':
                s = new HeapSort();
                System.out.println("HeapSort");
                break;
            case 'i':
                s = new InsertionSort();
                System.out.println("InsertionSort");
                break;
            case 'm':
                s = new MergeSort();
                System.out.println("MergeSort");
                break;
            case 'q':
                s = new QuickSort();
                System.out.println("QuickSort");
                break;
        }

        int ti = 1; //exponent
        int n = (int) Math.pow(10, ti);
        long time = 0;
        long comp = 0;
        long move = 0;

        double[] test = new double[n];

        if (method == 'i') {
            long avTime = 0;
            long avComp = 0;
            long avMove = 0;
            while (ti < 5) {
                System.out.printf("%1s %12s %13s %13s%n", "n", "time", "comps", "moves");
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < n; k++) {
                        test[k] = Math.random();
                    }

                    t.reset();
                    s.sort(test, t);
                    move = t.getMoves();
                    comp = t.getComparisons();
                    time = t.getElapsedTime();
                    avTime += time;
                    avComp += comp;
                    avMove += move;
                    System.out.printf("%1d %9d %12d %13d%n", n, time / 1000, comp, move);
                }
                ti++;
                n = (int) Math.pow(10, ti);
                test = new double[n];

                avTime = (avTime / 1000) / 5;
                avComp = avComp / 5;
                avMove = avMove / 5;
                System.out.printf("%1s %8d %10d %12d%n", "Averages: ", avTime, avComp, avMove);

            }
        } else {
            long avTime = 0;
            long avComp = 0;
            long avMove = 0;
            while (ti < 6) {
                System.out.printf("%1s %12s %13s %13s%n", "n", "time", "comps", "moves");
                for (int l = 0; l < 5; l++) {
                    for (int m = 0; m < n; m++) {
                        test[m] = Math.random();
                    }

                    t.reset();
                    s.sort(test, t);
                    move = t.getMoves();
                    comp = t.getComparisons();
                    time = t.getElapsedTime();
                    avTime += time;
                    avComp += comp;
                    avMove += move;
                    System.out.printf("%1d %9d %12d %13d%n", n, time / 1000, comp, move);
                }
                ti++;
                n = (int) Math.pow(10, ti);
                test = new double[n];

                avTime = (avTime / 1000) / 6;
                avComp = avComp / 6;
                avMove = avMove / 6;
                System.out.printf("%1s %8d %10d %12d%n", "Averages: ", avTime, avComp, avMove);

            }
        }
    }
}
