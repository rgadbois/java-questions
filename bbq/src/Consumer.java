
public class Consumer implements Runnable{

    private FixedCapacityQueue<Integer> myQueue;

    public Consumer(FixedCapacityQueue<Integer> myQueue){
        this.myQueue = myQueue;
    }
    @Override
    public void run() {
        while(true){
            Integer e = 0;
            try {
                e = myQueue.take();
                if (e == null) {
                    System.out.println(" Consumed Item : NULL");
                    continue;
                }
                // put some delay
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            // print the dequeued item
            System.out.println(" Consumed Item :" + e);
        }
    }
}