import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newFixedThreadPool(4);

            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                () -> System.out.println("*** Pen Cleaned!")
            );

            for (int i=0; i < 4 ; i++ ) {
                service.submit(() -> manager.performTask(c1, c2));
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}

class LionPenManager {
    private void removeAnimals() {
        System.out.println("Removing Animals.");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        try {
            removeAnimals();
            barrier1.await();
            cleanPen();
            barrier2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {}
    }
}
