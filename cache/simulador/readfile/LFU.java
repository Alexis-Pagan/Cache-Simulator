package cache.simulador.readfile;

import java.io.*;
import java.util.ArrayList;
public class LFU
{

	static ReadFileArray r = new ReadFileArray();
	public int hit = 0;
	public int miss = 0;
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;
	public int minimum = 0;
	public int num = 0; 
	static UX ob = new UX();

	public void lfuAlgorithm() throws FileNotFoundException, IOException {
		startTime = System.currentTimeMillis();
		int sizeOf = 0;
		startTime = System.currentTimeMillis();
		sizeOf = ob.stringToConvert();

		r.readFile();

		ArrayList<Integer> tx = r.convert();
		boolean flag = true;

		int count[] = new int[100000]; // size of cache
		int frame[] = new int[sizeOf]; // size of frame
		int frequency[] = new int[sizeOf];
		int fileNumbers[] = new int[tx.size()];

		for(int i = 0; i < tx.size(); i += 1)
			fileNumbers[i] = tx.get(i);

		for(int i = 0; i < tx.size();  i += 1)
		{
			flag = true;
			int page = fileNumbers[i];

			for(int j = 0; j < sizeOf; j += 1)
			{
				if(frame[j] == page) // finding hits 
				{
					flag = false;
					hit++;
					count[page]++;
					break;
				}
			}
			if(flag) // lets find the frequently used 
			{
				if(i>=3)
				{
					miss+=1; // finding missing
					for(int j = 0; j < sizeOf; j += 1)
					{

						frequency[j] = frame[j]; // is it equal to

					}
					minimum = frequency[0];
					for(int j = 0; j < sizeOf; j += 1)
					{
						if(frequency[j] < minimum) // if frequency not present
						{
							minimum = frequency[j]; // assign frequency found
						}
					}
					for(int j = 0; j < sizeOf; j += 1)
					{
						if(frequency[j] == minimum)
						{                       
							count[page]++; // incrementing the count for frequency 

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

	// returning time
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