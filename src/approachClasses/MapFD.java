package approachClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapFD<E extends Comparable<E>> extends FrequencyCounter<E> {

	public MapFD() {
		super("Map");
	}

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		HashMap< E, Integer > mapList = new HashMap<E, Integer>();
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		for(int i= 0; i<dataSet.size();i++ )
		{
			if(mapList.containsKey(dataSet.get(i)))
			{
				mapList.put(dataSet.get(i), mapList.get(dataSet.get(i)) + 1);
			}
			else
			{
				mapList.put(dataSet.get(i), 1);
			}
		}
		
		for (Entry<E,Integer> entry : mapList.entrySet()){ 
				results.add(entry);
		}
		return results;
	}

}