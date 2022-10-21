#include <iostream>

using namespace std;

#define MAX_RANGE 41

int T, N;
int dp[MAX_RANGE];

int topDown(int n) {
    if (n == 0) {
        dp[0] = 0;
        return 0;
    } else if (n == 1) {
        dp[1] = 1;
        return 1;
    }

    /*
     * [THE MOST IMPORTANT CODE BLOCK -- HERE]
     * The whole concept of `Dynamic Programming` is reusage of pre-calculated data.
     * Thus, this fibonacci sequence can be calculated with pre-calculated data and to-be-calculated data,
     * as this method is a recursive top-down approach.
     */
    if (dp[n] != 0) {
        return dp[n];
    } else {
        return dp[n] = topDown(n-1) + topDown(n-2);
    }
}

int main() {
    cin >> T;

    for (int i = 0; i < T; i++) {
        cin >> N;
        
        /*
         * DON'T RESET (int[]: dp)
         * fib(n) is always fib(n), no need to re-calculate it for different TC's
         */

        if (N == 0) {
            cout << "1 0" << endl;
            continue;
        } else if (N == 1) {
            cout << "0 1" << endl;
            continue;
        } else {
            topDown(N);
            cout << dp[N - 1] << " " << dp[N] << endl;
        }
    }
    return 0;
}