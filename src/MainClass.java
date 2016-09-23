package main;

import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) {
		ReadXml readXml = new ReadXml();
		readXml.getXml();
		//SplitCSV split = new SplitCSV();
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.out.println("tio cut");
			}
		});
		 }
}
