package approachClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class OrderedFD_Binary<E extends Comparable<E>> extends FrequencyCounter<E> {

	public OrderedFD_Binary() {
		super("Ordered Binary");
	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {

		//List recording occurrences
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();

		int low = 0;
		int high = dataSet.size() - 1;
		int mid = (low + high)/2;
		//amountElem tracks the number of times an element is repeated
		int amountElem = 0;
		//amountSkipped tracks the number of times an element is skipped because no match was found
		int amountSkipped=0;
		//index tracks at which element of the array we left off on the last loop
		int index=0;

		//Sorting based on dataSet elements
		dataSet.sort(new Comparator<E>(){
			@Override
			public int compare(E object2, E object1)
			{
				return object1.compareTo(object2); 
			}
		});

		//Case for an Array list with only 1 element
		if(high==0){
			Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(index), amountElem); 
			results.add(entry);
		}

		//Search for similar elements using Binary Search method
		while(low<high){
			amountElem = 0;
			if(dataSet.get(low).equals(dataSet.get(high))){
				amountElem = high+1; // +1 because array starts from 0
				index= low; //used to mark the position of the element later on
				low= high;
			}
			if(dataSet.get(low).equals(dataSet.get(mid))){
				amountElem= (mid-low)+1;
				index= low;
				low= mid+1;
			}
			if(dataSet.get(mid).equals(dataSet.get(high))){
				amountElem= (high-mid)+1;
				index= mid;
				high= mid-1;
			}
			//If no equal elements are found it checks if the next one is equal, if it is, low and amountSkipped are updated
			else{
				if(dataSet.get(low).equals(dataSet.get(low+1))){
					amountSkipped++;
					low++;
				}
				//if no equal elements have been found and the next one isn't equal either, add these to results and reset amountSkipped
				else{
					//Create a new entry for the first instance found of object e
					Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(low-1), amountElem+ amountSkipped); 
					results.add(entry);
					amountSkipped=0;
				}
			}

			//Create a new entry for the first instance found of object e
			Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(index), amountElem+ amountSkipped); 
			results.add(entry);

			mid = (low + high)/2;
		}
		return results;
	}
}
