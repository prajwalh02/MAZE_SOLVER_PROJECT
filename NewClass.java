
import javax.swing.*;
import java.util.*; 
import java.util.List;
import java.awt.*;

public class NewClass extends JFrame {



    private int[][] maze =
    {   {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,0,0,1,1,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,0,1,1,0,1},
        {1,1,0,0,1,1,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,0,1,1,0,0,0,0,0,1},
        {1,1,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path = new ArrayList<>();       //It will contain the co-ordinate of the path

    public NewClass() {                  //constructor
        setTitle("Maze Solver");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //it will close the whole operation when i click on exit button

        setBackground(Color.pink);
        getContentPane().setBackground(Color.red);
        

        DepthFirst.searchPath(maze, 1, 1, path);
        // System.out.println(path);


    }
    @Override
    public void paint(Graphics g) {       //paint is inbuild function which takes the graphics, Graphics is obj

        g.translate(130, 90);         //move the graphics accordingly in the window

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                Color color;               //Color is Object
                switch(maze[i][j]) {
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.RED; break;
                    default : color = Color.WHITE; break;
                }
                // for the current grid
                g.setColor(color);                      //set the color for the current grid
                g.fillRect(30*j, 30*i, 30, 30);       //fill the rect for that color
                g.setColor(Color.YELLOW);                 //set the new color for boundary of each grid
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        for(int i = 0; i < path.size(); i+=2) {
                int pathx = path.get(i);
                int pathy = path.get(i+1);

                // System.out.println("X Coordinates : " +pathx);
                // System.out.println("Y Coordinates : " +pathy);

                g.setColor(Color.GREEN);
                // g.fillRect(30*pathx, 30*pathy, 20, 20);
                g.fillOval(30*pathx, 30*pathy, 20, 20);
            }
    }


    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}