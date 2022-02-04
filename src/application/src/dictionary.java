
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class dictionary {
   
   
//variables to hold the different arrays of words to create the structure of the sentence.
public String pronouns[];
public String pronouns2[];
public String nouns[];
public String verbs [];
public String wordsarray [];
public String adverbs [];
public String verbs2 [];
public String adjectives[];
List<String> words= new ArrayList<String>();
 
//holds the adjectives.txt file in a linkedlist.
public String[] makenewarray() throws FileNotFoundException {
    ///workspace/Algorithim_Project/src/application/words1
    //src/application/words1/adjectives.txt
Scanner sc = new Scanner(new File("src/application/words1/adjectives.txt"));
   
    while (sc.hasNextLine()) {
     words.add(sc.nextLine());
    }
    wordsarray = words.toArray(new String[0]);
return wordsarray;
}
   
//these methods seperate the linkedlist that was made above into seperate arrays so that I can structure the sentence in a way that is semantically correct.
   public int adjectives() throws FileNotFoundException {
    makenewarray();
   
    adjectives = Arrays.copyOfRange(wordsarray, 0, 227);
    int size = adjectives.length;
    return size;
   }
   public int adverbs() throws FileNotFoundException {
    makenewarray();
   
    adverbs = Arrays.copyOfRange(wordsarray, 228, 626);
    int size = adverbs.length;
    return size;
   }
   public int nouns() throws FileNotFoundException {
    makenewarray();
   
    nouns = Arrays.copyOfRange(wordsarray, 627, 7427);
    int size = nouns.length;
    return size;
   }
   public int pronouns() throws FileNotFoundException {
    makenewarray();
   
    pronouns = Arrays.copyOfRange(wordsarray, 7428, 7453);
    int size = pronouns.length;
    return size;
   }
   public int pronouns2() throws FileNotFoundException {
    makenewarray();
   
    pronouns2 = Arrays.copyOfRange(wordsarray, 7454, 7460);
    int size = pronouns2.length;
    return size;
   }
   public int verbs() throws FileNotFoundException {
    makenewarray();
   
    verbs = Arrays.copyOfRange(wordsarray, 7461, 7844);
    int size = verbs.length;
    return size;
   }
   public int verbs2() throws FileNotFoundException {
    makenewarray();
   
    verbs2 = Arrays.copyOfRange(wordsarray, 7845, 8227);
    int size = verbs2.length;
    return size;
   }
 
   
 
   //This creates the sentences, the inputs passed through this method are in getsentences() method.
   public String getWord(int n,int n1, int n2, int n3, int n4, int n5, int n6){
   
   
    //I created a numbers array to generate a random sentence each time the method is called this is much faster then generating a sentence for each structured sentence variable.
    int array [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
    Random r = new Random();
   
   
    int firstSentence = r.nextInt(array.length);
   
    //use these words to break up the different sentences.
    String buffers []= {"a", "the"};
    String conjunctions[] = {"and", "but", "while"};
    String[] startsentence = {"it's", "it was"};
   
    String sentence = "";
    for(int i =0; i<array.length; i++) {
   
    if(firstSentence==0) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==1) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)];
    }
    else if (firstSentence==2) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)];
   
    }
    else if(firstSentence ==3) {
    sentence =pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" it "+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" it";
    }
   
    else if(firstSentence == 4) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+pronouns2[(int)(Math.random()*n5)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+pronouns2[(int)(Math.random()*n5)];
    }
    else if(firstSentence == 5) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)];
    }
    else if (firstSentence == 6) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs2[(int)(Math.random()*n6)]+" it";
    }
    else if(firstSentence==7) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence == 8) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==9) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==10) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs[(int)(Math.random()*n2)]+" "+pronouns2[(int)(Math.random()*n5)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs[(int)(Math.random()*n2)]+" "+pronouns2[(int)(Math.random()*n5)];
    }
    else if(firstSentence==11) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)] +" "+pronouns2[(int)(Math.random()*n5)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[(int)(Math.random()*n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==12) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)];
    }
    else if(firstSentence==13) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==14) {
    sentence = startsentence[r.nextInt(startsentence.length)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==15) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+" "+adverbs[(int)(Math.random()*n4)];
    }
    else if(firstSentence==16) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+adverbs[(int)(Math.random()*n4)]+" for "+pronouns2[(int)(Math.random()*n5)];
    }
    else if(firstSentence==17) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+adverbs[(int)(Math.random()*n4)];
    }
    else if(firstSentence==18) {
    sentence = pronouns[r.nextInt(n)]+" is "+adverbs[(int)(Math.random()*n4)]+" "+adjectives[(int)(Math.random()*n3)];
    }
    else if(firstSentence==19) {
    sentence =pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+pronouns2[(int)(Math.random()*n5)];
    }
    else if(firstSentence==20) {
   
    sentence = pronouns[r.nextInt(n)]+" "+verbs[(int)(Math.random()*n2)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)];
   
    }
    else if(firstSentence==21) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)];
    }
    else if (firstSentence==22) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)];
   
    }
    else if(firstSentence ==23) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" it "+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" it";
    }
    else if(firstSentence == 24) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+pronouns2[(int)(Math.random()*n5)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+pronouns2[(int)(Math.random()*n5)];
    }
    else if(firstSentence==25) {
   
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)];
   
    }
    else if(firstSentence==26) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==27) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==28) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs2[(int)(Math.random()*n6)]+" "+pronouns2[(int)(Math.random()*n5)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs2[(int)(Math.random()*n6)]+" "+pronouns2[(int)(Math.random()*n5)];
    }
    else if(firstSentence==29) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)] +" "+pronouns2[(int)(Math.random()*n5)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==30) {
    sentence =pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+", "+conjunctions[r.nextInt(conjunctions.length)]+" "+pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)];
    }
    else if(firstSentence==31) {
    sentence = buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+adjectives[(int)(Math.random()*n3)]+" "+nouns[(int)(Math.random()*n1)];
    }
    else if(firstSentence==32) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+buffers[r.nextInt(buffers.length)]+" "+nouns[(int)(Math.random()*n1)]+" "+adverbs[(int)(Math.random()*n4)];
    }
    else if(firstSentence==33) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+adverbs[(int)(Math.random()*n4)];
    }
    else if(firstSentence==34) {
    sentence = pronouns[r.nextInt(n)]+" "+verbs2[(int)(Math.random()*n6)]+" "+pronouns2[(int)(Math.random()*n5)];
    }
   
    }
   
    //This adds a capital letter to the start and a fullstop.
    sentence = sentence.substring(0,1).toUpperCase()+sentence.substring(1)+".";
   
   
   
   
   
       return sentence;
   }
   
 
   

}