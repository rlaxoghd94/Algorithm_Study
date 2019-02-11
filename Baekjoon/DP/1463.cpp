#include <iostream>
#include <algorithm>

using namespace std;

int dp[1000001] = { 0 };
int N;

// Top-Down Approach
int topDown(int n) {
    if (n == 1)
        return 0;
    if (dp[n] > 0)
        return dp[n];
    
    dp[n] = topDown(n-1) + 1;

    if (n%2 == 0)
        dp[n] = min( dp[n], topDown(n/2) + 1 );

    if (n%3 == 0)
        dp[n] = min( dp[n], topDown(n/3) + 1 );

    return dp[n];
}

int main(){
    cin >> N;
    // Top-Down Approach
    cout << topDown(N) << endl;


    // Bottom-Up Approach
    dp[1] = 0;

    for (int i = 2; i <= N; i++) {
        dp[i] = dp[i-1] + 1;
        if (i % 2 == 0)
            dp[i] = min( dp[i], dp[i/2] + 1 );
        if (i % 3 == 0)
            dp[i] = min( dp[i], dp[i/3] + 1 ); 
    }

    cout << dp[N] << endl;

    return 0;
}