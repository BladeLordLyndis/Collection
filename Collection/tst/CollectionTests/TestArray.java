package CollectionTests;

import org.junit.Test;
import static org.junit.Assert.*;

import Collection.Array;

public class TestArray {
  
  @Test
  public void testToString() {
    Array intArray = new Array(5);
    intArray.insert(5);
    intArray.insert(10);
    intArray.insert(15);
    String expectedString = "5 10 15";
    assertEquals(expectedString, intArray.toString());
  }
  
  @Test
  public void testInsertWithNoArguments() {
    
  }
  
  @Test
  public void testInsertAtSpecificIndex() {
    
  }
}
