package cat.uvic.teknos.m09.threadtests;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static Lock lock = new ReentrantLock();
    private static Random random = new Random();
    private static Condition condition = lock.newCondition();
    private static String message;


    public static void main(String[] args) {
        for (int i = 1; i < 10; i++){
            var t1 = new Thread(LockTest::printMessage, "Background Thread-" + i);
            var t2 = new Thread(LockTest::setMessage, "Interactive Thread-" + i);
            t1.start();
            t2.start();
        }
        System.out.println("Working...");
    }
    public static void printMessage(){
        lock.lock();
        try {
            if (message == null){
                condition.await();
            }else{
                System.out.println(Thread.currentThread().getName() + "prints: " + message);
                message = null;
                condition.signalAll();
            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }
    }
    public static void setMessage(){
        lock.lock();
        try {
            if (message == null) {
                var scanner = new Scanner(System.in);
                System.out.println("[" + Thread.currentThread().getName() + "] Type enter a new message");
                scanner.nextLine();

                condition.signalAll();
            }
            else {
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
