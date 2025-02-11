package library;

import books.Book;
import books.fiction.*;
import books.nonfiction.ArtBook;
import books.nonfiction.EconomicsBook;
import books.nonfiction.HistoryBook;
import books.nonfiction.PhilosophyBook;
import books.textbooks.*;
import thread.AutoSaveThread;

import java.util.Scanner;

public class LibraryManager {
    private Library library = new Library();
    private Scanner scanner = new Scanner(System.in);
    private Thread thread;
    private AutoSaveThread autoSaveThread;

    public LibraryManager() {
        autoSaveThread = new AutoSaveThread(library);
        thread = new Thread(autoSaveThread);
        thread.start();
    }

    public void displayMainMenu() {
        System.out.println("\n♡(っ*’ᵕ’)’ᵕ’*c)♡   ◌ ｡˚✩( › ̫ ‹ )✩˚ ｡◌");
        System.out.println("✿✧(♡⸃ ◡ ⸂♡)☆ 도서 관리 프로그램 ✿✧(♡⸃ ◡ ⸂♡)☆");
        System.out.println();
        System.out.println("아래의 메뉴에서 원하는 항목을 번호로 선택해주세요!");
        System.out.println();
        System.out.println("1. 책 추가하기");
        System.out.println("2. 책 삭제하기");
        System.out.println("3. 책 검색하기");
        System.out.println("4. 도서 정보 수정하기");
        System.out.println("5. 책 목록 보기");
        System.out.println("6. 종료하기");
        System.out.println();
        System.out.print("선택할 번호를 입력해주세요! : ");
    }

    public void handleUserInput() {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    handleBookAddition();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("도서 관리를 마칩니다! 다음에 만나요~");
                    System.out.println("♡(っ*’ᵕ’)’ᵕ’*c)♡   ◌ ｡˚✩( › ̫ ‹ )✩˚ ｡◌");
                    return;
                default:
                    System.out.println();
                    System.out.println("잘못된 입력입니다! 다시 선택해주세요~");
            }
        }
    }

    private void handleBookAddition() {
        while (true) {
            System.out.println("\n(♡ ◡ ♡) 책 추가하기 (♡ ◡ ♡)");
            System.out.println();
            System.out.println("아래의 메뉴에서 원하는 항목을 번호로 선택해주세요!");
            System.out.println();
            System.out.println("1. 일반 책 추가하기 (장르 X)");
            System.out.println("2. 교과서 추가하기");
            System.out.println("3. 비문학 책 추가하기");
            System.out.println("4. 문학 책 추가하기");
            System.out.println("5. 뒤로 가기");
            System.out.println();
            System.out.print("선택할 번호를 입력해주세요! : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addGeneralBook();
                    break;
                case 2:
                    addTextBook();
                    break;
                case 3:
                    addNonFiction();
                    break;
                case 4:
                    addFiction();
                    break;
                case 5:
                    return;
                default:
                    System.out.println();
                    System.out.println("잘못된 입력입니다! 다시 입력해주세요~");
            }
        }
    }


    private void addGeneralBook() {
        System.out.print("책 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        System.out.print("출판년도: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        library.addBook(new Book(title, author, year));
    }

    private void addTextBook() {
        System.out.print("책 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        System.out.print("출판년도: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("과목 선택하기 (국어, 수학, 영어, 사회, 과학): ");
        String subject = scanner.nextLine();

        switch (subject) {
            case "국어":
                library.addBook(new KoreanTextBook(title, author, year));
                break;
            case "수학":
                library.addBook(new MathTextBook(title, author, year));
                break;
            case "영어":
                library.addBook(new EnglishTextBook(title, author, year));
                break;
            case "사회":
                library.addBook(new SocialTextBook(title, author, year));
                break;
            case "과학":
                library.addBook(new ScienceTextBook(title, author, year));
                break;
            default:
                System.out.println();
                System.out.println("잘못된 입력입니다! 다시 입력해주세요~");
        }
    }

    private void addNonFiction() {
        System.out.print("책 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        System.out.print("출판년도: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("비문학 장르 선택하기 (역사, 예술, 철학, 경제): ");
        String category = scanner.nextLine();

        switch (category) {
            case "역사":
                library.addBook(new HistoryBook(title, author, year));
                break;
            case "예술":
                library.addBook(new ArtBook(title, author, year));
                break;
            case "철학":
                library.addBook(new PhilosophyBook(title, author, year));
                break;
            case "경제":
                library.addBook(new EconomicsBook(title, author, year));
                break;
            default:
                System.out.println();
                System.out.println("잘못된 입력입니다! 다시 입력해주세요~");
        }
    }

    private void addFiction() {
        System.out.print("책 제목: ");
        String title = scanner.nextLine();
        System.out.print("저자: ");
        String author = scanner.nextLine();
        System.out.print("출판년도: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("문학 장르 선택하기 (고전, 희곡, 소설, 시, 자서전): ");
        String genre = scanner.nextLine();

        switch (genre) {
            case "고전":
                library.addBook(new ClassicBook(title, author, year));
                break;
            case "희곡":
                library.addBook(new DramaBook(title, author, year));
                break;
            case "소설":
                library.addBook(new NovelBook(title, author, year));
                break;
            case "시":
                library.addBook(new PoetryBook(title, author, year));
                break;
            case "자서전":
                library.addBook(new AutobiographyBook(title, author, year));
                break;
            default:
                System.out.println();
                System.out.println("잘못된 입력입니다! 다시 입력해주세요~");
        }
    }

    private void deleteBook() {
        System.out.print("삭제할 책 제목을 입력해주세요! : ");
        String title = scanner.nextLine();
        library.removeBook(title);
    }

    private void searchBook() {
        System.out.print("검색할 책 제목을 입력해주세요! : ");
        String title = scanner.nextLine();
        library.searchBook(title);
    }

    private void updateBook() {
        System.out.print("수정할 책 제목을 입력해주세요! : ");
        String oldTitle = scanner.nextLine();
        System.out.print("새로운 제목: ");
        String newTitle = scanner.nextLine();
        System.out.print("새로운 저자: ");
        String newAuthor = scanner.nextLine();
        System.out.print("새로운 출판년도: ");
        int newYear = scanner.nextInt();
        scanner.nextLine();

        library.updateBook(oldTitle, newTitle, newAuthor, newYear);
    }

    // 프로그램 종료 시 자동 저장 스레드를 중지하는 메소드
    public void stopAutoSave() {
        autoSaveThread.stopThread();
    }
}