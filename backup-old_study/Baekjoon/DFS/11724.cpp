#include <iostream>
#include <vector>

using namespace std;

vector<int> a[1001];
bool check[1001];

int N, M, cnt = 0;

/*
*   @DESC - when an initial DFS is called in main(), this method occurs recursively in order to check the map so that further traversing has the right restrictions
*/
void DFS(int idx)
{
    check[idx] = true;

    for (int i = 0; i < a[idx].size(); i++)
    {
        int next = a[idx][i];
        if (!check[next])
        {
            DFS(next);
        }
    }
}

int main()
{
    cin >> N >> M;

    while (M--)
    {
        int u, v;
        cin >> u >> v;
        a[u].push_back(v);
        a[v].push_back(u);
    }

    for (int i = 1; i <= N; i++)
    {
        // This 'if-statement' basically finds number of graphs within the given input
        if (!check[i])
        {
            DFS(i);
            cnt++;
        }
    }

    cout << cnt << endl;

    return 0;
}