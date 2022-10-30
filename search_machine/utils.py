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
