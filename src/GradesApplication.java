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

        while (flag == true) {
            System.out.println("Welcome to the grades!\n");
            System.out.println("Here are the GitHub usernames for our students\n");
            for (HashMap.Entry<String, Student> entry : Students.entrySet()) {
                System.out.print("| " + entry.getKey() + " ");
            }
            System.out.print("|\n\n");
            int counter = 1;
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
                System.out.printf("Name: %s - GitHub Username: %s%nCurrent Average: %s%n", selectedStudent.getName(), selectedStudentUserName, df.format(selectedStudent.getGradeAverage()));
                for (double grade : selectedStudent.getGrades()) {
                    System.out.println("Grade " + counter + ": " + grade);
                    counter++;
                }
                System.out.println();
            }
            System.out.println("Would you like to spy on another student? Y/N\nOr would you like to see all the all the grades for all the students? Type \"all\"\nOr Would you like to see the class's average? Type \"class\"\nOr would you like to print a csv report for all the students? Type \"csv\"\n");
            String userInput2 = scanner.nextLine();
            System.out.println();
            if (!userInput2.equalsIgnoreCase("y") && !userInput2.equalsIgnoreCase("all") && !userInput2.equalsIgnoreCase("class") && !userInput2.equalsIgnoreCase("csv")) {
                flag = false;
            }
            if (userInput2.equalsIgnoreCase("all")) {
                for (HashMap.Entry<String, Student> entry : Students.entrySet()) {
                    String gradesString = "";
                    for (double grade : entry.getValue().getGrades()) {
                        gradesString += "|" + grade + "| ";
                    }
                    System.out.printf("%s's grades are : %s%n", entry.getValue().getName(), gradesString);
                }
                System.out.println();
                System.out.println("Would you like to spy on another student? Y/N\n");
                String userInput3 = scanner.nextLine();
                System.out.println();
                if (!userInput3.equalsIgnoreCase("y")) {
                    flag = false;
                }
            }
            if (userInput2.equalsIgnoreCase("class")) {
                double sum = 0;
                for (HashMap.Entry<String, Student> entry : Students.entrySet()) {
                    sum += entry.getValue().getGradeAverage();
                }
                System.out.printf("The class's average is : %s%n", df.format(sum / Students.entrySet().size()));
                System.out.println();
                System.out.println("Would you like to spy on another student? Y/N\n");
                String userInput3 = scanner.nextLine();
                System.out.println();
                if (!userInput3.equalsIgnoreCase("y")) {
                    flag = false;
                }
            }
            if(userInput2.equalsIgnoreCase("csv")){
                System.out.println("Here is the csv report for all the students (name,github_username,average).");
                for (HashMap.Entry<String, Student> entry : Students.entrySet()) {
                    System.out.println(entry.getValue().getName()+","+entry.getKey()+","+entry.getValue().getGradeAverage());
                }
                System.out.println();
                System.out.println("Would you like to spy on another student? Y/N\n");
                String userInput3 = scanner.nextLine();
                System.out.println();
                if (!userInput3.equalsIgnoreCase("y")) {
                    flag = false;
                }
            }

        }
        System.out.println("Have a nice day!");
    }
}
