#include <iostream>

using namespace std;

#define MAX_N 10001

int N;
int dp[MAX_N];
int val[MAX_N];

/*
 * [GOAL]
 * - Drink as much as wine as possible while following two conditions:
 *      1. If you select a cup, you must drink it and put it back in place
 *      2. You cannot drink 3 cups in a row
 * 
 * [Approach] - Bottom-Up
 *  - (Relation) let 'n' be the last count of the traversing routine,
 *      + if (n-1) have not been drank, (n-2) is drinkable
 *      + if (n-1) have been drank, you cannot drink (n-2)
 *           1. dp[n] = dp[n-2] + val[n]
 *           2. dp[n] = dp[n-3] + val[n-1] + val[n]
 *      => dp[n] = Max( dp[n-2] + val[n], dp[n-3] + val[n-1] + val[n] )
 * 
 *  **IMPORTANT RELATION**
 *  - I had no clue why my answers were being wrong, but there are some exceptions that needs to be accounted for.
 *      + if (int[]: val) were ( 100, 400, 2, 1, 4, 200 ),
 *          -> relation above will say that the max sum is 701, but in reality, the max sum should be 704
 *              +> THIS IS BECAUSE THEY CAN SKIP TWO CUPS IN A ROW
 *      => dp[n] = Max( dp[n-1], dp[n] )        <----- I still don't really get this part
 *     
 */

int max(int a, int b) {
    return a > b ? a : b;
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> val[i];
    
    dp[0] = val[0];
    dp[1] = dp[0] + val[1];

    /*
     * [Quick summary of the relations]
     * find the max between (int[]: dp) where you,
     *  1. skip 0 drinks
     *  2. skip 1 drinks
     *  3. skip 2 drinks
     */

    for (int i = 2; i < N; i++) {
        dp[i] = max( dp[i-2] + val[i], dp[i-3] + val[i-1] + val[i]);
        dp[i] = max( dp[i-1], dp[i] );
    }

    cout << dp[N - 1] << endl;

    return 0;
}