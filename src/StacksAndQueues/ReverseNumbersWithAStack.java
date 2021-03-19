package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        List<Integer> inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (Integer number : inputData) {
            numberStack.push(number);
        }


        while (!numberStack.isEmpty()) {
            int nnumber = numberStack.pop();
            System.out.print(nnumber + " ");
        }
    }
}
