#include <iostream>
#include <queue>
using namespace std;

int N, K;
queue<int> circle;
int main() {
  cin >> N >> K;
  for (int i = 1; i <= N; i++) {
    circle.push(i);
  }
  int count = 1, remain = N;
  cout << "<";
  while (remain > 0) {
    while (1) {

      if (count++ % K == 0) {
        cout << circle.front();
        circle.pop();
        remain--;
        break;
      } else {
        circle.push(circle.front());
        circle.pop();
      }
    }

    if (remain > 0)
      cout << ", ";
  }
  cout << ">" << endl;
}