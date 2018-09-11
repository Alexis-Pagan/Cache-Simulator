package four.ways.algorithms;


import java.io.*;
import java.util.ArrayList;

import cache.simulador.readfile.ReadFileArray;
import cache.simulador.readfile.UX;
public class LFU4WAYS
{

	static ReadFileArray r = new ReadFileArray();
	public int hit = 0;
	public int miss = 0;
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;
	public int min = 0;
	public int num = 0; 
	static UX ob = new UX();

	public void lfuAlgorithm() throws FileNotFoundException, IOException {
		startTime = System.currentTimeMillis();
		int sizeOf = 0;
		startTime = System.currentTimeMillis();
		sizeOf = ob.stringToConvert()/4;

		r.readFile();

		ArrayList<Integer> tx = r.convert();

		boolean flag = true;

		int count[] = new int[100000]; // size of cache
		int frame[] = new int[sizeOf]; // size of frame
		int frequency[] = new int[sizeOf];
		int fileNumbers[] = new int[tx.size()];

		for(int i=0;i<tx.size();i++)
			fileNumbers[i] = tx.get(i);

		for(int i=0; i<tx.size(); i++)
		{
			flag = true;
			int page = fileNumbers[i];

			for(int j=0; j<sizeOf; j++)
			{
				if(frame[j] == page)
				{
					flag = false;
					hit++;
					count[page]++;
					break;
				}
			}
			if(flag)
			{
				if(i>=3)
				{
					miss+=1;
					for(int j=0; j< sizeOf; j++)
					{

						frequency[j] = frame[j];

					}
					min = frequency[0];
					for(int j=0; j<sizeOf; j++)
					{
						if(frequency[j] < min)
						{
							min = frequency[j];
						}
					}
					for(int j=0; j<sizeOf; j++)
					{
						if(frequency[j] == min)
						{                       
							count[page]++;

							frame[j] = page;
							break;
						}
					}
				}
				else
				{
					frame[i]=page;
					count[page]++;
				}
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