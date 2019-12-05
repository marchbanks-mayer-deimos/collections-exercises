import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class GradesApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        HashMap<String, Student> Students = new HashMap<>();
        boolean flag = true;
        Student bobby = new Student("Bobby");
        Student colin = new Student("Colin");
        Student roger = new Student("Roger");
        Student niloc = new Student("Niloc");

        bobby.addGrade(75);
        bobby.addGrade(80);
        bobby.addGrade(60);
        bobby.addGrade(70);

        colin.addGrade(97.5);
        colin.addGrade(98.11);
        colin.addGrade(100);
        colin.addGrade(92.7);

        roger.addGrade(90);
        roger.addGrade(93.55);
        roger.addGrade(65);
        roger.addGrade(100);

        niloc.addGrade(57.9);
        niloc.addGrade(11.89);
        niloc.addGrade(1);
        niloc.addGrade(72.9);

        Students.put("bobby-mcfly", bobby);
        Students.put("colinmarchbanks", colin);
        Students.put("roger-mayer", roger);
        Students.put("sknabhcramniloc", niloc);

        System.out.println("Welcome to the grades!\n");
        System.out.println("Here are the GitHub usernames for our students\n");
        for (HashMap.Entry<String, Student> entry : Students.entrySet()) {
            System.out.print("| " + entry.getKey() + " ");
        }
        System.out.print("|\n\n");
        while (flag == true) {
            System.out.println("Who would you like to spy on?\n");
            String userInput = scanner.nextLine();
            System.out.println();
            Student selectedStudent = null;
            String selectedStudentUserName = "";
            for (HashMap.Entry<String, Student> entry : Students.entrySet()) {
                if (userInput.equalsIgnoreCase(entry.getKey())) {
                    selectedStudent = entry.getValue();
                    selectedStudentUserName = entry.getKey();
                }
            }
            if (selectedStudent == null) {
                System.out.printf("Sorry %s wasn't a valid option.%n%n", userInput);
            } else {
                System.out.printf("Name: %s - GitHub Username: %s%nCurrent Average: %s%n%n", selectedStudent.getName(), selectedStudentUserName, df.format(selectedStudent.getGradeAverage()));
            }
            System.out.println("Would you like to spy on another student? Y/N\n");
            String userInput2 = scanner.nextLine();
            System.out.println();
            if (!userInput2.equalsIgnoreCase("y")) {
                flag = false;
            }
        }
        System.out.println("Have a nice day!");


    }
}
