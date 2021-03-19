package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = numInput[0]; //number count we have to add in stack (push)
        int s = numInput[1]; //numbers count we have to Pop
        int x = numInput[2]; // check wether x

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            int number = numbers[i];
            stack.push(number);
        }

        while (s > 0 && !stack.isEmpty()) {
            stack.pop();
            s--;
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        }else if (stack.contains(x)) {
            System.out.println("true");
        } else {
            // get current min element
            int minElement = getMinElement(stack);
            System.out.println(minElement);
        }

    }

    public static int getMinElement (ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            min = Math.min(min, stack.pop());
        }
        return min;
    }
}
