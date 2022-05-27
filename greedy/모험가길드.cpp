#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> group;

int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    int x;
    cin >> x;
    group.push_back(x);
  }
  sort(group.begin(), group.end());

  int result = 0;
  int count = 0;
  for (int i = 0; i < N; i++) {
    count++;
    if (count >= group[i]) {
      result++;
      count = 0;
    }
  }
  cout << result << '\n';
}