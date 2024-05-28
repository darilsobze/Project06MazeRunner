package h06.problems;

import h06.world.DirectionVector;
import h06.world.World;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.awt.Point;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * An iterative implementation of a maze solver. The solver uses the left-hand rule to find a path from the start to
 * the end of the maze.
 *
 * @author Nhan Huynh
 */
@DoNotTouch
public class MazeSolverIterative implements MazeSolver {

    /**
     * Constructs an iterative maze solver.
     */
    @DoNotTouch
    public MazeSolverIterative() {
    }

    @StudentImplementationRequired
    @Override
    public DirectionVector nextStep(World world, Point p, DirectionVector d) {
        if(!world.isBlocked(p,d.rotate270())){
            return d.rotate270();
        }
        else if (!world.isBlocked(p,d)){
            return d;
        }
        else if(!world.isBlocked(p,d.rotate90())){
            return d.rotate90();
        }
        else{
            return d.rotate90().rotate90();
        }

    }

    @StudentImplementationRequired
    @Override
    public int numberOfSteps(World world, Point s, Point e, DirectionVector d) {
        int numOfStep=1;

        while (!(s.equals(e)) ) {
            d= nextStep(world,s,d);
            s = d.getMovement(s);
            //point= nextPoint;
            numOfStep++;
        }

        return numOfStep;
    }

    @StudentImplementationRequired
    @Override
    public Point[] solve(World world, Point s, Point e, DirectionVector d) {
        int numOfStep= numberOfSteps(world,s,e,d);
        Point[] path = new Point[numOfStep];
        int index=0;
        path[index]=s;
        while (!s.equals(e)){
            d= nextStep(world,s,d);
            s= d.getMovement(s);
            index++;
            path[index]= s;
        }
        return path;
    }
}
