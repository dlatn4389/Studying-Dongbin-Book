#include <iostream>
using namespace std;
#include <algorithm>
#include <vector>

int nums[502] = {0, };

class Stage {
public:
    int stage;
    double failure_rate;
    Stage() {}
    Stage(int stage, double failure_rate): stage(stage), failure_rate(failure_rate) {}
};

bool compare(Stage s1, Stage s2) {
    if (s1.failure_rate==s2.failure_rate) {
        return s1.stage < s2.stage;
    }
    return s1.failure_rate > s2.failure_rate;
}

double get_failure_rate(int stage, int N) {
    int not_clear = 0;
    int adventure = 0;
    for (int i=1; i<=N+1; i++) {
        int n = nums[i];
        if (n>0 && i>=stage) {
            while (n--) {
                adventure++;
                if (i==stage) {
                    not_clear++;
                }
            }
        }
    }
    if (adventure==0) return 0;
    return (double)not_clear/adventure;
}

vector<int> solution(int N, vector<int> stages) {
    for (int i : stages) {
        nums[i]++;
    }
    Stage failures[N];

    for (int i=1; i<=N; i++) {
        failures[i-1] = Stage(i, get_failure_rate(i, N));
    }
    sort(failures, failures+N, compare);

    vector<int> ans;
    for (Stage s : failures) {
        ans.push_back(s.stage);
    }

    return ans;
}

int main() {

}
