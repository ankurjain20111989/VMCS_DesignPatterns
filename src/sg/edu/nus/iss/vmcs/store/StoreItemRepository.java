package sg.edu.nus.iss.vmcs.store;

import java.util.Arrays;
import java.util.List;

public class StoreItemRepository implements StoreItemContainer{

	@Override
	public Iterator getIterator(StoreItem[] o) {
		// TODO Auto-generated method stub
		return new StoreItemIterator(o);
	}
	
	
	private class StoreItemIterator implements Iterator {
		/**This attribute hold the size of the store*/
		//protected int size;
		
		/**This attribute hold the items of the store*/
		protected List<StoreItem> items;
		private StoreItem next;
		
		
		/**
		 * This constructor creates an instance of Store object.
		 * @param itemn the number of item.
		 */
		public StoreItemIterator(StoreItem[] itemn) {
			items =  (List<StoreItem>) Arrays.asList(itemn);
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
		
		public StoreItem next()
		{
			next = items.get(items.indexOf(next)+1);
			return next;
			//return items.iterator().next();
		}
		
		public boolean has(StoreItem i)
		{
			return items.contains(i);
		}
		
		public StoreItem getCurrent()
		{
			return next;
		}
	}



}
