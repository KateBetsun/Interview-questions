package telran.interviews;

import java.util.HashMap;

//all methods must have complexity 0[1]
public class MyArray<T> {

    private HashMap<Integer, T> hashMap;
    private T defaultValue;
    private int size;

    public void setAll(T value) {
		//all array's elements should be set with a given value
    	hashMap = new HashMap<>();
    	this.defaultValue = value; 
    }

    public void set(int index, T value) {
    	//set new value at a given index
    	//throws ArrayIndexOutOfBoundsException for incorrect index
    	checkIndex(index);
        hashMap.put(index, value);
    }

    public T get(int index) {
    	//returns a value at a given index
    	//throws ArrayIndexOutOfBoundsException for incorrect index
    	checkIndex(index);
        return hashMap.getOrDefault(index, defaultValue);
    }
    

    public MyArray(int size) {
    	// DONE creates the Array object for a given size
    	//with setting null's at each element
    	this.size = size;
    }
    
    private void checkIndex(int index) {
    	if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}