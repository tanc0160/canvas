package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.OutputFactory;
import com.tanc0160.canvas.output.Outputable;
import com.tanc0160.canvas.service.CanvasService;
import com.tanc0160.canvas.service.CanvasServiceImpl;

import java.util.Scanner;

import static com.tanc0160.canvas.output.OutputFactory.OutputType.CONSOLE;


public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        String input = "";
        final CanvasService canvasService = new CanvasServiceImpl();
        final Outputable output = OutputFactory.getOutput(CONSOLE);
        while (!input.equals("Q")) {
            System.out.print("enter command: ");
            input = sc.nextLine();
            if (input.length() > 0) {
                try {
                    String[] list = input.split(" ");
                    switch (list[0].charAt(0)) {
                        case 'C':
                            if (isInputSizeCorrect(list, 3)) {
                                canvasService.create(
                                        Integer.parseInt(list[1]),
                                        Integer.parseInt(list[2])
                                );
                                canvasService.print(output);
                            } else {
                                System.out.println("Wrong input command size");
                            }
                            break;
                        case 'B':
                            if (isInputSizeCorrect(list, 4)) {
                                canvasService.fill(new Point(list[1], list[2]), list[3].charAt(0));
                                canvasService.print(output);
                            } else
                                System.out.println("Wrong input command size");
                            break;
                        case 'R':
                            if (isInputSizeCorrect(list, 5)) {
                                canvasService.drawRectangle(
                                        new Point(list[1], list[2]),
                                        new Point(list[3], list[4])
                                );
                                canvasService.print(output);
                            } else
                                System.out.println("Wrong input command size");
                            break;
                        case 'L':
                            if (isInputSizeCorrect(list, 5)) {
                                canvasService.drawLine(
                                        new Point(list[1], list[2]),
                                        new Point(list[3], list[4])
                                );
                                canvasService.print(output);
                            } else
                                System.out.println("Wrong input command size");
                            break;
                        case 'Q':
                            break;
                        default:
                            System.out.println("Wrong input");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }
    }

    private static boolean isInputSizeCorrect(final String[] inputs,
                                              final int expectedSize) {
        return inputs.length == expectedSize;
    }
}
