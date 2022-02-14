#include <algorithm>
#include <iostream>
#include <vector>

typedef long long ll;

using namespace std;

ll N, M;
vector<ll> card;

int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> N;
  for (int i = 0; i < N; i++) {
    ll input;
    cin >> input;
    card.push_back(input);
  }
  sort(card.begin(), card.end());

  cin >> M;
  for (int i = 0; i < M; i++) {
    ll tmp;
    bool flag = true;
    cin >> tmp;
    ll low = 0;
    ll high = N;
    ll result = 0;
    while (low <= high) {
      ll mid = (low + high) / 2;
      if (tmp == card[mid]) {
        flag = false;
        cout << "1 ";
        break;
      } else if (card[mid] > tmp) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (flag)
      cout << "0 ";
  }
}