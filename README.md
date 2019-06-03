# Algorithm Study Repository

by Nicholas Taehong Kim.

### TODO

- [큰수만들기](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/02_%ED%81%B0%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java): int range overflow occurance
	- Try BFS to solve this.
- Need to learn input optimization; input taking process causes error if only handled with a scanner

### Study Flow

- ~~Brute force~~
- ~~Greedy~~
- ~~DFS/BFS~~
- **Dynamic Programming** <-- current activity
- Back-tracking
- Sort
- Hash

### Progress

- ***Leet_code***
	- **Top 100 Liked**
		- 488_Find_All_Numbers_Disappeared_in_an_Array ([Link](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Leet_code/Top_100_Liked/448.java)

- ***Programmers_kr***
	- **Greedy**
		- 01_체육복 ([Link](https://programmers.co.kr/learn/courses/30/lessons/42862))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/01_%EC%B2%B4%EC%9C%A1%EB%B3%B5/Main.java)
		- 02_큰수만들기 ([Link](https://programmers.co.kr/learn/courses/30/lessons/42883))
			- [On Progress: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/02_%ED%81%B0%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java)
	- **DFS/BFS**
		- ***02_타겟넘버*** ([Link](https://programmers.co.kr/learn/courses/30/lessons/43165))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/DFS_BFS/02_%ED%83%80%EA%B2%9F%EB%84%98%EB%B2%84/Main.cpp)
			- Great example of a DFS algorithm (*Worth looking at again*)

- ***Baekjoon***
	- **DFS**
		- 단지번호붙이기_2667 ([Link](https://www.acmicpc.net/problem/2667))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/2667.java)
		- 유기농배추_1012 ([Link](https://www.acmicpc.net/problem/1012))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/1012.java)
		- 경로찾기_11403 ([Link](https://www.acmicpc.net/problem/11403))
			- [Answer: Java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/11403.java)
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/11403.cpp)
		- 영역구하기_2583 ([Link](https://www.acmicpc.net/problem/2583))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/2583.cpp)
		- ***로또_6603*** ([Link](https://www.acmicpc.net/problem/6603))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/6603.cpp)
			- mixture of a DFS and a backtracking algorithm (*Worth looking at again*)
		- 연결요소의개수_11724 ([Link](https://www.acmicpc.net/problem/11724))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/11724.cpp)
			- Instead of using `int a[1001][1001]`, this code uses `vector<int> a[1001]` for better memory management
		- 안전영역_2468 ([Link](https://www.acmicpc.net/problem/2468))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/2468.cpp)
		- 적록색약_10026 ([Link](https://www.acmicpc.net/problem/10026))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/10026.cpp)
	- **BFS**
		- 미로탐색_2178 ([Link](https://www.acmicpc.net/problem/2178))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/2178.cpp)
		- 나이트의이동_7562 ([Link](https://www.acmicpc.net/problem/7562))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/7562.cpp)
		- 숨바꼭질_1697 ([Link](https://www.acmicpc.net/problem/1697))
			- [**On Progress**: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/1697.cpp)
			- No clue on why this is wrong. I'm guessing the problem has to do with condition statements or variable initialization, but no clue on why this is wrong. *FIX IT LATER*
		- 토마토_7576 ([Link](https://www.acmicpc.net/problem/7576))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/7576.cpp)
		- 연구소_14502 ([Link](https://www.acmicpc.net/problem/14502))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/14502.cpp)
			- Having a `queue` as a global variable messed up the flow of the code. Not quite sure why this is wrong.
			- Reference Page: [HERE](https://wjdgus2951.tistory.com/80)
		- 보물섬_2589 ([Link](https://www.acmicpc.net/problem/2589))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/2589.cpp)
		- 탈출_3055 ([Link](https://www.acmicpc.net/problem/3055))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/3055.cpp)
			- Apparently, this code does not work for some of the test cases not available for the users to check. BUT, it works for the ones provided.
	- **Dynamic Programming**
		- 1로만들기_1463 ([Link](https://www.acmicpc.net/problem/1463))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/1463.cpp)
			- [Answer: Java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/1463.java)
		- 1,2,3더하기_9095 ([Link](https://www.acmicpc.net/problem/9095))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/9095.cpp)
		- 피보나치함수_1003 ([Link](https://www.acmicpc.net/problem/1003))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/1003.cpp)
		- 계단오르기_2579 ([Link](https://www.acmicpc.net/problem/2579))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/2579.cpp)
		- 정수삼각형_1932 ([Link](https://www.acmicpc.net/problem/1932))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/1932.cpp)
		- 연속합_1912 ([Link](https://www.acmicpc.net/problem/1912))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/1912.cpp)
		- 이친수_2193 ([Link](https://www.acmicpc.net/problem/2193))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/2193.cpp)
		- 포도주시식_2156 ([Link](https://www.acmicpc.net/problem/2156))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DP/2156.cpp)
			- *Comprehend the relations*

### Note

- When taking inputs in `Java`, following code is worth using:
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

n = Integer.parseInt(st.nextToken());
k = Integer.parseInt(st.nextToken());

for (int i = 0; i < n; i++){
	coin[i] = Integer.parseInt(br.readLine());
}

int ret = solve(0);
System.out.println(ret == INF ? -1 : ret);
```
- When using `Queue` in `C++`, following code is effective and efficient as it doesn't require a `struct` data type, rather using a `generic` data type:
```cpp
#include <queue>

int main(){
	queue<int, pair<int, int>> que;		// (int, (int, int))
	que.push( 1 , pair<int, int>(2, 3));	// ( 1 , ( 2 ,  3 ))

	int one = que.front().first;
	int two = que.front().second.first;
	int three = que.front().second.second;

	que.pop();
}
```

<br></br>
- Since java is run on a jvm(java virtual machine), it requires much more resources and run-time than most of other languages; therefore, this is taken into account during the grading process.
<br></br>
 - Difference between DFS and BFS (algorithm-wise):
	- DFS uses Stack (FILO)
	- BFS uses Queue (FIFO)
		- *Be aware* of how you use the counter if you don't use a `visit[][]`
<br></br>
 - `Programmers_kr/DFS_BFS/02_타겟넘버` diagram for better comprehension
 ![alt text](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/DFS_BFS/02_%ED%83%80%EA%B2%9F%EB%84%98%EB%B2%84/target_number-diagram.png "Programmers_kr/DFS_BFS/02_타겟넘버 diagram")

<br></br>
- I feel like `Dynamic Programming` is all about mathematical ability to observe and find the core-relation among the data given, and I lack the ability compared to fellow Korean students.
