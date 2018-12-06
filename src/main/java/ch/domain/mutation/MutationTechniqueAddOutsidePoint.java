package ch.domain.mutation;

import ch.domain.ChGene;
import ch.domain.Point;

import java.util.List;
import java.util.Random;

public class MutationTechniqueAddOutsidePoint implements MutationTechnique<ChGene> {

    private static MutationTechniqueAddOutsidePoint mutationTechniqueAddOutsidePoint;

    private MutationTechniqueAddOutsidePoint() {
    }

    public static synchronized MutationTechniqueAddOutsidePoint getInstance() {
        if (mutationTechniqueAddOutsidePoint == null) {
            mutationTechniqueAddOutsidePoint = new MutationTechniqueAddOutsidePoint();
        }
        return mutationTechniqueAddOutsidePoint;
    }

    @Override
    public void mutate(ChGene gene) {
        List<Point> outsidePoints = gene.getOutsidePoints();
        if (!outsidePoints.isEmpty()) {
            List<Point> mutatedHull = gene.getConvexHull();
            int chosenOutsidePoint = new Random().nextInt(outsidePoints.size());
            int randomIndex = new Random().nextInt(mutatedHull.size());
            mutatedHull.add(randomIndex, outsidePoints.get(chosenOutsidePoint));
            gene.setConvexHull(mutatedHull);
        }
    }

    @Override
    public String toString() {
        return "Using: MutationTechniqueAddOutsidePoint";
    }
}
