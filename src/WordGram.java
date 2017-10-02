
public class WordGram implements Comparable<WordGram>{
	
	private int myHash;
	private String[] myWords;
	private int startingPoint;
	private int sizeR;
	
	public WordGram(String[] words, int index, int size) {
		// complete this constructor
		
		//System.out.println(index);
		//System.out.println(words[index]);
		
		myWords = new String[size];
		
		startingPoint=index;
		
		sizeR = size;
		
		for(int i=index;i<size+index;i++) {
			
				//System.out.println(myWords[i-index]);
		/*	System.out.println("I is: " + i);
			System.out.println("Size of MyWords is: " + myWords.length);
			System.out.println("Size of words is: " + words.length);
			System.out.println("index is: " + index);*/
			
				myWords[i-index]=words[i];
		
			
		}
		
		//System.out.println("FINAL: " + myWords[0]);
		
		//possible error spot, should thig go under hashCode()?
		/*int hash = 0;
		for(int k=0; k < myWords.length; k++) {
			System.out.println(myWords[k]);
		    hash +=  k*myWords[k].hashCode();
		}
		myHash = hash;
		*/
		
	//	myHash = 17;
		
		
	}
	
	@Override
	public int hashCode() {
		
		int hash = 0;
		for(int k=0; k < myWords.length; k++) {
			//System.out.println(k + " " +myWords[k]);
			
		    hash +=  k*k*k*myWords[k].hashCode();}
		
		myHash = hash;

		
		
		return myHash;
	}
	
	@Override
	public String toString() {
		
		String allTheStrings = String.join(" ", myWords);
		
		
		return allTheStrings;
	}
	
	@Override
	public boolean equals(Object other) {
		
		
		if (other == null || ! (other instanceof WordGram)) {
			return false;
		}
		
		WordGram wg = (WordGram) other;
		
		//System.out.println( myWords.length + " " + wg.length());
		if(myWords.length!=wg.length()) {
			return false;
		}
		
		for(int i =0;i<myWords.length;i++) {
			
			

			
			if(!myWords[i].equals(wg.myWords[i])) {
			//	System.out.println("My words: " + myWords[i]);
			//	System.out.println("WG words: " + wg.myWords[i]);
				return false;
			}
			
			
		}
		
		//System.out.println("RETURNED TRUE");
		return true;
	}
	
	@Override
	public int compareTo(WordGram wg) {
		
		if(myWords.length>wg.length()) {
			return 1;
		}
		else if(myWords.length<wg.length()) {
			return -1;
		}
		
		for(int i =0;i<myWords.length;i++) {
			
			if(myWords[i].compareTo(wg.myWords[i])!=0) {
				return myWords[i].compareTo(wg.myWords[i]);
			}
			
			
		}
		
		
		
		
		return 0;
	}
	
	public int length() {
		return myWords.length;
	}
	
	
	public WordGram shiftAdd(String last) {
		
		String[] myWords2 = new String[myWords.length+1];
				
		
			int i =0;
			while(i<myWords2.length) {
				if((i)==myWords2.length-1) {
					myWords2[i]=last;
				}else {
			myWords2[i]=myWords[i];
				}
			i+=1;
			}
			
					
		
		
		
		return new WordGram(myWords2,1 ,myWords.length);
	}
	
		/*
		
		String[] newray = new String[myWords.length+1];
		for(int x = 0; x<newray.length; x++)
		{
		if(x == newray.length-1)
		{
		newray[x] = last;
		}
		else
		{
		newray[x] = myWords[x];
		}
		}
		 return new WordGram(newray,1,myWords.length);
	}*/
}
