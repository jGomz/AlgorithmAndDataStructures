package Threads;

public class ExtThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println("Running from extended class");
    }
}
