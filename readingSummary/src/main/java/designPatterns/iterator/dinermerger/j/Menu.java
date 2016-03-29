package designPatterns.iterator.dinermerger.j;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
