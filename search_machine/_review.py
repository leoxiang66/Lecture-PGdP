from ._author import Author
from ._document import Document
from ._date import Date
from .utils import DictForm

class Review(DictForm):
    def __init__(self,
                 content: str,
                 author: Author,
                 to_document: Document,
                 language: str,
                 publication_date: Date,
                 rating: int
                 ) -> None:
        super().__init__()
        if rating<0 or rating>10:
            raise RuntimeError(f'You entered invalid raing: {rating}.')

        self.content = content
        self.author = author
        self.to_document = to_document
        self.language = language
        self.publication_date = publication_date
        self.rating = rating

    def __str__(self) -> str:
        return f'''{self.content}'''

