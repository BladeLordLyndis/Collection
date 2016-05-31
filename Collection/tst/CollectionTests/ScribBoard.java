package CollectionTests;

import java.util.Arrays;
import Collection.Array;

public class ScribBoard {
  public static void main(String[] args) {
    int[] testArray = new int[] {1, 2, 3};
    Array array1 = new Array(5);
    
    array1.insert(99);
    array1.insert(73);
    array1.insert(100);
    System.out.println(array1);
  }
}
