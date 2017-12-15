import pathOptimizers.GreedyShortestPathOptimizer;
import pathOptimizers.PathOptimizer;
import pathOptimizers.TourInverterPathOptimizer;
import strategies.HalfingWithCentroidsStrategy;
import strategies.Strategy;
import strategies.StrategyExecuter;

import java.util.LinkedList;
import java.util.List;
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
        List<PathOptimizer> pathOptimizers = new LinkedList<>();
        pathOptimizers.add(new GreedyShortestPathOptimizer());
        pathOptimizers.add(new TourInverterPathOptimizer());

        new StrategyExecuter().execute(
                strategy,
                pathOptimizers);


        // todo 1: use SolutionChanger interface to implement algorithm which modify a give solution
        // todo 2: create a meta heuristic which use different SolutionChanger to find better solution
        // note: we may have to implement a NeighbourTourFinder which enumerate existing tours near a give point
    }
}
