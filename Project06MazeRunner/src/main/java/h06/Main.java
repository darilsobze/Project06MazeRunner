package h06;

import h06.problems.MazeSolverIterative;
import h06.problems.MazeSolverRecursive;
import h06.ui.MazeVisualizer;
import h06.world.DirectionVector;
import h06.world.World;

import java.awt.*;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        World world= new World(5,5);
        for(int j=0;j<4;j++) {
            world.placeWall(0, j, false);
        }
        for(int i=0;i<3;i++){
            world.placeWall(i+1,1,true);
        }
        world.placeWall(3,1,false);
        world.placeWall(2,0,false);
        world.placeWall(2,0,true);
        for(int j=0;j<2;j++){
            world.placeWall(1,j+3,false);
        }
        world.placeWall(2,2,true);
        world.placeWall(3,3,true);
        world.placeWall(3,3,false);
        world.placeWall(4,2,true);

        MazeVisualizer mazeVisualizer=new MazeVisualizer();
        mazeVisualizer.init(world);
        mazeVisualizer.show(true);

        MazeSolverRecursive mazeSolverRecursive= new MazeSolverRecursive();
        MazeSolverIterative mazeSolverIterative= new MazeSolverIterative();
        Point start = new Point(2,0);
        Point end = new Point(2,4);
        DirectionVector d= DirectionVector.UP;

        mazeVisualizer.run(mazeSolverIterative,start,end,d);
        //mazeVisualizer.run(mazeSolverRecursive,start,end,d);
    }
}
