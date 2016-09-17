package testerClasses;

import approachClasses.SequentialFD;
import approachClasses.FrequencyCounter;
import java.util.ArrayList;
import java.io.IOException;

public class OrderedTester extends SequentialTester {

	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		readFiles("inputData/integerData.txt", "inputData/stringData.txt");
		testerStr(strList);
		testerInt(intList);
	}

	//Methods to measure time in which SequentialFD executes for strings or integers
	//Need to change to work with OrderedFD, this is just Sequential copy/pasted
	public static void testerInt(ArrayList<Integer> array){

		FrequencyCounter<Integer> sequenCounter = new SequentialFD<>();
		long startTime = System.currentTimeMillis();
		sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		System.out.println("Method took "+ estimatedTime + " seconds for "+ array.size() +" integers");

	}
	public static void testerStr(ArrayList<String> array){

		FrequencyCounter<String> sequenCounter = new SequentialFD<>();
		long startTime = System.currentTimeMillis();
		sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		System.out.println("Method took "+ estimatedTime + " for "+ array.size() +" strings");

	}

}
