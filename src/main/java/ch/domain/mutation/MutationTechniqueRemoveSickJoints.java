package ch.domain.mutation;

import ch.domain.ChGene;
import ch.domain.Point;

import java.util.List;

public class MutationTechniqueRemoveSickJoints implements MutationTechnique<ChGene> {

    private static MutationTechniqueRemoveSickJoints mutationTechniqueRemoveSickJoints;

    private MutationTechniqueRemoveSickJoints() {
    }

    public static synchronized MutationTechniqueRemoveSickJoints getInstance() {
        if (mutationTechniqueRemoveSickJoints == null) {
            mutationTechniqueRemoveSickJoints = new MutationTechniqueRemoveSickJoints();
        }
        return mutationTechniqueRemoveSickJoints;
    }

    @Override
    public void mutate(ChGene gene) {
        List<Point> mutatedHull = gene.getConvexHull();
        List<Point> sickJoints = gene.getSickJoints();
        if (mutatedHull.size() > 3 && !sickJoints.isEmpty()) {
            mutatedHull.removeAll(sickJoints);
            gene.setConvexHull(mutatedHull);
        }
    }

    @Override
    public String toString() {
        return "Using: MutationTechniqueRemoveSickJoints";
    }
}
