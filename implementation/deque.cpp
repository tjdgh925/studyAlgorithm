#include <iostream>

using namespace std;

const int MAX = 1e5;

class Deque {
private:
  int data[MAX];
  int index_front;
  int index_back;

public:
  Deque();
  int size();
  bool empty();
  void push_front(int x);
  void push_back(int x);
  void pop_front();
  void pop_back();
  int front();
  int back();
};

Deque::Deque() {
  index_front = 0;
  index_back = 0;
}

int Deque::size() { return (index_back - index_front + MAX) % MAX; }

bool Deque::empty() {
  if (index_front == index_back)
    return true;
  else
    return false;
}

void Deque::push_front(int x) {
  data[index_front] = x;
  index_front = (index_front - 1 + MAX) % MAX;
}

void Deque::push_back(int x) {
  index_back = (index_back + 1) % MAX;
  data[index_back] = x;
}

void Deque::pop_front() { index_front = (index_front + 1) % MAX; }

void Deque::pop_back() { index_back = (index_back - 1 + MAX) % MAX; }

int Deque::front() { return data[(index_front + 1) % MAX]; }

int Deque::back() { return data[index_back]; }

int main() {
  Deque q;
  cout << "데이터 입력 : \n";
  q.push_front(3);
  q.push_front(2);
  q.push_front(1);
  q.push_back(4);
  q.push_back(5);
  q.push_back(6);
  cout << "데이터 입력 완료 \n";

  cout << "size() : " << q.size() << "\n";

  cout << "데이터 출력 : \n";
  while (!q.empty()) {
    cout << "Front : " << q.front() << ",  Back : " << q.back() << "\n";
    if (q.size() % 2 == 1)
      q.pop_front();
    else
      q.pop_back();
  }
}