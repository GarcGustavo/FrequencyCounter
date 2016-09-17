package testerClasses;

import approachClasses.SequentialFD;
import approachClasses.FrequencyCounter;
import java.util.ArrayList;
import java.util.Random;

public class SequentialTester {
	
	public static int capacity = 100;
	ArrayList<Integer> intList = new ArrayList<>(capacity);
	ArrayList<String> strList = new ArrayList<>(capacity);
	
	public void main(String[] args){

		Random randGen = new Random();
		for(int i=0; i<=capacity; i++){
			intList.set(i, randGen.nextInt());
			System.out.println("created new int"+intList.get(i));
		}
		
		seqTesterInt(intList);

	}
	
	public static void seqTesterInt(ArrayList<Integer> array){
		
		FrequencyCounter<Integer> sequenCounter = new SequentialFD<>();
		long startTime = System.currentTimeMillis();
		
		sequenCounter.computeFDList(array);
		
		long estimatedTime = System.currentTimeMillis()-startTime;
		System.out.println("Method took "+estimatedTime+ " for "+ capacity +" integers");
		
	}
	public static void seqTesterStr(ArrayList<String> array){
		
		FrequencyCounter<String> sequenCounter = new SequentialFD<>();
		long startTime = System.currentTimeMillis();
		
		sequenCounter.computeFDList(array);
		
		long estimatedTime = System.currentTimeMillis()-startTime;
		System.out.println("Method took "+estimatedTime+ " for "+ capacity +" integers");
		
	}

}
