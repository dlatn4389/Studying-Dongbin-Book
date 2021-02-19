#include <iostream>
using namespace std;

int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

int binary_search(int target, int start, int end) {
    if (start>end) return -1;

    int mid = (start+end)/2;

    if (array[mid]==target) {
        return mid;
    }
    else if (array[mid]>target) {
        return binary_search(target, start, mid-1);
    }
    else if (target>array[mid]) {
        return binary_search(target, mid+1, end);
    }
}

int main() {
    int n;
    cin >> n;

    int result = binary_search(n, 0, 9);

    if (result==-1) {
        cout << "Not exist";
    }
    else {
        cout << result;
    }
}
