"""LeetCode community answer

Never have I knew python had a default library dedicated for counting from an input value O:
	
the key to this code is:
	- from collections import Counter
	
	this library takes in string literals or other various input values and counts them for the programmer O:

Basically,
this user and I have the same approach, but I had to program "Counter" on my own
"""
from collections import Counter


class Solution:
	def isAnagram(self, s: str, t: str) -> bool:
		if len(s) != len(t):
			return False
		
		s_counter, t_counter = Counter(s), Counter(t)
		for c in s_counter:
			if s_counter[c] != t_counter[c]:
				return False
		
		return True

