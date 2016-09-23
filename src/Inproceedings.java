package main;

public class Inproceedings extends Publication {
	private String bookTitle;
	private String editor;
	
	public Inproceedings(){
		super();
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	
}
