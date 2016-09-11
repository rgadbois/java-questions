public class Main {

    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> dataManager = new HashMapCustom<Integer, Integer>();
        dataManager.put(1, 12);
        dataManager.put(2, 13);

        System.out.println(dataManager.get(1));
        System.out.println(dataManager.get(2));

        dataManager.put(1, 14);
        System.out.println(dataManager.get(1));

        dataManager.remove(1);
        System.out.println(dataManager.get(1));


        Integer[] keys = new Integer[] {10, 15};
        dataManager.put(10, 10);
        dataManager.put(15, 15);
        Writer writer  = new Writer(dataManager, "Mr. Writer", keys);
        Reader reader1 = new Reader(dataManager ,"Mrs Reader 1", keys);
        Reader reader2 = new Reader(dataManager ,"Mrs Reader 2", keys);
        Reader reader3 = new Reader(dataManager ,"Mrs Reader 3", keys);
        Reader reader4 = new Reader(dataManager ,"Mrs Reader 4", keys);
        Reader reader5 = new Reader(dataManager ,"Mrs Reader 5", keys);
        writer.start();
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();

        Thread producer1 = new Thread(new Producer(dataManager));
        Thread producer2 = new Thread(new Producer(dataManager));
        Thread consumer1 = new Thread(new Consumer(dataManager));
        Thread consumer2 = new Thread(new Consumer(dataManager));

        // start both producer and consumer
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
