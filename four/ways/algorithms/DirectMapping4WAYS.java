package four.ways.algorithms;


import java.io.*;	
import java.util.ArrayList;
import cache.simulador.readfile.ReadFileArray;
import cache.simulador.readfile.UX;

public class DirectMapping4WAYS {
	
	static ReadFileArray r = new ReadFileArray();
	public int hit = 0;
	public int miss = 0;
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;
	static UX ob = new UX();

	public void directMap() throws IOException {
		
		startTime = System.currentTimeMillis();
		int j = 0;
		int sizeOf = 0;
		
		r.readFile(); // read file
		ArrayList<Integer> tx = r.convert();
		int fileNumbers[] = new int[tx.size()];
		
		
		sizeOf = ob.stringToConvert()/4;
		
		int f[] = new int[sizeOf];
		
		for(int i = 0; i < tx.size(); i += 1) {
			
			fileNumbers[i] = tx.get(i);
		}
			
		boolean flag; 
		
		for(int i = 0; i < tx.size(); i += 1) {
			
			flag = false;
			int index = fileNumbers[i];
			for(int k = 0; k < sizeOf; k +=1) // pointer 
				if(f[k] == index) {
					flag = true;
					hit += 1;
				}
			
			if(!flag) {
				f[j] = fileNumbers[i]; 
				j++;
				if(j >= sizeOf)
					j = 0;
				miss += 1;
				
			}
		}
	
	
	endTime = System.currentTimeMillis();

	
	}
	
	 public int hitReturn() {
			
     	return hit;
     }  
     
     public int missReturn() {
     	
     	return miss;
     }
     
 	
     public float timeExecution() {
     	long total = (endTime - startTime);
     	timeseconds = total / 1000.00f;      
     	return timeseconds;
     	
     }
}