import java.util.EmptyStackException;
import java.util.InputMismatchException;
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
      demoStack(String.class);
    } else {
      demoStack(Integer.class);
    }
  }
    
  private static <T> void demoStack(Class<T> type) {
    MyStack<T> stack = new MyStack<>();
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
            System.out.print("Введите значение для добавления: ");
            T value = readValue(type);
            stack.push(value);
            System.out.println("Элемент добавлен");
            break;
          case 3:
            try {
              T popped = stack.pop();
              System.out.println("Извлеченный элемент: " + popped);
            } catch (EmptyStackException e) {
              System.out.println("Ошибка: попытка извлечь элемент из пустого стека");
            }
            break;
          case 4:
            try {
              T peeked = stack.peek();
              System.out.println("Элемент на вершине: " + peeked);
            } catch (EmptyStackException e) {
              System.out.println("Ошибка: стек пуст");
            }
            break;
          case 5:
            try {
              stack.swapTopTwo();
              System.out.println("Верхние элементы поменяны местами");
            } catch (IllegalStateException e) {
              System.out.println("Ошибка: недостаточно элементов для обмена");
            }
            break;
          case 6:
            System.out.print("Введите значение для удаления: ");
            T toRemove = readValue(type);
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
          default:
            System.out.println("Неизвестная команда. Пожалуйста, выберите действие от 1 до 8.");
            break;
          }
      } catch (InputMismatchException e) {
        System.out.println("Ошибка: неверный формат ввода");
        scanner.nextLine();
      }
      System.out.println();
    }
  }
    
  @SuppressWarnings("unchecked")
  private static <T> T readValue(Class<T> type) {
    if (type == String.class) {
      return (T) scanner.nextLine();
    } else if (type == Integer.class) {
      return (T) Integer.valueOf(readInt());
    }
    throw new IllegalArgumentException("Неподдерживаемый тип");
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