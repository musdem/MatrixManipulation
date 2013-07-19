package matrixManipulation;

public class MatrixStringOperations
{
	public static double [][] stringToMatrix(String matrixString)//this will convert a string matrix into a double [][] matrix
	{
		boolean first = true;
		double [][] out = new double [0][0];
		String [] rows = matrixString.split("\\n");
		for(int i=0;i<=rows.length-1;i++)
		{
			String [] columns = rows[i].split("\\s");
			for(int j=0;j<=columns.length-1;j++)
			{
				if(first==true)
				{
					out = arraySizeIncreaser(out,rows.length,columns.length);
					first = false;
				}
				out[i][j] = Double.parseDouble(columns[j]);
			}
		}
		return out;
	}
	public static String matrixToString(double [][] matrix)//this will convert a double [][] matrix into a string matrix
	{
		String out = "";
		int matrixx = matrix.length;
		int matrixy = matrix[0].length;
		for(int i=0;i<=matrixx-1;i++)
		{
			for(int j=0;j<=matrixy-1;j++)
			{
				out = out + Double.toString(matrix[i][j]) + " ";
			}
			out = out + "\n";
		}
		return out;
	}
	private static double [][] arraySizeIncreaser(double[][] array, int newArrayX, int newArrayY)//increases an arrays index size
	{
		double [][] ret = new double[newArrayX][newArrayY];   
        for (int x=0;x<array.length;x++)
        {
			for (int y=0;y<array[0].length;y++)
			{
				ret[x][y] = array[x][y];
			}
		}
		return ret;
    }
}
