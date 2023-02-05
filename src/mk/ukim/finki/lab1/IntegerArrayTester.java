package mk.ukim.finki.lab1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class IntegerArrayTester {

    static final class IntegerArray {

        private final int[] a;

        public IntegerArray(int[] a) {
            this.a=Arrays.copyOf(a,a.length);
            String marija;
            marija="marija e nogo ubava i pametna";
        }

        public int[] getA() {
            return a;
        }



        int length() {
            return a.length;
        }

        int getElementAt(int i) {
            return a[i];
        }

        int sum() {
            int sum = 0;
            for (int j : a) {
                sum += j;
            }
            return sum;
        }

        double average() {
            int sum = sum();
            return (double) sum / a.length;
        }

        IntegerArray getSorted() {
            int[] ias = Arrays.copyOf(a, a.length);
            Arrays.sort(ias);
            IntegerArray sorted = new IntegerArray(ias);
            return sorted;
        }

        IntegerArray concat(IntegerArray ia) {
            int[] newList = new int[length() + ia.length()];
            int[] iaList =ia.getA();
            int k=0;
            for(int j:a){
                newList[k++]=j;
            }
            for(int i=length(),j=0;i< newList.length;i++){
                newList[i]=iaList[j++];
            }
            return new IntegerArray(newList);
        }


        @Override
        public String toString() {
           StringBuilder message=new StringBuilder();
           message.append("[");
           for(int i=0;i<a.length-1;i++){
               message.append(Integer.valueOf(a[i]));
               message.append(", ");
           }
           message.append(a[a.length-1]);
           message.append("]");
           return message.toString();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntegerArray that = (IntegerArray) o;
            return Arrays.equals(a, that.a);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(a);
        }
    }

    static class ArrayReader{
        static int n;
        static int[] a;
        static IntegerArray readIntegerArray(InputStream input) throws IOException {
            Scanner scanner=new Scanner(input);
            n=scanner.nextInt();
            a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=scanner.nextInt();
            }
            scanner.close();
            return new IntegerArray(a);
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        IntegerArray ia = null;
        switch (s) {
            case "testSimpleMethods":
                ia = new IntegerArray(generateRandomArray(scanner.nextInt()));
                testSimpleMethods(ia);
                break;
            case "testConcat":
                testConcat(scanner);
                break;
            case "testEquals":
                testEquals(scanner);
                break;
            case "testSorting":
                testSorting(scanner);
                break;
            case "testReading":
                testReading(new ByteArrayInputStream(scanner.nextLine().getBytes()));
                break;
            case "testImmutability":
                int a[] = generateRandomArray(scanner.nextInt());
                ia = new IntegerArray(a);
                testSimpleMethods(ia);
                testSimpleMethods(ia);
                IntegerArray sorted_ia = ia.getSorted();
                testSimpleMethods(ia);
                testSimpleMethods(sorted_ia);
                sorted_ia.getSorted();
                testSimpleMethods(sorted_ia);
                testSimpleMethods(ia);
                a[0] += 2;
                testSimpleMethods(ia);
                ia = ArrayReader.readIntegerArray(new ByteArrayInputStream(integerArrayToString(ia).getBytes()));
                testSimpleMethods(ia);
                break;
        }
        scanner.close();
    }

    static void testReading(InputStream in) throws IOException {
        IntegerArray read = ArrayReader.readIntegerArray(in);
        System.out.println(read);
    }

    static void testSorting(Scanner scanner) {
        int[] a = readArray(scanner);
        IntegerArray ia = new IntegerArray(a);
        System.out.println(ia.getSorted());
    }

    static void testEquals(Scanner scanner) {
        int[] a = readArray(scanner);
        int[] b = readArray(scanner);
        int[] c = readArray(scanner);
        IntegerArray ia = new IntegerArray(a);
        IntegerArray ib = new IntegerArray(b);
        IntegerArray ic = new IntegerArray(c);
        System.out.println(ia.equals(ib));
        System.out.println(ia.equals(ic));
        System.out.println(ib.equals(ic));
    }

    static void testConcat(Scanner scanner) {
        int[] a = readArray(scanner);
        int[] b = readArray(scanner);
        IntegerArray array1 = new IntegerArray(a);
        IntegerArray array2 = new IntegerArray(b);
        IntegerArray concatenated = array1.concat(array2);
        System.out.println(concatenated);
    }

    static void testSimpleMethods(IntegerArray ia) {
        System.out.print(integerArrayToString(ia));
        System.out.println(ia);
        System.out.println(ia.sum());
        System.out.printf("%.2f\n", ia.average());
    }


    static String integerArrayToString(IntegerArray ia) {
        StringBuilder sb = new StringBuilder();
        sb.append(ia.length()).append('\n');
        for (int i = 0; i < ia.length(); ++i)
            sb.append(ia.getElementAt(i)).append(' ');
        sb.append('\n');
        return sb.toString();
    }

    static int[] readArray(Scanner scanner) {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }
        return a;
    }


    static int[] generateRandomArray(int k) {
        Random rnd = new Random(k);
        int n = rnd.nextInt(8) + 2;
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = rnd.nextInt(20) - 5;
        }
        return a;
    }

}
