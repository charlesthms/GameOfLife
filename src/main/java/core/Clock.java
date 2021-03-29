package core;

public class Clock extends Thread {

    public static boolean running = true;
    public static boolean generate = false;
    public static int speed = 100;

    public void run(){

        System.out.println("Thread started");

        while (running){
            System.out.checkError();
            if (generate){
                try {
                    do {
                        Thread.sleep(speed);
                        Game.nextGen();
                    } while (generate);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void inverseClockState(){
        running = !running;
    }

}
