#include <iostream>
#include <queue>

using namespace std;

int map[100001] = {0, };
int N, K;

int BFS()
{
    // starting at (pos: N), soobin will try to find where her sibling is (pos: K)
    queue<int> q;
    q.push(N);
    map[N] = 1; // NOTE: (int[]:map) is used both as a counter and a visit checker

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        // end condition
        if (cur == K)
            return map[cur] - 1;

        // case -1
        if (cur - 1 >= 0 && cur < map[cur - 1] == 0)
        {
            map[cur - 1] = map[cur] + 1;
            q.push(cur - 1);
        }

        // case +1
        if (cur + 1 <= 100000 && map[cur + 1] == 0)
        {
            map[cur + 1] = map[cur] + 1;
            q.push(cur + 1);
        }

        // case *2
        if (cur * 2 <= 100000 && map[2 * cur] == 0)
        {
            map[2 * cur] = map[cur] + 1;
            q.push(2 * cur);
        }
    }
}

int main()
{
    cin >> N >> K;
    // cout << N << " " << K << endl;

    cout << BFS() << endl;
    return 0;
}