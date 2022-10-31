
public class CRCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CRC test1= new CRC(100110);
		if(test1.crcASCIIString("az")==26)

			System.out.println("Test1 passed,the result is 26");
		else System.out.println("Test1 failed,the result is not 26");
	}

}
