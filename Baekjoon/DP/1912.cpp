#include <iostream>

using namespace std;

#define MAX_LEN 100001

int max(int a, int b) {
    return a > b ? a : b;
}

/*
 * [Goal] - find the maximum consecutive addition value
 * 
 * [Approach] - Bottom-Up
 * - let's say we are traversing on the 'n'th element:
 *      + if dp[n-1] + val[n] > val[n], we know the addition must keep occuring
 *      + if dp[n-1] + val[n] < val[n], we know the max value must be reset
 */

int main() {
    int dp[MAX_LEN];
    int val[MAX_LEN];
    int N;
    // Take input HERE
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> val[i];

    // Caculate HERE
    dp[0] = val[0];     // single value = no addition

    int maxVal = dp[0];
    for (int i = 1; i < N; i++) {
        dp[i] = max( dp[i-1] + val[i], val[i] );
        maxVal = max( maxVal, dp[i] );
    }

    cout << maxVal << endl;

    return 0;
}