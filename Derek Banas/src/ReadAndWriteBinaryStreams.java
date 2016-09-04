import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteBinaryStreams {

	public static void main(String[] args) throws FileNotFoundException {

		Customer[] customers = getCustomers();

		DataOutputStream custOutput = createFile("/C:/Users/Wojciech Figas/Desktop/customers.txt");

		for (Customer person : customers) {
			createCustomers(person, custOutput);

		}

		try {
			custOutput.close();
		} catch (IOException e) {
			System.exit(0);
		}
		
		getFileInfo();
	}
//d
	private static class Customer {
		public String name;
		public int age;
		public double debt;
		public boolean oweMoney;
		public char sex;

		public Customer(String name, int age, double debt, boolean oweMoney, char sex) {
			this.name = name;
			this.age = age;
			this.debt = debt;
			this.oweMoney = oweMoney;
			this.sex = sex;
		}

	}

	private static Customer[] getCustomers() {

		Customer[] customers = new Customer[5];

		customers[0] = new Customer("John", 21, 12.25, true, 'M');
		customers[1] = new Customer("John", 21, 12.25, true, 'M');
		customers[2] = new Customer("John", 21, 12.25, true, 'M');
		customers[3] = new Customer("John", 21, 12.25, true, 'M');
		customers[4] = new Customer("John", 21, 12.25, true, 'M');

		return customers;

	}

	private static DataOutputStream createFile(String fileName) {

		try {
			File listOfNames = new File(fileName);
			DataOutputStream infoToWrite = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(listOfNames)));
			return infoToWrite;
		} catch (IOException e) {
			System.out.println("Nie pyklo");
		}
		return null;

	}

	private static void createCustomers(Customer customer, DataOutputStream custOutput) {
		try {
			custOutput.writeUTF(customer.name);
			custOutput.writeInt(customer.age);
			custOutput.writeDouble(customer.debt);
			custOutput.writeBoolean(customer.oweMoney);
			custOutput.writeChar(customer.sex);

		} catch (IOException e) {
			System.out.println("Nie pyklo");
		}
	}
	
	private static void getFileInfo() throws FileNotFoundException{
		System.out.println("Info: ");
		
		File listOfNames = new File("myFile");
		
		boolean eof = false;
		
		try{
			DataInputStream getInfo = new DataInputStream(new BufferedInputStream(new FileInputStream(listOfNames)));
		}finally{
			
		}
	}

}
