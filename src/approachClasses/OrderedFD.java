package approachClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class OrderedFD<E extends Comparable<E>> extends FrequencyCounter<E> {

	public OrderedFD() {
		super("Ordered");
	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {

		int lastElemIndex=0;
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		ArrayList<E> listSort = new ArrayList<>();
		listSort.addAll(dataSet);

		//Sorting based on dataSet elements
		listSort.sort(new Comparator<E>(){
			@Override
			public int compare(E object2, E object1)
			{
				return object1.compareTo(object2);
			}
		});	
		
		for (int i=0; i<listSort.size(); i++){
			if(listSort.get(i)!=listSort.get(i+1)){
				Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(listSort.get(i), i+1-lastElemIndex); 
				results.add(entry);
				lastElemIndex=i;
			}
		}
		return results;
	}
}
