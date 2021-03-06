/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import hangman.Game;
import hangman.Hangman;
import hangman.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class HangmanServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(8888);
            Socket socket=serverSocket.accept();
            Hangman game = new Hangman();
            Player player = new NetworkPlayer(socket);
            game.playGame(player);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
