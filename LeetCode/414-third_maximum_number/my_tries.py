"""Nic's approach

goal: finding third **distinct** maximum number
approach: let (num: list) be the input,
    - set(num)
    - sorted_num = sorted(num, reverse=True)
    - return sorted_num[2]

O(n)이라고 봐야하나...? sorted가 기본적으로 무슨 알고리즘 쓰는지 따라 시간복잡도 바뀔텐데:
- sorted() = O(n log(n))

그럼 결국 O(n)이 안되는건데 어떻게 한담
"""
from typing import List


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        distinct_num = list(set(nums))
        sorted_distinct_num = sorted(distinct_num, reverse=True)

        return_val = None
        if len(distinct_num) < 3:
            return_val = sorted_distinct_num[0]
        else:
            return_val = sorted_distinct_num[2]
        
        return return_val
