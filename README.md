# Algorithm Study Repository

by Nicholas Taehong Kim.

### TODO
- [큰수만들기](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/02_%ED%81%B0%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java): int range overflow occurance
	- Try BFS to solve this.
- Need to learn input optimization; input taking process causes error if only handled with a scanner
- [연구소_14502](https://www.acmicpc.net/problem/14502): Endless loop occurance

### Study Flow
- ~~Brute force~~
- ~~Greedy~~
- **DFS/BFS** <-- current activity
- Dynamic
- Back-tracking
- Sort
- Hash

### Progress
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
			- [**On Progress**: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/BFS/14502.cpp)
			- No clue on why this is wrong; probably the `void: recursiveWall()` with wrong conditions?


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