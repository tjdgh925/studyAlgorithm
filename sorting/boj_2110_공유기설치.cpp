#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

long long N, C;
vector<long long> wifi;

int main() {
  cin >> N >> C;
  for (int i = 0; i < N; i++) {
    long long input;
    cin >> input;
    wifi.push_back(input);
  }

  sort(wifi.begin(), wifi.end());

  long long low = 1;
  long long high = wifi[N - 1] - wifi[0];
  long long result = 0;
  while (low <= high) {
    long long mid = (low + high) / 2;
    long long prev = wifi[0];
    int count = 1;
    for (int i = 0; i < N; i++) {
      long long distance = wifi[i] - prev;
      if (distance >= mid) {
        count++;
        prev = wifi[i];
      }
    }
    if (count < C) {
      high = mid - 1;
    } else {
      result = mid;
      low = mid + 1;
    }
  }
  cout << result;
}