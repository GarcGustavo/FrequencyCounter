package testerClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

import approachClasses.FrequencyCounter;
import approachClasses.MapFD;

/**
 * Tests map method using files
 * @author Gustavo Reyes
 *
 */
public class MapTester extends SequentialTester{
	
	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		readFiles("inputData/integerData.txt", "inputData/stringData.txt");
		testerInt(intList);
		testerStr(strList);
	}

	//Methods to measure time in which SequentialFD executes for strings or integers
	public static void testerInt(ArrayList<Integer> array){

		FrequencyCounter<Integer> mapCounter = new MapFD<>();
		ArrayList<Entry<Integer, Integer>> resultArray = null;
		
		long startTime = System.currentTimeMillis();
		resultArray = mapCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		
		for(int i=0; i<mapCounter.computeFDList(array).size();i++){
		System.out.println(resultArray.get(i));
		}
		System.out.println("Method took "+ estimatedTime + " seconds for "+ array.size() +" integers\n");

	}
	public static void testerStr(ArrayList<String> array){

		FrequencyCounter<String> mapCounter = new MapFD<>();
		ArrayList<Entry<String, Integer>> resultArray = null;
		
		long startTime = System.currentTimeMillis();
		resultArray = mapCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		
		for(int i=0; i<mapCounter.computeFDList(array).size();i++){
		System.out.println(resultArray.get(i));
		}
		System.out.println("Method took "+ estimatedTime + " seconds for "+ array.size() +" strings\n");

	}
}
