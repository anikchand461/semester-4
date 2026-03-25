import java.util.*;

class Student {
  int id;
  String name;
  int marks;

  Student(int id, String name, int marks) {
    this.id = id;
    this.name = name;
    this.marks = marks;
  }

  void display() {
    System.out.println(id + " " + name + " " + marks);
  }
}

class q3 {
  public static void main(String[] args) {
    Student s1 = new Student(1, "Anik", 98);
    Student s2 = new Student(2, "Sonik", 45);
    Student s3 = new Student(3, "Onik", 78);

    s1.display();
    s2.display();
    s3.display();
  }
}
