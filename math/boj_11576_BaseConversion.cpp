#include <cmath>
#include <iostream>
#include <stack>

using namespace std;

int a, b, n, tmp;
stack<int> s;
int sum = 0;

int main() {
  cin >> a >> b >> n;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    sum += tmp * pow(a, n - 1 - i);
  }
  while (sum != 0) {
    s.push(sum % b);
    sum /= b;
  }

  while (!s.empty()) {
    cout << s.top() << " ";
    s.pop();
  }
}