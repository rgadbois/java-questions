import java.util.Random;

/**
 * Created by rgadbois on 8/6/16.
 */
public class Writer extends Thread {
    private boolean runForestRun = true;
    private Integer[] keys;
    private HashMapCustom<Integer, Integer> dataManager = null;

    public Writer(HashMapCustom<Integer, Integer> dataManager, String threadName, Integer[] keys) {
        this.dataManager = dataManager;
        this.setName(threadName);
        this.keys = keys;
    }

    @Override
    public void run() {
        while (this.runForestRun) {
            for (Integer key : keys) {
                //updating dictionary with WRITE LOCK
                dataManager.put(key, key);
                System.out.println(getName() + " " + key + " : " + key);
            }

            //update every seconds
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWriter() {
        this.runForestRun = false;
        this.interrupt();
    }
}