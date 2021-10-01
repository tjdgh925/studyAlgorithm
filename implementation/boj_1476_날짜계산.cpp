#include <iostream>

using namespace std;

int E, S, M;
int answer = 0;
int main() {
  cin >> E >> S >> M;

  while (1) {
    answer++;
    if ((answer - E) % 15 == 0 && (answer - S) % 28 == 0 &&
        (answer - M) % 19 == 0)
      break;
  }
  cout << answer << endl;
}