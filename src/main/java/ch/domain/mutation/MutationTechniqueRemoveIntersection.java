package ch.domain.mutation;

import ch.domain.ChGene;
import ch.domain.Point;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MutationTechniqueRemoveIntersection implements MutationTechnique<ChGene> {

    private static MutationTechniqueRemoveIntersection mutationTechniqueRemoveIntersection;

    private MutationTechniqueRemoveIntersection() {
    }

    public static synchronized MutationTechniqueRemoveIntersection getInstance() {
        if (mutationTechniqueRemoveIntersection == null) {
            mutationTechniqueRemoveIntersection = new MutationTechniqueRemoveIntersection();
        }
        return mutationTechniqueRemoveIntersection;
    }

    @Override
    public void mutate(ChGene gene) {
        List<Point> mutatedHull = gene.getConvexHull();
        List<List<Point>> intersectionsLists = gene.getIntersectionPoints();
        if (mutatedHull.size() > 3 && !intersectionsLists.isEmpty()) {
            List<Point> randomIntersectionsList = intersectionsLists.get(new Random().nextInt(intersectionsLists.size()));
            double whatToSwap = new Random().nextDouble();
            Point intersectionPointA;
            Point intersectionPointB;
            if (whatToSwap < 0.5) {
                intersectionPointA = randomIntersectionsList.get(0);
                intersectionPointB = randomIntersectionsList.get(3);
            } else {
                intersectionPointA = randomIntersectionsList.get(1);
                intersectionPointB = randomIntersectionsList.get(2);
            }
            int indexA = 0;
            int indexB = 0;
            for (int i = 0; i < mutatedHull.size(); i++) {
                if (mutatedHull.get(i).equals(intersectionPointA)) {
                    indexA = i;
                } else if (mutatedHull.get(i).equals(intersectionPointB)) {
                    indexB = i;
                }
            }
            Collections.swap(mutatedHull, indexA, indexB);
            gene.setConvexHull(mutatedHull);
        }
    }

    @Override
    public String toString() {
        return "Using: MutationTechniqueRemoveIntersection";
    }
}
