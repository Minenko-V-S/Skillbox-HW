package Task2;

import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Deque;
import java.util.LinkedList;

public class RedisStorage {


     //Кол-во зарегистрированных пользователей.
    public static final int USERS_AMOUNT = 20;

    private RedissonClient redissonClient;
    private RDeque<Integer> registeredUsersIds;



     //Подключение к docker-контейнеру Redis.
    public void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Failed to connect to Redis");
            System.out.println(Exc.getMessage());
        }
        registeredUsersIds = redissonClient.getDeque("users");
    }


     //Инициализация данных.
    public void initData() {
        for (int i = 0; i < USERS_AMOUNT; i++) {
            registeredUsersIds.add(i);
        }
    }


    //Добавление id пользователя в конец очереди показа.
    public void addLast(int userId) {
        registeredUsersIds.addLast(userId);
    }


     //Доавление Id пользователя в самое начало очереди показа.
    public void pushUser(int userId) {
        registeredUsersIds.push(userId);
    }


     // Возврат без удаления первого в очереди Id пользователя.
    public Integer peekFirstUser() {
        return registeredUsersIds.peekFirst();
    }


     //Удаление и возврат первого в очереди показа Id пользователя.
    public Integer removeFirstUser() {
        return registeredUsersIds.removeFirst();
    }

}
