package h06.problems;

import h06.world.DirectionVector;
import h06.world.World;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;

import java.awt.Point;

/**
 * A solver for a problem.
 *
 * @author Nhan Huynh
 */
@DoNotTouch
public interface ProblemSolver {

    /**
     * Computes the next step of solving the problem.
     *
     * @param world the world to solve the problem in
     * @param p     the current position
     * @param d     the current direction
     * @return the next step of solving the problem
     */
    DirectionVector nextStep(World world, Point p, DirectionVector d);

    /**
     * Computes the number of steps needed to solve the problem.
     *
     * @param world the world to solve the problem in
     * @param s     the start position
     * @param e     the end position
     * @param d     the starting direction
     * @return the number of steps needed to solve the problem
     */
    int numberOfSteps(World world, Point s, Point e, DirectionVector d);

    /**
     * Computes the path to solve the problem.
     *
     * @param world the world to solve the problem in
     * @param s     the start position
     * @param e     the end position
     * @param d     the starting direction
     * @return the path to solve the problem
     */
    Point[] solve(World world, Point s, Point e, DirectionVector d);
}
