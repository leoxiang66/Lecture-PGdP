from ._date import Date
from ._author import Author
from ._wordcount import WordCountList
from .utils import DictForm

class Document(DictForm):
    SUFFICES = ['ab', 'al', 'ant', 'artig', 'bar', 'chen', 'ei', 'eln', 'en', 'end', 'ent', 'er', 'fach', 'fikation', 'fizieren', 'fähig',
'gemäß', 'gerecht', 'haft', 'haltig', 'heit', 'ie', 'ieren', 'ig', 'in', 'ion', 'iren', 'isch', 'isieren', 'isierung',
'ismus', 'ist', 'ität', 'iv', 'keit', 'kunde', 'legen', 'lein', 'lich', 'ling', 'logie', 'los', 'mal', 'meter', 'mut',
'nis', 'or', 'sam', 'schaft', 'tum', 'ung', 'voll', 'wert', 'würdig']
    PUNTUCATION = ['.', ',', '?', '!', ':', ';', '...', '-']
    
    def __init__(self, title: str, content: str, abstract: str, language:str, publication_date: Date,author: Author) -> None:
        super().__init__()
        self.title = title
        self.content = content
        self.abstract =abstract
        self.language = language
        self.publication_date = publication_date
        self.author = author
        self.word_counts = WordCountList()
        
        # setup word counts
        self.addContent(content)
        

    def __str__(self) -> str:
        ret = f'{self.title}'
        ret+=f'\n- content: {self.content}'
        ret += f'\n- abstract: {self.abstract}'
        ret += f'\n- langauge: {self.language}'
        ret += f'\n- publication date: {self.publication_date}'
        ret +=f'\n- author: {self.author}'
        return ret
    
    def getWordCounts(self) -> WordCountList:
        return self.word_counts

    @classmethod
    def __tokenize__(cls,text: str):
        return text.split(' ')
    
    @classmethod
    def __sufficesEqual__(cls, text1: str, text2: str, n:int):
        '''
        return True if the last n letters of the two texts are equal
        '''
        return text1[-n:] == text2[-n:]
    
    @classmethod
    def __findSuffix__(cls, word: str):
        for i in cls.SUFFICES:
            length = len(i)
            if len(word) < length: continue
            if cls.__sufficesEqual__(i,word,length):
                return i


    @classmethod
    def __getWordstamm__(cls,word:str) -> str:
        suffix = cls.__findSuffix__(word)
        if suffix:
            length = len(suffix)
            return word[:-length]
        else:
            return word
    @classmethod
    def __removePunc__(cls,text:str) ->str:
        for i in cls.PUNTUCATION:
            text = text.replace(i,'')
        return text
    
    def addContent(self,content: str):
        content = self.__removePunc__(content)
        words = self.__tokenize__(content) # [str]
        wordstamms = [self.__getWordstamm__(word) for word in words]
        
        tmp = dict()
        for i in wordstamms:
            if i not in tmp:
                tmp[i] = 1
            else:
                tmp[i] += 1
        for word,count in tmp.items():
            self.word_counts.add(word,count)
    