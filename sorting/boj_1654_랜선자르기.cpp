#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 1000000;

int N, K;
vector<long long> lan;

int main() {
  cin >> K >> N;
  for (int i = 0; i < K; i++) {
    long long input;
    cin >> input;
    lan.push_back(input);
  }

  sort(lan.begin(), lan.end());

  long long low = 1;
  long long high = lan[K - 1];
  long long result = 0;

  while (low <= high) {
    long long mid = (low + high) / 2;
    long long count = 0;

    for (int i = 0; i < K; i++) {
      count += lan[i] / mid;
    }

    if (count < N) {
      high = mid - 1;
    } else {
      result = mid;
      low = mid + 1;
    }
  }
  cout << result;
}