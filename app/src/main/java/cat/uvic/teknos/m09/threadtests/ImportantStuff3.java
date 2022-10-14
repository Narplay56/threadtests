package cat.uvic.teknos.m09.threadtests;

public class ImportantStuff3  {
    public void doStuff() {
        try {
            Thread.sleep(2*1000);
            System.out.println("Done important stuff 3");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
