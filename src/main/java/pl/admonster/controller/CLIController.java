package pl.admonster.controller;

import pl.admonster.model.board.Board;
import pl.admonster.model.board.BoardField;
import pl.admonster.model.board.Checkerboard;
import pl.admonster.model.movingObject.Bird;
import pl.admonster.model.movingObject.MovingObject;
import pl.admonster.model.pointee.Pointee;
import pl.admonster.service.Game;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class CLIController {

    private static Game game;
    public static void start(){
        System.out.println("Welcome to PointeesGame!");
        System.out.println("X axis is vertical, Y axis is horizontal. Coordinates of top left field are (0, 0)");
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
            if(game.isPossibleToFinish())
                askUserIfWishToContinue();
        }
    }

    private static void askUserIfWishToContinue() {
        System.out.println("You have reached round number " + (game.getRoundNumber() - 1));
        System.out.println("Would you like to finish now and redeem coupon or continue?");
        System.out.println("Type 1 if you want to finish or 2 if you wish to continue.");

        switch (askUserForOneOfIntOptions(new ArrayList<>(Arrays.asList(1, 2)))) {
            case 1:
                game.finish();
                break;
            case 2:
                break;
            case -1:
                System.out.println("Could not obtain chosen option. Game over.");
                appFinshedByUser();
        }
    }

    private static int askUserForOneOfIntOptions(List<Integer> options) {
        Scanner s = new Scanner(System.in);
        boolean succeed = false;
        int selectedOption = -1;

        while (!succeed) {
            try {
                selectedOption = Integer.parseInt(s.next());
            } catch (NumberFormatException e) {
                appFinshedByUser();
            }
            if (!options.contains(selectedOption))
                System.out.println("Not a valid option. Type again.");
            else
                succeed = true;
        }
        return selectedOption;
    }

    private static void sumUpGame() {
        int pointOnSelectedBoardField = game.getSelectedToRedeem().getPointeesOn().stream().mapToInt(Pointee::getValue).sum();
        List<BoardField> boardFieldsWithMaxValues = getBoardFieldsWithMaxValues();

        System.out.println("############# GAME SCORE #############");
        System.out.println("Maximum Pointees on single Coupon: " + boardFieldsWithMaxValues.get(0).sumPointeesValues());
        System.out.println("Coupon with max points are located on:");
        for (BoardField single : boardFieldsWithMaxValues)
            System.out.println("X=" + single.getCoordinates().getX()
                            + " Y=" + single.getCoordinates().getY());
        System.out.println("Coupon selected to redeem is located on: X="
                        + game.getSelectedToRedeem().getCoordinates().getX()
                + " Y=" + game.getSelectedToRedeem().getCoordinates().getY());
        System.out.println("You have accumulated " + pointOnSelectedBoardField + " points on your coupon selected to redeem.");
        System.out.println("Thank you for playing a game!");
    }

    private static List<BoardField> getBoardFieldsWithMaxValues() {
        Optional<Integer> maxPointeesPointsOnField = Arrays.stream(game.getGameBoard().getFields())
                .flatMap(Arrays::stream)
                .map(BoardField::sumPointeesValues)
                .max(Integer::compareTo);

        return Arrays.stream(game.getGameBoard().getFields())
                .flatMap(Arrays::stream)
                .filter(singleField -> maxPointeesPointsOnField.get().equals(singleField.sumPointeesValues()))
                .collect(Collectors.toList());
    }

    public static Point askUserForNewCoordinates(){
        Scanner s = new Scanner(System.in);
        Point typedPoint;
        System.out.println("Type X coordinate: ");
        typedPoint = new Point();
        try {
            typedPoint.x = Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            appFinshedByUser();
        }
        System.out.println("Type Y coordinate: ");
        try {
            typedPoint.y = Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            appFinshedByUser();
        }
        return typedPoint;
    }

    private static void appFinshedByUser(){
        System.out.println("Typed string is not valid number. Game over.");
        System.exit(0);
    }

}
