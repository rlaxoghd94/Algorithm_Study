#include <iostream>

using namespace std;

#define MAX_N 91

int N;
long dp[MAX_N];     // <--- MUST BE A 'LONG' TYPE, if 'int', overflow occurs

/*
 * [Goal] - find all possible binary outcome that abides the following conditions:
 * 1. binary mustn't begin with '0'
 * 2. binary mustn't have a consecutive '1'; meaning no strings such as '..11..'
 * 
 * [Approach] - Bottom-Up
 * - Let's say we are on the 'n'th element in the traversing sequence,
 *      + if [n-1] is 0, [n] can either be 0 or 1
 *          -> dp[n] = dp[n-1]
 *      + if [n-1] is 1, [n] can only be 0,
 *          -> dp[n] = dp[n-2]
 *          -> to be precise, if [n] = 1, [n-2] can be 1
 *      Therefore, if we combine the two relations found above:
 *              => dp[n] = dp[n-1] + dp[n-2]
 */

int main() {
    cin >> N;

    dp[0] = 1;  // 1st condition
    for (int i = 1; i < N; i++)
        dp[i] = dp[i-1] + dp[i-2];

    cout << dp[N-1] << endl;

    return 0;
}