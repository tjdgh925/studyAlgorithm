#include <iostream>
#include <algorithm>

using namespace std;

const int MAX = 5000001;

int n, a;
int arr[MAX];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> a;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + n);

	cout << arr[a-1] << "\n";
}
