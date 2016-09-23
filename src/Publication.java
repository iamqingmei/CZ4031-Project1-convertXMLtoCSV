package main;

public class Publication {
	private String pubKey;
	private String title;
	private String year;
	private long pubID;
	public long getPubID() {
		return pubID;
	}

	public void setPubID(long pubID) {
		this.pubID = pubID;
	}

	public Publication(){}

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String toString(){
		return this.pubKey+this.title+this.pubID+this.year;
	}

}
