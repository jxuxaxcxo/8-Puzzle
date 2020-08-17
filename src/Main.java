import java.util.ArrayList;

public class Main {

	private static  int [][] matrix; 
	private static ArrayList<Integer> listaDeValores;
	private static int [][] backupMatrix; 
	public static void main (String [] args) {
		initialize();
		fillGrid();
		printGrid(matrix);
		
		ordenado(matrix);
		
	}
	private static void initialize() {
		matrix = new int [3][3];
		backupMatrix = new int [3][3];
		listaDeValores = new ArrayList<Integer>();
	}
	
	public static void printGrid(int [][] matrix) {
		for(int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j =0; j <3; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public static int getRandom() {
		Boolean numberFound = false;
		while(!numberFound) {
			int number = (int) Math.floor(Math.random()*9);
			if(!listaDeValores.contains(number) || listaDeValores.size() == 0) {
				numberFound = true;
				listaDeValores.add(number);
				return number;
			}
		}
		return -1;
	}
	
	public static void fillGrid() {
		Math.random();
		for(int i =0; i <3; i++) {
			for(int j =0; j <3; j++) {
				matrix[i][j] = getRandom();
			}
		}
	}
	public static void ordenado(int [] []matrix) {
		ArrayList<int []> posibilidadesActuales = getPosibleMoves(matrix);

		for(int i =0;i<posibilidadesActuales.size();i++) {
			System.out.println("size" + posibilidadesActuales.size());
			int [][] currentMatrix = matrix.clone();
			currentMatrix = movePiece(posibilidadesActuales.get(i), currentMatrix);
			System.out.println("_________________________");
			printGrid(currentMatrix);
		}
	}
	
	public static int[][] movePiece(int[] move, int [][] matrix) {
		int [][] currentMatrix = new int [3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				currentMatrix[i][j]=matrix[i][j];
			}
		}

		int iN = move[0]/10;
		int jN = move[0]%10;
		
		int i0 = move[1]/10;
		int j0 = move[1]%10;
		
		int aux = currentMatrix[iN][jN];
		currentMatrix [iN][jN] = currentMatrix [i0][j0];
		currentMatrix [i0][j0] = aux;
		
		return currentMatrix;
	}
	
	public static ArrayList<int []> getPosibleMoves(int [][] matrix) {
		ArrayList<int []> posibilidades = new ArrayList<int []>();;
		for(int i=0; i<3;i++) {
			for(int j =0;j<3;j++) {
				if(matrix[i][j]==0) {						
					for(int k=0;k<4;k++) {
							switch(k) {
								case 0:
									
									if(j-1>=0 && k==0) {
										System.out.println("caso 0");
										posibilidades.add(new int[] {(i)*10+(j-1),i*10+j}); break;} //Caso Izquierda 
								case 1:
									
									if(i-1>=0 && k==1) {
										System.out.println("caso 1");
										posibilidades.add(new int[] {(i-1)*10+(j),i*10+j}); break;} //Caso Arriba
								case 2:
									
									if(j+1<=2 && k==2) {
										System.out.println("caso 2");
										posibilidades.add(new int[] {(i)*10+(j+1),i*10+j}); break;} //Caso Derecha
								case 3:
									
									if(i+1<=2 && k==3) {
										System.out.println("caso 3");
										posibilidades.add(new int[] {(i+1)*10+(j),i*10+j}); break;} //Caso Abajo
							
							}
					}
					return posibilidades;
				}
			}
		}
		return posibilidades;
	}
	

}
