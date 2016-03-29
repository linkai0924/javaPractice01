package designPatterns.iterator.original;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
