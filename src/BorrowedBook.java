import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class BorrowedBook extends Book {
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private int lastDay;

    public BorrowedBook(Book book){
        super(book.getBookName(),book.getAuthor(),book.getIsbn());
        borrowDate=LocalDate.now();
        returnDate=borrowDate.plusWeeks(2);
        lastDay=Period.between(borrowDate,returnDate).getDays();
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getLastDay() {
        return lastDay;
    }
}
