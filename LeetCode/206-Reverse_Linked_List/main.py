from typing import Optional

class ListNode:
	def __init__(self, val=0, next=None):
		self.val = val
		self.next = next


class Solution:
	def __init__(self):
		pass
	
	def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
		prev_node, cur_node, next_node = None, None, None
		if not head:
			return head
		
		else:
			prev_node = cur_node = head

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



def create_input_list(input_values: list) -> Optional[ListNode]:
	head_node, cur_node = None, None

	for index, value in enumerate(input_values):
		if index == 0:
			head_node = ListNode(val=value)
			cur_node = head_node
		elif index == len(input_values) - 1:
			return head_node
		else:
			cur_node.next = ListNode(val=value)
			cur_node = cur_node.next
	
	return head_node


def print_list_node(node: ListNode):
	index = 0
	while node.next != None:
		print(f'[{index}] - val: {node.val}, next: {node.next}')
		index += 1
		
		node = node.next
		

if __name__ == '__main__':
	# create ListNode
	input_values = [1, 2, 3, 4, 5]
	head_node = create_input_list(input_values)
	
	# print_list_node(head_node)
	# test solution
	solution = Solution()
	result = solution.reverseList(head=head_node)
	print_list_node(result)


