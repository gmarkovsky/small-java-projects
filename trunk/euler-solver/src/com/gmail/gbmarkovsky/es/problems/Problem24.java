package com.gmail.gbmarkovsky.es.problems;

public class Problem24 {
    public static void main(String[] args) {
        
        //permute(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        
        //permute(new int[] {0, 1, 2});
        
        int[] X = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        int i = 1;
        System.out.println(i + ":\t0123456789");
        while (permute2(X)) {
            i++;
            System.out.print(i + ":\t");
            print(X);
            if (i == 100) {
                return;
            }
        }
    }

    static void permute(int[] a) {
        int counter = 0;
        while (true) {
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i] < a[i + 1]) {
                    int m = a.length - 1;
                    while (a[m] < a[i]) {
                        m--;
                    }
                    int tmp = a[i];
                    a[i] = a[m];
                    a[m] = tmp;
                    for (int j = i + 1; j < a.length - (a.length - i)/2; j++) {
                        int k = a.length - j  + i;
                        int tp = a[j];
                        a[j] = a[k];
                        a[k] = tp;
                    }
                } else  if (i == 0) 
                    return;
                   else
                    continue;
                
                
                for (int j = 0; j < a.length; j++) {
                    System.out.print(a[j]);
                }
                counter++;
                if (counter == 1000000)
                    return;
                System.out.println();
            }
        }
    }
    
    static boolean permute2(int[] X) {
        int i = X.length - 2;
        while ((i >= 0) && (X[i] > X[i + 1])) {
            i--;
        }
        ;
        if (i >= 0) {
            int j = i + 1;
            while ((j < X.length - 2) && (X[j + 1] > X[i])) {
                j++;
            }
            int tmp = X[i];
            X[i] = X[j];
            X[j] = tmp;
            for (j = i + 1; j < (X.length + i) / 2; j++) {

                int tp = X[j];
                X[j] = X[X.length - j + i];
                X[X.length - j + i] = tp;
            }
            ;
        } else {
            return false;
        }
        return true;
    }
    
    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
