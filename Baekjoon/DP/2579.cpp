#include <iostream>

using namespace std;

#define MAX_HEIGHT 301

int val[MAX_HEIGHT];
int dp[MAX_HEIGHT];
int stairCnt;

int max( int a, int b ) {
    return a > b ? a : b;
}

int main() {
    cin >> stairCnt;

    for (int i = 1; i <= stairCnt; i++)
        cin >> val[i];

    dp[0] = 0;
    dp[1] = val[1];
    dp[2] = max( val[1] + val[2], val[2] );
    dp[3] = max( val[1] + val[3], val[2] + val[3] );

    int case1, case2;
    
    /*
     * According to the conditions given,
     * 1. you can climb a single step or a double steps on the stair
     * 2. you mustn't climb on 3 consecutive steps; excluding the starting step
     * 3. you must step on the highest stair
     * 
     * if we apprach this focusing on the 3rd condition, we can come up with the following relation:
     * let stair count be (int: N),
     * - we must step on 'N'
     * - we could step on either n-1 or n-2
     *      - case n-1:
     *          + you can't step on n-2, b/c it violates the 2nd condition, therefore
     *              -> dp[n] = val(n) + val(n-1) + dp[n-3]
     *      - case n-2:
     *          + dp[n] = val(n) + dp[n-2]
     * 
     */ 

    for (int i = 4; i <= stairCnt; i++) {
        case1 = dp[i-2] + val[i];
        case2 = dp[i-3] + val[i-1] + val[i];
        dp[i] = max( case1, case2 );
    }

    cout << dp[stairCnt] << endl;

    return 0;
}