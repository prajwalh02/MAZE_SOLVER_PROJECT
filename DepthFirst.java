import java.util.List;

public class DepthFirst {
    
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {  

        if(maze[y][x] == 9) {  //reach destination
            path.add(x);
            path.add(y);
            return true;
        }

        if(maze[y][x] == 0) {           //we can traverse through it
            maze[y][x] = 2;             //mark visited

            // check top
            int dx = -1;
            int dy = 0;
            if(searchPath(maze, x+dx, y+dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            // check down
            dx = 1;
            dy = 0;
            if(searchPath(maze, x+dx, y+dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            // check left
            dx = 0;
            dy = -1;
            if(searchPath(maze, x+dx, y+dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            // check right
            dx = 0;
            dy = 1;
            if(searchPath(maze, x+dx, y+dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;

    }
}
