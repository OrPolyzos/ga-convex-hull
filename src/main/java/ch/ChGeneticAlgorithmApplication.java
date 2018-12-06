package ch;

import ch.domain.ChGene;
import ch.domain.ChGeneticAlgorithm;
import ch.domain.Point;
import ch.domain.mutation.MutationTechnique;
import ch.domain.mutation.MutationTechniqueAddOutsidePoint;
import ch.domain.mutation.MutationTechniqueRemoveIntersection;
import ch.domain.mutation.MutationTechniqueRemoveRandomPoint;
import ch.domain.mutation.MutationTechniqueRemoveSickJoints;
import ch.domain.mutation.MutationTechniqueReplaceWithOutsidePoint;
import ch.utilities.ChUtilities;
import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.exception.GeneticAlgorithmException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChGeneticAlgorithmApplication {

    private static final double MUTATION_RATE = 0.9;
    private static final int POPULATION_COUNT = 10;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private static final int POINTS_COUNT = 500;
    private static final List<Point> POINTS = ChUtilities.generatePoints(WIDTH, HEIGHT, POINTS_COUNT);

    private static final List<MutationTechnique<ChGene>> mutationTechniques = Arrays.asList(
            MutationTechniqueAddOutsidePoint.getInstance(),
            MutationTechniqueReplaceWithOutsidePoint.getInstance(),
            MutationTechniqueRemoveIntersection.getInstance(),
            MutationTechniqueRemoveSickJoints.getInstance(),
            MutationTechniqueRemoveRandomPoint.getInstance());

    public static void main(String[] args) throws GeneticAlgorithmException {
        ChGeneticAlgorithmApplication chGeneticAlgorithmApplication = new ChGeneticAlgorithmApplication();

        new ChGeneticAlgorithm(MUTATION_RATE,
                chGeneticAlgorithmApplication::generateInitialGeneration,
                chGeneticAlgorithmApplication::calculateFitnessWithSickJoints,
                chGeneticAlgorithmApplication::selectPopulationFittestChromosome,
                chGeneticAlgorithmApplication::pickFittestParent,
                chGeneticAlgorithmApplication::mutate,
                POINTS).run();
    }

    private void mutate(Chromosome<ChGene> chromosomeToMutate, double mutationRate) {
        if (new Random().nextDouble() < mutationRate) {
            mutationTechniques.get(new Random().nextInt(mutationTechniques.size())).mutate(chromosomeToMutate.getGene());
        }
    }

    private List<Chromosome<ChGene>> generateInitialGeneration() {
        return IntStream.range(0, POPULATION_COUNT)
                .boxed()
                .map(i -> new Chromosome<>(new ChGene(POINTS, ChUtilities.getRandomPoints(POINTS, 3))))
                .collect(Collectors.toList());
    }

    private double calculateFitnessWithSickJoints(Chromosome<ChGene> chromosomeToCalculateFitness) {
        ChGene chGene = chromosomeToCalculateFitness.getGene();
        if (chGene.getConvexHull().size() < 3) {
            return 0;
        }
        double fitOutsidePoints = Math.pow(chGene.getOutsidePoints().size() + 1, 1);
        double fitIntersections = Math.pow(chGene.getIntersectionPoints().size() + 1, 1);
        double fitSickJoints = Math.pow(chGene.getSickJoints().size() + 1, 1);
        return 1 / (fitIntersections * fitOutsidePoints * fitSickJoints);
    }

    private Chromosome<ChGene> selectPopulationFittestChromosome(List<Chromosome<ChGene>> population, Chromosome<ChGene> fittestChromosomeEver, Chromosome<ChGene> populationFittestChromosome) {
        return populationFittestChromosome;
    }

    private Chromosome<ChGene> pickFittestParent(Chromosome<ChGene> parentA, Chromosome<ChGene> parentB) {
        Chromosome<ChGene> winnerParent;
        if (parentA.getFitness() > parentB.getFitness()) {
            winnerParent = parentA;
        } else {
            winnerParent = parentB;
        }
        List<Point> points = winnerParent.getGene().getPoints();
        List<Point> childHull = new ArrayList<>(winnerParent.getGene().getConvexHull());
        ChGene childGene = new ChGene(points, childHull);
        return new Chromosome<>(childGene);
    }

}

