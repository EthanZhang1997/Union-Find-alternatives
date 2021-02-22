package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;

public class DeducerForUnionFindAlternatives {
    private static final int[] testNumbers= {10, 100, 1000, 10000, 100000, 1000000};

    public static int count_WQU(int n) {
        WQU h = new WQU(n);
        int numberOfNeededConnections = 0;
        Random ran = new Random();
        while (h.count() != 1) {
            int p = ran.nextInt(n);
            int q = ran.nextInt(n);
            if (p != q) {
                h.union(p ,q);
                numberOfNeededConnections++;
            }
        }
        return numberOfNeededConnections;
    }

    public static int count_WQU_Depth(int n) {
        WQU_Depth h = new WQU_Depth(n);
        int numberOfNeededConnections = 0;
        Random ran = new Random();
        while (h.count() != 1) {
            int p = ran.nextInt(n);
            int q = ran.nextInt(n);
            if (p != q) {
                h.union(p ,q);
                numberOfNeededConnections++;
            }
        }
        return numberOfNeededConnections;
    }

    public static int count_WQUPC(int n) {
        WQUPC h = new WQUPC(n);
        int numberOfNeededConnections = 0;
        Random ran = new Random();
        while (h.count() != 1) {
            int p = ran.nextInt(n);
            int q = ran.nextInt(n);
            if (p != q) {
                h.union(p ,q);
                numberOfNeededConnections++;
            }
        }
        return numberOfNeededConnections;
    }

    public static void main(String[] args) {
        // Benchmark WQU
        for (int i : testNumbers) {
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "WQU", b -> DeducerForUnionFindAlternatives.count_WQU(i));
            double x = bm.run(true, 10);
            System.out.println("The time cost for connecting " + i + " nodes with WQU is: " + x + "\n");
        }

        // Benchmark WQU which stores depth instead of size
        for (int i : testNumbers) {
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "WQU_Depth", b -> DeducerForUnionFindAlternatives.count_WQU_Depth(i));
            double x = bm.run(true, 10);
            System.out.println("The time cost for connecting " + i + " nodes with WQU which stores depth instead of size is: " + x + "\n");
        }

        // Benchmark WQUPC
        for (int i : testNumbers) {
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "WQUPC", b -> DeducerForUnionFindAlternatives.count_WQUPC(i));
            double x = bm.run(true, 10);
            System.out.println("The time cost for connecting " + i + " nodes with WQUPC is: " + x + "\n");
        }
    }
}
