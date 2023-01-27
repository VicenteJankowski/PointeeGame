package org.example;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Point newBirdPosition = new Point();
        Checkerboard gameBoard = new Checkerboard();

        System.out.println(gameBoard);

        Scanner s = new Scanner(System.in);
        while(!s.next().equals("x")) {
            System.out.println("Podaj nową pozycję x: ");
            newBirdPosition.x = Integer.parseInt(s.next());
            System.out.println("Podaj nową pozycję y: ");
            newBirdPosition.y = Integer.parseInt(s.next());

            gameBoard.birdApproachesToField(newBirdPosition);
            System.out.println(gameBoard);
        }

    }

    static void clearConsole(){
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else
                Runtime.getRuntime().exec("clear");
        } catch (InterruptedException|IOException e) {
            throw new RuntimeException(e);
        }
    }
}
