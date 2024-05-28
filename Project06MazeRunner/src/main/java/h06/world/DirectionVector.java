package h06.world;


import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.SolutionOnly;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.awt.Point;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * The DirectionVector enum represents vectors in four directions: UP, RIGHT, DOWN, and LEFT.
 *
 * <p>Each DirectionVector has an x and y component that can be used for movement or other purposes.
 *
 * @author Nhan Huynh
 */
@DoNotTouch
public enum DirectionVector {

    /**
     * The direction vector pointing up.
     */
    UP(0, 1),

    /**
     * The direction vector pointing right.
     */
    RIGHT(1, 0),

    /**
     * The direction vector pointing down.
     */
    DOWN(0, -1),

    /**
     * The direction vector pointing left.
     */
    LEFT(-1, 0);

    /**
     * The x component of the direction vector.
     */
    private final int dx;

    /**
     * The y component of the direction vector.
     */
    private final int dy;

    /**
     * Constructs a new direction vector with the given x and y components.
     *
     * @param dx the x component of the direction vector
     * @param dy the y component of the direction vector
     */
    @DoNotTouch
    DirectionVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Returns the direction vector with the given x and y components.
     *
     * @param p the point to get the direction vector from
     * @return the direction vector with the given x and y components
     * @throws IllegalArgumentException if no direction vector with the given x and y components exists
     */
    @SolutionOnly
    public static DirectionVector from(Point p) {
        for (DirectionVector d : values()) {
            if (d.dx == p.x && d.dy == p.y) {
                return d;
            }
        }
        throw new IllegalArgumentException("No direction vector with %s".formatted(p));
    }

    /**
     * Returns the direction vector counterclockwise to this direction vector (90 degrees to the left).
     *
     * @return the direction vector counterclockwise to this direction vector
     */
    @StudentImplementationRequired
    public DirectionVector rotate270() {
        return        (this.equals(DirectionVector.UP))? DirectionVector.LEFT:
            (this.equals(DirectionVector.LEFT)? DirectionVector.DOWN:
                (this.equals(DirectionVector.DOWN)?DirectionVector.RIGHT:
                    DirectionVector.UP));

    }

    /**
     * Returns the direction vector clockwise to this direction vector (90 degrees to the right).
     *
     * @return the direction vector clockwise to this direction vector
     */
    @StudentImplementationRequired
    public DirectionVector rotate90() {
        if(this.equals(DirectionVector.UP)) {
            return DirectionVector.RIGHT;
        }
        else if (this.equals(DirectionVector.RIGHT)) {
            return DirectionVector.DOWN;
        }
        else if (this.equals(DirectionVector.DOWN)){
            return DirectionVector.LEFT;
        }
        else {
            return DirectionVector.UP;
        }
    }

    /**
     * Returns the x component of the direction vector.
     *
     * @return the x component of the direction vector
     */
    @DoNotTouch
    public int getDx() {
        return dx;
    }

    /**
     * Returns the y component of the direction vector.
     *
     * @return the y component of the direction vector
     */
    @DoNotTouch
    public int getDy() {
        return dy;
    }

    /**
     * Returns a point that is the result of adding this direction vector to the given point.
     *
     * @param p The Point to add to.
     * @return a point that is the result of adding this direction vector to the given point
     */
    @DoNotTouch
    public Point getMovement(Point p) {
        return new Point(p.x + dx, p.y + dy);
    }
}
