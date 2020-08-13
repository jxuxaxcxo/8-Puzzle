import java.util.ArrayList;

public class Main {

	private static  int [][] matrix; 
	private static ArrayList<Integer> listaDeValores;
	private static int [][] backupMatrix; 
	public static void main (String [] args) {
		initialize();
		fillGrid();
		printGrid();
		
	}
	private static void initialize() {
		matrix = new int [3][3];
		backupMatrix = new int [3][3];
		listaDeValores = new ArrayList<Integer>();
	}
	
	public static void printGrid() {
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
	
	public static void movePiece() {
		for(int i=0; i<3;i++) {
			for(int j =0;j<3;j++) {
				if(matrix[i][j]==0) {
					ArrayList<int []> posibilidades = new ArrayList<int []>();
						if(i!=0 && j!=0){
							int[] aux = new int[] {1,2};
							aux = 
							aux[0] = 1;
							aux[1] = i*10+j;
							posibilidades.add(aux);
							
						}
						else if(i==0) {
							
						}
					
					
				}
			}
		}
	}
	

}
