package cache.simulador.readfile;

import java.io.IOException;
import java.util.*;

public class OPTIMO 
{
	static ReadFileArray r = new ReadFileArray();
	public int hit = 0;
	public int miss = 0;
	public boolean flag = false;
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;
	static UX ob = new UX();

	public void Optimo() throws IOException {

		startTime = System.currentTimeMillis();

		int locationFrame;

		int sizeOf = 0; // size of cache 
		r.readFile(); // calling read method 
		ArrayList<Integer> tx = r.convert(); // calling the returned array

		sizeOf = ob.stringToConvert(); // size of cache 

		int fileNumbers[] = new int[tx.size()];
		int f[] = new int[sizeOf];
		int finder[] = new int[sizeOf];

		for(int i = 0; i < tx.size(); i += 1) 
			fileNumbers[i] = tx.get(i);

		for(int i = 0; i < sizeOf; i = i + 1)
		{
			
			for(int t = 0; t < tx.size(); t ++) 
				
			f[i] = fileNumbers[t]; 
			finder[i] = 0;
			
		}
		for(int i = 0; i < tx.size(); i +=1)
		{
			for(int j = 0; j < sizeOf; j +=1)
			{
				if(f[j] == fileNumbers[i])
				{
					
					flag= true;
					hit +=1;
					break;
				}
				else
					flag= false;
			}
			if(!flag)
			{
				for(int j = 0; j < sizeOf; j +=1)
				{
					for(int k = i + 1; k < tx.size(); k +=1)
					{
						if(f[j] == fileNumbers[k])
							
							finder[j] = k;
						
						
						else
							finder[j] = 0;
						
					}
				}
				locationFrame = movingfinder(finder, sizeOf);
				f[locationFrame] = fileNumbers[i];
				miss++;
			}
		}
		endTime = System.currentTimeMillis();
	}
	static int movingfinder(int finder[],int size)
	{
		int locationFrame=0;
		
		for(int i = 1; i < size; i +=1)
			// coloca le finder en su posicion real
			if((finder[i] > finder[i-1]) && (finder[i]!=0))
				
				locationFrame=i;
		
		return locationFrame;
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