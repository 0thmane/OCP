import java.util.concurrent.*;

public class SynchronizedBlocks {
    public static void main(String[] args) {
        ExecutorService service = null;


        try {
            service = Executors.newFixedThreadPool(20);

            SheepManager manager = new SheepManager();

            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.synchronizedIncrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }


        /*
            Even though the method synchronizedIncrementAndReport is
            synchronized, the output from the code above and the following code
            will be mixed in an unpredictable fashion.
        */
        /*
        try {
            service = Executors.newFixedThreadPool(20);

            SheepManager manager = new SheepManager();

            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.synchronizedIncrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }*/
    }
}

class SheepManager {
    private int sheepCount = 0;

    public void synchronizedIncrementAndReport() {
        // Ensure ordered output
        synchronized(this) {
            System.out.println((++sheepCount) + " ");
        }
    }

    public void incrementAndReport() {
        System.out.println((++sheepCount) + " ");
    }
}
