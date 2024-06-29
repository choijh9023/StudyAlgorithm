import algorithm.Stack.IntStack;

public class Main {
    public static void main(String[] args) {

        IntStack intStack = new IntStack(3);
        intStack.push(3);
        intStack.push(4);
        intStack.push(10);

        System.out.println(
                intStack.peek());

        System.out.println(intStack.indexOf(4));
        System.out.println(intStack.isEmpty());
        intStack.printStack();
        System.out.println(intStack.isEmpty());
        System.out.println(intStack.getCapacity());

        IntStack secondStack = new IntStack(10);
        System.out.println(secondStack.getCapacity());

            }
}