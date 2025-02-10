package books;

public class Book {
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void getInfo() {
        System.out.println("카테고리: " + getCategory());
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("출판년도: " + year);
    }

    public String getCategory() {
        return "일반 (장르 X)";
    }

    // setter 메서드 -> title, author, year 변수는 protected 접근 제한자를 가지고 있음.
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }
}