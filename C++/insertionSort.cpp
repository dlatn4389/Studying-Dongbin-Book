#include <iostream>
using namespace std;

int randNum = 3195413;

int rand(int k) {
    randNum = 4819431*k + 319801*randNum + 38913051;
    int ans = randNum%39113;
    if (ans<0) {
        return ans+39113;
    }
    return ans;
}

int main() {
    int array[10000];

    for (int i=0; i<10000; i++) {
        array[i] = rand(i);
    }

    for (int i=1; i<10000; i++) {
        for (int j=i; j>0; j--) {
            if (array[j]<array[j-1]) {
                swap(array[j], array[j-1]);
            }
        }
    }

    for (int i : array) {
        cout << i << " ";
    }
}
