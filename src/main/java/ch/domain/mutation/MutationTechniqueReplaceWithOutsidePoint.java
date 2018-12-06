package ch.domain.mutation;

import ch.domain.ChGene;
import ch.domain.Point;
import ch.utilities.ChUtilities;

import java.util.List;
import java.util.Random;

public class MutationTechniqueReplaceWithOutsidePoint implements MutationTechnique<ChGene> {

    private static MutationTechniqueReplaceWithOutsidePoint mutationTechniqueReplaceWithOutsidePoint;

    private MutationTechniqueReplaceWithOutsidePoint() {
    }

    public static synchronized MutationTechniqueReplaceWithOutsidePoint getInstance() {
        if (mutationTechniqueReplaceWithOutsidePoint == null) {
            mutationTechniqueReplaceWithOutsidePoint = new MutationTechniqueReplaceWithOutsidePoint();
        }
        return mutationTechniqueReplaceWithOutsidePoint;
    }

    @Override
    public void mutate(ChGene gene) {
        List<Point> outsidePoints = gene.getOutsidePoints();
        if (!outsidePoints.isEmpty()) {
            List<Point> mutatedHull = gene.getConvexHull();
            Point chosenOutsidePoint = outsidePoints.get(new Random().nextInt(outsidePoints.size()));
            int closestCurrentPoint = ChUtilities.findClosest(chosenOutsidePoint, mutatedHull);
            mutatedHull.set(closestCurrentPoint, chosenOutsidePoint);
            gene.setConvexHull(mutatedHull);
        }
    }

    @Override
    public String toString() {
        return "Using: MutationTechniqueReplaceWithRandomLetterFromKeyboard";
    }
}
