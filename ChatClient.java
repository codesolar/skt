import java.io.*;
import java.net.*;
import java.util.*;
public class ChatClient{
	
public static void main(String[] args) {
	
			
			String sentenceIn="",sentenceOut="",line="";
			String server_ip="localhost";
			int port=8001;
			try {
			@SuppressWarnings("resource")
			Socket clientSocket=new Socket(server_ip,port);
			
			while(true) {
			try{
			
			Scanner sc=new Scanner(System.in);
			System.out.println("client chat:");
			sentenceOut=sc.next(); 
			
			OutputStreamWriter outFromClient=new OutputStreamWriter(clientSocket.getOutputStream());
			outFromClient.write(sentenceOut);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while((line=br.readLine())!=null) {
				sentenceIn=line+"\n";
			}
			
			System.out.println("server has sent="+sentenceIn);
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


