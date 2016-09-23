package main;

public class Incollection extends Publication {
	private String bookTitle;
	private String publisher;
	private String ISBN;
	
	public Incollection(){
		super();
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String toString(){
		return this.getPubKey()+this.getTitle()+this.getYear()+this.getBookTitle()+this.getPublisher()+this.getISBN();
	}
}
