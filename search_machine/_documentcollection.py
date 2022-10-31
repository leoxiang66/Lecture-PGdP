from ._document import Document

class DocumentCollectionCell:
    def __init__(self, doc: Document):
        self.__document__ = doc
        self.__next__ = None

    def getDocument(self):
        return self.__document__
    
    def setNext(self,o: object):
        if not isinstance(o,self.__class__):
            raise RuntimeError(f'The given object is not from class {self.__class__}.')
        self.__next__ = o
    def getNext(self):
        return self.__next__

    def __str__(self) -> str:
        return str(self.__document__)


class DocumentCollection:
    def __init__(self) -> None:
        self.__start__ = None
        self.__end__ = self.__start__
        self.__num__ = 0
        
    def __assert__(self):
        if self.__num__ > 0:
            if not (isinstance(self.__start__,DocumentCollectionCell) and isinstance(self.__end__,DocumentCollectionCell)):
                raise RuntimeError(f'The start cell and end cell is not a DocumentCollectionCell!')
    
    def prependDocument(self, doc: Document):
        if doc is None:
            return
        
        if self.__start__ is None:
            self.__start__ = DocumentCollectionCell(doc)
            self.__end__ = self.__start__
        
        else:
            newcell = DocumentCollectionCell(doc)
            newcell.setNext(self.__start__)
            self.__start__ = newcell

        self.__num__ += 1
        self.__assert__()
        
    
    def appendDocument(self,doc:Document):
        if doc is None:
            return
        
        if self.__start__ is None:
            self.__start__ = DocumentCollectionCell(doc)
            self.__end__ = self.__start__
        else:
            self.__end__.setNext(DocumentCollectionCell(doc=doc))
            self.__end__ = self.__end__.getNext()

        self.__num__ += 1
        self.__assert__()
            
    def isEmpty(self)-> bool:
        return self.__num__ == 0
    
    def __len__(self):
        return self.__num__
    
    def getFirstDocument(self):
        return self.__start__.getDocument()
    
    def getLastDocument(self):
        return self.__end__.getDocument()
    
    def removeFirstDocument(self):
        if self.__num__ == 0:
            return

        if self.__num__ > 1:
            self.__start__ = self.__start__.getNext()
        elif self.__num__ == 1:
            self.__start__ = None
            self.__end__ = None

        self.__num__ -= 1
        self.__assert__()

    def getDocumentCellAt(self,idx:int) -> DocumentCollectionCell:
        if idx < 0 or idx >= self.__num__:
            raise IndexError('Index out of range.')
        else:
            tmp = self.__start__
            for idx in range(idx):
                tmp = tmp.getNext()
            return tmp


    def removeLastDocument(self):
        if self.__num__ == 0:
            return
        if self.__num__ > 1:
            tmp = self.getDocumentCellAt(self.__num__-2)
            self.__end__ = tmp
            tmp.__next__= None

        if self.__num__ == 1:
            self.__start__ = None
            self.__end__ = None

        self.__num__ -= 1
        self.__assert__()

    def remove(self,idx:int) -> bool:
        if idx < 0 or idx >= self.__num__:
            return False
        elif idx == 0:
            self.removeFirstDocument()
        elif idx == self.__num__-1:
            self.removeLastDocument()
        else:
            cell = self.getDocumentCellAt(idx-1)
            cell.setNext(cell.getNext().getNext())
            self.__num__ -= 1

        self.__assert__()

    def get(self,idx: int):
        return self.getDocumentCellAt(idx)

    def __iter__(self):
        self.__pointer__ = self.__start__
        return self

    def __next__(self):
        if self.__pointer__ is None:
            raise StopIteration
        else:
            tmp = self.__pointer__
            self.__pointer__ = self.__pointer__.getNext()
            return tmp


    def indexOf(self, doc: Document):
        for id,cell in enumerate(self):
            if cell.getDocument() == doc:
                return id
        return -1

    def __contains__(self, item):
        if not isinstance(item,Document):
            return False
        else:
            for cell in self:
                if cell.getDocument() == item:
                    return True

            return False






        
        
        

    