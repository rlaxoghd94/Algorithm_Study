"""LeetCode community answer

Basic O(n) traverse using Stack,
no need for a recursive approach

+) to be fair, it's basically the same but not "recursive"
"""
class Solution(object):
	def isValid(self, s):
		stack = []
		match = {'(': ')', '[': ']', '{': '}'}
		
		for c in s:
			if c in ['(', '[', '{']:
				stack.append(c)
			elif not stack or match[stack.pop()] != c:
				return False
		
		return not stack

