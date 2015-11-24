package dictionaryCovnverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapper 
{
	
	private HashMap<String,ArrayList<String>> container;
	private static final int MAX_SIZE =75000;
	
	
	public HashMapper()
	{
		container = new HashMap<String,ArrayList<String>>(MAX_SIZE);
	}
		
	public boolean addWord(String number,String word)
	{				
		if(container.containsKey(number)==false)
		{
			ArrayList<String> wordList = new ArrayList<String>();
			wordList.add(word);
			container.put(number,wordList);
			return true;
		}else{			
			ArrayList<String> wordList = container.get(number);
			if(wordList.contains(word))
			{
				return false;
			}
			wordList.add(word);
			container.put(number,wordList);
			return true;
		}
		
	}
	
	
	public void displayData()
	{
		Set<String> keys = container.keySet();
		
		for(Object key:keys.toArray())
		{
			ArrayList<String> wordList = container.get(key);
			for(int i=0;i<wordList.size();++i)
			{
				System.out.println("Value at " + (i+1) +" =" + wordList.get(i));
			}
		}
	}
	
	
	
	public ArrayList<String> findSolution(String number,boolean flag)
	{
		ArrayList<String> solution = new ArrayList<String>();		
		Set<String> keys = container.keySet();		
		
		if((number.length()==1)&&(flag==false))
		{
			solution.add(number);
			return solution;
		}
		
		for(String key:keys)
		{
			int pos = number.indexOf(key);
			if(number.equals(key))		
			{
				ArrayList<String> wordList = container.get(number);
				for(String str:wordList)
				{
					solution.add(str);
				}
				
			}else if(number.contains(key))
			{
				if(pos==0)
				{
					ArrayList<String> wordList = container.get(key);	
					ArrayList<String> innerSolution = findSolution(number.substring(key.length()),false);
					for(int i=0;i<wordList.size();++i)
					{
						for(String str:innerSolution)
						{
							solution.add(wordList.get(i) + " " + str);
						}
					}
					
				}else if((pos==1)&&(flag==false))
				{
					ArrayList<String> innerSolution = findSolution(number.substring(1),true);					
					for(String str:innerSolution)
					{
						solution.add(number.charAt(0) + " " + str);
					}					
				}
			}
		}		
		
		return solution;
	}

}



