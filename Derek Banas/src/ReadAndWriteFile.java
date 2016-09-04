import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadAndWriteFile {
	
	public static void main(String[] args) {
		
		Customer[] customers = getCustomers();
		
		PrintWriter custOutput = createFile("/C:/Users/Wojciech Figas/Desktop/customers.txt");
		
		
		for(Customer person: customers){
			createCustomers(person, custOutput);
			
		}
		
		custOutput.close();
		
		getFileInfo();
		
		
	}

	private static class Customer{
		
		public String firstName, lastName;
		public int custAge;
		
		public Customer(String firstName, String lastName, int custAge){
			this.firstName=firstName;
			this.lastName=lastName;
			this.custAge=custAge;
			
		}
		
		
	}
	
	private static Customer[] getCustomers(){
		
		Customer[] customers = new Customer[5];
		customers[0]= new Customer("John","Smith", 21);
		customers[1]= new Customer("Sally","Smith", 23);
		customers[2]= new Customer("Paul","Smith", 21);
		customers[3]= new Customer("Tom","Smith", 21);
		customers[4]= new Customer("Mark","Smith", 21);
		
		return customers;
		
	}
	
	private static PrintWriter createFile(String fileName){
		
		try{
			File listOfNames = new File(fileName);
			PrintWriter infoToWrite = new PrintWriter( new BufferedWriter(new FileWriter(listOfNames)));
			return infoToWrite;

		}
		catch(IOException e){
			System.out.println("Shit");
		}
		return null;
		
	}
	
	private static void createCustomers(Customer customer, PrintWriter print){
		String custInfo = customer.firstName + " " + customer.lastName;
		
		custInfo += Integer.toString(customer.custAge);
		print.println(custInfo);
	}
	
	private static void getFileInfo(){
		System.out.println("Info to file \n");
		
		File listOfNames = new File("/C:/Users/Wojciech Figas/Desktop/customers.txt");
		
		try{
			BufferedReader br = new BufferedReader( new FileReader(listOfNames));
			
			String custInfo = br.readLine();
			
			while(custInfo != null){
				System.out.println(custInfo);
				custInfo=br.readLine();
			}
			
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("IO exception");
			System.exit(0);
		}
	}
	
}
