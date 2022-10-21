from typing import List

"""Elaboration

DP Approach(bottom-up)
"""

class Solution:
	def minCostClimbingStairs(self, cost: List[int]) -> int:
		if len(cost) < 2:
			return None
		if len(cost) < 3:
			return min(cost[0], cost[1])
		
		a, b = cost[0], cost[1]
		for index in range(2, len(cost)):
			a, b = b, min(a, b) + cost[index]

		return min(a, b)


if __name__ == '__main__':
	# debug here
	pass

