#include <iostream>
using namespace std;

void swap(int& a, int& b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int array[10000];

    for (int i=0; i<5000; i++) {
        array[i] = i+10000;
    }
    for (int i=5000; i<10000; i++) {
        array[i] = i;
    }

    for (int i=0; i<10000; i++) {
        int minIndex = i;
        for (int j=i+1; j<10000; j++) {
            if (array[minIndex]>array[j]) {
                minIndex = j;
            }
        }
        swap(array[i], array[minIndex]);
    }

    for (int i : array) {
        cout << i << " ";
    }
}
