#include <iostream>
#include <math.h>

using namespace std;

const int MAX = 300000 + 1;
int A, P, cnt = 0;
int visited[MAX];

void dfs(int A, int P) {
  visited[A]++;
  if (visited[A] == 3)
    return;
  int temp = 0;
  while (A != 0) {
    temp += (int)pow(A % 10, P);
    A /= 10;
  }

  dfs(temp, P);
}

int main() {
  cin >> A >> P;
  dfs(A, P);
  for (int i = 0; i < MAX; i++)
    if (visited[i] == 1)
      cnt++;

  cout << cnt;
}