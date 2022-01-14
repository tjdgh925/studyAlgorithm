#include <iostream>

using namespace std;

const int MAX = 1e5;

class Stack {
private:
  int data[MAX];
  int index;

public:
  Stack();
  int size();
  bool empty();
  void push(int x);
  void pop();
  int top();
};

Stack::Stack() { index = -1; }

int Stack::size() { return index + 1; }

bool Stack::empty() {
  if (index == -1)
    return true;
  else
    return false;
}

void Stack::push(int x) { data[++index] = x; }

void Stack::pop() { index--; }

int Stack::top() { return data[index]; }

int main() {
  Stack s;
  cout << "데이터 입력 : \n";
  s.push(1);
  s.push(2);
  s.push(3);
  s.push(4);
  s.push(5);
  s.push(6);
  cout << "데이터 입력 완료 \n";

  cout << "size() : " << s.size() << "\n";

  cout << "데이터 출력 : [";
  while (!s.empty()) {
    if (s.size() == 1)
      cout << s.top();
    else
      cout << s.top() << " ";
    s.pop();
  }
  cout << "]\n";
}