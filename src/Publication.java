package main;

public class Publication {
	private long pubId;
	private String pubKey;
	private String title;
	private long year;

	public long getPubId() {
		return this.pubId;
	}

	public void setPubId(long pubId) {
		this.pubId = pubId;
	}

	public Publication(){}

	public String getPubKey() {
		return this.pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public String toString(){
		return this.pubId.toString()+ this.pubKey+this.title+this.year.toString();
	}

}
