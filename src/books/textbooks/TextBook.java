package books.textbooks;

import books.Book;

public class TextBook extends Book {
    protected String subject;

    public TextBook(String title, String author, int year, String subject) {
        super(title, author, year);
        this.subject = subject;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("과목: " + subject);
    }

    @Override
    public String getCategory() {
        return "교과서";
    }
}