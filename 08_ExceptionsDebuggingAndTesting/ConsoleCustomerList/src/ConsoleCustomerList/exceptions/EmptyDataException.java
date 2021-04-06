package ConsoleCustomerList.exceptions;

public class EmptyDataException extends RuntimeException  {
    public String getMessage() {
        return "Пустые входные данные. Невозможно выполнить команду.";
    }
}
