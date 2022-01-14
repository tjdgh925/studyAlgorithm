#include <iostream>

using namespace std;

const int MAX = 1e5;

class Queue {
private:
  int data[MAX];
  int index_front;
  int index_back;

public:
  Queue();
  int size();
  bool empty();
  void push(int x);
  void pop();
  int front();
  int back();
};

Queue::Queue() {
  index_front = 0;
  index_back = 0;
}

int Queue::size() { return index_back - index_front; }

bool Queue::empty() {
  if (index_front == index_back)
    return true;
  else
    return false;
}

void Queue::push(int x) { data[++index_back] = x; }

void Queue::pop() { index_front += 1; }

int Queue::front() { return data[index_front]; }

int Queue::back() { return data[index_back]; }

int main() {
  Queue q;
  cout << "데이터 입력 : \n";
  q.push(1);
  q.push(2);
  q.push(3);
  q.push(4);
  q.push(5);
  q.push(6);
  cout << "데이터 입력 완료 \n";

  cout << "size() : " << q.size() << "\n";

  cout << "데이터 출력 : \n";
  while (!q.empty()) {
    cout << "Front : " << q.front() << ",  Back : " << q.back() << "\n";
    q.pop();
  }
}