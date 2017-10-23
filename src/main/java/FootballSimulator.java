import java.util.Random;

public class FootballSimulator implements SportSimulator{
    private final int gameLength = 90;
    private final int extraTimeLength = 120;
    private GameType gameType;
    private Player teamOne;
    private Player teamTwo;
    private Random random;

    public FootballSimulator(Player teamOne, Player teamTwo, GameType gameType){
        random = new Random();
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.gameType = gameType;
    }

    @Override
    public void startSim() {
        GameState gameState = new GameState();
        while (gameState.getCount() < gameLength){
            nextStep(gameState);
        }
        if (teamOne.getScore() == teamTwo.getScore() && gameType == GameType.CUP) {
            while (gameState.getCount() < extraTimeLength) {
                nextStep(gameState);
            }
        }
        System.out.println(printState());
    }

    @Override
    public void nextStep(GameState gameState) {
        gameState.setCount(gameState.getCount() + 1);
        doesTeamScore(teamOne);
        doesTeamScore(teamTwo);
    }

    @Override
    public String printState() {
        return teamOne.getPlayerName() + "'s score: " + teamOne.getScore() + "\n"
                + teamTwo.getPlayerName() + "'s score: " + teamTwo.getScore();
    }

    private void doesTeamScore(Player team) {
        if (genRandomNum() < 3) {
            incrementScore(team);
        }
    }

    private int genRandomNum(){
        return random.nextInt(100)+1;
    }

    private void incrementScore(Player team){
        team.setScore(team.getScore()+1);
    }

    public static void main(String [] args){
        Player playerOne = new Player("Leamington Spa", 50);
        Player playerTwo = new Player("Birmingham City", 50);
        FootballSimulator simulator = new FootballSimulator(playerOne, playerTwo, GameType.CUP);
        simulator.startSim();
    }

}
