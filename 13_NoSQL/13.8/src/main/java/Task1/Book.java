package Task1;
import lombok.*;

@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String author;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    private int year;
}
