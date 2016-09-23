

public class Author {
	private String name;
	private long authorId;
	public long getAuthorID() {
		return this.authorId;
	}

	public void setAuthorID(long authorID) {
		this.authorId = authorID;
	}

	public Author(){
		name = null;
	}
	
	public Author(String name){
		this.name = name;
	}
	public Author(long authorID,String name){
		this.authorId = authorID;
		this.name = name;
	}

	public String getAuthorName() {
		return this.name;
	}

	public void setAuthorName(String name) {
		this.name = name;
	}
	
}
