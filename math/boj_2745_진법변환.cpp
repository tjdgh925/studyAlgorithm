#include <iostream>

using namespace std;

string n;
int b;
int result = 0;

int main() {
  cin >> n >> b;
  for (int i = 0; i < n.length(); i++) {
    if (n[i] >= 'A') {
      result = result * b + (n[i] - 'A' + 10);
    } else
      result = result * b + (n[i] - '0');
  }
  cout << result;
}