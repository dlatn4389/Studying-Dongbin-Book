#include <iostream>
using namespace std;

int array[10000];

void quickSort(int start, int end) {
    if (start>=end) return;

    int pivot = start;
    int left = start+1;
    int right = end;

    while (left<=right) {
        while (left<=end && array[left]<=array[pivot]) {
            left++;
        }
        while (right>start && array[right]>=array[pivot]) {
            right--;
        }
        if (left>right) {
            swap(array[right], array[pivot]);
        }
        else {
            swap(array[left], array[right]);
        }
    }

    quickSort(start, right-1);
    quickSort(right+1, end);
}

int main() {
    int N; cin >> N;
    for (int i=0; i<N; i++) {
        cin >> array[i];
    }
    quickSort(0, N-1);

    for (int i=0; i<N; i++) {
        cout << array[i] << " ";
    }
}
