#include <iostream>
#include <stack>

using namespace std;

bool error = false;
int n, cnt = 0;
string input;

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    stack<char> VPS;
    cin >> input;
    error = false;
    for (int j = 0; j < input.size(); j++) {
      if (input[j] == '(')
        VPS.push(input[j]);
      else {
        if (!VPS.empty()) {
          VPS.pop();
        } else {
          error = true;
          break;
        }
      }
    }
    if (!VPS.empty() || error)
      cout << "NO\n";
    else
      cout << "YES\n";
  }
}