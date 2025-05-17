/**
 * Класс MyStack представляет собой реализацию стека с использованием массива.
 * @param <T> тип элементов стека
 */
public class MyStack<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] elements;
  private int size;
    
  /**
  * Создает пустой стек с начальной емкостью по умолчанию.
  */
  public MyStack() {
    this.elements = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }
    
  /**
  * Создает пустой стек с указанной начальной емкостью.
  * @param initialCapacity начальная емкость стека
  * @throws IllegalArgumentException если начальная емкость отрицательна
  */
  public MyStack(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
    this.elements = new Object[initialCapacity];
    this.size = 0;
  }
    
  /**
  * Проверяет, пуст ли стек.
  * @return true если стек пуст, false в противном случае
  */
  public boolean isEmpty() {
    return size == 0;
  }
    
  /**
  * Добавляет элемент на вершину стека.
  * @param element элемент для добавления
  */
  public void push(T element) {
    ensureCapacity();
    elements[size++] = element;
  }
    
  /**
  * Удаляет и возвращает элемент с вершины стека.
  * @return элемент с вершины стека
  * @throws IllegalStateException если стек пуст
  */
  @SuppressWarnings("unchecked")
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Стек пуст");
    }
    T element = (T) elements[--size];
    elements[size] = null; // для сборщика мусора
    return element;
  }
    
  /**
  * Возвращает элемент с вершины стека без его удаления.
  * @return элемент с вершины стека
  * @throws IllegalStateException если стек пуст
  */
  @SuppressWarnings("unchecked")
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Стек пуст");
    }
    return (T) elements[size - 1];
  }
    
  /**
  * Меняет местами два верхних элемента стека.
  * @throws IllegalStateException если в стеке меньше двух элементов
  */
  public void swapTopTwo() {
    if (size < 2) {
      throw new IllegalStateException("Стек содержит менее двух элементов");
    }
    Object temp = elements[size - 1];
    elements[size - 1] = elements[size - 2];
    elements[size - 2] = temp;
  }
    
  /**
  * Удаляет первое вхождение указанного элемента из стека.
  * @param element элемент для удаления
  * @return true если элемент был найден и удален, false в противном случае
  */
  public boolean removeFirstOccurrence(T element) {
    for (int i = size - 1; i >= 0; i--) {
      if ((element == null && elements[i] == null) || 
        (element != null && element.equals(elements[i]))) {
          removeElementAt(i);
          return true;
      }
    }
    return false;
  }
    
  /**
  * Возвращает строковое представление стека.
  * @return строковое представление стека
  */
  public String toString() {
    if (isEmpty()) {
      return "[]";
    }
        
    StringBuilder sb = new StringBuilder("[");
    for (int i = size - 1; i >= 0; i--) {
      sb.append(elements[i]);
      if (i > 0) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
    
  private void ensureCapacity() {
    if (size == elements.length) {
      int newCapacity = elements.length * 2;
      Object[] newElements = new Object[newCapacity];
      System.arraycopy(elements, 0, newElements, 0, size);
      elements = newElements;
    }
  }
    
  private void removeElementAt(int index) {
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(elements, index + 1, elements, index, numMoved);
    }
    elements[--size] = null;
  }
}