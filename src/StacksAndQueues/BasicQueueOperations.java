package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLineInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = firstLineInput[0];
        int s = firstLineInput[1];
        int x = firstLineInput[2];

        ArrayDeque<Integer> numberQueue = new ArrayDeque<>();

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n ; i++) {
            int num = numbers[i];
            numberQueue.offer(num);
        }

        for (int i = 0; i < s ; i++) {
            if (!numberQueue.isEmpty()){
                numberQueue.poll();
            }

        }

        if (numberQueue.isEmpty()) {
            System.out.println("0");
        } else if (numberQueue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numberQueue));
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
