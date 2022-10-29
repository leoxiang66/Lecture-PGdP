from ._date import Date
from .utils import valid_email

class Author:
    def __init__(self, first_name: str, last_name, birthday: Date, email:str) -> None:
        super().__init__()
        if not valid_email(email):
            raise RuntimeError('You entered a wrong email. Please enter it again.')

        self.first_name = first_name
        self.last_name = last_name
        self.birthday = birthday
        self.email = email

    def __str__(self) -> str:
        return f'''{self.first_name} {self.last_name}'''


