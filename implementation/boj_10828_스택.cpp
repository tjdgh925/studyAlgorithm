#include <iostream>
using namespace std;
int sz;
int a[10001];

void push(int x) {
  a[sz] = x;
  sz++;
}

int pop() {
  if (sz == 0)
    return -1;
  int t = a[sz - 1];
  sz--;
  return t;
}

int size() { return sz; }

int top() {
  if (sz == 0)
    return -1;
  return a[sz - 1];
}

int empty() {
  if (sz == 0)
    return 1;
  else
    return 0;
}

int main() {

  int n;
  cin >> n;
  while (n--) {
    string str;
    cin >> str;
    if (str == "push") {
      int n;
      cin >> n;
      push(n);
    }
    if (str == "pop") {
      cout << pop() << '\n';
    }
    if (str == "top") {
      cout << top() << '\n';
    }
    if (str == "size") {
      cout << size() << '\n';
    }
    if (str == "empty") {
      cout << empty() << '\n';
    }
  }
}