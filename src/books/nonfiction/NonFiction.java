package books.nonfiction;

import books.Book;

public class NonFiction extends Book {
    protected String category;

    public NonFiction(String title, String author, int year, String category) {
        super(title, author, year);
        this.category = category;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("비문학 장르: " + category);
    }

    @Override
    public String getCategory() {
        return "비문학";
    }
}