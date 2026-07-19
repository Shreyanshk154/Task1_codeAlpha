import java.util.*;

class Student {
    private String name;
    private Map<String, Integer> subjectGrades;

    public Student(String name) {
        this.name = name;
        this.subjectGrades = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        subjectGrades.put(subject, grade);
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }

    // Convert marks to grade letter
    public String getGradeLetter(int marks) {
        if (marks >= 90) return "O";
        else if (marks >= 80) return "A+";
        else if (marks >= 70) return "A";
        else if (marks >= 60) return "B+";
        else if (marks >= 50) return "B";
        else return "F";
    }

    public double getAverage() {
        if (subjectGrades.isEmpty()) return 0;
        int sum = 0;
        for (int g : subjectGrades.values()) sum += g;
        return (double) sum / subjectGrades.size();
    }

    public int getHighest() {
        if (subjectGrades.isEmpty()) return 0;
        return Collections.max(subjectGrades.values());
    }

    public int getLowest() {
        if (subjectGrades.isEmpty()) return 0;
        return Collections.min(subjectGrades.values());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of subjects for " + name + ": ");
            int subCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < subCount; j++) {
                System.out.print("Enter subject name: ");
                String subject = sc.nextLine();
                System.out.print("Enter marks for " + subject + ": ");
                int marks = sc.nextInt();
                sc.nextLine();
                student.addGrade(subject, marks);
            }
            students.add(student);
        }

        System.out.println("\n=== Summary Report ===");
        for (Student s : students) {
            System.out.println("Student: " + s.getName());
            for (Map.Entry<String, Integer> entry : s.getSubjectGrades().entrySet()) {
                String subject = entry.getKey();
                int marks = entry.getValue();
                String gradeLetter = s.getGradeLetter(marks);
                System.out.println(subject + ": " + marks + " (" + gradeLetter + ")");
            }
            System.out.printf("Average Marks: %.2f\n", s.getAverage());
            System.out.println("Highest Marks: " + s.getHighest());
            System.out.println("Lowest Marks: " + s.getLowest());
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
