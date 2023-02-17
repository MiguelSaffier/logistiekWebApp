package sr.unasat.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {

    static Scanner sc = new Scanner(System.in);

    public static String scanstring() {
        return sc.nextLine();
    }

    public static double scandouble() {
        return sc.nextDouble();
    }

    public static int scanInt() {
        return sc.nextInt();
    }

    public static List<Integer> scanIntList() {
        List<Integer> a = new ArrayList<>();
        System.out.println("Hoeveel producten: ");
        int b = scanInt();
        for (int i = 1; i < b + 1; i++) {
            System.out.println("hoeveelheid product " + i + ": ");
            int c = scanInt();
            a.add(c);
        }
        return a;
    }

    public static List<String> scanStringList() {
        List<String> a = new ArrayList<>();
        System.out.println("Hoeveel producten: ");
        int b = scanInt();
        for (int i = 1; i < b + 1; i++) {
            System.out.println("Product " + i + ": ");
            String c = scanstring();
            a.add(c);
        }
        return a;
    }

}
