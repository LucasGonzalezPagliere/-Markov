import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientMarkov extends MarkovModel {
	
	String holdMyBalls;
	
	Map<String, ArrayList<String>> myMap;
	
	ArrayList<String> b;
	
	ArrayList<String> container = new ArrayList<String>();
	
	ArrayList<String> a = new ArrayList<String>();
	
	public EfficientMarkov(int order) {
		
		super(order);
		
		myMap = new HashMap();
		
	}
	
	
	
	@Override public void setTraining(String text) {
		
		
		myText = text;
		
		myMap.clear();
		
		for(int i=0; i<text.length()-(myOrder-1);i++) {
			
			
			
			if(i>text.length()-(myOrder+1)) {
				
				if(myMap.containsKey(text.substring(i, myOrder+i))) {
					//ArrayList<String> a = new ArrayList<String>();
					
					//a = myMap.get(gram);
					//a.add(postGram);
					//myMap.put(gram, a);
					
					//System.out.println(text.substring(i, myOrder+i));
					
					myMap.get(text.substring(i, myOrder+i)).add(PSEUDO_EOS);
					
				}
				else {
					b = new ArrayList<String>();
					b.add(PSEUDO_EOS);
					myMap.put(text.substring(i, myOrder+i), b);
					//System.out.println(text.substring(i, myOrder+i));
				}
				
				//myMap.get(text.substring(i, myOrder+i)).add(PSEUDO_EOS);
				//myMap.get(text.substring(i, myOrder+i)).add(PSEUDO_EOS);
				
				
			}
			
			
			else if(myMap.containsKey(text.substring(i, myOrder+i))) {
				//ArrayList<String> a = new ArrayList<String>();
				
				//a = myMap.get(gram);
				//a.add(postGram);
				//myMap.put(gram, a);
				
				//System.out.println(text.substring(i, myOrder+i));
				
				myMap.get(text.substring(i, myOrder+i)).add(text.substring(myOrder+i, myOrder+i+1));
				
			}
			else {
				b = new ArrayList<String>();
				b.add(text.substring(myOrder+i, myOrder+i+1));
				myMap.put(text.substring(i, myOrder+i), b);
				//System.out.println(text.substring(i, myOrder+i));
			}
			
		}
		
		/*int runner =0;
		
		String gram = "";
		
		while(runner < myText.length()) {
			
			ArrayList<String> a = new ArrayList<String>();
			
			gram = text.substring(runner, myOrder+runner);
			a = myMap.get(gram);
			
			if(runner+myOrder> myText.length()) {
				
				a.add(PSEUDO_EOS);
				myMap.put(gram, a);
				
				break;
			}
			
			
			String postGram = myText.substring(myOrder+runner, myOrder+runner+1);
			
			System.out.println(a);
			
			a.add(gram);
			myMap.put(gram, a);
			
			
			
			runner++;
			
		}
		*/
		
		
		
		
		
	}
	
	
	@Override
	public ArrayList<String> getFollows(String key){
	
		
		//for(String s:myMap.keySet()) {
		//System.out.print(key);
		//System.out.println(myMap.keySet());	
		
		if(myMap.containsKey(key)){
			return myMap.get(key);
		}
		
		/*if(key.equals("m")) {
			System.out.println("m was called");
		}
			*/
		
		//}
		
		 throw new NoSuchElementException("Sorry No Such Key Exists. This is the missing key: " + key);
			
		
		
		
	
	
			
			
		
	}
}
