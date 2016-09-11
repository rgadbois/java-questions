/**
 * Created by rgadbois on 8/6/16.
 */

public class Reader extends Thread{
    private HashMapCustom<Integer, Integer> dataManager = null;
    private Integer[] keys;

    public Reader(HashMapCustom<Integer, Integer> dataManager, String threadName, Integer[] keys) {
        this.dataManager = dataManager;
        this.setName(threadName);
        this.keys = keys;
    }

    private boolean runForestRun = true;
    @Override
    public void run() {
        while (runForestRun) {
            for (Integer key : keys) {
                //reading from dictionary with READ LOCK
                Integer value = dataManager.get(key);
                //make what ever you want with the value.
                System.out.println(getName() + " " + key + " : " + value);
            }
            //update every seconds
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopReader(){
        this.runForestRun = false;
        this.interrupt();
    }
}