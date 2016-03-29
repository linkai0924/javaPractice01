package designPatterns.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;


@SuppressWarnings("unchecked")
public class IteratorEnumeration implements Enumeration {
	Iterator iterator;
 
	public IteratorEnumeration(Iterator iterator) {
		this.iterator = iterator;
	}
 
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}
 
	public Object nextElement() {
		return iterator.next();
	}
}
