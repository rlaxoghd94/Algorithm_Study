"""LeetCode community answer

very similar to my approach, but better - O(n)

I guess collections.Counter library is sequential,
so finding a counter value with 1 while traversing collections.Counter sequentially is all there's to do
"""
from collections import Counter


class Solution:
    def firstUniqChar(self, s: str) -> int:
        m = Counter(s)

        for i,v in m.items():
            if v==1:
                return s.index(i)
        
        return -1