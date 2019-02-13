#include <iostream>

using namespace std;

#define MAX_LEN 12
int dp[MAX_LEN] = { 0 };
int T,N;

int main(){
    cin >> T;

    for (int i = 0; i < T; i++) {
        cin >> N;
        /* 
         * [Bottom-Up Approach]
         * (1) = 1                          [1]
         * (2) = 1 + 1, 2                   [2]
         * (3) = 1 + 1 + 1, 2 + 1, 1 + 2, 3 [4]
         * (4) = 1 + (3), 2 + (2), 3 + (1)
         *      - the trick here is that there are 4 ways to make (3), 2 ways to make (2), and 1 way to make (1),
         *        meaning, [4] + [2] + [1] is how you make (4)
         */
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= N; i++) 
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        
        cout << dp[N] << endl;
    }
    return 0;
}