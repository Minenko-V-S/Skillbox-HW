package Task1;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.stream.Stream;
import java.util.function.Consumer;

public class TaskRun {
    public static void main(String[] args) {
        MongoDatabase database = new TaskMongoClient().getMongoDatabase();
        MongoCollection<Document> booksCollection = database.getCollection("books");
        booksCollection.drop();

        Stream<Book> bookStream = Stream.of(
                new Book ("Философия Java", "Эккель Брюс", 2019),
                new Book ("Spring 4 Для профессионалов", "Крис Шеффер", 2015),
                new Book ("Java. Полное руководство", "Герберт Шилдт", 2018),
                new Book ("Воин", "Роберт Энтони Сальваторе", 1991),
                new Book ("Тысяча орков", "Роберт Энтони Сальваторе", 2002),
                new Book ("Neverwinter", "Роберт Энтони Сальваторе", 2011)

        );
        bookStream.forEach(book -> {
            booksCollection.insertOne(
                    new Document()
                            .append("name", book.getName())
                            .append("author", book.getAuthor())
                            .append("year", book.getYear())
            );
        });

        //запрос на самую старую книгу
        System.out.println("Самая старая книга:");
        BsonDocument oneOlderBookSortQuery = BsonDocument.parse("{year: 1}");
        System.out.println(booksCollection.find().sort(oneOlderBookSortQuery).first());
        //запрос на книги любимого автора
        System.out.println("Книги любимого автора:");
        booksCollection.find(Filters.eq("author", "Роберт Энтони Сальваторе"))
                .forEach((Consumer<Document>) System.out::println);


    }
}
