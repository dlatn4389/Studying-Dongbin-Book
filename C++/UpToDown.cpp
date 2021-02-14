#include <iostream>
using namespace std;

int array[501];

void quickSort(int start, int end) {
    if (start>=end) return;

    int pivot = start;
    int left = start+1;
    int right = end;

    while (left<=right) {
        while (left<=end && array[left]<=array[pivot]) {
            left += 1;
        }
        while (right>start && array[right]>=array[pivot]) {
            right -= 1;
        }
        if (left>right) {
            swap(array[pivot], array[right]);
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

    for (int i=N-1; i>=0; i--) {
        cout << array[i] << '\n';
    }
}
