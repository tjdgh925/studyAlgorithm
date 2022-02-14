#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 1000000;

int N, M;
vector<long long> trees;

int main() {
  cin >> N >> M;
  for (int i = 0; i < N; i++) {
    long long input;
    cin >> input;
    trees.push_back(input);
  }

  sort(trees.begin(), trees.end());

  long long low = 0;
  long long high = trees[N - 1];
  long long result = 0;

  while (low <= high) {
    long long total = 0;
    long long mid = (low + high) / 2;

    for (int i = 0; i < N; i++) {
      if (trees[i] > mid)
        total += trees[i] - mid;
    }

    if (total < M) {
      high = mid - 1;
    } else {
      result = mid;
      low = mid + 1;
    }
  }
  cout << result;
}