import math

from .utils import DictForm

class WordCount(DictForm):
    '''
    represents a word and its absolute frequency in a document
    '''
    def __init__(self, word: str, count: int) -> None:
        super().__init__()
        if count<0:
            raise RuntimeError(f"You entered invalid absolute frequency: {count}.")
        self.word = word
        self.count = count

    def incCount(self, n: int = 1):
        self.count += n
    def getWord(self):
        return self.word
    def getCount(self):
        return self.count
    def setWord(self,word:int):
        self.word = word
    def setCount(self,count: int):
        if count<0:
            raise RuntimeError(f"You entered invalid absolute frequency: {count}.")
        self.count = count
    
    def __str__(self) -> str:
        return f'''{{Word: {self.word}, Count: {self.count}}}'''
    
    def __repr__(self) -> str:
        return f'''{{Word: '{self.word}', Count: {self.count}}}'''
    
    def __copy__(self):
        return WordCount(self.word,self.count)
    def __deepcopy__(self, memodict={}):
        return self.__copy__()

    def __hash__(self):
        return id(self)



class WordCountList:
    def __init__(self) -> None:
        super().__init__()
        self.__list__ = []

    def add(self,word:str, count: int):
        idx = self.getIndexofWord(word)
        if  idx == -1:
            self.__list__.append(WordCount(word, count))
        else:
            self.__list__[idx].setCount(self.__list__[idx].count + count)

    def __len__(self):
        return len(self.__list__)
    def getWord(self,idx: int):
        if not idx in range(len(self.__list__)):
            return None
        return self.__list__[idx].getWord()
    def getIndexofWord(self,word: str):
        for id,i in enumerate(self.__list__):
            if word == i.getWord():
                return id
        return -1

    def getCount(self,idx: int):
        if not idx in range(len(self.__list__)):
            return None
        return self.__list__[idx].getCount()
    def setCount(self,idx: int, count: int):
        self.__list__[idx].setCount(count)
    def __str__(self) -> str:
        return str(self.__list__)
    
    def __repr__(self) -> str:
        return str(self.__list__)

    def wordsEqual(self,wca):
        '''
        check whether the words and order of words equals (not considering the counts)
        :param wca:
        :return:
        '''
        if not isinstance(wca,self.__class__):
            return False
        if len(self) != len(wca):
            return False
        length = len(self)
        for i in range(length):
            if self.getWord(i) != wca.getWord(i):
                return False
        return True

    def scalarProduct(self,wca):
        if not self.wordsEqual(wca):
            raise RuntimeError('Number of words are not equal.')

        return sum([self.getCount(i)*wca.getCount(i) for i in range(len(self))])
    def sort(self,reverse: bool = False):
        self.__list__.sort(key=lambda x: x.word, reverse=reverse)
        # self.__list__.sort(key= lambda x: x.count,reverse = reverse)


    def computeSimilarity(self, wca):
        if not isinstance(wca,self.__class__):
            raise TypeError('Not the samle class.')
        self.sort()
        wca.sort()

        return self.scalarProduct(wca) / math.sqrt(self.scalarProduct(self) * wca.scalarProduct(wca))

    def __copy__(self):
        new = WordCountList()
        new.__list__ = [x.__copy__() for x in self.__list__]
        return new

    def copy(self):
        return self.__copy__()

    # subscriptable and slice-able
    def __getitem__(self, n):
        return self.__list__[n]



    def __add__(self, other):
        if not isinstance(other,self.__class__):
            raise TypeError('The object is not of the same class.')
        else:
            new = self.copy()
            for wc in other.__list__:
                idx = new.getIndexofWord(wc.word)
                if idx == -1:
                    new.add(wc.word,wc.count)
                else:
                    new[idx].incCount(wc.count)
            new.sort()
            return new

    def extend(self, other):
        if not isinstance(other, self.__class__):
            raise TypeError("The object is not of the same class")
        else:
            for wc in other.__list__:
                idx = self.getIndexofWord(wc.word)
                if idx == -1:
                    self.add(wc.word,wc.count)
                else:
                    self[idx].incCount(wc.count)

        self.sort()

    def count(self,word:str):
        idx = self.getIndexofWord(word)
        if idx == -1:
            return 0
        else:
            return self[idx].count
