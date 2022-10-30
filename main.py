import search_machine as sm
from pprint import pprint
if __name__ == '__main__':

    docu = sm.Document('title1', 'this is a content',
                    'this is the abstract',
                    'english',
                    sm.Date(2022,10,14),
                    author= sm.Author('tao', 'xiang', sm.Date(1997,8,8),'abc@gmail.com')
                    )

    print(docu)
    print(sm.Document.__findSuffix__('hallo'))
    print(sm.Document.__findSuffix__('guten'))
    print(sm.Document.__findSuffix__('tag'))
    print(sm.Document.__findSuffix__('durch'))
    print(sm.Document.__findSuffix__('Tisch'))
    print(sm.Document.__getWordstamm__('Tisch'))
    docu.addContent('Ich bin ein Student an Technische Universitaet Muenchen. Ich studiere Informatik. Muenchen ist eine schoene Stadt.')
    print(docu.getWordCounts())
    print()
    print(docu.__dict__)
    pprint(docu.getDict())
    print(docu.__class__)

    date1 = sm.Date(1997,2,3)
    date2 = sm.Date(1997,2,3)
    print(date1 == date2)

    print(docu.getWordCounts().getWord(555))

    docu.getWordCounts().sort()
    print(docu.getWordCounts())

    print(docu.getWordCounts().computeSimilarity(docu.word_counts))