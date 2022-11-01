import re

def valid_email(email):
    regex = re.compile(r'([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+')
    if (re.fullmatch(regex, email)):
        return True
    else:
        return False
    

class DictForm(object):
    def getDict(self) -> dict:
        ret = dict()
        for attr, value in self.__dict__.items():
            if hasattr(value,'getDict'):
                ret[attr] = value.getDict()
            else:
                ret[attr] = value
        return ret

    def __eq__(self, o: object) -> bool:
        if not isinstance(o,self.__class__):
            return False
        return self.getDict() == o.getDict()


def truncate(text: str, padding_len: int, max_len:int):
    result = ''
    i = 0
    while i+max_len < len(text):
        result += text[i:i+max_len].strip() +'\n' +' ' * padding_len
        i+= max_len

    result += text[i:].strip() +'\n'
    return result

if __name__ == '__main__':
    print(truncate('''Fügt der DocumentCollection ein neues Document mit dem Titel Titel und demFließtext fliesstext des dokumentes hinzu. Titel und Fließtext werden dabei durch einen Doppelpunkt (:) getrennt.''',40,20))

