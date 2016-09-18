package experimentClasses;

import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ExperimentalTrials {

	private static int elements=50; //number of entries in list
	private static int repetitions=200; //times to repeat each approach in one list
	private static int increments=30; //amount of lists to go through
	private static int elementIncrement=50; //amount of elements to add for next list experiment
	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();


	public static void main(String[] args) throws IOException{
		
		clearFile("resultsSequential.txt");
		clearFile("resultsOrdered.txt");
		clearFile("resultsMap.txt");
		for(int i=1; i<=increments; i++){
		experimentSequen.testerInt(intList, repetitions);
		experimentOrdered.testerInt(intList, repetitions);
		experimentMap.testerInt(intList, repetitions);
		}
		for(int i=1; i<=increments; i++){
		createList(elements);
		experimentSequen.testerStr(strList, repetitions);
		experimentOrdered.testerStr(strList, repetitions);
		experimentMap.testerStr(strList, repetitions);
		elements+=elementIncrement;
		}
		
		System.out.println("Experiment complete, data saved to experimentalResults directory text files.");
	}

	//Method to clear files of previous experiment results
	public static void clearFile(String fileName) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(fileName);
		pw.close();
	}
	
	public static void createList(int numElems){
		Random randomGen = new Random();
		for(int i=0; i<numElems; i++){
			intList.add(randomGen.nextInt(numElems/2));
		}
		for(int i=0; i<numElems; i++){	
			strList.add(String.valueOf(randomGen.nextInt(numElems/2))+"\n");
		}
	}
}
