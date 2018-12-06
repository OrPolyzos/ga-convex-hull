package ch.domain;

import com.algorithms.ai.domain.GeneticAlgorithm;
import com.algorithms.ai.provider.CrossOverTechniqueProvider;
import com.algorithms.ai.provider.FitnessTechniqueProvider;
import com.algorithms.ai.provider.InitialGenerationProvider;
import com.algorithms.ai.provider.MutationTechniqueProvider;
import com.algorithms.ai.provider.SelectionTechniqueProvider;

import java.util.List;

public class ChGeneticAlgorithm extends GeneticAlgorithm<ChGene> {

    private List<Point> points;

    public ChGeneticAlgorithm(double mutationRate,
                              InitialGenerationProvider<ChGene> initialGenerationProvider,
                              FitnessTechniqueProvider<ChGene> fitnessTechniqueProvider,
                              SelectionTechniqueProvider<ChGene> selectionTechniqueProvider,
                              CrossOverTechniqueProvider<ChGene> crossOverTechniqueProvider,
                              MutationTechniqueProvider<ChGene> mutationTechniqueProvider,
                              List<Point> points) {
        super(mutationRate, initialGenerationProvider, fitnessTechniqueProvider, selectionTechniqueProvider, crossOverTechniqueProvider, mutationTechniqueProvider);
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}