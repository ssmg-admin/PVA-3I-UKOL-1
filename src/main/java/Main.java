import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void naplnPole(int[] pole, int maxHodnota) {
        Random rand = new Random();
        for (int i = 0; i < pole.length; i++) {
            pole[i] = rand.nextInt(maxHodnota + 1);
        }
    }


    public static void bubbleSort(int[] pole){
        int n = pole.length;
        boolean vymena = false;


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (pole[j] > pole[j + 1]) {
                    int temp = pole[j];
                    pole[j] = pole[j + 1];
                    pole[j + 1] = temp;
                    vymena = true;
                }
            }

            if (!vymena) break;
        }
    }


    public static void binarySearch(int[] pole, int klic) {
        int left = 0;
        int right = pole.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (pole[mid] == klic) {
                System.out.println("Číslo nalezeno na indexu: " + mid);
                return;
            } else if (pole[mid] < klic) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Číslo nebylo nalezeno.");
    }

    public static void time(Runnable kod) {
        long start = System.nanoTime();

        kod.run();

        long end = System.nanoTime();
        double sekundy = (end - start) / 1_000_000_000.0;
        System.out.println("Doba běhu: " + sekundy + " s");
    }

    public static void main(String[] args) {
        int delkaPole = 50_000;
        int maxElement = 100_000;
        int hledaneCislo = 80_000;
        int[] pole = new int[delkaPole];


        time(() -> naplnPole(pole,maxElement));
        time(() -> bubbleSort(pole));
        time(() -> binarySearch(pole,hledaneCislo));

    }
}
