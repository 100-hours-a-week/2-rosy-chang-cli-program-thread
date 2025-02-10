package books.fiction;

import books.Book;

public class Fiction extends Book {
    protected String genre;

    public Fiction(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("문학 장르: " + genre);
    }

    @Override
    public String getCategory() {
        return "문학";
    }
}