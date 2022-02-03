

import java.security.*;
import java.io.*;



public class MAIN {

	    
	    public static void main (String[] args) throws FileNotFoundException{
	    	
	    	
	    	theanswer();
	    	
	    	
	    }
	   

	    
	  	    public static String sha256(String input){
	        try{
	            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
	            byte[] salt = "CS210+".getBytes("UTF-8");
	            mDigest.update(salt);
	            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
	            StringBuffer sb = new StringBuffer();
	            for (int i=0;i<data.length;i++){
	                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
	            }
	            return sb.toString();
	        }catch(Exception e){
	            return(e.toString());
	        }
	    }
	    
	  	    //generates a new sentence everytime its called.
	    public static String newsentences() throws FileNotFoundException {
	    	
	    	dictionary input = new dictionary();
	    	
	    	
		    
		    	//the size of each subarray from the big array of the txt file.
		    	int n = input.pronouns();	 
		    	int n1 = input.nouns();	
		    	int n2 = input.verbs();
		    	int n3 = input.adjectives();
		    	int n4 = input.adverbs();
		    	int n5 = input.pronouns2();
		    	int n6 = input.verbs2();
		    
		    	
		    	String sentence = input.getWord(n,  n1,  n2,  n3,  n4,  n5, n6);		    	
		    	 	
		    	
		        return sentence;
		    	
		    	
		    	
	    	
	    }

	public static void theanswer() throws FileNotFoundException {
		
		//holds the final answers
	    	String finalsentence1 = "";
	    	String finalsentence2 ="";
	    	String finalsha2561 ="";
	    	String finalsha2562 ="";
	    	String sentence = "";
	    	String sentence2 = "";
	    	String temphash1 ="";
	    	String temphash2 ="";
	    	
	    	//temp is the amount of matches that we get from each hash value
	    	int temp=0;
	    	//this holds the biggest number of matches so far in the search.
	    	int biggestmatches =0;
	    	
	    	
	    	
	    	//this while loop searches through each sentence
	    	while(temp<=25) {
	    	temp=0;
	    	//holds the new temp value after the first half of the hash value is scanned.
	    	int newtemp=0;
	    	
	    	sentence =newsentences();
	    	sentence2 = newsentences();
	    	temphash1 = sha256(sentence);
	    	temphash2 = sha256(sentence2);
	    	
	    	//divide each of the hash values in two.
	    	String a = temphash1.substring(0,32);
	    	String b = temphash2.substring(0,32);
	    	String c = temphash1.substring(32,64);
	    	String d = temphash2.substring(32,64);
	    	
	    	
	    	//if the sentences are the same pick a new one.
		    if(sentence.equals(sentence2)) {
		    	sentence2=newsentences();
		    }
		    
	    //run through the first half of the hash value and find the number of pairs
	    	for(int j =0; j<32; j++) {
	    		
	    		
	    		if(a.charAt(j)==b.charAt(j)) {
	    			temp=temp+1;
	    		}
	    			
	    	}
	    	
	    	
	    	//find the probability and if it is bigger then your average probability of finding 20 pairs then run the other half of the code
	    	 newtemp=temp;
	    	if(probability(temp)) {
	    		for(int j =0; j<32; j++) {
	    			if(c.charAt(j)==d.charAt(j)) {
		    			newtemp=newtemp+1;
		    		}
	    		}
	    		}
	    	//otherwise start again.
	    	else {
	    		temp=0;
	    		newtemp=0;
	    	}
	    		
	    	//whenever you get a bigger match then the last one put it into the biggest matches variable
	    	if(newtemp>=biggestmatches) {
	    		biggestmatches=newtemp;
	    		finalsentence1 = sentence;
	    		finalsentence2 = sentence2;
	    		finalsha2561 =temphash1;
		    	finalsha2562 =temphash2;
		    	
		    	System.out.println(finalsentence1);
		    	System.out.println(finalsentence2);
		    	System.out.println(finalsha2561);
		    	System.out.println(finalsha2562);
		    	System.out.println(biggestmatches);
	    		
	    	}
	    	
	    	
	    	}
	    	
	}
	
	//finds the probability of getting 20 or above matches.
	public static boolean probability(int temp) {
	
		//this finds the proability for getting 20 or more matches out of the entire hash value
		//need 20 pairs
	int n=20;
    //44 left out of 64
	int np=44;
	double probability=0.0;
		
	
	while(np>=0) {
		double equation =0;
		//1/15 chance of getting a match with each letter scanned. take this number and put it to the power of 
		//20 and then add one to it each time. 14/15 chance of getting it wrong. take this number and multiply 
		//it by the amount of pairs you dont need then and take away one each time.
		equation = Math.pow(1.0/15.0, n)*Math.pow(14.0/15.0, np);
			n=n+1;
			np=np-1;
			//add each equation up to find the probability of getting 20 matches.
			probability = (probability+equation);

	}
	
	//take the variable temp which is the number of matches in the first half of the hash value and minus it from the number of matches we need.
	int numberneeded= 20-temp;
	//take the amount of hash values left to scan and minus it from the amount of pairs that we need.
	int numpairs = 32-numberneeded;
	double probability2 = 0.0;
	
	//repeat the same equation as we did finding the overall probability.
	while(numpairs>=0) {
		double equation2 =0;
		equation2 = Math.pow(1.0/15.0, numberneeded)*Math.pow(14.0/15.0, numpairs);
			numberneeded=numberneeded+1;
			numpairs=numpairs-1;
			probability2 = (probability2+equation2);

	}
	
	//if the probability of finding 20 or more matches is bigger or equals to the average probability 
	//of finding 20 or more matches since scanning half the hash value then return true.
	if(probability2>=probability) {
		return true;
	}
	else {
		return false;
	}
	
	}

}
