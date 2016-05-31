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
  
  public int getSize() {
    return size;
  }
  
  public int getCapacity() {
    return capacity;
  }
  
  // TODO: Throw exception
  public Object at(int index) throws Exception {
    if (index > capacity || index < 0) {
      throw new Exception("Index out of bounds: " + index);
    }
    return array[index];
  }
  
  public void insert(Object itemToInsert) {
    insert(itemToInsert, size);
  }
  
  public void insert(Object itemToInsert, int indexToInsert) {
    if (indexToInsert > capacity) {
      expandArray(indexToInsert);
    }
    if (array[indexToInsert] == null) {
      ++size;
    }
    array[indexToInsert] = itemToInsert;
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
  
  private void expandArray(int minimumCapacity) {
    int newCapacity = capacity;
    while (newCapacity < minimumCapacity) {
      newCapacity *= DEFAULT_SCALE_FACTOR;
    }

    Object[] oldArray = array;
    array = new Object[newCapacity];
    for(int item = 0; item < capacity; ++item) {
      array[item] = oldArray[item];
    }
  }
}


















