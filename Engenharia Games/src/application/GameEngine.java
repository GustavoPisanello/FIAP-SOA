package application;

import domain.Mission;
import domain.Player;
import service.AdvancedMissionValidatorService;
import service.BasicMissionValidatorService;
import service.ScoreService;

public class GameEngine {

    private BasicMissionValidatorService basicValidator;
    private AdvancedMissionValidatorService advancedValidator;

    public GameEngine(){
        this.basicValidator = new BasicMissionValidatorService();
    }

    public int[] executeMission(Player player, Mission mission, ScoreService score){

        boolean success = basicValidator.validate(mission);

        int successPoints = mission.getDifficulty() * 10;
        int unsuccessPoints = -5;

        if (success){
            score.addScore(successPoints, player);
        } else {
            score.addScore(unsuccessPoints, player);
        }

        return new int[] {
            success ? 1 : 0,
                successPoints,
                unsuccessPoints

        };
    };

    public int[] executeAdvancedMission(Player player, Mission mission, ScoreService score){

        boolean success = basicValidator.validate(mission);

        int successPoints = mission.getDifficulty() * 100;
        int unsuccessPoints = -50;

        if (success){
            score.addScore(successPoints, player);
        } else {
            score.addScore(unsuccessPoints, player);
        }

        return new int[] {
                success ? 1 : 0,
                successPoints,
                unsuccessPoints

        };
    }

}
