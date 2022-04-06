import java.util.Random;

public class UsersQueue {

    public static final int USERS_COUNT = 20;

    public static void main(String[] args) {

        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int i = 1; i <= USERS_COUNT; i++) {
            redis.addUser(i, String.valueOf(i));
        }

        for (int i = 0; i < 20; i++) {
            for (int score = 1; score <= USERS_COUNT; score++) {

                printUser(redis, score);

                int r = new Random().nextInt(11);
                if (r == 10) {
                    int u = new Random().nextInt(20) + 1;
                    String userId = String.valueOf(u);
                    int uScore = redis.getUserScore(userId);
                    System.out.println(">> Пользователь " + userId + "\t купил услугу по повышению в очереди!");
                    if (uScore > score) {
                        for (int shift = uScore; shift > score; shift--) {
                            String shiftUser = redis.getUserByScore(shift - 1);
                            redis.setUserScore(shift, shiftUser);
                        }
                        redis.setUserScore(score, userId);
                        printUser(redis, score);
                    }
                    if (uScore < score) {
                        for (int shift = score; shift > uScore; shift--) {
                            String shiftUser = redis.getUserByScore(shift);
                            redis.setUserScore(shift - 1, shiftUser);
                        }
                        redis.setUserScore(score, userId);
                        printUser(redis, score);
                    }
                    if (uScore == score) {
                        printUser(redis, score);
                    }
                }
            }
        }

        redis.shutdown();
    }

    private static void printUser(RedisStorage redis, int score) {
        String user = redis.getUserByScore(score);
        System.out.println("Пользователь " + user + "\t\t Очередь: " + redis.getUserScore(user));
        pause();
    }

    private static void pause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
