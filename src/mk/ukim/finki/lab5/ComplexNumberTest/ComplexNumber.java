//package mk.ukim.finki.lab5.ComplexNumberTest;
//
//public class ComplexNumber<T extends Number, U extends Number> implements Comparable<ComplexNumber<?,?>>{
//    private T real;
//    private U imaginary;
//
//    public ComplexNumber(T real, U imaginary) {
//        this.real = real;
//        this.imaginary = imaginary;
//    }
//
//    public T getReal() {
//        return real;
//    }
//
//    public U getImaginary() {
//        return imaginary;
//    }
//    public double modul(){
//        return Math.sqrt(Math.pow(real.doubleValue(),2)+Math.pow(imaginary.doubleValue(),2));
//    }
//    @Override
//    public String toString() {
//        if(imaginary.doubleValue()>=0)
//        return String.format("%.2f+%.2fi",real.doubleValue(),imaginary.doubleValue() );
//        else return String.format("%.2f%.2fi",real.doubleValue(),imaginary.doubleValue() );
//    }
//
//    @Override
//    public int compareTo(ComplexNumber<?, ?> o) {
//        return Double.compare(modul(),o.modul());
//    }
//}
