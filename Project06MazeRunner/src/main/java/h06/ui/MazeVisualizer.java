package h06.ui;

import fopbot.Direction;
import fopbot.Robot;
import h06.problems.ProblemSolver;
import h06.world.DirectionVector;
import h06.world.World;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;

import java.awt.Color;
import java.awt.Point;

/**
 * Visualizes a maze problem.
 *
 * @author Nhan Huynh
 */
@DoNotTouch
public class MazeVisualizer implements ProblemVisualizer {

    /**
     * The world to visualize.
     */
    private World world;

    /**
     * Constructs a maze visualizer.
     */
    public MazeVisualizer() {
    }

    @Override
    public void init(World world) {
        this.world = world;
        int width = world.getWidth();
        int height = world.getHeight();
        fopbot.World.setSize(width, height);

        // Place walls
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (world.isBlocked(x, y, true)) {
                    fopbot.World.placeHorizontalWall(x, y);
                }
                if (world.isBlocked(x, y, false)) {
                    fopbot.World.placeVerticalWall(x, y);
                }
            }
        }
    }

    @Override
    public void show(boolean visible) {
        fopbot.World.setVisible(visible);
    }

    @Override
    public void run(ProblemSolver solver, Point s, Point e, DirectionVector d) {
        Point[] path = solver.solve(world, s, e, d);
        Robot robot = new Robot(s.x, s.y, Direction.values()[d.ordinal()], 0);

        fopbot.World.getGlobalWorld().setFieldColor(s.x, s.y, Color.BLUE);
        fopbot.World.getGlobalWorld().setFieldColor(e.x, e.y, Color.YELLOW);

        for (int i = 1; i < path.length; i++) {
            Point p = path[i];
            int x = robot.getX();
            int y = robot.getY();

            // Compute movement direction
            Direction direction;
            if (p.x > x && p.y == y) {
                direction = Direction.RIGHT;
            } else if (p.x < x && p.y == y) {
                direction = Direction.LEFT;
            } else if (p.x == x && p.y > y) {
                direction = Direction.UP;
            } else {
                direction = Direction.DOWN;
            }

            // Turn robot to the correct direction and then move
            while (robot.getDirection() != direction) {
                robot.turnLeft();
            }
            robot.move();
        }
        robot.turnOff();
    }

    @Override
    public void setDelay(int delay) {
        fopbot.World.setDelay(delay);
    }
}
