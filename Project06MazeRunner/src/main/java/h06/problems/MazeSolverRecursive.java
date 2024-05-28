package h06.problems;

import h06.world.DirectionVector;
import h06.world.World;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.awt.Point;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A recursive implementation of a maze solver. The solver uses the left-hand rule to find a path from the start to
 * the end of the maze.
 *
 * @author Nhan Huynh
 */
public class MazeSolverRecursive implements MazeSolver {

    /**
     * Constructs a recursive maze solver.
     */
    @DoNotTouch
    public MazeSolverRecursive() {
    }

    @StudentImplementationRequired
    @Override
    public DirectionVector nextStep(World world, Point p, DirectionVector d) {
        return (!world.isBlocked(p, d.rotate270())) ? d.rotate270() :
            nextStep(world, p, d.rotate90());
    }

    @StudentImplementationRequired
    @Override
    public int numberOfSteps(World world, Point s, Point e, DirectionVector d) {
        if (s.equals(e)){
            return 1;
        }
        else
            return (numberOfSteps(world, nextStep(world,s,d).getMovement(s), e, nextStep(world,s,d))+1);

    }

    @StudentImplementationRequired
    @Override
    public Point[] solve(World world, Point s, Point e, DirectionVector d) {
        int numOfSteps = numberOfSteps(world, s, e, d);
        Point[] path= new Point[numOfSteps];
        solveHelper(world,s,e,d,path,0);
        return path;
    }

    /**
     * Helper method for solve. Computes the path from p to end.
     *
     * @param world the world to solve the maze in
     * @param p     the current point
     * @param e     the end point
     * @param d     the current direction
     * @param path  the path calculated so far from s to p
     * @param index the index of the next free spot in path
     */
    @StudentImplementationRequired
    private void solveHelper(World world, Point p, Point e, DirectionVector d, Point[] path, int index) {
        path[index]= p;
        if (p.equals(e)){
            path[index]=p;
        }
        else {
            DirectionVector nextDirectionVector= nextStep(world,p,d);
            Point nextStart = nextDirectionVector.getMovement(p);
            solveHelper(world,nextStart,e,nextDirectionVector,path,index+1);
        }
    }
}
