package main;

public class Article extends Publication {
	private String school;
	private String note;
	
	
	
	public Article(){
		super();
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getNote() {
		return note;
	}

	public void setNoteString note) {
		this.note = note;
	}

	
	
	
	
	public String toString(){
		return this.getPubId()+this.getPubKey()+this.getTitle()+this.getYear()+this.getSchool()+this.getNote();
	}
}
