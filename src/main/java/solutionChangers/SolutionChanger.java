package solutionChangers;

import trips.Trip;

import java.util.List;

public interface SolutionChanger {
    List<Trip> change(List<Trip> solution);
}
