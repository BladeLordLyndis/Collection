package CollectionTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Collection.List;

public class ListTest {
  private List<String> stringList;
  private List<String> comparisonList;
  
  @Before
  public void init() {
    stringList = new List<String>();
  }
  
  @Test
  public void testToString() throws Exception {
    stringList.add("Duran");
    stringList.add("Lise");
    stringList.add("Hawk");
    stringList.add("Angela");
    stringList.add("Kevin");
    stringList.add("Carlie");
    
    String stringListString = stringList.toString();
    String expectedString = "Duran, Lise, Hawk, Angela, Kevin, Carlie";
    assertEquals(stringListString, expectedString);
  }
  
  @Test
  public void testAddInDifferentIndexes() throws Exception {
    stringList.add("Jarvan IV");
    stringList.add("LeBlanc", 0);
    stringList.add("Sona", 0);
    stringList.add("Irelia", 3);
    stringList.add("Olaf");
    stringList.add("Darius");
    stringList.add("Jax", 0);
    
    String stringListString = stringList.toString();
    String expectedString = "Jax, Sona, LeBlanc, Jarvan IV, Irelia, Olaf, Darius";
    assertEquals(stringListString, expectedString);
    
    int listSize = stringList.size();
    int expectedSize = 7;
    assertEquals(listSize, expectedSize);
  }
  
  @Test
  public void testAtWithValidIndexes() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    String itemAtIndex0 = stringList.at(0);
    String itemAtIndex1 = stringList.at(1);
    String itemAtIndex2 = stringList.at(2);
    
    String expectedAtIndex0 = "Fighter";
    String expectedAtIndex1 = "Knight";
    String expectedAtIndex2 = "Paladin";
    
    assertEquals(itemAtIndex0, expectedAtIndex0);
    assertEquals(itemAtIndex1, expectedAtIndex1);
    assertEquals(itemAtIndex2, expectedAtIndex2);
  }
  
  @Test(expected=Exception.class)
  public void testAtWithIndexTooLarge() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    stringList.at(3);
  }
  
  @Test(expected=Exception.class)
  public void testAtWithNegativeIndex() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    stringList.at(-1);
  }
  
  @Test
  public void testFront() throws Exception {
    stringList.add("Jarvan IV");
    stringList.add("LeBlanc", 0);
    stringList.add("Sona", 0);
    stringList.add("Irelia", 3);
    stringList.add("Olaf");
    stringList.add("Darius");
    stringList.add("Jax", 0);
    
    String frontItemInList = stringList.front();
    String expectedValue = "Jax";
    assertEquals(frontItemInList, expectedValue);
  }
  
  @Test
  public void testBack() throws Exception {
    stringList.add("Jarvan IV");
    stringList.add("LeBlanc", 0);
    stringList.add("Sona", 0);
    stringList.add("Irelia", 3);
    stringList.add("Olaf");
    stringList.add("Darius");
    stringList.add("Jax", 0);
    
    String backItemInList = stringList.back();
    String expectedValue = "Darius";
    assertEquals(backItemInList, expectedValue);
  }
  
  @Test
  public void testContainsOnSuccess() throws Exception {
    stringList.add("Jarvan IV");
    stringList.add("LeBlanc", 0);
    stringList.add("Sona", 0);
    stringList.add("Irelia", 3);
    stringList.add("Olaf");
    stringList.add("Darius");
    stringList.add("Jax", 0);
    
    boolean isItemInList = stringList.contains("Irelia");
    assertTrue(isItemInList);
  }
  
  @Test
  public void testContainsOnFailure() throws Exception {
    stringList.add("Jarvan IV");
    stringList.add("LeBlanc", 0);
    stringList.add("Sona", 0);
    stringList.add("Irelia", 3);
    stringList.add("Olaf");
    stringList.add("Darius");
    stringList.add("Jax", 0);
    
    boolean isItemInList = stringList.contains("Shyvana");
    assertFalse(isItemInList);
  }
  
  @Test
  public void testClear() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    stringList.clear();
    
    int sizeOfClearedList = stringList.size();
    int expectedSize = 0;
    assertEquals(sizeOfClearedList, expectedSize);
    
    String stringListString = stringList.toString();
    String expectedString = "";
    assertEquals(stringListString, expectedString);
  }
  
  @Test
  public void testRemoveFirstElement() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    stringList.remove(0);
    String newFirstString = stringList.at(0);
    String expectedString = "Knight";
    assertEquals(newFirstString, expectedString);
    
    stringList.add("Sword Master", 0);
    newFirstString = stringList.at(0);
    expectedString = "Sword Master";
    assertEquals(newFirstString, expectedString);
    
    int listSize = stringList.size();
    int expectedSize = 3;
    assertEquals(listSize, expectedSize);
    
    String stringListString = stringList.toString();
    expectedString = "Sword Master, Knight, Paladin";
    assertEquals(stringListString, expectedString);
    
    String front = stringList.front();
    expectedString = "Sword Master";
    assertEquals(front, expectedString);
    
    String back = stringList.back();
    expectedString = "Paladin";
    assertEquals(back, expectedString);
  }
  
  @Test
  public void testRemoveLastElement() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    stringList.remove(2);
    String newLastString = stringList.at(1);
    String expectedString = "Knight";
    assertEquals(newLastString, expectedString);
    
    stringList.add("Sword Master", 2);
    newLastString = stringList.at(2);
    expectedString = "Sword Master";
    assertEquals(newLastString, expectedString);
    
    int listSize = stringList.size();
    int expectedSize = 3;
    assertEquals(listSize, expectedSize);
    
    String stringListString = stringList.toString();
    expectedString = "Fighter, Knight, Sword Master";
    assertEquals(stringListString, expectedString);
    
    String front = stringList.front();
    expectedString = "Fighter";
    assertEquals(front, expectedString);
    
    String back = stringList.back();
    expectedString = "Sword Master";
    assertEquals(back, expectedString);
  }
  
  @Test
  public void testEqualsOnSameList() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    comparisonList = new List<String>();
    comparisonList.add("Fighter");
    comparisonList.add("Knight");
    comparisonList.add("Paladin");
    
    assertTrue(stringList.equals(comparisonList));
    assertTrue(comparisonList.equals(stringList));
  }
  
  @Test
  public void testEqualsOnListsOfEqualSizeDifferentElements() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    comparisonList = new List<String>();
    comparisonList.add("Fighter");
    comparisonList.add("Knight");
    comparisonList.add("Duelist");
    
    assertFalse(stringList.equals(comparisonList));
    assertFalse(comparisonList.equals(stringList));
  }
  
  @Test
  public void testEqualsOnListsOfDifferentSize() throws Exception {
    stringList.add("Fighter");
    stringList.add("Knight");
    stringList.add("Paladin");
    
    comparisonList = new List<String>();
    comparisonList.add("Fighter");
    comparisonList.add("Knight");
    comparisonList.add("Paladin");
    comparisonList.add("Lord");
    
    assertFalse(stringList.equals(comparisonList));
    assertFalse(comparisonList.equals(stringList));
  }
}
