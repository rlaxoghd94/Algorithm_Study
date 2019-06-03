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
     * 1. you can climb a single step or skip a step on the stair
     * 2. you mustn't step on 3 consecutive stairs; excluding the starting point
     * 3. you must step on the highest stair
     * 
     * if we apprach this focusing on the 3rd condition, we can come up with the following relations:
     * let stair count be (int: N),
     * - we must step on 'N' according to the 3rd condition
     * - we could step on either N-1 or N-2 before we step on N
     *      - case N-1:
     *          + you can't step on N-2, b/c it violates the 2nd condition, therefore
     *              -> dp[N] = val[N] + val(N-1) + dp[N-3]
     *      - case N-2:
     *          + dp[N] = val[N] + dp[N-2]
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