package Collection;

/**
 * A linked list.
 * @param <T> the type of the objects to be stored in the list.
 */
public class List<T> {
  private int size;
  private Link<T> head;
  private Link<T> tail;
  
  public List() {
    size = 0;
  }
  
  // TODO: copy constructor
  
  // TODO: clone method
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  /**
   * Get the object at the specified index.
   * @param index the index of the item to get.
   * @return the object at the specified index.
   * @throws Exception when the index provided is invalid.
   */
  public T at(int index) throws Exception {
    if (index < 0 || index >= size) {
      throw new Exception("Invalid index provided: " + index);
    }
    
    Link<T> currentLink = head;
    for (int currentIndex = 0; currentIndex < index; ++currentIndex){
      currentLink = currentLink.next;
    }
    return currentLink.data;
  }
  
  /**
   * Add an object to the end of the list.
   * @param data the object to add to the list.
   */
  public void add(T data) {
    try {
      add(data, size);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Add an object to the list at the specified index.
   * @param data the object to add to the list.
   * @param index the index to insert the object at.
   * @throws Exception when the index specified is invalid.
   */
  public void add(T data, int index) throws Exception {
    if (index > size || index < 0) {
      throw new Exception("Invalid index specified: " + index);
    }
    
    // Find link to insert before. 
    Link<T> newLink = new Link<T>(data);
    Link<T> linkToInsertBefore = head;
    for (int currentIndex = 0; currentIndex < index; ++currentIndex) {
      linkToInsertBefore = linkToInsertBefore.next;
    }
    
    // Update join point links.
    newLink.next = linkToInsertBefore;
    if (linkToInsertBefore != null) {
      newLink.prev = linkToInsertBefore.prev;
      if (linkToInsertBefore.prev != null) {
        linkToInsertBefore.prev.next = newLink;
      }
      linkToInsertBefore.prev = newLink;
    } else if (size != 0) {
      newLink.prev = tail;
      tail.next = newLink;
    }
    
    // Update head and tail.
    if (index == 0) {
      head = newLink;
    }
    if (index == size) {
      tail = newLink;
    }
    
    ++size;
  }
  
  /**
   * Remove the object at the specified index.
   * @param index the index of the object to remove.
   * @throws Exception when the index specified is invalid.
   */
  public void remove(int index) throws Exception{
    if (index < 0 || index >= size) {
      throw new Exception("Invalid index specified: " + index);
    }
    
    // Find the link to remove.
    Link<T> currentLink = head;
    for (int currentIndex = 0; currentIndex < index; ++currentIndex) {
      currentLink = currentLink.next;
    }

    // Remove the link.
    if (currentLink.next != null) {
      currentLink.next.prev = currentLink.prev;
    }
    if (currentLink.prev != null) {
      currentLink.prev.next = currentLink.next;
    }
    
    // Update the head and tail.
    if (index == 0) {
      head = currentLink.next;
    }
    if (index == size - 1) {
      tail = currentLink.prev;
    }
    
    currentLink.next = null;
    currentLink.prev = null;
    --size;
  }
  
  /**
   * Get the object at the front of the list.
   * @return the object at the front of the list. 
   */
  public T front() throws Exception {
    if (size == 0) {
      return null;
    }
    return head.data;
  }
  
  /**
   * Get the object at the back of the list.
   * @return the object at the back of the list.
   */
  public T back(){
    if (size == 0) {
      return null;
    }
    return tail.data;
  }
  
  /**
   * Determines whether the list contains the specified object.
   * @param data the object to search in the list.
   * @return whether the list contains the specified object.
   */
  public boolean contains(T data) {
    Link<T> currentLink = head;
    for (int index = 0; index < size; ++index) {
      if (currentLink.data.equals(data)) {
        return true;
      }
      currentLink = currentLink.next;
    }
    return false;
  }
  
  /**
   * Remove all objects from the list.
   */
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }
  
  public String toString() {
    StringBuilder listString = new StringBuilder();
    Link<T> currentLink = head;
    for (int index = 0; index < size; ++index) {
      if (index > 0) {
        listString.append(", ");
      }
      listString.append(currentLink.data);
      currentLink = currentLink.next;
    }
    return listString.toString();
  }
  
  public boolean equals(List<T> argList) {
    if (size != argList.size) {
      return false;
    }
    
    Link<T> currentLink = head;
    Link<T> argListCurrentLink = argList.head;
    for (int currentIndex = 0; currentIndex < size; ++currentIndex) {
      if (!currentLink.data.equals(argListCurrentLink.data)) {
        return false;
      }
      currentLink = currentLink.next;
      argListCurrentLink = argListCurrentLink.next;
    }
    return true;
  }
  
  public int hashCode() {
    int result = 17;
    Link<T> currentLink = head;
    for (int currentIndex = 0; currentIndex < size; ++currentIndex){
      result = 31 * result + currentLink.data.hashCode();
    }
    return result;
  }
  
  /**
   * A link in a linked list.
   * @param <T>
   */
  private class Link<T> {
    private T data;
    private Link<T> prev;
    private Link<T> next;
    
    public Link(T data) {
      this.data = data;
    }
  }
  
}
