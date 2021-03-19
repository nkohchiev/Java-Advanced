package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {

            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            switch (line[0]) {
                case 1:
                    //add number in stack
                    int number = line[1];
                    numberStack.push(number);
                    break;
                case 2: //remove top elemt -> pop()
                    if (!numberStack.isEmpty()) {
                        numberStack.pop();
                    }
                    break;
                case 3: // print max element
                    Integer maxNumber = Collections.max(numberStack);
                    System.out.println(maxNumber);
                    break;
            }
        }


    }

    public static int getMaxElement(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            max = Math.min(max, stack.pop());
        }
        return max;
    }
}
