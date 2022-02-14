#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N, M;

int main() {

  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> N;
  vector<int> card(N);

  for (int i = 0; i < N; i++)
    cin >> card[i];

  sort(card.begin(), card.end());

  cin >> M;
  for (int i = 0; i < M; i++) {
    int tmp;
    cin >> tmp;
    auto upper = upper_bound(card.begin(), card.end(), tmp);
    auto lower = lower_bound(card.begin(), card.end(), tmp);
    cout << upper - lower << " ";
  }
}