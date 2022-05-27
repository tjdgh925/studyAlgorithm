#include <iostream>

using namespace std;

int arr[11];
int N, M, result = 0;

int main() {
  cin >> N >> M;
  for (int i = 0; i < N; i++) {
    int x;
    cin >> x;
    arr[x]++;
  }

  for (int i = 1; i <= M; i++) {
    N -= arr[i];
    result += arr[i] * N;
  }
  cout << result << endl;
}
/*
더 효율적인 알고리즘을 봤는데 컨셉은 이해가 되는데 구체적인 풀이가 이해가 안
가서 직접 써봤다. (전체 무게의 수) - (현재 무게의 수)가 가장 기본적인 경우의
수다. 근데 같은 무게는 다르게 취급하니까 곱해준다.
{(전체 무게의 수) - (현재 무게의 수)} * (현재 무게의 수)
전체 무게의 수는 계속 줄어들어야 해서 미리 빼준다.
*/