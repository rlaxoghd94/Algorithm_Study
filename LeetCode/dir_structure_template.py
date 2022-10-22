import os


TEMPLATE_FILES = ['my_tries.py', 'answer.py', 'question.md']


if __name__ == '__main__':
    folder_name = input('folder name: ')
    base_dir = f'./{folder_name}'
    try:
        os.mkdir(base_dir)
        for template_file in TEMPLATE_FILES:
            open(f'{base_dir}/{template_file}', 'a').close()
    except Exception as e:
        print(e)
