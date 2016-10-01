import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("start3");
		ReadXml readXml = new ReadXml();
		readXml.getXml();
		System.out.println("start!");
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.out.println("tio cut");
			}
		});
		System.out.println("finished!");
	}
	
}

