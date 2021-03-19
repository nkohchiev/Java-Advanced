package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> robots = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());

        String[] names = new String[robots.size()];
        int[] processTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] tokens = robots.get(i).split("-");
            String name = tokens[0];
            names[i] = name;
            int time = Integer.parseInt(tokens[1]);
            processTime[i] = time;
        }

        String startTime = scanner.nextLine();

        ArrayDeque<String> productQueue = new ArrayDeque<>();
        String inputProduct;
        while (!"End".equals(inputProduct = scanner.nextLine())) {
            productQueue.offer(inputProduct);
        }

        String[] timeData = startTime.split(":"); // 8 00 00
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        //convert in seconds
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotsWorkLeft = new int[robots.size()];

        while (!productQueue.isEmpty()) {
            //robot should take a product if they are available
            startTimeInSeconds++;
            String product = productQueue.poll();
            int index = -1; // assume that the robot is not available

            for (int i = 0; i < robotsWorkLeft.length ; i++) {
                if (robotsWorkLeft[i] > 0 ) {
                    //robot working
                    robotsWorkLeft[i]--;
                }

                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                //assign product to a robot
                robotsWorkLeft[index] = processTime[index];
                System.out.println(printRobotData(names[index], product, startTimeInSeconds));
            } else {
                // index -1 -> all robots are busy
                productQueue.offer(product);
            }
        }
    }

    public static String printRobotData(String robot, String product, int beginTime) {

        long seconds = beginTime % 60 ;
        long minutes = (beginTime / 60)  % 60;
        long hours  = (beginTime / (60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return String.format("%s - %s [%s]", robot, product, time);
    }
}
