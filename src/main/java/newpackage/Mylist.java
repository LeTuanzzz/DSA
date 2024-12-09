package newpackage;

public class Mylist {
    private Node head;

    // Add a new student to the list
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Edit a student's details by ID
    public void editStudent(String id, String newFullName, double newMarks) {
        Node current = head;
        while (current != null) {
            if (current.student.getId().equals(id)) {
                current.student = new Student(id, newFullName, newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete a student by ID
    public void deleteStudent(String id) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.student.getId().equals(id)) {
            head = head.next;
            System.out.println("Student with ID " + id + " has been deleted.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.student.getId().equals(id)) {
                current.next = current.next.next;
                System.out.println("Student with ID " + id + " has been deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Display all students in the list
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Full Name", "Marks", "Ranking");
        System.out.println("-------------------------------------------------------------");
        Node current = head;
        while (current != null) {
            Student student = current.student;
            System.out.printf("%-10s %-20s %-10.2f %-10s%n",
                    student.getId(), student.getFullName(), student.getMarks(), student.getRanking());
            current = current.next;
        }
    }

    // Sort students by their marks in ascending order (Bubble Sort)
 public void sortStudents() {
    if (head == null || head.next == null) return;

    for (Node end = null; end != head; end = getEndBefore(end)) {
        for (Node current = head; current.next != end; current = current.next) {
            if (current.student.getMarks() > current.next.student.getMarks()) {
                // Hoán đổi dữ liệu
                Student temp = current.student;
                current.student = current.next.student;
                current.next.student = temp;
            }
        }
    }
    System.out.println("Students have been sorted by marks using Bubble Sort.");
}

// Hàm phụ để tìm node đứng trước node 'end'
private Node getEndBefore(Node end) {
    Node current = head;
    while (current.next != null && current.next != end) {
        current = current.next;
    }
    return current;
}
public void selectionSortStudents() {
    if (head == null || head.next == null) return;

    for (Node current = head; current != null; current = current.next) {
        Node maxNode = current; // Start by assuming the current node has the max marks

        for (Node nextNode = current.next; nextNode != null; nextNode = nextNode.next) {
            if (nextNode.student.getMarks() > maxNode.student.getMarks()) {  // Changed to ">" for descending order
                maxNode = nextNode;
            }
        }

        // Swap if necessary (if the maxNode is different from the current node)
        if (maxNode != current) {
            Student temp = current.student;
            current.student = maxNode.student;
            maxNode.student = temp;
        }
    }
    System.out.println("Students have been sorted by marks (descending) using Selection Sort.");
}


    // Search for a student by ID
    public Student searchStudent(String id) {
        Node current = head;
        while (current != null) {
            if (current.student.getId().equals(id)) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }
}
