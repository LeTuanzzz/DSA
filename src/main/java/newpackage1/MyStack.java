package newpackage1;

public class MyStack {
    private Node top;

    public void push(Student student) {
        Node newNode = new Node(student);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public Student pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return null;
        }
        Student removedStudent = top.student;
        top = top.next;
        return removedStudent;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("No students to display.");
            return;
        }
        Node current = top;
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Full Name", "Marks", "Ranking");
        System.out.println("-------------------------------------------------------------");
        while (current != null) {
            Student student = current.student;
            System.out.printf("%-10s %-20s %-10.2f %-10s%n",
                    student.getId(), student.getFullName(), student.getMarks(), student.getRanking());
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}
