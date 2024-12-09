package newpackage1;

public class Student {
    private String id;
    private String fullName;
    private double marks;

    public Student(String id, String fullName, double marks) {
        this.id = id;
        this.fullName = fullName;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getMarks() {
        return marks;
    }

    public String getRanking() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName + ", Marks: " + marks + ", Rank: " + getRanking();
    }
}
