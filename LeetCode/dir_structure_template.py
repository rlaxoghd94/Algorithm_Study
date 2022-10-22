import os


TEMPLATE_FILES = [
        {
            'file_name': 'my_tries.py',
            'content': '"""Nic\'s approach\n"""'
        },
        {
            'file_name': 'answer.py',
            'content': '"""LeetCode community answer\n"""'
        },
        {
            'file_name': 'question.md',
            'content': '#'
        }
    ]


if __name__ == '__main__':
    folder_name = input('folder name: ')
    base_dir = f'./{folder_name}'
    try:
        os.mkdir(base_dir)
        for template_file_info in TEMPLATE_FILES:
            with open(f'{base_dir}/{template_file_info["file_name"]}', 'a') as file:
                file.write(template_file_info['content'])
    except Exception as e:
        print(e)
