package experimentClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import approachClasses.FrequencyCounter;
import approachClasses.SequentialFD;

public class experimentMap {
	
	//Modify to work with map
	public static void testerInt(ArrayList<Integer> array, int runs) throws IOException{

		int timeSum=0;
		int averageTime=0;
		FrequencyCounter<Integer> sequenCounter = new SequentialFD<>();
		for(int i=0; i<runs; i++){
		long startTime = System.currentTimeMillis();
		sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		timeSum += estimatedTime;
		}
		averageTime = timeSum/runs;
		FileWriter fw = new FileWriter("experimentalResults/resultsSequential.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Integers: "+ array.size() +" | "+averageTime+"\n");
		bw.close();
		fw.close();
	}
	public static void testerStr(ArrayList<String> array, int runs) throws IOException{

		int timeSum=0;
		int averageTime=0;
		FrequencyCounter<String> sequenCounter = new SequentialFD<>();
		for(int i=0; i<runs; i++){
		long startTime = System.currentTimeMillis();
		sequenCounter.computeFDList(array);
		long estimatedTime = System.currentTimeMillis()-startTime;
		timeSum += estimatedTime;
		}
		averageTime = timeSum/runs;
		FileWriter fw = new FileWriter("experimentalResults/resultsSequential.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Strings: "+ array.size() +" | "+averageTime+"\n");
		bw.close();
		fw.close();
	}

}
