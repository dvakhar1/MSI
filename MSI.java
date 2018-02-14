mport java.awt.font.ShapeGraphicAttribute;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class differentway {
	static int c1 =1;
	static int c2 = 2;
	static int c3 = 3;
	static int c4 = 4;
	static String proc;
	static int Pvar;
	static int Pvalue;
	static int Pvar11;
	static int Pvalue11;
	static int Change;
	
	//Declaring the Processors..
	
	static ArrayList<Integer> p1 = new ArrayList<Integer>();
	static ArrayList<Integer> p2 = new ArrayList<Integer>();
	static ArrayList<Integer> p3 = new ArrayList<Integer>();
	static ArrayList<Integer> p4 = new ArrayList<Integer>();
	static ArrayList<Integer> SharedMemory1 = new ArrayList<Integer>();
	static ArrayList<Integer> MainMemory = new ArrayList<Integer>();

	//ModifiedMemory
	ArrayList<Integer> ModifiedMemory = new ArrayList<Integer>();
	
	static String read;
	static String write;
	
	
public static void main(String [] args)
{
	p1.add(4);
	p1.add(1);
	p1.add(2);
	p1.add(3);
	p1.add(4);
	
	p2.add(1);
	p2.add(11);
	p2.add(12);
	p2.add(13);
	p2.add(14);
	
	p3.add(4);
	p3.add(21);
	p3.add(22);
	p3.add(23);
	p3.add(24);
	
	p4.add(2);
	p4.add(31);
	p4.add(32);
	p4.add(33);
	p4.add(34);
	
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	SharedMemory1.add(0);
	
	for(int i = 0; i <=100; i++)
	{
		MainMemory.add(i);
	}
	
	
	
	init();
	
	
}
public static void init()
{
	Scanner scan = new Scanner(System.in);
	while(true)
	{
		if(p1.get(0)==1)
		{
			System.out.println("P1 in the Invalid Stage"+p1);
		}
		if(p1.get(0)==2)
		{
			System.out.println("P1 in the Modified Stage"+p1);
		}
		if(p1.get(0)==4)
		{
			System.out.println("P1 in the Shared Stage"+p1);
		}
		if(p2.get(0)==1)
		{
			System.out.println("P2 in the Invalid Stage"+p2);
		}
		if(p2.get(0)==2)
		{
			System.out.println("P2 in the Modified Stage"+p2);
		}
		if(p2.get(0)==4)
		{
			System.out.println("P2 in the Shared Stage"+p2);
		}
		if(p3.get(0)==1)
		{
			System.out.println("P3 in the Invalid Stage"+p3);
		}
		if(p3.get(0)==2)
		{
			System.out.println("P3 in the Modified Stage"+p3);
		}
		if(p3.get(0)==4)
		{
			System.out.println("P3 in the Shared Stage"+p3);
		}
		if(p4.get(0)==1)
		{
			System.out.println("P4 in the Invalid Stage"+p4);
		}
		
		if(p4.get(0)==2)
		{
			System.out.println("P4 in the Modified Stage"+p4);
		}
		
		
		if(p4.get(0)==4)
		{
			System.out.println("P4 in the Shared Stage"+p4);
		}
		
		
	System.out.println("Do you want to perform Read or Write");
	read=scan.next();
	System.out.println(read);
	if(read.equalsIgnoreCase("r"))
	{
		System.out.println("Enter the processor between(1-4)");
		proc=scan.next();
		System.out.println("Please enter the memory location(1-4)");
		int loc = scan.nextInt();
		System.out.println("Please enter the value on that location");
		int loc_value = scan.nextInt();

		if(proc.equals("1"))
		{
		    Read(p1,loc,loc_value);
		}
		
		if(proc.equals("2"))
		{
		    Read(p2,loc,loc_value);
		}
		
		if(proc.equals("3"))
		{
		    Read(p3,loc,loc_value);
		}
		
		if(proc.equals("4"))
		{
		    Read(p4,loc,loc_value);
		}
	}
	else if(read.equalsIgnoreCase("w"))
	{
		System.out.println("Enter the processor");
		proc=scan.next();
		System.out.println("Please enter the memory location");
		int loc = scan.nextInt();
		System.out.println("Please enter the value on that location");
		int loc_value = scan.nextInt();
		if(proc.equals("1"))
		{
		    write(p1,loc,loc_value);
		}
		
		if(proc.equals("2"))
		{
		    write(p2,loc,loc_value);
		}
		
		if(proc.equals("3"))
		{
		    write(p3,loc,loc_value);
		}
		
		if(proc.equals("4"))
		{
		    write(p4,loc,loc_value);
		}
	}
	else
	{
		System.out.println("Please enter the value for R or W");
	}
	}
}
public static void Read(ArrayList Processor, int Pvar1, int Pvalue1)
{
	Pvar=Pvar1;
	Pvalue=Pvalue1;
	//System.out.println(Processor+","+Pvar+","+Pvalue);
	if(proc.equals("1"))
	{
		if(p1.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();//Calling Invalidation from Read..
			
		}
		if(p1.get(0)==2)
		{
			Modified();
		}
		if(p1.get(0)==4)
		{
			SharedMemory();
		}
	}
	if(proc.equals("2"))
	{
		if(p2.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();
		}
		if(p2.get(0)==2)
		{
			Modified();
		}
		if(p2.get(0)==4)
		{
			SharedMemory();
		}
	}
	if(proc.equals("3"))
	{
		if(p3.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();
		}
		if(p3.get(0)==2)
		{
			Modified();
		}
		if(p3.get(0)==4)
		{
			SharedMemory();
		}
	}
	if(proc.equals("4"))
	{
		if(p4.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();
		}
		if(p4.get(0)==2)
		{
			Modified();
		}
		if(p4.get(0)==4)
		{
			SharedMemory();
		}
	}
}

public static void Invalid()
{
	if(proc.equals("1"))
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Do yo want to read/write this is from Invalid Stage..");
		String ask = scan.next();
		if(ask.equalsIgnoreCase("r"))
		{
			System.out.println("We have to move to the Modified State from Invalid Stage..");
			p1.set(0,2);
			Modified();
		}
		if(ask.equalsIgnoreCase("w"))
		{
			System.out.println("We have to move to the Modified State from Invalid Stage..");
			p1.set(0,2);
			System.out.println("Please enter the memory location this is part of Invalid Stage..");
			int loc = scan.nextInt();
			System.out.println("Please enter the value on that location this is part of Invalid Stage..");
			int loc_value = scan.nextInt();
			write(p1, loc, loc_value);
		}
		
	}
	
	if(proc.equals("2"))
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Do yo want to read/write");
		String ask = scan.next();
		if(ask.equalsIgnoreCase("r"))
		{
			System.out.println("We have to move to the Modified State I");
			p2.set(0,2);
			Modified();
		}
		if(ask.equalsIgnoreCase("w"))
		{
			System.out.println("We have to move to the Modified State I");
			p2.set(0,2);
			System.out.println("Please enter the memory location I");
			int loc = scan.nextInt();
			System.out.println("Please enter the value on that location I");
			int loc_value = scan.nextInt();
			write(p2, loc, loc_value);
		}
		
	}
}
//Modified..
public static void Modified()
{
	Scanner scan1=new Scanner(System.in);
	if(proc.equals("1"))
	{
		System.out.println("This is local Read M");
		
		if(p1.get(Pvar)==Pvalue)
		{
			System.out.println("You can read M");
			System.out.println("P1 Modified State"+p1);
			System.out.println("Do you want to read/write M");
			String ask=scan1.next();
			if(ask.equalsIgnoreCase("r"))
			{
				System.out.println("Confirm");
				String ask1=scan1.next();
				if(ask1.equalsIgnoreCase("y"))
				{
					System.out.println("Modified");
					init();
					//main(null);
					//Read(p1,Pvar,Pvalue);
				}
				if(ask1.equalsIgnoreCase("n"))
				{
					System.out.println("Shared M");
					SharedMemory();
				}
			}
			if(ask.equalsIgnoreCase("w"))
			{
				p1.set(0, 2);
				write(p1,Pvar,Pvalue);
			}
			System.out.println("Moving this value to the shared memory M");
			SharedMemory();
		}
		else
		{
			System.out.println("It is a read miss M");
			System.out.println("From here it will go to Read Miss");
			Read_Miss();
		}
	}
	if(proc.equals("2"))
	{
		System.out.println("This is local Read");
		
		if(p2.get(Pvar)==Pvalue)
		{
			System.out.println("You can read");
			//p2.set(0, 4);
			System.out.println("P2 Modified State"+p2);
			System.out.println("Do you want to read/write");
			String ask=scan1.next();
			if(ask.equalsIgnoreCase("r"))
			{
				System.out.println("Confirm");
				String ask1=scan1.next();
				if(ask1.equalsIgnoreCase("y"))
				{
					System.out.println("Modified");
					init();
					//main(null);
					//Read(p1,Pvar,Pvalue);
				}
				if(ask1.equalsIgnoreCase("n"))
				{
					System.out.println("Shared");
					SharedMemory();
				}
			}
			if(ask.equalsIgnoreCase("w"))
			{
				p2.set(0, 2);
				write(p2,Pvar,Pvalue);
			}
			System.out.println("Moving this value to the shared memory");
			SharedMemory();
		}
		else
		{
			System.out.println("It is a read miss");
			System.out.println("From here it will go to Read Miss");
			Read_Miss();
		}
	}
	if(proc.equals("3"))
	{
		System.out.println("This is local Read");
		
		if(p3.get(Pvar)==Pvalue)
		{
			System.out.println("You can read");
			//p3.set(0, 4);
			System.out.println("P3 Modified State"+p3);
			System.out.println("Do you want to read/write");
			String ask=scan1.next();
			if(ask.equalsIgnoreCase("r"))
			{
				System.out.println("Confirm");
				String ask1=scan1.next();
				if(ask1.equalsIgnoreCase("y"))
				{
					System.out.println("Modified");
					init();
					//main(null);
					//Read(p1,Pvar,Pvalue);
				}
				if(ask1.equalsIgnoreCase("n"))
				{
					System.out.println("Shared");
					SharedMemory();
				}
			}
			if(ask.equalsIgnoreCase("w"))
			{
				p3.set(0, 2);
				write(p3,Pvar,Pvalue);
			}
			System.out.println("Moving this value to the shared memory");
			SharedMemory();
		}
		else
		{
			System.out.println("It is a read miss");
			System.out.println("From here it will go to Read Miss");
			Read_Miss();
		}
	}
	if(proc.equals("4"))
	{
		System.out.println("This is local Read");
		
		if(p4.get(Pvar)==Pvalue)
		{
			System.out.println("You can read");
			//p4.set(0, 4);
			System.out.println("P4 Modified State"+p4);
			System.out.println("Do you want to read/write more");
			String ask=scan1.next();
			if(ask.equalsIgnoreCase("r"))
			{
				System.out.println("Confirm");
				String ask1=scan1.next();
				if(ask1.equalsIgnoreCase("y"))
				{
					System.out.println("Modified");
					init();
					//main(null);
					//Read(p1,Pvar,Pvalue);
				}
				if(ask1.equalsIgnoreCase("n"))
				{
					System.out.println("Shared");
					SharedMemory();
				}
			}
			if(ask.equalsIgnoreCase("w"))
			{
				p4.set(0, 2);
				write(p4,Pvar,Pvalue);
			}
			System.out.println("Moving this value to the shared memory");
			SharedMemory();
		}
		else
		{
			System.out.println("It is a read miss");
			System.out.println("From here it will go to Read Miss Day");
			Read_Miss();
		}
	}
}
//Shared Memory..
public static void SharedMemory()
{
	if(proc.equals("1"))	
	{
		System.out.println("You are inside 1st IF");
		if(p1.get(Pvar)==Pvalue)
		{
			System.out.println("You are inside 2nd IF");
		p1.set(0, 4);
		System.out.println("This is the Shared Memory State");
		
		System.out.println("Everyone can read from this processor"+p1);
		}
		else
		{
			System.out.println("Request Not Matched1");
			p1.set(0, 2);//Moving back to the modified state for the local read and the write..
			Read_Miss();
		}
	}
	
	if(proc.equals("2")) 
	{
		if(p2.get(Pvar)==Pvalue)
		{
		p2.set(0, 4);
		System.out.println("P2"+p2);
	    }
		else
		{
			System.out.println("Request Not Matched2");
			p2.set(0, 2);
			Read_Miss();
		}
	}
	
	if(proc.equals("3"))
	{
		if(p3.get(Pvar)==Pvalue)
		{		
			System.out.println("P3"+p3);
		}
		else
		{
			System.out.println("Request Not Matched3");
			p3.set(0, 2);
			Read_Miss();
		}
	}
	
	if(proc.equals("4"))
	{
		if(p4.get(Pvar)==Pvalue)
		{
			System.out.println("P4"+p4);
		}
		else
		{
			System.out.println("Request Not Matched4");
			p4.set(0, 2);
			Read_Miss();
		}
	}
	
}
public static void Read_Miss()//If there is a read miss in the modified state..
{
	//Searching the Processors before searching the Memory..
	if(proc.equals("1"))
	{
		System.out.println("The old value of P1"+p1);
		System.out.println(Pvalue);
		System.out.println(Pvar);
		for(int i = 1; i < 5; i++)
		{
			System.out.println();
			if(p2.get(i)==Pvalue && p2.get(0)!=1)
			{
				System.out.println("p2 Contains the value");
				System.out.println("Writing from the memory..");
				System.out.println("Updating the value of p1");
				p1.set(Pvar, p2.get(i));
				System.out.println("The new value of p1"+p1);
			}
			else if(p3.get(i)==Pvalue && p3.get(0)!=1)
			{
				System.out.println("p3 Contains the value");
				System.out.println("Writing from the memory..");
				p1.set(Pvar, p3.get(i));
			}
			else if(p4.get(i)==Pvalue && p4.get(0)!=1)
			{
				System.out.println("p4 Contains the value");
				System.out.println("Writing from the memory..");
				p1.set(Pvar, p4.get(i));
			}
			else
			{
				for(int j=0;j<=100;j++)
				{
					if(MainMemory.get(j)==Pvalue)
					{
						p1.set(Pvar, MainMemory.get(j));
						System.out.println("Done writing from Memory"+p1);
					}
					
				}
			}
		}	
	}
	if(proc.equals("2"))
	{
		for(int i = 1; i <= 4; i++)
		{
			if(p1.get(i)==Pvalue)
			{
				System.out.println("p1 Contains the value");
				System.out.println("Writing from the memory..");
				p2.set(Pvar, p1.get(i));
			}
			else if(p3.get(i)==Pvalue && p3.get(0)!=1)
			{
				System.out.println("p3 Contains the value");
				System.out.println("Writing from the memory..");
				p2.set(Pvar, p3.get(i));
			}
			else if(p4.get(i)==Pvalue && p4.get(0)!=1)
			{
				System.out.println("p4 Contains the value");
				System.out.println("Writing from the memory..");
				p2.set(Pvar, p4.get(i));
			}
			else
			{
				for(int j=0;j<=100;j++)
				{
					if(MainMemory.get(j)==Pvalue)
					{
						p2.set(Pvar, MainMemory.get(j));
						System.out.println("Done writing from Memory"+p2);
					}
					
				}
			}
		}	
	}
	if(proc.equals("3"))
	{
		for(int i = 1; i <= 4; i++)
		{
			if(p1.get(i)==Pvalue)
			{
				System.out.println("p1 Contains the value");
				System.out.println("Writing from the memory..");
				p3.set(Pvar, p1.get(i));
			}
			else if(p2.get(i)==Pvalue && p2.get(0)!=1)
			{
				System.out.println("p2 Contains the value");
				System.out.println("Writing from the memory..");
				p3.set(Pvar, p2.get(i));
			}
			else if(p4.get(i)==Pvalue && p4.get(0)!=1)
			{
				System.out.println("p4 Contains the value");
				System.out.println("Writing from the memory..");
				p3.set(Pvar, p4.get(i));
			}
			else
			{
				for(int j=0;j<=100;j++)
				{
					if(MainMemory.get(j)==Pvalue)
					{
						p3.set(Pvar, MainMemory.get(j));
						System.out.println("Done writing from Memory"+p3);
					}
					
				}
			}
		}	
	}
	if(proc.equals("4"))
	{
		for(int i = 1; i <= 4; i++)
		{
			if(p1.get(i)==Pvalue)
			{
				System.out.println("p1 Contains the value");
				System.out.println("Writing from the memory..");
				p4.set(Pvar, p1.get(i));
			}
			
			else if(p2.get(i)==Pvalue && p2.get(0)!=1)
			{
				System.out.println("p2 Contains the value");
				System.out.println("Writing from the memory..");
				p4.set(Pvar, p2.get(i));
			}
			else if(p3.get(i)==Pvalue && p3.get(0)!=1)
			{
				System.out.println("p3 Contains the value");
				System.out.println("Writing from the memory..");
				p4.set(Pvar, p3.get(i));
			}
			else
			{
				for(int j=0;j<=100;j++)
				{
					if(MainMemory.get(j)==Pvalue)
					{
						p1.set(Pvar, MainMemory.get(j));
						System.out.println("Done writing from Memory"+p1);
					}
					
				}
			}
		}	
	}
}

public static void write(ArrayList Processor, int Pvar1, int Pvalue1)
{
	Pvar11=Pvar1;
	Change=Pvalue1;//Change Value
	Pvalue11=(int) Processor.get(Pvar11);
	System.out.println("Pvalue"+Pvalue11);
	if(proc.equals("1"))
	{
	
		if(p1.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();
			
		}
		if(p1.get(0)==2)
		{
			ModifiedWrite();
		}
		if(p1.get(0)==4)
		{
			SharedMemoryWrite();
		}
	}
	if(proc.equals("2"))
	{
		if(p2.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();
		}
		if(p2.get(0)==2)
		{
			ModifiedWrite();
		}
		if(p2.get(0)==4)
		{
			SharedMemoryWrite();
		}
	}
	if(proc.equals("3"))
	{
		if(p3.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			Invalid();
		}
		if(p3.get(0)==2)
		{
			ModifiedWrite();
		}
		if(p3.get(0)==4)
		{
			SharedMemoryWrite();
		}
	}
	if(proc.equals("4"))
	{
		if(p4.get(0)==1)
		{
			System.out.println("This is an Invalidation stage");
			
		}
		if(p4.get(0)==2)
		{
			ModifiedWrite();
		}
		if(p4.get(0)==4)
		{
			SharedMemoryWrite();
		}
	}
}

public static void ModifiedWrite()
{
	System.out.println("This is Local Write..");
	Scanner scan = new Scanner(System.in);
	if(proc.equals("1"))
	{
		p1.set(Pvar11, Change);
		System.out.println("Do you want to Read/Write");
		String ask = scan.next();
		if(ask.equalsIgnoreCase("w"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			write(p1,mw,w1c1);
		}
		if(ask.equalsIgnoreCase("r"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			Read(p1,mw,w1c1);
		}
	}
	
	if(proc.equals("2"))
	{
		p2.set(Pvar11, Change);
		System.out.println("Do you want to Read/Write");
		String ask = scan.next();
		if(ask.equalsIgnoreCase("w"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			write(p2,mw,w1c1);
		}
		if(ask.equalsIgnoreCase("r"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			Read(p2,mw,w1c1);
		}
	}
	
	if(proc.equals("3"))
	{
		p3.set(Pvar11, Change);
		System.out.println("Do you want to Read/Write");
		String ask = scan.next();
		if(ask.equalsIgnoreCase("w"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			write(p3,mw,w1c1);
		}
		if(ask.equalsIgnoreCase("r"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			Read(p3,mw,w1c1);
		}
	}
	
	if(proc.equals("4"))
	{
		p4.set(Pvar11, Change);
		System.out.println("Do you want to Read/Write");
		String ask = scan.next();
		if(ask.equalsIgnoreCase("w"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			write(p4,mw,w1c1);
		}
		if(ask.equalsIgnoreCase("r"))
		{
			System.out.println("Enter the Location");
			int mw=scan.nextInt();
			System.out.println("Enter the value you want to write");
			int  w1c1 = scan.nextInt();
			Read(p4,mw,w1c1);
		}
	}
}

public static void SharedMemoryWrite()
{
	Scanner scan = new Scanner(System.in);
	System.out.println("This is Local Write..");
	if(proc.equals("1"))
	{
		if(p1.get(Pvar11)==Change)
		{
			System.out.println("Done and Changing State To Modified");
			p1.set(0, 2);
		}	
		else
		{
			p1.set(0, 2);
			p1.set(Pvar11, Change);
			for(int i=0;i<=4;i++)
			{
				if(p2.get(i)==Pvalue11 && p2.get(0)!=1)
				{
					p2.set(p2.get(i), Change);
					p2.set(0, 2);
				}
				if(p3.get(i)==Pvalue11 && p3.get(0)!=1)
				{
					p3.set(p3.get(i), Change);
					p3.set(0, 2);
				}
				if(p4.get(i)==Pvalue11 && p4.get(0)!=1)
				{
					p4.set(p4.get(i), Change);
					p4.set(0, 2);
				}
			}
		}
	}
	
	if(proc.equals("2"))
	{
		if(p2.get(Pvar11)==Change)
		{
			System.out.println("Done and Changing State To Modified");
			p2.set(0, 2);
		}	
		else
		{
			p2.set(0, 2);
			p2.set(Pvar11, Change);
			for(int i=0;i<=4;i++)
			{
				if(p1.get(i)==Pvalue11 && p1.get(0)!=1)
				{
					p1.set(p1.get(i), Change);
					System.out.println("Going to modified state..");
					p1.set(0, 2);
				}
				if(p3.get(i)==Pvalue11 && p3.get(0)!=1)
				{
					p3.set(p3.get(i), Change);
					System.out.println("Going to modified state..");
					p3.set(0, 2);
				}
				if(p4.get(i)==Pvalue11 && p4.get(0)!=1)
				{
					p4.set(p4.get(i), Change);
					System.out.println("Going to modified state..");
					p4.set(0, 2);
				}
			}
		}
	}
	
	if(proc.equals("3"))
	{
		if(p3.get(Pvar11)==Change)
		{
			System.out.println("Done and Changing State To Modified");
			p3.set(0, 2);
		}
		else
		{
			p3.set(Pvar11, Change);
			for(int i=0;i<=4;i++)
			{
				if(p1.get(i)==Pvalue11 && p1.get(0)!=1)
				{
					p1.set(p1.get(i), Change);
					System.out.println("Going to modified state..");
					p1.set(0, 2);
				}
				if(p2.get(i)==Pvalue11 && p2.get(0)!=1)
				{
					p2.set(p2.get(i), Change);
					System.out.println("Going to modified state..");
					p2.set(0, 2);
				}
				if(p4.get(i)==Pvalue11 && p4.get(0)!=1)
				{
					p4.set(p4.get(i), Change);
					System.out.println("Going to modified state..");
					p4.set(0, 2);
				}
			}
		}
	}
	
	if(proc.equals("4"))
	{
		if(p1.get(Pvar11)==Change)
		{
			System.out.println("Done and Changing State To Modified");
			p1.set(0, 2);
		}
		else
		{
		p4.set(Pvar11, Change);
		System.out.println("Moving to the Modified Stage..");
		p4.set(0, 2);
		for(int i=0;i<=4;i++)
		{
			if(p1.get(i)==Pvalue11 && p1.get(0)!=1)
			{
				p1.set(p1.get(i), Change);
				p1.set(0, 2);
			}
			if(p2.get(i)==Pvalue11 && p2.get(0)!=1)
			{
				p2.set(p2.get(i), Change);
				p2.set(0, 2);
			}
			if(p3.get(i)==Pvalue11 && p3.get(0)!=1)
			{
				p3.set(p3.get(i), Change);
				p3.set(0, 2);
			}
		}
		}
	}
}

}

