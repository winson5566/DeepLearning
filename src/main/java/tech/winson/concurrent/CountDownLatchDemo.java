package tech.winson.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    class PokerPlayer implements Runnable {
        private final String[] POINTS = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K",};
        private String name;
        private CountDownLatch countDown;
        public PokerPlayer(String name, CountDownLatch countDown) {
            this.name = name;
            this.countDown = countDown;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long) (Math.random() * 5000));
                // 随机抽一张牌
                Random random = new Random();
                String myPoint = POINTS[random.nextInt(13)];
                System.out.println(name + "ready!");
                // 准备就绪，等待其它玩家也就绪
                countDown.countDown();
                countDown.await();
                // 玩家都就绪了，翻底牌
                System.out.println(name + ":" + myPoint);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final int PER_TABLE_PLAYERS = 4; // 多少人够开一桌的
        CountDownLatch countDown = new CountDownLatch(PER_TABLE_PLAYERS);
        CountDownLatchDemo ins = new CountDownLatchDemo();
        ExecutorService executorPool = Executors.newFixedThreadPool(PER_TABLE_PLAYERS);
        for(int i=0; i<PER_TABLE_PLAYERS; i++) {
            executorPool.execute(ins.new PokerPlayer(i +"号玩家", countDown));
        }
        executorPool.shutdown();
    }
}
