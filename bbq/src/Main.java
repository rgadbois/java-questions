
public class Main {

    public static void main(String[] args) {
        try {
            FixedCapacityQueue<Integer> myQueue = new FixedCapacityQueue<Integer>(100);

            // instantiate both producer and consumer
            Producer producer1 = new Producer(myQueue);
            Producer producer2 = new Producer(myQueue);
            Thread consumer1 = new Thread(new Consumer(myQueue));
            Thread consumer2 = new Thread(new Consumer(myQueue));

            // start both producer and consumer
            producer1.start();
            producer2.start();
            consumer1.start();
            consumer2.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
