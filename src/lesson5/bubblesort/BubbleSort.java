package lesson5.bubblesort;

public class BubbleSort {
	public static void main (String[] args) {
		
		int[] tbl = new int[10];
		for(int i=0; i<tbl.length;i++){
			tbl[i] = i;
		}
		
		int[] sortTbl = sort(tbl);
		for(int i=0; i<sortTbl.length;i++){
			System.out.println(tbl[i]);
		}
	}
	
	public static int[] sort(int[] tbl){
		
		for(int i=0; i<tbl.length-1;i++){
			for(int j=0;j<tbl.length-i-1;j++){

				if ( tbl[j] < tbl[j+1] ) 
				{
					int temp = tbl[j+1];
					tbl[j+1] = tbl[j];
					tbl[j] = temp;

				}
			}
		}
	return tbl;
	}
}
