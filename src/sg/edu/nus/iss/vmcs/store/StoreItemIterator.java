package sg.edu.nus.iss.vmcs.store;

import java.util.Arrays;
import java.util.List;

public class StoreItemIterator implements Iterator {
		/**This attribute hold the size of the store*/
		//protected int size;
		
		/**This attribute hold the items of the store*/
		private List<StoreItem> items;
		private int next;
		
		
		/**
		 * This constructor creates an instance of Store object.
		 * @param itemn the number of item.
		 */
		public StoreItemIterator(StoreItem[] itemn) {
			items =  (List<StoreItem>) Arrays.asList(itemn);
			//items = new StoreItem[size];
			next = 0;
		}
		
		public boolean hasNext()
		{
			return next < items.size();
		}
		
		public void next() 
		{
			next++;
		}
		
		public boolean has(StoreItem i)
		{
			return items.contains(i);
		}
		
		public StoreItem getCurrent()
		{
			return items.get(next);
		}

		@Override
		public void reset() {
			next=0;
			
		}
	}


