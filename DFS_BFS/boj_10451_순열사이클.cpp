#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 1001;
int T, N, result, cnt = 0;
int graph[MAX];
bool visited[MAX];

void cycle(int start) {
  visited[start] = true;
  if (!visited[graph[start]]) {
    cycle(graph[start]);
  }
}

int main() {
  cin >> T;
  for (int i = 0; i < T; i++) {
    cnt = 0;
    cin >> N;
    for (int j = 1; j <= N; j++) {
      cin >> graph[j];
    }
    for (int j = 1; j <= N; j++) {
      if (!visited[j]) {
        cycle(j);
        cnt++;
      }
    }
    cout << cnt << "\n";
    memset(visited, false, sizeof(visited));
  }
}