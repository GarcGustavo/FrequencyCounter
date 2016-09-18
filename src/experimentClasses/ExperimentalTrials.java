package experimentClasses;

import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ExperimentalTrials {

	private static int elements=50; //number of entries in list
	private static int repetitions=200; //times to repeat each approach
	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();


	public static void main(String[] args) throws IOException{
		
		createList(elements);
		clearFile("resultsSequential.txt");
		experimentSequen.testerInt(intList, repetitions);
		experimentSequen.testerStr(strList, repetitions);
		clearFile("resultsOrdered.txt");
		experimentOrdered.testerInt(intList, repetitions);
		experimentOrdered.testerStr(strList, repetitions);
		clearFile("resultsMap.txt");
		experimentMap.testerInt(intList, repetitions);
		experimentMap.testerStr(strList, repetitions);
		
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
