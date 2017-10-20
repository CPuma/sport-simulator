import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SportSimulatorTest {

    public static class FootballSimTest{
        FootballSimulator footballSimulator;
        @Before
        public void setUp(){
            Player teamOne = new Player("Leamington Spa",1);
            Player teamTwo = new Player("Aston Villa",100);
            footballSimulator = new FootballSimulator(teamOne, teamTwo);
        }

        @Test
        public void testSports(){
            footballSimulator.startSim();

            String expectedResult = "Leamington Spa's score: " + [0-9] + "\nAston Villa's score: ";
            String actualResult = footballSimulator.printState();
            assertEquals("Charlton ",actualResult);
        }
    }
}
