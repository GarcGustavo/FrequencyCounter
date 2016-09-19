package experimentClasses;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExperimentalTrials {

	private static int entries=50; //number of starting elements in list
	private static int repetitions=20; //times to repeat each approach in one list
	private static int iterations=30; //amount of lists to go through
	private static int elementIncrement=50; //amount of elements to add for next list experiment
	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();


	public static void main(String[] args) throws IOException{

		clearFile("experimentalResults/resultsSequential.txt");
		clearFile("experimentalResults/resultsOrdered.txt");
		clearFile("experimentalResults/resultsMap.txt");
		FileWriter fw = new FileWriter("experimentalResults/resultsMap.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<Number of Elements> <Average Time in Nano-Seconds>\n\n");
		bw.close();
		fw.close();
		int index=0;
		intList.clear();
		strList.clear();
		for(int i=1; i<=iterations; i++){
			if(i<=1){
				createList(index, entries);
			}
			else{
				createList(index, elementIncrement);
			}
			experimentSequen.testerInt(intList, repetitions);
			experimentOrdered.testerInt(intList, repetitions);
			experimentMap.testerInt(intList, repetitions);
			index+=elementIncrement;
		}
		index=0;
		intList.clear();
		strList.clear();
		for(int i=1; i<=iterations; i++){
			if(i<=1){
				createList(index, entries);
			}
			else{
				createList(index, elementIncrement);
			}
			experimentSequen.testerStr(strList, repetitions);
			experimentOrdered.testerStr(strList, repetitions);
			experimentMap.testerStr(strList, repetitions);
			index+=elementIncrement;
		}
		System.out.println("Experiment complete, data saved to experimentalResults directory text files.");
	}

	//Method to clear files of previous experiment results
	public static void clearFile(String fileName) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(fileName);
		pw.write("");
		pw.close();
	}

	public static void createList(int index, int numElems){
		Random randomGen = new Random();
		for(int i=0; i<numElems; i++){
			intList.add(index, randomGen.nextInt(numElems/2));
			strList.add(index, String.valueOf(randomGen.nextInt(numElems/2))+"\n");
		}
	}
}
