//package mk.ukim.finki.lab2.ContactsTester;
//
//import java.util.Arrays;
//
//public class Faculty {
//    String name;
//    Student [] students;
//
//    public Faculty(String name, Student[] students) {
//        this.name = name;
//        this.students = students;
//    }
//    int countStudentsFromCity(String cityName){
//        int count=0;
//        for(Student student:students){
//            if(student.getCity().equals(cityName))
//                count++;
//        }
//        return count;
//    }
//    Student getStudent(long index){
//        for(Student student:students)
//            if(student.getIndex()==index)
//                return student;
//        return null;
//    }
//    double getAverageNumberOfContacts(){
//        int vkupenbrStudenti = students.length;
//        int brojkontakti = 0;
//        for (Student student : students) {
//            brojkontakti += student.getEmailContactNumber() + student.getPhoneContactNumber();
//        }
//        return (float)brojkontakti / vkupenbrStudenti;
//    }
//    Student getStudentWithMostContacts(){
//        int max=0;
//        for(int i=1;i<students.length;i++){
//            if(students[max].contacts.length<students[i].contacts.length)
//                max=i;
//            else if(students[max].contacts.length==students[i].contacts.length){
//                if(students[max].index<students[i].index)
//                    max=i;
//            }
//        }
//        return students[max];
//    }
//
//    @Override
//    public String toString() {
//        return "Faculty{" +
//                "name='" + name + '\'' +
//                ", students=" + Arrays.toString(students) +
//                '}';
//    }
//}
