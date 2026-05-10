import java.util.ArrayList;
import java.util.Iterator;

// Generic class to store student details
class Student<T> {
    private T studentId;
    private String name;
    private String department;
    private double cgpa;

    public Student(T studentId, String name, String department, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
    }

    public T getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name      : " + name);
        System.out.println("Department: " + department);
        System.out.println("CGPA      : " + cgpa);
        System.out.println("-----------------------------");
    }
}

// Main class
public class StudentRecordManagement {
    public static void main(String[] args) {

        ArrayList<Student<Integer>> studentList = new ArrayList<>();

        studentList.add(new Student<Integer>(101, "Arun", "CSE", 8.7));
        studentList.add(new Student<Integer>(102, "Bala", "IT", 8.9));
        studentList.add(new Student<Integer>(103, "Charan", "AIML", 9.1));
        studentList.add(new Student<Integer>(104, "Dinesh", "ECE", 8.3));

        System.out.println("Student Records");
        System.out.println("=============================");

        Iterator<Student<Integer>> iterator = studentList.iterator();

        while (iterator.hasNext()) {
            Student<Integer> student = iterator.next();
            student.displayStudent();
        }
    }
}