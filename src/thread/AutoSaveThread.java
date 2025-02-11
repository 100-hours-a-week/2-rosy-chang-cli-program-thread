package thread;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import library.Library;
import books.Book;

public class AutoSaveThread implements Runnable{
    private Library library;
    private boolean running = true;

    public AutoSaveThread(Library library) {
        this.library = library;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                saveLibraryData();
            } catch (InterruptedException e) {
                System.out.println("목록 자동 저장 스레드가 종료되었습니다!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveLibraryData() throws IOException {
        List<Book> books = library.getBooks(); // 현재 저장된 도서 목록 가져오기
        FileWriter fw = new FileWriter("BookList.txt", false);
        try {
            for (Book book : books) {
                fw.write(book.getTitle() + " | "
                           + book.getCategory() + " | "
                           + book.getAuthor() + " | "
                           + book.getYear() + "\n");
            }
            System.out.println();
            System.out.println("** 자동 저장 완료! 도서 목록이 저장되었습니다! **");
        } catch (IOException e) {
            System.out.println("자동 저장 중 오류가 발생했습니다! 에러 메시지: " + e.getMessage());
        }
    }
}
