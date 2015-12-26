package my.Learning;

public class MatrixSpiralTraversal {
		int n;
		int [][] array = null;
		int [][] move = {
				{ 1, 0}, // Down
				{ 0, 1}, // Right
				{-1, 0}, // Up
				{ 0,-1}, // Left
				};

		MatrixSpiralTraversal( int dim)
		{ 
			if (dim < 1)
			return;
			n=dim;
			//The actual Array is not needed for the this code piece
			//array = new int [dim][dim];
			
		}
		private boolean isValidMove(int x , int y, int x_dir, int y_dir)
		{
			if (x + x_dir < n && x + x_dir >= 0 && y + y_dir < n && y + y_dir >= 0)
				return true;
			return false;
		}
		public void SimpleTraversal() //As Discussed
		{
			boolean [][] isVisited = new boolean[n][n];
			for(int i=0; i< n; i++)
				for(int j=0; j< n; j++)
					isVisited[i][j] = false;
			int x_dir = 1, y_dir=0, x=0, y=0;
			for(int i=0; i < n*n; i++)
			{

				System.out.println("["+x+"]["+y+"]");
				isVisited[x][y] = true;
				if (isValidMove(x, y, x_dir, y_dir ) && ! isVisited[x + x_dir ][y + y_dir])
				{ /* Next move is valid, go in the same direction */ }
				else if (x_dir == 1 &&  y_dir == 0 )  
			    { x_dir = 0; y_dir = 1; }		// Was going down, Go Right
				else if (x_dir == 0 &&  y_dir == 1 )
			    { x_dir = -1; y_dir = 0; }		// Was going Right, Go Up 
				else if (x_dir == -1 &&  y_dir == 0 )
			    { x_dir = 0; y_dir = -1; }		// Was going Up, Go Left
				else if (x_dir == 0 &&  y_dir == -1 )
			    { x_dir = 1; y_dir = 0; }		// // Was going Left, Go Down
				
				x += x_dir; y += y_dir;
			}
		}
		public void SimpleTraversalMoveMatrix()
		{
			boolean [][] isVisited = new boolean[n][n];
			for(int i=0; i< n; i++)
				for(int j=0; j< n; j++)
					isVisited[i][j] = false;
			int move_no=0, x=0, y=0;
			for(int i=0; i < n*n; i++)
			{
				System.out.println("["+x+"]["+y+"]");
				isVisited[x][y] = true;
				/* Next move is invalid, change direction */
				if (!(isValidMove(x, y, move[move_no][0], move[move_no][1] ) && ! isVisited[x + move[move_no][0] ][y + move[move_no][1]]))
					move_no = (move_no + 1 ) % 4;
				x += move[move_no][0];
				y += move[move_no][1];
			}
		}
	private void OptimizedTraversal()
	{
		int move_no = 0;
		int x=0, y=0;
		System.out.println("["+x+"]["+y+"]");
		for (int moves=n; moves > 0 ; moves--)
		{
			/*
			 * Build the flow pattern like 
			 * n=3, moves will be
			 * 3(this is 2 moves since 0,0 is already visited above), 2, 2, 1, 1
			 * n=4, moves will be 
			 * 4(this is 3 moves since 0,0 is already visited above), 3, 3, 2, 2, 1, 1
			 */
			for (int j=0; ((j < moves*2 && moves < n) || (j < moves-1) ) && moves > 0; j++)
			{
				//Move to the next cell and Display
				x += move[move_no][0];
				y += move[move_no][1];
				System.out.println("["+x+"]["+y+"]");
				
				if (j == moves -1 && moves < n && moves > 0) // for every Set of moves done change direction 
					move_no = (move_no + 1 ) % 4;	// we have 0 - 3 move directions.
			}
		move_no = (move_no + 1 ) % 4; 
		}		
	}

	public static void main(String[] args) {
		System.out.println("Evaluating for n=3");
		MatrixSpiralTraversal Test1 = new MatrixSpiralTraversal(3);
		System.out.println("Evaluating SimpleTraversal for n=3");
		Test1.SimpleTraversal();
		System.out.println("Evaluating OptimizedTraversal for n=3");
		Test1.OptimizedTraversal();

		Test1 = new MatrixSpiralTraversal(4);
		System.out.println("Evaluating SimpleTraversal for n=4");
		Test1.SimpleTraversal();
		System.out.println("Evaluating OptimizedTraversal for n=4");
		Test1.OptimizedTraversal();
	}

}
