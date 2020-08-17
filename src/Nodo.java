
public class Nodo {

	public int [] [] matrixNodo;

	public Nodo padre;


	public Nodo(int[][] matrixNodo, Nodo padre) {

	this.matrixNodo = matrixNodo;
	this.padre = padre;

	}


	public boolean equals(int [][] matrix) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if( ! (matrixNodo[i][j]==matrix[i][j]) )
				{
					return false;
				}
			}
		}
		return true;
	}

}
