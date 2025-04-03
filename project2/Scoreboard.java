package project2;

import java.io.BufferedReader;
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

            }
        } finally {
            listener.close();
        }
    }

}

class Game {
    private String[] players = new String[2];
    private int white, whiteKings, black, blackKings, currentPlayer;
    

    class ScoreKeeper {
        Socket socket;
        BufferedReader input;
        PrintWriter output;
    }
}