

public class Article extends Publication {
	private String journal;
	private String pages;
	private String volume;
	
	
	public Article(){
		super();
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	
	
	public String toString(){
		return this.getPubId()+this.getPubKey()+this.getTitle()+this.getYear()+this.getJournal()+this.getPages()+this.getVolume();
	}
}
