package ConsoleCustomerList.exceptions;

public class EmptyListException extends RuntimeException {
    public String getMessage() {
        return "В базе данных отсутствуют записи.";
    }
}
