package sg.edu.nus.iss.vmcs.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StoreIterator<T> implements Iterator  {
	
	
	/**This attribute hold the size of the store*/
	//protected int size;
	
	/**This attribute hold the items of the store*/
	protected List<T> items;
	private T next;
	/**
	 * This constructor creates an instance of Store object.
	 */
	
	public StoreIterator(){
		
	}
	
	/**
	 * This constructor creates an instance of Store object.
	 * @param itemn the number of item.
	 */
	public StoreIterator(StoreItem[] itemn) {
		items =  (List<T>) Arrays.asList(itemn);
		//items = new StoreItem[size];
		next = items.get(0);
	}
	
	public boolean hasNext()
	{
		if(items.indexOf(next)+1 < items.size())
		{
			return true;
		}
		return false;
	}
	
	public T next()
	{
		next = items.get(items.indexOf(next)+1);
		return next;
		//return items.iterator().next();
	}
	
	public boolean has(StoreItem i)
	{
		return items.contains(i);
	}
	
	public T getCurrent()
	{
		return next;
	}
}
