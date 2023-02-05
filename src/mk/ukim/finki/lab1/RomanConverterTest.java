package mk.ukim.finki.lab1;

public class RomanConverterTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        IntStream.range(0, n)
//                .forEach(x -> System.out.println(RomanConverter.toRoman(scanner.nextInt())));
//        scanner.close();
        System.out.println(Math.random());
    }
}


class RomanConverter {
    /**
     * Roman to decimal converter
     *
     * @param n number in decimal format
     * @return string representation of the number in Roman numeral
     */
//    public static String addLetter(int num, String prev, int year){
//        if(num>year){
//            prev=prev+"M";
//            num-=1000;
//        }
//
//        return prev;
//    }
    public static String toRoman(int n) {
        String romanNum="";
        int values[]={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romanLetters = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        while(n>0){
            for(int i=values.length-1;i>=0;i--){
                if(n>=values[i]){
                    n-=values[i];
                    romanNum=romanNum+romanLetters[i];
                    i=0;
                }
            }
        }
        return romanNum;
    }

}
