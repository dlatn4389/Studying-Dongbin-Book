#include <iostream>
using namespace std;

class Student {
public:
    string name;
    int score;
    Student() {}
    Student(string name, int score): name(name), score(score) {}

    void print() {
        cout << name << '\n';
    }
};

bool compare(Student s1, Student s2) {
    return s1.score < s2.score;
}

int main() {
    int N; cin >> N;

    Student students[N];
    for (int i=0; i<N; i++) {
        string name; int score;
        cin >> name >> score;
        students[i] = Student(name, score);
    }
}
