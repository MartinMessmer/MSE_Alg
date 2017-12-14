import strategies.HalfingWithCentroidsStrategy;
import strategies.RandomStrategy;
import strategies.Strategy;
import strategies.StrategyExecuter;

public class App {
    public static void main(String[] args) {
        // demo: reading gifts -> see demo/ShowGiftsApp
        System.out.println("team rocket - santa trips solution");
        System.out.println("**********************************");

        // choose strategy
        //Strategy strategy = new RandomStrategy();
        Strategy strategy = new HalfingWithCentroidsStrategy();

        new StrategyExecuter().execute(strategy);
    }
}
