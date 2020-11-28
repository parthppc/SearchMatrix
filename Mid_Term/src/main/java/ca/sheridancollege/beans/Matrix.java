package ca.sheridancollege.beans;

public class Matrix {


	private char[][] arr;
	private String sch;	

	private int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 }; 
	private int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 }; 
	private String fn;

	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	
	public Matrix() {
		
	}
	
	public char[][] getArr() {
		return arr;
	}
	public void setArr(char[][] arr) {
		this.arr = arr;
	}
	public String getSch() {
		return sch;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	

public void patternSearch(char[][] arr,int side) { 
	
	fn="";
	
    int a=0;
    
    for (int i = 0; i < side; i++) { 
        for (int j = 0; j < side; j++) { 
        	
            if (searchString(arr,i, j,side)) {
            	a++;
                fn=fn+"pattern found at " + i + ", " + j+"\n";
            }
        } 
    } 
    
    if (a==0) {
    	fn="Pattern Not Found!";
    }
} 

public boolean searchString(char[][] arr,int i, int j,int side) { 
    
	if (arr[i][j] != sch.charAt(0)) 
        return false; 

    int len = sch.length(); 

    for (int k = 0; k < 8; k++) { 

    	int z;
    	int r = i + x[k];
    	int c = j + y[k]; 

        
        for (z = 1; z < len; z++) { 
         
            if (r >= side || r < 0 || c >= side || c < 0) 
                break; 

            if (arr[r][c] != sch.charAt(z)) 
                break; 
 
            r += x[k]; 
            c += y[k]; 
        } 

        if (z == len) 
            return true; 
    } 
    return false; 
}

}	

