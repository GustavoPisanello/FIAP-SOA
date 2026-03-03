package ui;

import application.GameEngine;
import domain.Mission;
import domain.Player;
import service.BasicMissionValidatorService;
import service.MissionValidatorService;
import service.ScoreService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame(){
        GameEngine game = new GameEngine();
        ScoreService score = new ScoreService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao jogo! Qual seu nome de usuário? ");

        String playerUserName = scanner.nextLine();

        Player player = new Player(playerUserName);

        String exitKey = "q";

        String userKey = "";

        do {

            int playerScore = player.getScore();

            if (playerScore == 0){
                System.out.println("Parece que é sua primeira vez aqui, " + playerUserName + "!");
            }

            System.out.println("Qual missão decide enfrentar? Seu score: " + playerScore);

            System.out.println("[1]: Missão básica; ");
            System.out.println("[2]: Missão avançada; ");

            int selectedMission = scanner.nextInt();

            if (selectedMission == 1){
                Mission mission = new Mission("Missão básica", 1);

                int[] results = game.executeMission(player, mission, score);

                if (results[0] == 1){
                    System.out.println("Você conseguiu! Passou da missão, e isso te retornou " + results[1] +" pontos!");
                } else {
                    System.out.println("Você perdeu " + Math.abs(results[2]) + " pontos ;(");
                }

            }

            if (selectedMission == 2){
                Mission mission = new Mission("Missão avançada", 6);

                int[] results = game.executeAdvancedMission(player, mission, score);

                if (results[0] == 1){
                    System.out.println("Você conseguiu! Passou da missão, e isso te retornou" + results[1] +" pontos!");
                } else {
                    System.out.println("Você perdeu" + results[2] + "pontos ;(");
                }

            }

            System.out.println("Deseja continuar?");
            userKey = scanner.nextLine();

        } while (!userKey.equals(exitKey.toLowerCase()));

    }
}