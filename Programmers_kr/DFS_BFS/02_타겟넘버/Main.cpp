#include <string>
#include <vector>
#include <iostream>

using namespace std;

int DFS(vector<int> numbers, int idx, int num, int target)
{
    
    if (idx == numbers.size()) // recursive sequence end condition
    {
        return num == target ? 1 : 0;
    }
    else // recursively traverse throughout all posibilities of addition and subtraction
    {
        return DFS(numbers, idx + 1, num + numbers[idx], target) + DFS(numbers, idx + 1, num - numbers[idx], target);
    }
}

int solution(vector<int> numbers, int target)
{
    int answer = DFS(numbers, 0, 0, target);
    return answer;
}

int main()
{
    vector<int> nums;
    int targ;

    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(1);
    targ = 3;

    cout << solution(nums, targ) << endl;

    return 0;
}