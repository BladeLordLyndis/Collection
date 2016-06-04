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
  
  public Object at(int index) throws Exception {
    if (index >= capacity || index < 0) {
      throw new Exception("Index out of bounds: " + index);
    }
    return array[index];
  }
  
  public void insert(Object itemToInsert) {
    insert(itemToInsert, size);
  }
  
  public void insert(Object itemToInsert, int indexToInsert) {
    if (indexToInsert >= capacity) {
      expandArray(indexToInsert);
    }
    if (array[indexToInsert] == null) {
      ++size;
    }
    array[indexToInsert] = itemToInsert;
  }
  
  public void clear() {
    size = 0;
    for (int item = 0; item < capacity; ++item) {
      array[item] = null;
    }
  }
  
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
