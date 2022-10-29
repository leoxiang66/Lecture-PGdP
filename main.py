from search_machine import *

if __name__ == '__main__':

    docu = Document('title1', 'this is a content',
                    'this is the abstract',
                    'english',
                    Date(2022,10,14),
                    author= Author('tao', 'xiang', Date(1997,8,8),'abc@gmail.com')
                    )

    print(docu)
    print(Document.__findSuffix__('hallo'))
    print(Document.__findSuffix__('guten'))
    print(Document.__findSuffix__('tag'))
    print(Document.__findSuffix__('durch'))
    print(Document.__findSuffix__('Tisch'))
    print(Document.__getWordstamm__('Tisch'))
    docu.addContent('Ich bin ein Student an Technische Universitaet Muenchen. Ich studiere Informatik. Muenchen ist eine schoene Stadt.')
    print(docu.getWordCounts())