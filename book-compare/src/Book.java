
public class Book {

	private String title;
	private String author;
	private int publicationYear;
	private int pages;
	
	public Book (String title, String author, int publicationYear, int pages)
	{
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
