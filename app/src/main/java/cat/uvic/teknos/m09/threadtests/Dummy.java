package cat.uvic.teknos.m09.threadtests;

public class Dummy {
    public static void doImportantStuff1(){
        try {
            Thread.sleep(10*1000);
            System.out.println("Done important stuff 1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void doImportantStuff2(){
        System.out.println("Done important stuff 2");
    }
    public static void doImportantStuff3(){
        System.out.println("Done important stuff 3");

    }
}
