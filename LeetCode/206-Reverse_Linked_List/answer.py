from typing import Optional

class ListNode:
	def __init__(self, val=0, next=None):
		self.val = val
		self.next = next

class Solution:
	def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
		if head == None:
			return head
		else:
			prev_node, cur_node = head, head
			while cur_node != None:
				if prev_node == cur_node:
					cur_node = cur_node.next
					prev_node.next = None
				else:
					next_node = cur_node.next
					cur_node.next = prev_node
					prev_node = cur_node
					cur_node = next_node
		
		return prev_node

if __name__ == '__main__':
	pass
