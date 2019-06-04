import java.util.Arrays;

public class ArrayIntList {
	
	private int[] elementData;
	private int size;	
	public static final int DEFAULT_CAPACITY = 100;
	
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayIntList(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity: " + capacity);
		} else {
			elementData = new int[capacity];
			size = 0;
		}
	}
	
	//replaceAll() method Ch 15 Ex 3
	public void replaceAll(int turnThis, int intoThis) {
		for(int i = 0; i < size(); i++) {
			if(get(i) == turnThis) {
				remove(i);
				add(i, intoThis);
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	//append a value to the end of the list
	public void add(int value) {
		ensureCapacity(size + 1);
		elementData[size] = value;
		size++;
	}
	
	//insert a given value at a given index
	//must shift the subsequent values to the right
		public void add(int index, int value) {
			if(index < 0 || index > size) {
				throw new IndexOutOfBoundsException("index" + index);
			}
			ensureCapacity(size + 1);
			for(int i = size; i > index; i--) {
				elementData[i] = elementData[i - 1];
			}
			elementData[index] = value;
			size++;
		}
	
	//ensure that the array capacity is sufficient, if not, the size will be doubled.
	public void ensureCapacity(int capacity) {
		if(capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if(capacity > newCapacity) {
				newCapacity = capacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	
	//remove the value at specified index
	//shift values in following indexes to one lesser
	public void remove(int index) {
		checkIndex(index);
		for(int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
	}
	
	//replace the value at the given index with the new value
	public void set(int index, int value) {
		checkIndex(index);
		elementData[index] = value;
	}
	
	//append all values in the passed ArrayIntList to end of this list
	public void addAll(ArrayIntList other) {
		ensureCapacity(size + other.size());
		for(int i = 0; i < other.size(); i++) {
			add(other.elementData[i]);
		}
	}
	
	//return an iterator for the list
	public ArrayIntListIterator iterator() {
		return new ArrayIntListIterator(this);
	}
	
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index);
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	//create a bracketed string representation of the list
	public String toString() {
		if(size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for(int i = 1; i < size; i++) {
				result += ", " + elementData[i];
			}
			result += "]";
			return result;
		}				
	}
	
	//return the position of the first occurrence of a value
	//-1 if not found
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if(elementData[i] == value) {
				return i;
			}
		}
		return -1; //value not found
	}
	
	//returns true if a value is contained in the list, false otherwise
	public boolean contains(int value) {
		return indexOf(value) >= 0;
	}
}
