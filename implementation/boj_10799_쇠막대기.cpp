#include <iostream>
#include <stack>

using namespace std;

stack<char> arr;
string input;
int cnt = 0, result = 0;

int main() {
  cin >> input;

  for (int i = 0; i < input.size(); i++) {
    if (input[i] == '(') {
      arr.push(input[i]);
    } else {
      arr.pop();
      if (input[i - 1] == '(')
        result += arr.size();
      else
        result++;
    }
  }
  cout << result;
}