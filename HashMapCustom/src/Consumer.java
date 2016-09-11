import java.util.Random;

/**
 * Created by rgadbois on 8/6/16.
 */

public class Consumer implements Runnable{

    private HashMapCustom<Integer, Integer> dataManager;

    public Consumer(HashMapCustom<Integer, Integer> dataManager){
        this.dataManager = dataManager;
    }
    @Override
    public void run() {
        while(true){
            Integer e = 0;
            try {
                Integer random = new Random().nextInt(10000);
                e = dataManager.get(random);

                if (e == null) {
                    System.out.println(" Consumed Item : " + random + " = NULL");
                } else {
                    dataManager.remove(random);
                    System.out.println(" Consumed Item :" + random + " = " + e);
                }
                // put some delay
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}