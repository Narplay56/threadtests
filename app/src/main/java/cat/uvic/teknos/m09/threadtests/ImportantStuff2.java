package cat.uvic.teknos.m09.threadtests;

public class ImportantStuff2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Done important stuff 2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
