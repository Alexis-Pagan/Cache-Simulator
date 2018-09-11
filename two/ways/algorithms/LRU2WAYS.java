package two.ways.algorithms;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import cache.simulador.readfile.ReadFileArray;
import cache.simulador.readfile.UX;

public class LRU2WAYS
{
	static ReadFileArray r = new ReadFileArray();
	static UX ob = new UX();
	public int hit = 0;
	public int miss = 0; 
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;

	public void lruAlgorithm() throws IOException, FileNotFoundException {

		startTime = System.currentTimeMillis();
		int sizeOf = 0;

		r.readFile();
		ArrayList<Integer> tx = r.convert();

		sizeOf = ob.stringToConvert()/2;

		int f[]=new int[sizeOf];		
		int fileNumbers[] = new int[tx.size()];
		int age[]=new int[sizeOf];

		for(int i = 0; i < sizeOf; i +=1)

			f[i] = -1;

		for(int i = 0; i < tx.size(); i +=1)

			fileNumbers[i]= tx.get(i);

		for(int i = 0; i < sizeOf; i +=1)

			age[i]= 0;

		boolean flag; 

		for(int j = 0, i = 0; j < sizeOf && i < tx.size(); j = j % sizeOf, i++)
		{
			flag = false;

			for(int k = 0; k < sizeOf; k +=1)
			{
				if(f[k]== fileNumbers[i])
				{
					flag = true;
					hit++;
					age[k] = 0; 
				}
			}
			if(flag == false)

				if(f[j] == -1)
				{ 

					f[j] = fileNumbers[i];
					miss++;
					j++;
				}
				else

				{
					int max = age[0], loc = 0;
					miss++;

					for(int b = 0; b < sizeOf; b +=1)
						if(age[b]>max)
						{
							max = age[b];loc = b;
						}
					f[loc] = fileNumbers[i];
					age[loc] = 0;
					j++;
				} 

			for(int a = 0; a < sizeOf; a +=1)
			{
				if(f[a] == -1)
					age[a] = 0;
				else
					age[a]++;
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