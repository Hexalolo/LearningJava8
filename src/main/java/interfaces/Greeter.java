package interfaces;

public class Greeter implements Runnable {
    private String target;

    public Greeter(int n, String target){
        this.target = target;
        for(int i = 0; i < n; i++){
            run();
        }
    }

    public void runTogether(Runnable... tasks){
        System.out.println("start run together");
        new Thread(task1).start();
        new Thread(task2).start();
    }

    public void runInOrder(Runnable... tasks){
        System.out.println("start run in order");
        Thread th1 = new Thread(task1);
        th1.start();
        do{
        } while(!th1.getState().equals(Thread.State.TERMINATED));
        Thread th2 = new Thread(task2);
        th2.start();

    }

    Runnable task1 = new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 5; i++) {
                target = "Misja1";
                System.out.println("Witaj! " + target + " wątek " + Thread.currentThread().getId());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable task2 = new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 5; i++) {
                target = "Misja2";
                System.out.println("Witaj! " + target + " wątek " + Thread.currentThread().getId());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    public void run(){
        System.out.println("Witaj! "+ target +" wątek "+ Thread.currentThread().getId());
    }
}
