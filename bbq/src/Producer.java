import java.util.Random;

public class Producer extends Thread{

    private boolean runForestRun = true;
    private FixedCapacityQueue<Integer> myQueue;

    public Producer(FixedCapacityQueue<Integer> myQueue){
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while(this.runForestRun){
            // lets produce some item
            Integer random = new Random().nextInt(10);
            if (random == 0) {
                myQueue.add(null);
            } else {
                myQueue.add(random);
            }
            System.out.println("Produced Item : " + random);
            // putting some delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWriter(){
        this.runForestRun = false;
        this.interrupt();
    }
}