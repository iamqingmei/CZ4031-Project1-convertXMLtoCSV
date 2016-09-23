package main;

public class Article extends Publication {
	private String journal;
	private String month;
	private String volume;
	private String number;
	
	public Article(){
		super();
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString(){
		return this.getPubKey()+this.getTitle()+this.getYear()+this.getJournal()+this.getMonth()+this.getVolume()+this.getNumber();
	}
}
