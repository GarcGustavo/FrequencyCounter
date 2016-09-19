package testerClasses;

import approachClasses.SequentialFD;
import approachClasses.FrequencyCounter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tests sequence method using files
 * @author Gustavo Reyes
 *
 */
public class SequentialTester {

	//Used this integer to set the amount of elements in randomly generated lists
	//private static int generatorSize=1000;
	private static ArrayList<Integer> intList = new ArrayList<Integer>();
	private static ArrayList<String> strList = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		readFiles("inputData/integerData.txt", "inputData/stringData.txt");
		testerInt(intList);
		testerStr(strList);
	}
	
	//Method to read files and create the lists
	public static void readFiles(String intFile, String strFile) throws NumberFormatException, IOException{

		FileReader fileReaderInt = new FileReader("inputData/integerData.txt");
		BufferedReader inInt = new BufferedReader(fileReaderInt);
		FileReader fileReaderStr = new FileReader("inputData/stringData.txt");
		BufferedReader inStr = new BufferedReader(fileReaderStr);
		String strParseInt;
		String strParseString;

		//These 2 methods generate elements at the list to test
		/*
		writeFileInt(generatorSize);
		writeFileStr(generatorSize);
		*/

		while((strParseInt = inInt.readLine()) != null){
			intList.add(Integer.parseInt(strParseInt));
		}
		while((strParseString = inStr.readLine()) != null){
			strList.add(strParseString);
		}
		fileReaderInt.close();
		inInt.close();
		fileReaderStr.close();
		inStr.close();
	}

	//Methods used to generate random tester files at integerData.txt and stringData.txt
	public static void writeFileInt(int numElements) throws IOException{

		Random randomGen = new Random();
		FileWriter fw = new FileWriter("inputData/integerData.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0; i<numElements; i++){
			bw.write(randomGen.nextInt(100) +"\n");
		}
		bw.close();
		fw.close();

	}

	public static void writeFileStr(int numElements) throws IOException{

		Random randomGen = new Random();
		FileWriter fw = new FileWriter("inputData/stringData.txt");
		BufferedWriter bw = new BufferedWriter(fw);	
		for(int i=0; i<numElements; i++){	
			bw.write(String.valueOf(randomGen.nextInt(100))+"\n");
		}
		bw.close();
		fw.close();
	}

	//Methods to measure time in which SequentialFD executes for strings or integers
	
	public static void testerInt(ArrayList<Integer> array){

		FrequencyCounter<Integer> sequenCounter = new SequentialFD<>();
		ArrayList<Entry<Integer, Integer>> resultArray = null;
		
		long startTime = System.currentTimeMillis();
		resultArray = sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		
		for(int i=0; i<sequenCounter.computeFDList(array).size();i++){
		System.out.println(resultArray.get(i));
		}
		System.out.println("Method took "+ estimatedTime + " milliseconds for "+ array.size() +" integers\n");

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
		System.out.println("Method took "+ estimatedTime + " milliseconds for "+ array.size() +" strings\n");

	}

}
