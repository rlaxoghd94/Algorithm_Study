from typing import List

"""Elaboration

This question is a simple DP + Memoization question

Approach: Top-Down DP
	- create DP size of cost array length + a
	- calculate as if you are coming back down the stairs and find the minimum cost possible

"""

class Solution:
	def minCostClimbingStairs(self, cost: List[int]) -> int:
		if len(cost) < 2:
			return None
		if len(cost) < 3:
			return min(cost[0], cost[1])
		
		total_cost = [0] * len(cost)
		total_cost[-1], total_cost[-2] = cost[-1], cost[-2]
		for index in range(len(cost)-3, -1, -1):
			total_cost[index] = cost[index] + min(total_cost[index + 1], total_cost[i + 2])

		return min(total_cost[0], total_cost[1])

if __name__ == '__main__':
	# debug here
	pass

