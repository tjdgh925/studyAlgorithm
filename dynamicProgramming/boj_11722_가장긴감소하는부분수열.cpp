#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 1001;
int dp[MAX], seq[MAX];
int N, result = 0;

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> seq[i];
        dp[i] = 1;
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (seq[j] > seq[i])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        result = max(result, dp[i]);
    }

    cout << result << "\n";
}
