package dictionaryCovnverter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Dictionary {

	
	private String fileName;
	private ArrayList<String> data;
	
	public Dictionary(String file)
	{
		fileName = System.getProperty("user.dir")  + file;
	}
	
	public void readFile() throws Throwable
	{
		Scanner in = new Scanner(new File(fileName));
		data = new ArrayList<String>();
		while(in.hasNext())
		{
			data.add(in.next());			
		}
		in.close();		
	}
	
	public ArrayList<String> getData()
	{
		return data;
	}
	
	public void displayData()
	{
		for(String str:data)
		{
			System.out.println(str);
		}
	}
	
	
}
