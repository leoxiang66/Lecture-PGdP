from ._date import Date
from .utils import valid_email, DictForm

class Author(DictForm):
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
    
    def __eq__(self, o: object) -> bool:
        if not isinstance(o, Author):
            return False
        
        if self.first_name == o.first_name and self.last_name == o.last_name and \
        self.birthday == o.birthday and self.email == o.email:
            return True
        
        return False


