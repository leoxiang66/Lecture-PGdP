from ._date import Date
from ._author import Author

class Document:
    def __init__(self, title: str, content: str, abstract: str, language:str, publication_date: Date,author: Author) -> None:
        super().__init__()
        self.title = title
        self.content = content
        self.abstract =abstract
        self.language = language
        self.publication_date = publication_date
        self.author = author


    def __str__(self) -> str:
        ret = f'{self.title}'
        ret+=f'\n- content: {self.content}'
        ret += f'\n- abstract: {self.abstract}'
        ret += f'\n- langauge: {self.language}'
        ret += f'\n- publication date: {self.publication_date}'
        ret +=f'\n- author: {self.author}'
        return ret





