import java.util.Scanner;

/**
* Демонстрационное приложение для работы с классом MyStack.
*/
class StackDemoApp {
  private static Scanner scanner = new Scanner(System.in);
    
  public static void main(String[] args) {
    System.out.println("Выберите тип элементов стека:");
    System.out.println("1. String (ссылочный тип)");
    System.out.println("2. Integer (примитивный тип int)");
        
    int choice = readIntInRange(1, 2);
        
    if (choice == 1) {
      demoStringStack();
    } else {
      demoIntStack();
    }
  }
    
  private static void demoStringStack()
  {
    MyStack<String> stack = new MyStack<String>();
    boolean running = true;
        
    while (running) {
      printMenu();
      int choice = readIntInRange(1, 8);
            
      try {
        switch (choice) {
          case 1:
            System.out.println("Стек " + (stack.isEmpty() ? "пуст" : "не пуст"));
            break;
          case 2:
            System.out.print("Введите строку для добавления: ");
            String str = scanner.nextLine();
            stack.push(str);
            System.out.println("Элемент добавлен");
            break;
          case 3:
            String popped = stack.pop();
            System.out.println("Извлеченный элемент: " + popped);
            break;
          case 4:
            String peeked = stack.peek();
            System.out.println("Элемент на вершине: " + peeked);
            break;
          case 5:
            stack.swapTopTwo();
            System.out.println("Верхние элементы поменяны местами");
            break;
          case 6:
            System.out.print("Введите строку для удаления: ");
            String toRemove = scanner.nextLine();
            boolean removed = stack.removeFirstOccurrence(toRemove);
            System.out.println(removed ? "Элемент удален" : "Элемент не найден");
            break;
          case 7:
            System.out.println("Содержимое стека (сверху вниз):");
            System.out.println(stack);
            break;
          case 8:
            running = false;
            break;
        }
      } catch (Exception e) {
        System.out.println("Ошибка: " + e.getMessage());
      }        
      System.out.println();
    }
  }
    
  private static void demoIntStack() {
    MyStack<Integer> stack = new MyStack<Integer>();
    boolean running = true;
        
    while (running) {
      printMenu();
      int choice = readIntInRange(1, 8);
            
      try {
        switch (choice) {
          case 1:
            System.out.println("Стек " + (stack.isEmpty() ? "пуст" : "не пуст"));
            break;
          case 2:
            System.out.print("Введите число для добавления: ");
            int num = readInt();
            stack.push(num);
            System.out.println("Элемент добавлен");
            break;
          case 3:
            int popped = stack.pop();
            System.out.println("Извлеченный элемент: " + popped);
            break;
          case 4:
            int peeked = stack.peek();
            System.out.println("Элемент на вершине: " + peeked);
            break;
          case 5:
            stack.swapTopTwo();
            System.out.println("Верхние элементы поменяны местами");
            break;
          case 6:
            System.out.print("Введите число для удаления: ");
            int toRemove = readInt();
            boolean removed = stack.removeFirstOccurrence(toRemove);
            System.out.println(removed ? "Элемент удален" : "Элемент не найден");
            break;
          case 7:
            System.out.println("Содержимое стека (сверху вниз):");
            System.out.println(stack);
            break;
          case 8:
            running = false;
            break;
        }
      } catch (Exception e) {
        System.out.println("Ошибка: " + e.getMessage());
      }    
      System.out.println();
    }
  }
    
  private static void printMenu() {
    System.out.println("Меню:");
    System.out.println("1. Проверить, пуст ли стек");
    System.out.println("2. Добавить элемент");
    System.out.println("3. Извлечь элемент");
    System.out.println("4. Посмотреть элемент на вершине");
    System.out.println("5. Поменять местами два верхних элемента");
    System.out.println("6. Удалить первое вхождение элемента");
    System.out.println("7. Вывести стек на экран");
    System.out.println("8. Выход");
    System.out.print("Выберите пункт: ");
  }
    
  private static int readInt() {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.print("Ошибка ввода. Введите целое число: ");
      }
    }
  }
    
  private static int readIntInRange(int min, int max) {
    while (true) {
      int value = readInt();
      if (value >= min && value <= max) {
        return value;
      }
      System.out.printf("Введите число от %d до %d: ", min, max);
    }
  }
}