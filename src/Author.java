package main;

public class Author {
	private String authorName;
	private long authorID;
	public long getAuthorID() {
		return authorID;
	}

	public void setAuthorID(long authorID) {
		this.authorID = authorID;
	}

	public Author(){
		authorName = null;
	}
	
	public Author(String authorName){
		this.authorName = authorName;
	}
	public Author(long authorID,String authorName){
		this.authorID = authorID;
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
}
