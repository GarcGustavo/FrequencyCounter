package testerClasses;

import approachClasses.SequentialFD;
import approachClasses.FrequencyCounter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.io.IOException;

public class OrderedTester extends SequentialTester {

	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		readFiles("inputData/integerData.txt", "inputData/stringData.txt");
		testerInt(intList);
		testerStr(strList);
	}

	//Methods to measure time in which SequentialFD executes for strings or integers
	//Need to change to work with OrderedFD, this is just Sequential copy/pasted
	public static void testerInt(ArrayList<Integer> array){

		FrequencyCounter<Integer> sequenCounter = new SequentialFD<>();
		ArrayList<Entry<Integer, Integer>> resultArray = null;
		
		long startTime = System.currentTimeMillis();
		resultArray = sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		
		for(int i=0; i<sequenCounter.computeFDList(array).size();i++){
		System.out.println(resultArray.get(i));
		}
		System.out.println("Method took "+ estimatedTime + " seconds for "+ array.size() +" integers\n");

	}
	public static void testerStr(ArrayList<String> array){

		FrequencyCounter<String> sequenCounter = new SequentialFD<>();
		ArrayList<Entry<String, Integer>> resultArray = null;
		
		long startTime = System.currentTimeMillis();
		resultArray = sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		
		for(int i=0; i<sequenCounter.computeFDList(array).size();i++){
		System.out.println(resultArray.get(i));
		}
		System.out.println("Method took "+ estimatedTime + " seconds for "+ array.size() +" strings\n");

	}

}
