#include <iostream>
using namespace std;

string plusString(string a, string b) {
    for (char c : b) {
        a.push_back(c);
    }
    return a;
}

bool isBalanced(string s) {
    int count1 = 0, count2 = 0;
    for (char c : s) {
        if (c=='(') count1++;
        else if (c==')') count2++;
    }
    return count1==count2;
}

bool isRight(string s) {
    int count = 0;
    for (char c : s) {
        if (c=='(') count++;
        else if (c==')') count--;
        if (count<0) return false;
    }
    if (count!=0) return false;
    return true;
}

string solution(string w) {
    if (w=="") return "";
    else {
        string u, v;
        int length = w.length();
        for (int i=1; i<=length; i++) {
            u = w.substr(0, i);
            v = w.substr(i, length-i);
            if (isBalanced(u)) {
                break;
            }
        }

        if (isRight(u)) {
            return plusString(u, solution(v));
        }
        else {
            string str = "(";
            str = plusString(str, solution(v));
            str.push_back(')');
            u = u.substr(1, u.length()-2);
            for (char c : u) {
                if (c=='(') {
                    str.push_back(')');
                }
                else if (c==')') {
                    str.push_back('(');
                }
            }
            return str;
        }
    }
}

int main() {
    string input; cin >> input;

    cout << solution(input);
}