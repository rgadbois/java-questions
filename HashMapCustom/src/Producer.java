
import java.util.Random;

public class Producer implements Runnable{

    private HashMapCustom<Integer, Integer> dataManager;

    public Producer(HashMapCustom<Integer, Integer> dataManager){
        this.dataManager = dataManager;
    }

    @Override
    public void run() {
        while(true){
            // lets produce some item
            Integer random = new Random().nextInt(20);
            dataManager.put(random, random);
            System.out.println("Produced Item : " + random);
            // putting some delay
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}