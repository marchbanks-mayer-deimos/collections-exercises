import java.util.ArrayList;
import java.util.HashMap;
//Create a class named Student.
public class Student {
    // private properties for the Student’s name, and grades.
    private String name;
    private ArrayList<Double> grades;
    // constructor that sets name property, and initializes the grades property as an empty ArrayList.
    public Student(String studentName) {
        this.name = studentName;
        this.grades = new ArrayList<>();
    }
    // returns the student’s name
    public String getName() {
        return this.name;
    }
    // adds the given grade to the grades property
    public void addGrade(double grade){
        this.grades.add(grade);
    }

    public ArrayList<Double> getGrades(){
        return grades;
    }
    // returns the average of the students grades
    public double getGradeAverage(){
        double sum =0;
        for (double grade: this.grades){
            sum += grade;
        } return sum / this.grades.size();
    }
    public static void main(String[] args) {
        Student roger = new Student("Roger");
        roger.addGrade(99);
        roger.addGrade(90);
        roger.addGrade(95);
        System.out.println(roger.getGradeAverage());
    }
}
