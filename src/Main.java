
import library.Library;
import library.LibraryManager;
import thread.AutoSaveThread;


public class Main {


    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            manager.stopAutoSave();
        }));
        /*
        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            while (!Thread.currentThread().isInterrupted()) {
                //manager.thread.interrupt();
                try {
                    manager.thread.interrupt();
                    manager.thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }));
        */
        manager.handleUserInput();
    }
}