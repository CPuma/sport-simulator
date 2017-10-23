public interface SportSimulator{

    void startSim();

    void nextStep(GameState gameState);

    String printState();
}
