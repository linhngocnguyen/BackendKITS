package org.example;

import games.GameRunner;
import games.Mario;
import games.Pacman;
import games.SuperContra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Mario myMario = new Mario();
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        switch (option) {
            case 1:
                Pacman myPacman = new Pacman();
                GameRunner myGameRunner = new GameRunner(myPacman);
                myGameRunner.run();
            case 2:
                Mario myMario = new Mario();
                myGameRunner = new GameRunner(myMario);
                myGameRunner.run();
            case 3:
                SuperContra mySuperContra = new SuperContra();
                myGameRunner = new GameRunner(mySuperContra);
                myGameRunner.run();
        }
    }
}