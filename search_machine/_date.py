from .utils import DictForm

class Date(DictForm):
    def __init__(self, year:int, month:int,day:int) -> None:
        super().__init__()
        if year < 1900 or month<0 or month>12 or day<0 or day>31:
            raise RuntimeError('This is an invalid date. Please enter again.')
        self.year = year
        self.month = month
        self.day = day

    def __str__(self) -> str:
        return f'''{self.year}-{self.month}-{self.day}'''
    
    def __eq__(self, o: object) -> bool:
        if not isinstance(o, Date):
            return False
        # if self.year == o.year and self.month == o.month and self

    

