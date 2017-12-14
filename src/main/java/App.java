import pathOptimizers.GreedyShortestPathOptimizer;
import pathOptimizers.PathOptimizer;
import strategies.HalfingWithCentroidsStrategy;
import strategies.Strategy;
import strategies.StrategyExecuter;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        // demo: reading gifts -> see demo/ShowGiftsApp
        System.out.println("team rocket - santa trips solution");
        System.out.println("**********************************");

        // choose strategy
        //Strategy strategy = new RandomStrategy();
        Strategy strategy = new HalfingWithCentroidsStrategy();

        // choose path optimization algorithm (optimize path within the tour)
        //PathOptimizer pathOptimizers = null;
        PathOptimizer pathOptimizer = new GreedyShortestPathOptimizer();


        new StrategyExecuter().execute(
                strategy,
                pathOptimizer == null ? Optional.empty() : Optional.of(pathOptimizer));
    }
}
