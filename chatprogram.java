public class chatprogram {

	public static void main(String[] args) throws Exception {
		Thread t1=new Thread(new ServerChat());
		t1.start();
		t1.join();
	}

}
