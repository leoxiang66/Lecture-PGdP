import search_machine as sm
from ..utils import truncate
BACKEND = sm.DocumentCollection()
import re


def cli():
    help = {
        'exit' : 'Veranlasst die Termination der main-Methode.',
        'add <Titel>:<fliesstext des dokumentes>': '''Fügt der DocumentCollection ein neues Document mit dem Titel Titel und dem Fließtext fliesstext des dokumentes hinzu. Titel und Fließtext werden dabei durch einen Doppelpunkt (:) getrennt.''',
        'list': '''Listet die Titel aller mittels add hinzugefügten Dokumente auf.''',
        'count <word>':'''Listet für jedes Dokument auf, wie oft darin das Wort word vorkommt.''',
        'query <suchanfrage>':'''Führt die Suchanfrage suchanfrage auf den Documenten der DocumentCollection durch und gibt eine nummerierte Trefferliste der Documente aus'''
    }
    prompt = ''
    max_len = max([len(x) for x in help.keys()])
    for i,j in help.items():
        prompt += i.ljust(max_len+5) + truncate(j,max_len+5,30)+'\n'
    usr = input(prompt)
    while usr != 'exit':
        if re.match(pattern='add [a-zA-Z0-9äöüÄÖÜß\s]+:[a-zA-Z0-9äöüÄÖÜß\s]+',string=usr):
            # add document
            idx = usr.index(':')
            title = usr[4:idx]
            content = usr[idx+1:]
            BACKEND.appendDocument(sm.Document(title,content,None,None,None,None))
        elif usr == 'list':
            # lis docs
            for i in BACKEND:
                print(i.getDocument().title)
        elif re.fullmatch("count [a-zA-Z0-9äöüÄÖÜß]+",usr):
            # count words
            word = usr[6:]
            for i in BACKEND:
                print(f'''{i.getDocument().title}: {i.getDocument().count(word)}''')
        elif re.match("query [a-zA-Z0-9äöüÄÖÜß\s]+",usr):
            # query
            query = usr[6:]
            BACKEND.match(query)
            for idx,i in enumerate(BACKEND):
                print(f'''{i.getDocument().title}: {BACKEND.getQuerySimilarity(idx)}''')
        else:
            print()
            print('You entered invalid commands.')
            # print(prompt)

        usr = input()

if __name__ == '__main__':
    cli()