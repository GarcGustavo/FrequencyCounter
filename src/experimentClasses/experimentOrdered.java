package experimentClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import approachClasses.FrequencyCounter;
import approachClasses.OrderedFD;

public class experimentOrdered {
	
	//modify to work with ordered
	public static void testerInt(ArrayList<Integer> array, int runs) throws IOException{

		long timeSum=0;
		long averageTime=0;
		FrequencyCounter<Integer> orderedCounter = new OrderedFD<>();
		for(int i=0; i<runs; i++){
		long startTime = System.nanoTime();
		orderedCounter.computeFDList(array);
		long estimatedTime = System.nanoTime()-startTime;
		timeSum += estimatedTime;
		}
		averageTime = timeSum/runs;
		FileWriter fw = new FileWriter("experimentalResults/resultsOrdered.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Integers: "+ array.size() +" | "+averageTime+"\n");
		bw.close();
		fw.close();
	}
	public static void testerStr(ArrayList<String> array, int runs) throws IOException{

		long timeSum=0;
		long averageTime=0;
		FrequencyCounter<String> orderedCounter = new OrderedFD<>();
		for(int i=0; i<runs; i++){
		long startTime = System.nanoTime();
		orderedCounter.computeFDList(array);
		long estimatedTime = System.nanoTime()-startTime;
		timeSum += estimatedTime;
		}
		averageTime = timeSum/runs;
		FileWriter fw = new FileWriter("experimentalResults/resultsOrdered.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Strings: "+ array.size() +" | "+averageTime+"\n");
		bw.close();
		fw.close();
	}

}
