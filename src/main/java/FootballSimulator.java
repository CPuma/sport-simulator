import java.util.Random;

public class FootballSimulator implements SportSimulator{
    private int gameLength;
    private Player teamOne;
    private Player teamTwo;
    private Random random;
    private GameState gameState;

    public FootballSimulator(Player teamOne, Player teamTwo){
        random = new Random();
        gameState = new GameState();
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        gameLength = 90;
    }

    @Override
    public void startSim() {
        for(int i = 0; i < gameLength; i++){
            nextStep();
        }
    }

    @Override
    public void nextStep() {
        if (genRandomNum()< 3) {
            incrementScore(teamOne);
            System.out.println(teamOne.getPlayerName() + " scored!");
        }

        if (genRandomNum()< 3) {
            incrementScore(teamTwo);
            System.out.println(teamTwo.getPlayerName() + " scored!");
        }
    }

    @Override
    public String printState() {
       return teamOne.getPlayerName() + "'s score: " + teamOne.getScore() + "\n"
            + teamTwo.getPlayerName() + "'s score: " + teamTwo.getScore();
    }

    public int getGameLength() {
        return gameLength;
    }

    public void setGameLength(int gameLength) {
        this.gameLength = gameLength;
    }

    private int genRandomNum(){
        return random.nextInt(100)+1;
    }

    private void incrementScore(Player team){
        team.setScore(team.getScore()+1);
    }

    public GameState getGameState() {
        return gameState;
    }
}
