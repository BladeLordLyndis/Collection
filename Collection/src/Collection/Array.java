package Collection;

public class Array {
  private static int DEFAULT_CAPACITY = 10;
  
  private int size;
  private int capacity;
  private int[] array;
  
  public Array() {
    capacity = DEFAULT_CAPACITY;
    size = 0;
    array = new int[DEFAULT_CAPACITY];
  }
}
