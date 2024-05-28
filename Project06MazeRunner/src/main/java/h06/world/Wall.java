package h06.world;

import fopbot.FieldEntity;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;

/**
 * A wall with orientation.
 *
 * @author Nhan Huynh
 */
@DoNotTouch
public class Wall extends FieldEntity {

    /**
     * Whether the wall is horizontal or vertical.
     */
    private final boolean horizontal;

    /**
     * Creates a vertical wall at the given position.
     *
     * @param x the x coordinate of the wall
     * @param y the y coordinate of the wall
     */
    public Wall(int x, int y) {
        this(x, y, false);
    }

    /**
     * Creates a wall at the given position.
     *
     * @param x          the x coordinate of the wall
     * @param y          the y coordinate of the wall
     * @param horizontal whether the wall is horizontal or vertical
     */
    public Wall(int x, int y, boolean horizontal) {
        super(x, y);
        this.horizontal = horizontal;
    }

    /**
     * Returns whether the wall is horizontal or vertical.
     *
     * @return whether the wall is horizontal or vertical
     */
    public boolean isHorizontal() {
        return horizontal;
    }
}
