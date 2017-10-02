import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientWordMarkov extends WordMarkovModel{

	Map<WordGram, ArrayList<String>> myWordMap;
	
	ArrayList<String> b;
	
	String[] theWords;
	
	WordGram a;
	
	ArrayList<String> thingInsideWordMap;
	
	
		
		
	
	
	
	
	public EfficientWordMarkov(int order){
			super(order);
		
			myWordMap = new HashMap();
		
	}
	
	@Override
	public void setTraining(String text) {
	
		//START OF MY CODE
		theWords = text.split("\\s+");
		
		 myWords = text.split("\\s+");
		
		myWordMap.clear();
		//hey
		for(int i=0; i<myWords.length-(myOrder-1);i++) {
			
			a = new WordGram(myWords, i, myOrder);
			
			if(i>=myWords.length-(myOrder+1)) {
				
				//System.out.println(theWords[i+myOrder]);
				
				if(myWordMap.containsKey(a)) {
		
					
					myWordMap.get(a).add(PSEUDO_EOS);
					
				}
				else {
					//b = new ArrayList<String>();
					thingInsideWordMap = new ArrayList<String>();
					thingInsideWordMap.add(PSEUDO_EOS);
					//b.add(PSEUDO_EOS);.
					//myWordMap.put(text.substring(i, myOrder+i), b);
					myWordMap.put(new WordGram(theWords, i, myOrder), thingInsideWordMap);
				}
		
				
			}
			
			

			
			else if(myWordMap.containsKey(a)) {
		
				
				myWordMap.get(a).add(theWords[i+myOrder]);
				
			}
			else {
				//b = new ArrayList<String>();
				//b.add(text.substring(myOrder+i, myOrder+i+1));
				//myWordMap.put(text.substring(i, myOrder+i), b);
				
				thingInsideWordMap = new ArrayList<String>();
				thingInsideWordMap.add(theWords[i+myOrder]);
				myWordMap.put(new WordGram(theWords, i, myOrder),thingInsideWordMap);
				
			}
			
		}
		
		//END OF MY CODE
		
		
	}
	
	@Override
	public
	ArrayList<String> getFollows(WordGram key){
		
		//System.out.println(key);
		//System.out.println(myWordMap.keySet());
		
		if(myWordMap.containsKey(key)){
			return myWordMap.get(key);
		}
		
		
		 throw new NoSuchElementException("Sorry No Such Key Exists. This is the missing key: " + key);
			
		
		
		
	}

	
}
