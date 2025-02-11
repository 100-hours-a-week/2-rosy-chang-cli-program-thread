import library.Library;
import library.LibraryManager;
import thread.AutoSaveThread;

public class Main {
    static Library library = new Library();
    static AutoSaveThread autoSaver = new AutoSaveThread(library);


    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            manager.stopAutoSave();
        }));

        /*
        Thread thread = new Thread(autoSaver);
        thread.start(); // 스레드 시작
        */
        manager.handleUserInput();
    }

}