package ch.domain.mutation;

import ch.domain.ChGene;
import ch.domain.Point;

import java.util.List;
import java.util.Random;

public class MutationTechniqueRemoveRandomPoint implements MutationTechnique<ChGene> {

    private static MutationTechniqueRemoveRandomPoint mutationTechniqueRemoveRandomPoint;

    private MutationTechniqueRemoveRandomPoint() {
    }

    public static synchronized MutationTechniqueRemoveRandomPoint getInstance() {
        if (mutationTechniqueRemoveRandomPoint == null) {
            mutationTechniqueRemoveRandomPoint = new MutationTechniqueRemoveRandomPoint();
        }
        return mutationTechniqueRemoveRandomPoint;
    }

    @Override
    public void mutate(ChGene gene) {
        List<Point> mutatedHull = gene.getConvexHull();
        if (mutatedHull.size() > 3) {
            mutatedHull.remove(mutatedHull.get(new Random().nextInt(mutatedHull.size())));
            gene.setConvexHull(mutatedHull);
        }
    }

    @Override
    public String toString() {
        return "Using: MutationTechniqueRemoveSickJoints";
    }
}
