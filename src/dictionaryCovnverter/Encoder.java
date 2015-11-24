package dictionaryCovnverter;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Encoder 
{
	
	public static void main(String[] args) throws Throwable 
	{		
		long startTime = System.currentTimeMillis();
		Dictionary dict = new Dictionary("\\dictionary.txt");
		HashMapper map = new HashMapper();
		DatatoNumberConverter convertor;
		dict.readFile();		
		
		String no; 
		
		System.out.println("Enter the phone number");
		Scanner in = new Scanner(System.in);
		no= in.nextLine();
		no = no.replaceAll("-","");
		no = no.replaceAll("/", "");		
		System.out.print(no+ "\n");		
		in.close();
		
		
		for(String word:dict.getData())
		{
			convertor = new DatatoNumberConverter(word);
			map.addWord(convertor.convert(), word);					
		}		
		
		
		ArrayList<String> allSolutions = map.findSolution(no,false);
		Set<String> solution = new TreeSet<String>();
		
		for(int i=0;i<allSolutions.size();++i)
		{
			String str = allSolutions.get(i);
			if(str.length()>=no.length())
			{
				solution.add(str);
			}
		}
		
		if(solution.size()>0)
		{
			for(String str:solution)
			{
				System.out.println(str);
			}
		}else
		{
			System.out.println("no combinations matched");
		}
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("Run time = "+ elapsedTime/(1000) + " seconds");
	    
	}

}
