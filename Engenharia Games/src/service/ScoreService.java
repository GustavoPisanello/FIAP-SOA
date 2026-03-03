package service;

import domain.Player;

public class ScoreService implements IScoreService {

    @Override
    public void addScore(int newScore, Player player){
        player.setScore(player.getScore() + newScore);
    }

}
