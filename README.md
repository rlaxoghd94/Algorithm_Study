# Algorithm Study Repository

by Nicholas Taehong Kim.

### TODO
- [큰수만들기](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/02_%ED%81%B0%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java): int range overflow occurance
	- Try BFS to solve this.
- Need to learn input optimization; input taking process causes error if only handled with a scanner

### Study Flow
- ~~Brute force~~
- ~Greedy~
- **DFS/BFS** <-- current activity
- Dynamic
- Back-tracking
- Sort
- Hash

### Progress
- Programmers_kr
	- Greedy
		- 01_체육복 ([Link](https://programmers.co.kr/learn/courses/30/lessons/42862))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/01_%EC%B2%B4%EC%9C%A1%EB%B3%B5/Main.java)
		- 02_큰수만들기 ([Link](https://programmers.co.kr/learn/courses/30/lessons/42883))
			- [On Progress: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Programmers_kr/Greedy/02_%ED%81%B0%EC%88%98%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java)

- Baekjoon
	- DFS
		- 단지번호붙이기_2667 ([Link](https://www.acmicpc.net/problem/2667))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/2667.java)
		- 유기농배추_1012 ([Link](https://www.acmicpc.net/problem/1012))
			- [Answer: java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/1012.java)
		- 경로찾기_11403 ([Link](https://www.acmicpc.net/problem/11403))
			- [Answer: Java](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/11403.java)
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/11403.cpp)
		- 영역구하기_2583 ([Link](https://www.acmicpc.net/problem/2583))
			- [Answer: C++](https://github.com/rlaxoghd94/Algorithm_Study/blob/master/Baekjoon/DFS/2583.cpp)


### Note
When taking inputs, following code is worth using:
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
