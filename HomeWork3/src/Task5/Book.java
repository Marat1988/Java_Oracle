package Task5;

public class Book {
    private String nameBook;
    private String nameAuthor;
    private int yearRelease;
    private String namePublishing;
    private String genreBook;
    private int pageCount;

    public Book(String nameBook, String nameAuthor, int yearRelease, String namePublishing, String genreBook, int pageCount) {
        this.nameBook = nameBook;
        this.nameAuthor = nameAuthor;
        this.yearRelease = yearRelease;
        this.namePublishing = namePublishing;
        this.genreBook = genreBook;
        this.pageCount = pageCount;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getNamePublishing() {
        return namePublishing;
    }

    public void setNamePublishing(String namePublishing) {
        this.namePublishing = namePublishing;
    }

    public String getGenreBook() {
        return genreBook;
    }

    public void setGenreBook(String genreBook) {
        this.genreBook = genreBook;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void sellBook(String nameBuyer) {
        System.out.println("Покупатель " + nameBuyer);
    }

    public void sellBook(String nameBuyer, int cost) {
        sellBook(nameBuyer);
        System.out.println("Куплена за " + cost + " рублей");
    }

    @Override
    public String toString() {
        return "Название книги: " + nameBook + "\n" +
                "Автор: " + nameAuthor + "\n" +
                "Год выпуска: " + yearRelease + "\n" +
                "Название издательства: " + namePublishing + "\n" +
                "Жанр книги: " + genreBook + "\n" +
                "Количество страниц: " + pageCount;
    }
}
