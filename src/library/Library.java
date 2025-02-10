package library;

import books.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println();
        System.out.println("책이 추가되었습니다 (｡♥‿♥｡)");
        System.out.println();
    }

    public void removeBook(String title) {
        if (books.isEmpty()) {
            System.out.println("도서 목록이 비어있습니다! 삭제할 수 있는 책이 없습니다 (•̆·̭•̆ )");
            return;
        }

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                System.out.println();
                System.out.println("책이 삭제되었습니다 (ꌩ-ꌩ)");
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println();
            System.out.println("해당 책이 목록에 존재하지 않습니다 ㅇࡇㅇ?");
            System.out.println();
        }

    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println();
                System.out.println("검색된 책의 정보는 다음과 같습니다!");
                System.out.println();
                book.getInfo();
                return;
            }
        }
        System.out.println();
        System.out.println("책을 찾을 수 없습니다 (´△｀)");
        System.out.println();
    }

    public void updateBook(String oldTitle, String newTitle, String newAuthor, int newYear) {
        for (Book book : books) {
            if (book.getTitle().equals(oldTitle)) {
                // setter 메서드 사용 -> Book 클래스의 protected 변수에 접근하기 위해.
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setYear(newYear);
                System.out.println();
                System.out.println("책 정보가 업데이트 되었습니다! ");
                System.out.println();
                return;
            }
        }
        System.out.println();
        System.out.println("책을 찾을 수 없습니다 (´△｀)");
        System.out.println();
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println();
            System.out.println("도서 목록이 비어 있습니다 (｡•́︿•̀｡)");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("현재 도서관에 있는 책의 목록은 다음과 같습니다~");
            System.out.println();
            for (Book book : books) {
                book.getInfo();
                System.out.println();
            }
        }
    }
}