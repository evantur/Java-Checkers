package project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class Scoreboard {
    private JFrame sb = new JFrame("Live Scoreboard");
    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8905);
        System.out.println("Scoreboard server is running");
        try {
            while (true) {
                ScoreKeeper sk = new ScoreKeeper();
                ScoreKeeper.Game game = sk.new Game(listener.accept());
            }
        } finally {
            listener.close();
        }
    }

}

class ScoreKeeper {
    private String[] players = new String[2];
    private int white, whiteKings, black, blackKings, currentPlayer;
    private Game sk;

    // TODO
    public boolean drawReached() {
        return false;
    }

    public boolean hasWinner() {
        if (white == 0 || black == 0) return true;
        else return false;
    }
    

    class Game {
        Socket socket;
        BufferedReader input;
        PrintWriter output;

        public Game(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {}
        }
    }
}