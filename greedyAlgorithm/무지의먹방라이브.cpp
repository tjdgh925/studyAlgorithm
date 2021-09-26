#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) { return a.second < b.second; }

int solution(vector<int> food_times, long long k) {
  long long summary = 0;
  priority_queue<pair<int, int>> pq;

  for (int i = 0; i < food_times.size(); i++) {
    summary += food_times[i];
    pq.push({-food_times[i], i + 1});
  }
  if (summary <= k)
    return -1;
  summary = 0;                          // 먹기 위해 사용한 시간
  long long previous = 0;               // 직전에 다 먹은 음식 시간
  long long length = food_times.size(); // 남은 음식의 개수

  while (summary + ((-pq.top().first - previous) * length) <= k) {
    int now = -pq.top().first;
    pq.pop();
    summary += (now - previous) * length;
    length -= 1;    // 다 먹은 음식 제외
    previous = now; // 이전 음식 시간 재설정
  }

  // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
  vector<pair<int, int>> result;
  while (!pq.empty()) {
    int food_time = -pq.top().first;
    int num = pq.top().second;
    pq.pop();
    result.push_back({food_time, num});
  }
  sort(result.begin(), result.end(), compare); // 음식의 번호 기준으로 정렬
  return result[(k - summary) % length].second;
}

int main() {
  cout << solution({946, 314, 757, 322, 559, 647, 983, 482, 145}, 1833);
  // print({3, 1, 2}, 5, 1);
  // print({8, 6, 4}, 15, 2);
  // print({946, 314, 757, 322, 559, 647, 983, 482, 145}, 1833, 1);

  return 0;
}
