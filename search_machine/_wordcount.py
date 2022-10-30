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
    
        



class WordCountList:
    def __init__(self) -> None:
        super().__init__()
        self.__list__ = []

    def add(self,word:str, count: int):
        self.__list__.append(WordCount(word,count))
    def __len__(self):
        return len(self.__list__)
    def getWord(self,idx: int):
        return self.__list__[idx].getWord()
    def getCount(self,idx: int):
        return self.__list__[idx].getCount()
    def setCount(self,idx: int, count: int):
        self.__list__[idx].setCount(count)
    def __str__(self) -> str:
        return str(self.__list__)
    
    def __repr__(self) -> str:
        return str(self.__list__)
