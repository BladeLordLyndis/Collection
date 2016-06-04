package CollectionTests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;

import Collection.Array;

public class TestArray {
  private static int INT_ARRAY_CAPACITY = 10;
  private Array intArray;
  private Array secondIntArray;
  
  @Before
  public void init() {
    intArray = new Array(INT_ARRAY_CAPACITY);
  }
  
  @Test
  public void testToString() {
    intArray.insert(5);
    intArray.insert(10);
    intArray.insert(15, 4);
    intArray.insert(20, 9);
    String expectedString = "5 10 15 20";
    assertEquals(expectedString, intArray.toString());
  }
  
  @Test
  public void testInsertAtValidIndex() {
    intArray.insert(10, 5);

    try {
      int itemInArray = (int) intArray.at(5);
      int arraySize = intArray.size();
      int arrayCapacity = intArray.capacity();
      
      int expected = 10;
      int expectedSize = 1;
      int expectedCapacity = 10;
      
      assertEquals(itemInArray, expected);
      assertEquals(arraySize, expectedSize);
      assertEquals(arrayCapacity, expectedCapacity);
    } catch (Exception e) {
      fail("Exception thrown when getting an element at a valid index");
    }
  }
  
  @Test
  public void testInsertMultipleAtValidIndex() throws Exception {
    intArray.insert(0, 0);
    intArray.insert(1, 1);
    intArray.insert(9, 9);
    
    int valueInArray = 0;
    int expectedValue = 0;
    for (int position = 0; position < INT_ARRAY_CAPACITY; ++position) {
      switch(position) {
        case 0:
        case 1:
        case 9:
          valueInArray = (int) intArray.at(position);
          expectedValue = position;
          assertEquals(valueInArray, expectedValue);
          break;
        default:
          Object objectInArray = intArray.at(position);
          assertEquals(objectInArray, null);
      }
    }
    
    int sizeOfArray = intArray.size();
    int capacityOfArray = intArray.capacity();
    int expectedSize = 3;
    int expectedCapacity = 10;
    
    assertEquals(sizeOfArray, expectedSize);
    assertEquals(capacityOfArray, expectedCapacity);
  }
  
  @Test(expected=Exception.class)
  public void testAtWithInvalidIndex() throws Exception {
    Object object = intArray.at(10);
  }
  
  @Test
  public void testInsertAtIndexLargerThanCapacity() throws Exception {
    intArray.insert(10, 10);
    int valueInArray = (int) intArray.at(10);
    int expectedValue = 10;
    int sizeOfExpandedArray = intArray.size();
    int capacityOfExpandedArray = intArray.capacity();
    int expectedSize = 1;
    int expectedCapacity = 20;
    
    assertEquals(valueInArray, expectedValue);
    assertEquals(sizeOfExpandedArray, expectedSize);
    assertEquals(capacityOfExpandedArray, expectedCapacity);
  }
  
  @Test
  public void testEqualsAgainstArrayOfDifferentSize() {
    intArray.insert(1);
    intArray.insert(2);
    intArray.insert(3);
    
    secondIntArray = new Array(INT_ARRAY_CAPACITY);
    secondIntArray.insert(1);
    
    assertFalse(intArray.equals(secondIntArray));
    assertFalse(secondIntArray.equals(intArray));
  }
  
  @Test
  public void testEqualsAgainstArrayWithSameElements() {
    intArray.insert(1);
    intArray.insert(2);
    intArray.insert(3);
    
    secondIntArray = new Array(INT_ARRAY_CAPACITY);
    secondIntArray.insert(1);
    secondIntArray.insert(2);
    secondIntArray.insert(3);
    
    assertTrue(intArray.equals(secondIntArray));
    assertTrue(secondIntArray.equals(intArray));
  }
  
  @Test
  public void testEqualsAgainstArrayWithSameElementsByOrderButDifferentPositions() {
    intArray.insert(1);
    intArray.insert(2);
    intArray.insert(3);
    
    secondIntArray = new Array(INT_ARRAY_CAPACITY);
    secondIntArray.insert(1);
    secondIntArray.insert(2);
    secondIntArray.insert(3, 3);
    
    assertFalse(intArray.equals(secondIntArray));
    assertFalse(secondIntArray.equals(intArray));
  }
  
  @Test
  public void testHashingArrays() {
    HashMap<Array, Integer> map = new HashMap<Array, Integer>();
    
    intArray.insert(1);
    intArray.insert(2);
    intArray.insert(3);
    
    secondIntArray = new Array(INT_ARRAY_CAPACITY);
    secondIntArray.insert(1);
    secondIntArray.insert(2);
    secondIntArray.insert(3, 3);
    
    int intArrayHashValue = 0;
    int secondIntArrayHashValue = 99;
    
    map.put(intArray, intArrayHashValue);
    map.put(secondIntArray, secondIntArrayHashValue);
    
    assertEquals((int) map.get(intArray), intArrayHashValue);
    assertEquals((int) map.get(secondIntArray), secondIntArrayHashValue);
  }
}
