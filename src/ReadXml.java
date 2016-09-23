package main;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXml extends DefaultHandler{
	private ArrayList<Author> AuthorList = new ArrayList<Author>();
	private Publication publication;
	private Author author;
	private Authored authored;
	private ArrayList<Authored> authoredList;
	private int pubId,authorID;
	private ArrayList<Author> authorList;
	private WriteToCSV writeToCSV;
public ArrayList<Authored> getXml(){
  try {
	  authoredList = new ArrayList<Authored>();
	  pubId = 0;
	  authorID = 0;
	  
	  // obtain and configure a SAX based parser
	  SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

	  // obtain object for SAX parser
	  SAXParser saxParser = saxParserFactory.newSAXParser();

	  // default handler for SAX handler class
	  // all three methods are written in handler's body
	  DefaultHandler defaultHandler = new DefaultHandler(){
    
	  //article
	  boolean articleTag = false;
	  boolean journalTag = false;
	  boolean pagesTag = false;
	  boolean volumeTag = false;
	 
	  
	  //author
	  boolean authorTag = false;
	  boolean nameTag = false;
	  boolean authorIdTag = false;
	  
	  //book
	  boolean bookTag = false;
	  boolean booktitleTag = false;
	  boolean publisherTag = false;
	  boolean seriesTag = false;
	  
	  //inproceedings
	  boolean inproceedingsTag = false;
	  boolean booktitleTag = false;
	  boolean pagesTag = false;
	  boolean crossRefTag = false;
	  
	  
	  //incollection
	  boolean incollectionTag = false;
	  boolean bookTitleTag = false;
	  boolean pagesTag = false;
	  boolean crossRefTag = false;
	  
	  
	  //publication
	  boolean yearTag = false;
	  boolean titleTag = false;
	  boolean pubKeyTag = false;
	  boolean pubIdTag = false;
	  
	  String elementTag = "";
	  
    // this method is called every time the parser gets an open tag '<'
    // identifies which tag is being open at time by assigning an open flag
    public void startElement(String uri, String localName, String qName,
      Attributes attributes) throws SAXException {
    	if(qName.compareToIgnoreCase("book") == 0){
    		bookTag = true;
    		authored = new Authored();
    		authorList = new ArrayList<Author>();
    		publication = new Book();
    		publication.setPubID(generatePublicationID());
    		publication.setPubKey(attributes.getValue("key"));
    	}
    	else if(qName.compareToIgnoreCase("article")==0){
    		articleTag = true;
    		authored = new Authored();
    		authorList = new ArrayList<Author>();
    		publication = new Article();
    		publication.setPubId(generatePublicationId());
    		publication.setPubKey(attributes.getValue("key"));
    	}
    	else if(qName.compareToIgnoreCase("inproceedings")==0){
    		inproceedingsTag = true;
    		authored = new Authored();
    		authorList = new ArrayList<Author>();
    		publication = new Inproceedings();
    		publication.setPubId(generatePublicationId());
    		publication.setPubKey(attributes.getValue("key"));
    	}
    	else if(qName.compareToIgnoreCase("incollection")==0){
    		authored = new Authored();
    		authorList = new ArrayList<Author>();
    		publication = new Incollection();
    		publication.setPubId(generatePublicationId());
    		publication.setPubKey(attributes.getValue("key"));
    		incollectionTag = true;
    	}
    	
    	elementTag = qName;
    	//System.out.println(qName);
    }

    public int generatePublicationId(){
    	return ++pubId;
    }
    public int generateAuthorID(){
    	return ++authorID;
    }
    // prints data stored in between '<' and '>' tags
    public void characters(char ch[], int start, int length) throws SAXException {
    	if(bookTag){
    		if(elementTag.compareToIgnoreCase("title")==0){
    			publication.setTitle(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("year")==0){
    			publication.setYear(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("author")==0){
    			author = new Author(new String(ch, start, length));
    			authorList.add(author);
    		}
    		else if(elementTag.compareToIgnoreCase("publisher")==0){
    			((Book)publication).setPublisher(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("series")==0){
    			((Book)publication).setISBN(new String(ch, start, length));
    		}
			else if(elementTag.compareToIgnoreCase("booktitle")==0){
    			((Book)publication).setISBN(new String(ch, start, length));
    		}
    	}
    	else if(articleTag){
    		if(elementTag.compareToIgnoreCase("title")==0){
    			publication.setTitle(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("year")==0){
    			publication.setYear(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("author")==0){
    			author = new Author(new String(ch, start, length));
    			authorList.add(author);
    		}
    		else if(elementTag.compareToIgnoreCase("journal")==0){
    			((Article)publication).setJournal(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("pages")==0){
    			((Article)publication).setPages(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("volume")==0){
    			((Article)publication).setVolume(new String(ch, start, length));
    		}
    		
    		
    	}
    	else if(inproceedingsTag){
    		if(elementTag.compareToIgnoreCase("title")==0){
    			publication.setTitle(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("year")==0){
    			publication.setYear(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("author")==0){
    			author = new Author(new String(ch, start, length));
    			authorList.add(author);
    		}
    		else if(elementTag.compareToIgnoreCase("booktitle")==0){
    			((Inproceedings)publication).setBookTitle(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("pages")==0){
    			((Inproceedings)publication).setPages(new String(ch, start, length));
    		}
			else if(elementTag.compareToIgnoreCase("crossref")==0){
    			((Inproceedings)publication).setCrossRef(new String(ch, start, length));
    		}
    	}
    	else if(incollectionTag){
    		if(elementTag.compareToIgnoreCase("title")==0){
    			publication.setTitle(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("year")==0){
    			publication.setYear(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("author")==0){
    			author = new Author(new String(ch, start, length));
    			authorList.add(author);
    		}
    		else if(elementTag.compareToIgnoreCase("booktitle")==0){
    			((Incollection)publication).setBookTitle(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("pages")==0){
    			((Incollection)publication).setPublisher(new String(ch, start, length));
    		}
    		else if(elementTag.compareToIgnoreCase("booktitle")==0){
    			((Incollection)publication).setISBN(new String(ch, start, length));
    		}
    	}
    }

    // calls by the parser whenever '>' end tag is found in xml 
    // makes tags flag to 'close'
    public void endElement(String uri, String localName, String qName)
      throws SAXException {
    	if(qName.compareToIgnoreCase("book") == 0){
    		bookTag = false;
    		authored.setAuthorList(authorList);
    		authored.setPublication(publication);
    		authoredList.add(authored);
    	}
    	else if(qName.compareToIgnoreCase("article")==0){
    		articleTag = false;
    		authored.setAuthorList(authorList);
    		authored.setPublication(publication);
    		authoredList.add(authored);
    	}
    	else if(qName.compareToIgnoreCase("inproceedings")==0){
    		inproceedingsTag = false;
    		authored.setAuthorList(authorList);
    		authored.setPublication(publication);
    		authoredList.add(authored);
    	}
    	else if(qName.compareToIgnoreCase("incollection")==0){
    		incollectionTag = false;
    		authored.setAuthorList(authorList);
    		authored.setPublication(publication);
    		authoredList.add(authored);
    	}
    }
    
    public void endDocument() throws SAXException{
    	System.out.println("AuthoredList size: "+authoredList.size());
    	writeToCSV = new WriteToCSV(authoredList);
//    	writeToCSV.writeToPublication();
//    	writeToCSV.writeToArticle();
//    	writeToCSV.writeToBook();
//    	writeToCSV.writeToIncollection();
//    	writeToCSV.writeToInproceedings();
    	writeToCSV.writeToAuthor();
    	writeToCSV.writeToAuthored();
    }
   };
   saxParser.parse("xmlToRead/dblp.xml", defaultHandler);
  } catch (Exception e) {
   e.printStackTrace();
  }
  return authoredList;
 }
}

