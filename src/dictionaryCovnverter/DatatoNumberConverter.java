package dictionaryCovnverter;




public class DatatoNumberConverter 
{
	public String[] map = new String[]{"e","jnq","rwx", "dsy","ft", "am", "civ", "bku", "lop", "ghz"};
	
	private String number;
	private String word;
	
	
	public DatatoNumberConverter(String str)
	{
		this.word = str.toLowerCase();
		number="";
	}
	
	public String convert()
	{
		for(char ch:word.toCharArray())
		{
			for(int i=0;i<10;++i)
			{
				String str = map[i];
				int position = str.indexOf(ch);
				if((position<10)&&(position>=0))
				{
					number = number + i;
				}
			}			
		}
		return number;
	}
	
}
