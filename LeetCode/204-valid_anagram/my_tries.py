"""Nic's approach

basically, we're comaparing if 's' and 't' contains the same amount of equal characters,

	first try)
		just tried winging this question with set() operations
		
		but one of the failed test cases was:
			- s: 'ccaa', b: 'ccac'
	
	second try)
		count each characters and see if counter value matches them all
"""
class Solution:
	def isAnagram(self, s: str, t: str) -> bool:
		if len(s) != len(t):
			return False
		
		char_counter_s, char_counter_t = {}, {}
		
		for idx in range(0, len(s)):
			char_s = s[idx]
			char_t = t[idx]
			if not char_counter_s.get(char_s):
				char_counter_s[char_s] = 1
			else:
				char_counter_s[char_s] = char_counter_s[char_s] + 1
			
			if not char_counter_t.get(char_t):
				char_counter_t[char_t] = 1
			else:
				char_counter_t[char_t] = char_counter_t[char_t] + 1
			
		for key, value in char_counter_s.items():
			if not char_counter_t.get(key):
				return False
			
			if char_counter_s[key] != char_counter_t[key]:
				return False
		
		return True


if __name__ == '__main__':
	solution = Solution()
	
	a = 'car'
	b = 'rac'
	
	print(solution.isAnagram(s=a, t=b))
	
