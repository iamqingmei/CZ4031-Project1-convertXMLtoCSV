

public class Incollection extends Publication {
	private String booktitle;
	private String pages;
	private String crossRef;
	
	public Incollection(){
		super();
	}

	public String getBookTitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getcrossRef() {
		return crossRef;
	}

	public void setcrossRef(String crossRef) {
		this.crossRef = crossRef;;
	}
	public String toString(){
		return this.getPubKey()+this.getTitle()+this.getYear()+this.getBookTitle()+this.getPages()+this.getcrossRef();
	}
}
