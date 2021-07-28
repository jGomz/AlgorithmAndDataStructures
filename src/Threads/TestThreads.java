package Threads;

public class TestThreads {
    public static void main (String [] args){
        Runnable thread1 = new ImplRunnableThread();
        Thread test = new Thread(thread1);
        test.start();

        ExtThreadClass newThread = new ExtThreadClass();
        newThread.start();
    }
}
