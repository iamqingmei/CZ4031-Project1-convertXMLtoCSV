package main;

public class Book extends Publication {
	private String publisher;
	private String ISBN;
	
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

	public Book(){
		super();
	}
	
	public String toString(){
		return this.getPubKey()+this.getTitle()+this.getYear()+this.getPublisher()+this.getISBN();
	}
	
}
