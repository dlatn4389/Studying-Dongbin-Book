#include <iostream>
using namespace std;

int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

int binary_search(int target, int start, int end) {
    while (start<=end) {
        int mid = (start+end)/2;

        if (array[mid]==target) {
            return mid;
        }
        else if (target>array[mid]) {
            start = mid+1;
        }
        else if (array[mid]>target) {
            end = mid-1;
        }
    }
    return -1;
}

int main() {
    int n;
    cin >> n;

    int result = binary_search(n, 0, 9);
    if (result==-1) {
        cout << "Not exist.";
    }
    else {
        cout << result;
    }
}