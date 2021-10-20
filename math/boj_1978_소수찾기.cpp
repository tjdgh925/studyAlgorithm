#include <iostream>

using namespace std;

int N, temp, result = 0;

int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    int count = 0;
    cin >> temp;
    if (temp == 1)
      continue;
    else if (temp == 2)
      count++;
    else {
      for (int j = 2; j <= temp; j++) {
        if (temp % j == 0)
          count++;
      }
    }
    if (count == 1)
      result++;
  }
  cout << result;
}