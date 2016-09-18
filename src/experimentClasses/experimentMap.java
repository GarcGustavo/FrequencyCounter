package experimentClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import approachClasses.FrequencyCounter;
import approachClasses.MapFD;

public class experimentMap {
	
	//Modify to work with map
	public static void testerInt(ArrayList<Integer> array, int runs) throws IOException{

		long timeSum=0;
		long averageTime=0;
		FrequencyCounter<Integer> mapCounter = new MapFD<>();
		for(int i=0; i<runs; i++){
		long startTime = System.nanoTime();
		mapCounter.computeFDList(array);
		long estimatedTime = System.nanoTime()-startTime;
		timeSum += estimatedTime;
		}
		averageTime = timeSum/runs;
		FileWriter fw = new FileWriter("experimentalResults/resultsMap.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Integers: "+ array.size() +" | "+averageTime+"\n");
		bw.close();
		fw.close();
	}
	public static void testerStr(ArrayList<String> array, int runs) throws IOException{

		long timeSum=0;
		long averageTime=0;
		FrequencyCounter<String> mapCounter = new MapFD<>();
		for(int i=0; i<runs; i++){
		long startTime = System.nanoTime();
		mapCounter.computeFDList(array);
		long estimatedTime = System.nanoTime()-startTime;
		timeSum += estimatedTime;
		}
		averageTime = timeSum/runs;
		FileWriter fw = new FileWriter("experimentalResults/resultsMap.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Strings: "+ array.size() +" | "+averageTime+"\n");
		bw.close();
		fw.close();
	}

}
