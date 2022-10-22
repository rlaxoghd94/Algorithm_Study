"""LeetCode community answer

using python native min heap library
- min heap always keeps elements sorted in an ascending order
- time complexity ~= O(log n)
    + 내꺼가 O(n log n)임을 고려하면 이게 훨신 나은 알고리즘

"""
from heapq import heappop, heappush


class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        unums, heap = set([]), []
        for x in nums:
            if x not in unums:
                heappush(heap, x)
                unums.add(x)
                if len(heap) == 4:
                    unums.remove(heappop(heap))
        if len(heap) == 2:
            x = heappop(heap)
        return heap[0]
