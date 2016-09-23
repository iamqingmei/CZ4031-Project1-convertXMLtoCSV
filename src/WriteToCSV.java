package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class WriteToCSV {
	private ArrayList<Authored> authoredList;
	private long authorID;
	private long pubID;
	private File file;
	private FileWriter fileWriter;
	private ArrayList<Author> authorList = new ArrayList<Author>();
	private Hashtable[] authorTable = new Hashtable[53];
	private final String authorPath = "Author";
	private final String articlePath = "Article";
	private final String bookPath = "Book";
	private final String incollectionPath = "Incollection";
	private final String inproceedingsPath = "Inproceedings";
	private final String publicationPath = "Publication";
	private final String authoredPath = "Authored";
	
	public WriteToCSV(ArrayList<Authored> authoredList){
		this.authoredList = authoredList;
		setPubID();
	}
	
	public long getAuthorID(){
		return ++authorID;
	}
	public long getPubID(){
		return ++pubID;
	}
	
	public void getFile(String path){
		path = "CSV/"+path;
		path += ".csv";
		file = new File(path);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Cannot create file :"+path);
			}
		}
		try {
			fileWriter = new FileWriter(file,true);
		} catch (IOException e) {
			System.out.println("FileWriter error :"+path);
		}
	}
	public void setPubID(){
		int i;
		for(i=0;i<this.authoredList.size();i++){
			authoredList.get(i).getPublication().setPubID(getPubID());
		}
		System.out.println("set pub ID done:"+i);
	}
	
	private String isNULL(String value){
		if(value == null){
			return "";
		}
		else{
			return value;
		}
	}
	private void cleanUP(String message){
		try {
			fileWriter.flush();
			fileWriter.close();
			System.gc();
			System.out.println(message);
		} catch (IOException e1) {}
	}
	private String hasComma(String string){
		if(string == null){
			return "";
		}
		else{
		if (string.contains(",")){
			return string.replaceAll(",", "~");
		}
		return string;
		}
	}
	public void writeToPublication(){
		Publication publication;
		getFile(publicationPath);//open publication file
		for(int i=0;i<this.authoredList.size();i++){
			publication = this.authoredList.get(i).getPublication();
				try {
					fileWriter.append(publication.getPubID()+",");
					fileWriter.append(hasComma(publication.getPubKey())+",");
					fileWriter.append(hasComma(publication.getTitle())+",");
					fileWriter.append(hasComma(publication.getYear()));
					fileWriter.append("\r\n");
				} catch (IOException e) {
					System.out.println("Error at publication:"+e+","+publication.getPubID());
					System.exit(0);
				}
		}
		cleanUP("publication done");
	}
	
	public void writeToBook(){
		Publication publication;
		getFile(bookPath);//open book file
		for(int i=0;i<this.authoredList.size();i++){
			publication = this.authoredList.get(i).getPublication();
			if(publication instanceof Book){
				try {
					fileWriter.append(publication.getPubID()+",");
					fileWriter.append(hasComma(((Book) publication).getPublisher())+",");
					fileWriter.append(hasComma(((Book) publication).getISBN()));
					fileWriter.append("\r\n");
				} catch (IOException e) {
					System.out.println("Error at book:"+e+","+publication.getPubID());
					System.exit(0);
				}
		}
		}
		cleanUP("book done");
	}
	public void writeToArticle(){
		Publication publication;
		getFile(articlePath);//open article file
		for(int i=0;i<this.authoredList.size();i++){
			publication = this.authoredList.get(i).getPublication();
			if(publication instanceof Article){
				try {
					fileWriter.append(publication.getPubID()+",");
					fileWriter.append(hasComma(((Article) publication).getJournal())+",");
					fileWriter.append(hasComma(((Article) publication).getMonth())+",");
					fileWriter.append(hasComma(((Article) publication).getVolume())+",");
					fileWriter.append(hasComma(((Article) publication).getNumber()));
					fileWriter.append("\r\n");
				} catch (IOException e) {
					System.out.println("Error at article:"+e+","+publication.getPubID());
					System.exit(0);
				}
		}
		}
		cleanUP("article done");
	}
	
	public void writeToIncollection(){
		Publication publication;
		getFile(incollectionPath);//open incollection file
		for(int i=0;i<this.authoredList.size();i++){
			publication = this.authoredList.get(i).getPublication();
			if(publication instanceof Incollection){
				try {
					fileWriter.append(publication.getPubID()+",");
					fileWriter.append(hasComma(((Incollection) publication).getBookTitle())+",");
					fileWriter.append(hasComma(((Incollection) publication).getPages())+",");
					fileWriter.append(hasComma(((Incollection) publication).getcrossRef()));
					fileWriter.append("\r\n");
				} catch (IOException e) {
					System.out.println("Error at incollection:"+e+","+publication.getPubID());
					System.exit(0);
				}
		}
		}
		cleanUP("incollection done");
	}
	
	public void writeToInproceedings(){
		Publication publication;
		getFile(inproceedingsPath);//open inproceedings file
		for(int i=0;i<this.authoredList.size();i++){
			publication = this.authoredList.get(i).getPublication();
			if(publication instanceof Inproceedings){
				try {
					fileWriter.append(publication.getPubID()+",");
					fileWriter.append(hasComma(((Inproceedings) publication).getBookTitle())+",");
					fileWriter.append(hasComma(((Inproceedings) publication).getEditor()));
					fileWriter.append("\r\n");
				} catch (IOException e) {
					System.out.println("Error at Inproceedings:"+e+","+publication.getPubID());
					System.exit(0);
				}
		}
		}
		cleanUP("Inproceedings done");
	}
	public void writeToAuthor(){
		//HashSet hs = new HashSet();
		
		ArrayList<Author> authorList;
		HashSet<String> set;
		ArrayList<String> authorStringArray = new ArrayList<String>();
		Author author;
		
		//put all author name into authorStringArray
		
		for(int i=0;i<this.authoredList.size();i++){
			authorList = this.authoredList.get(i).getAuthorList();
			for(int j=0;j<authorList.size();j++){
				author = authorList.get(j);
				authorStringArray.add(author.getAuthorName());
			}
		}
		set = new HashSet<String>(authorStringArray);
		authorStringArray = new ArrayList<String>(set);

//		//write into authorList
		for(int i=0;i<authorStringArray.size();i++){
			author = new Author(getAuthorID(),authorStringArray.get(i));
			this.authorList.add(author);
		}
//		authorStringArray = null;
//		authorList = null;
//		//write into author file
//		getFile(authorPath);//open author file
//		for(int i=0;i<this.authorList.size();i++){
//			author = this.authorList.get(i);
//			try {
//				fileWriter.append(author.getAuthorID()+",");
//				fileWriter.append(hasComma(author.getAuthorName()));
//				fileWriter.append("\r\n");
//			} catch (IOException e) {
//				System.out.println("Error at author:"+e+","+author.getAuthorID());
//				System.exit(0);
//			}
//		}
//		cleanUP("author done");
	}
	
	public void writeToAuthored(){
		Author author;
		Authored authored;
		Publication publication;
		HashSet set;
		ArrayList<Author> authorList;
		ArrayList<String> authoredString = new ArrayList<String>();
		long authorID;
		//initalise hashtable
		for(int i=0;i<authorTable.length;i++){
			authorTable[i] = new Hashtable();
		}
		//put author into respective hashtable
		for(int i=0;i<this.authorList.size();i++){
			author = this.authorList.get(i);
			splitHash(author);
		}
		getFile(authoredPath);
		for(int i=0;i<authoredList.size();i++){
			authored = authoredList.get(i);
			publication = authored.getPublication();
			authorList = authored.getAuthorList();
			for(int j=0;j<authorList.size();j++){
				author = authorList.get(j);
				authorID = getHash(author);
				if(authorID > 0){
					authoredString.add(authorID+","+publication.getPubID());
				}
			}
		}
		set = new HashSet<String>(authoredString);
		authoredString = new ArrayList<String>(set);
		set = new HashSet<String>(authoredString);
		authoredString = new ArrayList<String>(set);
		for(int i=0;i<authoredString.size();i++){
			try{
				fileWriter.append(authoredString.get(i));
				fileWriter.append("\r\n");
			}
			catch(Exception e){
				System.out.println("authored error:"+e);
			}
		}
		cleanUP("authored done");
	}
	
	//split author based on the first character of the name
		public int split(String authorName){
			char a = authorName.charAt(0);
			int b = (int)a-64;
			if(b<0 || b>58){
				return 0;
			}
			else if(b>26 && b<33){
				return 0;
			}
			else if(b>=33){
				return b-6;
			}
			else{
				return b;
			}
		}
		
		//insert into hash table
		@SuppressWarnings("unchecked")
		public void splitHash(Author author){
			int value = split(author.getAuthorName());
			authorTable[value].put(author.getAuthorName(), author.getAuthorID());
		}
		
		//get from hash table
		public long getHash(Author author){
			long authorID=0;
			int value = split(author.getAuthorName());
			try{
				authorID = ((long)authorTable[value].get(author.getAuthorName()));
			}catch(Exception e){
				return 0;
			}
			return authorID;
		}
}
