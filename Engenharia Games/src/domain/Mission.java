package domain;

public class Mission {
    public String name;
    private int difficulty;

    public Mission(String name, int difficulty){
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public String getName(){
        return name;
    }
}
