package pathOptimizers;

import gifts.Gift;

import java.util.List;

public interface PathOptimizer {
    List<Gift> reorder(List<Gift> gifts);
}
