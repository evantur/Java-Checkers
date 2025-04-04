package project1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

public class CheckersClient {
    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private JFrame game;
    private Board board;

    public CheckersClient(String serverAddress) throws Exception {

        // Setup networking
        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        
        game = new JFrame(); //creates new frame

        //set the frame's main settings
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane();
        game.pack();
        game.setSize(340,454);
        game.setResizable(false); //the window is not resizable
        game.setLayout(null);
        game.setVisible(true);
        game.setBackground(new Color(225, 225, 225));

        //creates new Board and adds its components
        board = new Board(socket, in, out);
        game.add(board);
        game.add(board.title);
        game.add(board.newGame);
        game.add(board.howToPlay);        
        game.add(board.message);

        //places components on the frame in the correct places
        board.setBounds(0,80,324,324);
        board.title.setBounds(0,0,324,50);
        board.newGame.setBounds(6, 50, 100, 30);
        board.howToPlay.setBounds(112, 50, 100, 30);
        board.credits.setBounds(218, 50, 100, 30);
        board.message.setBounds(0, 404, 324, 30);
    }

    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost";
        CheckersClient client = new CheckersClient(serverAddress);
    }
}
