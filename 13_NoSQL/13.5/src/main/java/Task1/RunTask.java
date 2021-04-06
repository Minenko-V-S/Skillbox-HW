package Task1;

public class RunTask {
    public static void main(String[] args) {
        RedisStorage rs = new RedisStorage();
        rs.init();
        rs.initData();
        rs.readAll();
        rs.showCheapestFlights(3);
        rs.showMostExpensive(3);
    }
}
