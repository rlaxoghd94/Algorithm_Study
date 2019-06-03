#include <iostream>

using namespace std;

#define MAX_N 501

int N;
int val[MAX_N][MAX_N] = { 0 };
int dp[MAX_N][MAX_N] = { 0 };

int max(int a, int b) {
    return a > b ? a : b;
}

/*
 * [Approach HERE]
 * if we were to approach this in a 'Bottom-Up' manner, we must use the following nested-for-statement:
 *   - for (int i = 1; i <= N; i++)
 *       for (int j = 1; j <= i; j++) 
 * 
 * let's say we are on the 'n'th floor of the triangle traversing according to the code above.
 *   - val[n][j] can only make addition with val[n+1][j] and val[n+1][j+1],
 *     BUT, by the 'n'th floor, we should've made the addition already meaning the relation is as below.
 *      + SINCE we are using the 'Bottom-Up' approach, dp[n][j] is either largest of the below:
 *          -> dp[n][j] = dp[n-1][j-1] + val[i][j]
 *          -> dp[n][j] = dp[n-1][j] + val[i][j]
 */
int main() {
    // Take input HERE
    cin >> N;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= i; j++) 
            cin >> val[i][j];

    // Calculate HERE
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= i; j++)
            dp[i][j] = max( dp[i-1][j] + val[i][j], dp[i-1][j-1] + val[i][j]);

    /*
     * [FAILED SORT ATTEMPT];    
     * int *a = dp[N];
     * sort(a, a + sizeof(int) * N);
     * cout << a[N] << endl;
     */

    // [SUCCESSFUL SORT ATTEMPT]
    int maxVal = -99;
    for (int i = 1; i <= N; i++)
        maxVal = max(maxVal, dp[N][i]);
    cout << maxVal << endl;

    return 0;
}