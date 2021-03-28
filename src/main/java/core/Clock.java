package core;

public class Clock implements Runnable {

    public static boolean running = true;


    public synchronized void run(){

        System.out.println("Thread started");

        while (running){
            try {
                do {
                    Thread.sleep(500);
                    Game.nextGen();
                } while (running);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inverseClockState(){
        running = !running;
    }

}
