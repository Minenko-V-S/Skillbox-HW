package Task2;

import java.util.Random;

public class RunLoveSiteTask {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {

        RedisStorage rs = new RedisStorage();
        rs.init();
        rs.initData();

        while (true) {
            for (int i = 1; i <= RedisStorage.USERS_AMOUNT; i++) {
                System.out.println("На главной странице показываем пользователя " + rs.peekFirstUser());
                rs.addLast(rs.removeFirstUser());
                if (i % getRandom() == 0) {
                    System.out.println("Пользователь " + i + " оплатил платную услугу");
                    rs.pushUser(i);
                }
            }
            System.out.println("===");
            Thread.sleep(2000);
        }
    }


    //Возврат случайного числа для определния оплатившего подъем пользователя.
    private static int getRandom() {
        return RANDOM.nextInt(RedisStorage.USERS_AMOUNT)+1;
    }
}
