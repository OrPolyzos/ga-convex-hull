package ch.domain;

import ch.utilities.ChUtilities;

import java.util.ArrayList;
import java.util.List;

public class ChGene {

    private List<Point> points;
    private List<Point> convexHull;
    private List<Point> outsidePoints;
    private List<Point> sickJoints;
    private List<List<Point>> intersectionPoints;

    public ChGene(List<Point> points, List<Point> convexHull) {
        this.points = points;
        this.convexHull = convexHull;
        updateLists();
    }

    public ChGene getCopy() {
        List<Point> convexHullCopy = new ArrayList<>(this.convexHull);
        return new ChGene(this.points, convexHullCopy);
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Point> getConvexHull() {
        return convexHull;
    }

    public void setConvexHull(List<Point> convexHull) {
        this.convexHull = convexHull;
        updateLists();
    }

    public List<Point> getOutsidePoints() {
        return outsidePoints;
    }

    public List<Point> getSickJoints() {
        return sickJoints;
    }

    public List<List<Point>> getIntersectionPoints() {
        return intersectionPoints;
    }

    private void updateLists() {
        this.outsidePoints = ChUtilities.calculateOutsidePoints(convexHull, points);
        this.sickJoints = ChUtilities.calculateSickJoints(convexHull);
        this.intersectionPoints = ChUtilities.calculateIntersections(convexHull);
    }

}
