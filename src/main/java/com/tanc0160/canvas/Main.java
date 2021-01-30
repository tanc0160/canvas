package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.ConsoleOutput;
import com.tanc0160.canvas.output.Drawable;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Canvas canvas = null;
        final Drawable output = new ConsoleOutput();
        while (!input.equals("Q")) {
            System.out.print("enter command: ");
            input = sc.nextLine();
            if (input.length() > 0) {
                String[] list = input.split(" ");
                switch (list[0].charAt(0)) {
                    case 'C':
                        if (isInputSizeCorrect(list, 3)) {
                            canvas = new Canvas(
                                    Integer.parseInt(list[1]),
                                    Integer.parseInt(list[2])
                            );
                            canvas.print(output);
                        } else {
                            System.out.println("Wrong input command size");
                        }
                        break;
                    case 'B':
                        if (isInputSizeCorrect(list, 4)) {
                            if (canvas == null)
                                System.out.println("Canvas must be initialized first, " +
                                        "please use C w h");
                            else {
                                canvas.fill(new Point(list[1], list[2]), list[3].charAt(0));
                                canvas.print(output);
                            }
                        } else
                            System.out.println("Wrong input command size");
                        break;
                    case 'R':
                        if (isInputSizeCorrect(list, 5)) {
                            if (canvas == null)
                                System.out.println("Canvas must be initialized first, " +
                                        "please use C w h");
                            else {
                                canvas.drawRectangle(
                                        new Point(list[1], list[2]),
                                        new Point(list[3], list[4])
                                );
                                canvas.print(output);
                            }
                        } else
                            System.out.println("Wrong input command size");
                        break;
                    case 'L':
                        if (isInputSizeCorrect(list, 5)) {
                            if (canvas == null)
                                System.out.println("Canvas must be initialized first, " +
                                        "please use C w h");
                            else {
                                canvas.drawLine(
                                        new Point(list[1], list[2]),
                                        new Point(list[3], list[4])
                                );
                                canvas.print(output);
                            }
                        } else
                            System.out.println("Wrong input command size");
                        break;
                    case 'Q':
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            }
        }
    }

    private static boolean isInputSizeCorrect(final String[] inputs,
                                              final int expectedSize) {
        return inputs.length == expectedSize;
    }
}
