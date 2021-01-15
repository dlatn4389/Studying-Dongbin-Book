package Chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem6_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Student[] students = new Student[T];
        sc.nextLine();
        for (int i=0; i<T; i++) {
            String[] input = sc.nextLine().split(" ");
            students[i] = new Student(input[0], Integer.parseInt(input[1]));
        }
        Arrays.sort(students, new StudentComparator());
        for (int i=0; i<T; i++) {
            students[i].show();
        }
    }
}

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    void show() {
        System.out.println(name);
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.score > s2.score) {
            return 1;
        }
        else if (s1.score < s2.score) {
            return -1;
        }
        return 0;
    }
}
