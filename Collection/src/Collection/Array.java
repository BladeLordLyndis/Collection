package Collection;

public class Array {
  private static int DEFAULT_CAPACITY = 10;
  private static int DEFAULT_SCALE_FACTOR = 2;
  
  private int size;
  private int capacity;
  private Object[] array;
  
  public Array() {
    capacity = DEFAULT_CAPACITY;
    size = 0;
    array = new Object[DEFAULT_CAPACITY];
  }
  
  /**
   * Create an Array with the specified capacity.
   * @param capacity the initial capacity of the Array.
   */
  public Array(int capacity) {
    this.capacity = capacity;
    size = 0;
    array = new Object[capacity];
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public int size() {
    return size;
  }
  
  public int capacity() {
    return capacity;
  }
  
  public boolean contains(Object object) {
    for (int item = 0; item < capacity; ++item) {
      if (object.equals(array[item])) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Get the object at the specified index.
   * @param index the index of the item to get.
   * @return the object at the specified index.
   * @throws Exception when an invalid index is accessed.
   */
  public Object at(int index) throws Exception {
    if (index >= capacity || index < 0) {
      throw new Exception("Index out of bounds: " + index);
    }
    return array[index];
  }
  
  /**
   * Insert an object at the end of the array.
   * @param itemToInsert the object to insert into the array.
   */
  public void insert(Object itemToInsert) {
    insert(itemToInsert, size);
  }
  
  /**
   * Insert an object at the specified index.
   * @param itemToInsert the object to insert.
   * @param indexToInsert the index to insert at.
   */
  public void insert(Object itemToInsert, int indexToInsert) {
    if (indexToInsert >= capacity) {
      expandArray(indexToInsert);
    }
    if (array[indexToInsert] == null) {
      ++size;
    }
    array[indexToInsert] = itemToInsert;
  }
  
  /**
   * Sets all elements in the Array to null.
   */
  public void clear() {
    size = 0;
    for (int item = 0; item < capacity; ++item) {
      array[item] = null;
    }
  }
  
  /**
   * Clears all elements from the Array and sets the size and capacity to the defaults.
   */
  public void reset() {
    size = 0;
    capacity = DEFAULT_CAPACITY;
    array = new Object[capacity];
  }
  
  public String toString() {
    StringBuilder arrayString = new StringBuilder();
    for (int item = 0; item < capacity; ++item) {
      if (array[item] != null) {
        if (arrayString.length() != 0) {
          arrayString.append(" ");
        }
        arrayString.append(array[item].toString());
      }
    }
    return arrayString.toString();
  }
  
  public boolean equals(Array argArray) {
    if (size != argArray.size()) {
      return false;
    }
    for (int item = 0; item < capacity; item++) {
      if (array[item] == null || argArray.array[item] == null) {
        if (array[item] != argArray.array[item]) {
          return false;
        }
      } else if (!array[item].equals(argArray.array[item])) {
        return false;
      }
    }
    return true;
  }
  
  @Override
  public int hashCode() {
    int result = 17;
    for (int item = 0; item < capacity; ++item) {
      if (array[item] != null) {
        result = 31 * item * result + array[item].hashCode();
      } else {
        result = 31 * item * result + 0;
      }
    }
    return result;
  }
  
  /**
   * Expand the internal array until at least as large as the specified capacity.
   * @param minimumCapacity the minimum capacity to expand the array to.
   */
  private void expandArray(int minimumCapacity) {
    int newCapacity = capacity;
    while (newCapacity <= minimumCapacity) {
      newCapacity *= DEFAULT_SCALE_FACTOR;
    }

    Object[] oldArray = array;
    array = new Object[newCapacity];
    for(int item = 0; item < capacity; ++item) {
      array[item] = oldArray[item];
    }
    capacity = newCapacity;
  }
}
