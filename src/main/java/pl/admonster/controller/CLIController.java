package pl.admonster.controller;

import pl.admonster.model.board.Board;
import pl.admonster.model.board.Checkerboard;
import pl.admonster.model.movingObject.Bird;
import pl.admonster.model.movingObject.MovingObject;
import pl.admonster.service.Game;

import java.awt.*;
import java.util.Scanner;

public class CLIController {

    private static Game game;
    public static void start(){
        System.out.println("Welcome to PointeesGame!");
        System.out.println("If you want to finish game type non-digit character or string, when prompted to type anything.");

        initializeGame();
        playGame();
        sumUpGame();
    }

    private static void initializeGame() {
        Board gameBoard = new Checkerboard();
        MovingObject movingObject = new Bird();
        game = new Game(gameBoard, movingObject);

        Point typedIn;
        do {
            System.out.println("Please select field you would like to redeem.");
            typedIn = askUserForNewCoordinates();
        } while (!gameBoard.contains(typedIn));

        game.setSelectedToRedeem(typedIn);
    }

    private static void playGame() {
        while (game.isNotfinshed()) {
            System.out.println("ROUND NUMBER " + game.getRoundNumber());
            System.out.println("Please select field for Bird to start flying.");
            Point typedIn = askUserForNewCoordinates();
            while (!game.getGameBoard().contains(typedIn)) {
                System.out.println("Typed coordinates out of gameboard. Please type again");
                typedIn = askUserForNewCoordinates();
            }
            game.playRound(typedIn);
            System.out.println(game.getGameBoard());
        }
    }

    private static void sumUpGame() {
    }

    public static Point askUserForNewCoordinates(){
        Scanner s = new Scanner(System.in);
        Point typedPoint;
        System.out.println("Type X coordinate: ");
        typedPoint = new Point();
        try {
            typedPoint.x = Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            gameFinishedByUser();
        }
        System.out.println("Type Y coordinate: ");
        try {
            typedPoint.y = Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            gameFinishedByUser();
        }
        return typedPoint;
    }

    private static void gameFinishedByUser(){
        System.out.println("Typed string is not valid number. Game over.");
        System.exit(0);
    }

}
