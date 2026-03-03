package service;

import domain.Mission;

public class AdvancedMissionValidatorService implements IAdvancedMissionValidateService {

    @Override
    public boolean validate (Mission mission){
        return (mission.getDifficulty() % 2 == 0);
    }
}
