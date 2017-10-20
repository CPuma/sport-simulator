public class Player {
    private String playerName;
    private int score;
    private int skillLevel;

    public Player(String playerName, int skillLevel){
        score = 0;
        this.playerName = playerName;
        this.skillLevel = skillLevel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
