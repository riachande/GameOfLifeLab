import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower ;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList; 

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 5 rows and 5 columns
    private final int ROWS = 10;
    private final int COLS = 10;
    
    
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
        world.show();
        
    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // constants for the location of the three cells initially alive
       final int X1 = 4,Y1 = 4;
       final int X2 = 4,Y2 = 2; 
        
       final int X4  = 5 , Y4 = 2;
       final int X6 = 4, Y6 = 3; 
       
       
       final int X9 = 6, Y9 = 3; 
       final int X10 = 6, Y10 = 4; 
       final int X11 = 5, Y11 = 4; 
      
       final int X13 = 6, Y13 = 2; 
       
       
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // create and add rocks (a type of Actor) to the three intial locations
       Flower rock1 = new Flower();
       Location loc1 = new Location(Y1, X1);
       grid.put(loc1, rock1);
        
       Flower rock2 = new Flower();
       Location loc2 = new Location(Y2, X2);
       grid.put(loc2, rock2);
        
       
       Flower rock6 = new Flower();
       Location loc6 = new Location(Y6, X6);
       grid.put(loc6, rock6);
       
       
       
       Flower rock4 = new Flower();
       Location loc4 = new Location(Y4, X4);
       grid.put(loc4, rock4);
       
       Flower rock9= new Flower();
       Location loc9 = new Location(Y9, X9);
       grid.put(loc9, rock9);
       
       Flower rock10 = new Flower();
       Location loc10 = new Location(Y10, X10);
       grid.put(loc10, rock10);
       
       Flower rock11 = new Flower();
       Location loc11 = new Location(Y11, X11);
       grid.put(loc11, rock11);
       
       
       
       Flower rock13 = new Flower();
       Location loc13 = new Location(Y13, X13);
       grid.put(loc13, rock13);
       
      
    }
    
    
    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        BoundedGrid<Actor> ng = new BoundedGrid<Actor>(ROWS,COLS); 
        
        int cols = getNumCols();
        int rows = getNumRows(); 
       
        for (int row =0; row<rows; row++)
    {
      for(int col =0; col<cols; col++){
                
        Actor cell = getActor(row,col); 
        Location location = new Location(row, col); 
            if (cell != null)
           { 
             ArrayList<Actor> NextFlower = grid.getNeighbors(location);
            int Flowercount = NextFlower.size(); 
            if (Flowercount == 3)
            {
                Flower nflower = new Flower();
                Location nflowerloc = new Location(row,col); 
                ng.put(nflowerloc,nflower); 
           }
            else if(Flowercount == 2)
            {
           Flower  nflower = new Flower();
           Location nflowerloc = new Location(row,col); 
           ng.put(nflowerloc,nflower); 
           
            }
            else if (Flowercount > 3 || Flowercount< 3)
           {
           }
        }
         if (cell == null)
         {
              ArrayList<Actor> NextFlower = grid.getNeighbors(location);
              int Flowercount = NextFlower.size(); 
           if (Flowercount ==3)
            {
                Flower nflower = new Flower();
                Location nflowerloc = new Location(row,col); 
                ng.put(nflowerloc,nflower); 
          }
         }
     }
      
      
     world.setGrid(ng); 
     world.show();
    }
   
    
    }



    

    
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    
    }
    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
  
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

    
    
}
