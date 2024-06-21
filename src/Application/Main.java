package Application;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch match = new ChessMatch();

        while (true){
            try {
                UI.clearScreen();
                UI.printBoard(match.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = match.performChessMove(source, target);
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

    }
}