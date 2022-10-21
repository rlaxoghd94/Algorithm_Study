from typing import Optional


"""my solution

Approach: Recursive
	- Since the order of the opening parentheses must be closed with a corresponding close bracket,
		keep open brackets in a stack:
			+ enter recursive on open bracket,
			+ exit recursive on matching close bracket

LeetCode test cases even included "]" just to test if this code was fail-proofed O:
"""
class Solution:
	matching_parentheses = {
	'{': '}',
	'(': ')',
	'[': ']'
	}
	
	def isValid(self, s: str) -> bool:
		input_str = s
		idx = 0
		stack = []
		
		return self.recursive_approach(input_str, idx, stack)	
		
	def is_matching_parentheses(self, a: str, b: str) -> bool:
		if b not in self.matching_parentheses.keys():
			return False
			
		if a == self.matching_parentheses[b]:
			return True
			
		return False
		
	def recursive_approach(self, input_str: str, idx: int, stack: list) -> Optional[bool]:
		if not input_str:
			return False
			
		if idx == len(input_str):
			if len(stack) == 0:
				return True
			else:
				return False
				
		check_char = input_str[idx]
		if check_char in ('{', '(', '['):
			# open brackets
			stack.append(check_char)
			return self.recursive_approach(input_str, idx+1, stack)
		else:
			# close brackets
			if len(stack) == 0:
				return False
				
			stack_top = stack[-1]
			if not self.is_matching_parentheses(check_char, stack_top):
				return False
			else:
				stack.pop()
				return self.recursive_approach(input_str, idx+1, stack)

