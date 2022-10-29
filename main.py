from search_machine import *

if __name__ == '__main__':

    docu = Document('title1', 'this is a content',
                    'this is the abstract',
                    'english',
                    Date(2022,10,14),
                    author= Author('tao', 'xiang', Date(1997,8,8),'abc@gmail.com')
                    )

    print(docu)