package service;

import domain.Mission;

public class BasicMissionValidatorService implements MissionValidatorService {
    @Override
    public boolean validate(Mission mission){
        return mission.getDifficulty() <= 5;
    }
}
