import java.io.*;
import java.net.*;
import java.util.*;
public class ServerChat implements Runnable{

	public void run(){

		String sentenceIn="",sentenceOut="",line="";
		int port=8001;

		try {
			@SuppressWarnings("resource")
			ServerSocket welcomeSocket = new ServerSocket(port);
			System.out.println("server has started");
		

			while(true) {

				
					
					Socket connectionSocket=welcomeSocket.accept();
					System.out.println("connection is established");
					BufferedReader br=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
					while((line=br.readLine())!=null) {
						sentenceIn=line+"\n";
					}

					System.out.println("client has sent="+sentenceIn);

					Scanner sc=new Scanner(System.in);
					System.out.println("server chat :");
					sentenceOut=sc.next();

					OutputStreamWriter outFromServer=new OutputStreamWriter(connectionSocket.getOutputStream());
					outFromServer.write(sentenceOut);
					sc.close();
					connectionSocket.close();
				}

			}
		 catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
