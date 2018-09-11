package two.ways.algorithms;


import java.io.*;		
import java.util.ArrayList;

import cache.simulador.readfile.ReadFileArray;
import cache.simulador.readfile.UX;

public class FIFO2WAYS {


	static ReadFileArray r = new  ReadFileArray(); // static instance of ReadFileArray class 
	public int hit = 0;
	public int miss = 0;
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;
	public int set = 2;
	static UX ob = new UX();

	public void fifoAlgorithm() throws IOException, FileNotFoundException {

		startTime = System.currentTimeMillis();
		int j = 0;
		int sizeOf = 0;

		r.readFile(); // read file 
		ArrayList<Integer> tx = r.convert(); // call array from method convert() in class ReadFileArray
		int fileNumbers[] = new int[tx.size()]; // array size to initialize array size of b[]

		sizeOf = ob.stringToConvert()/2;

		int f[] = new int[sizeOf]; // # of frames in cache 

			for(int i = 0; i < tx.size(); i +=1)

				fileNumbers[i] = tx.get(i); // get array elements inside b[i]

		boolean flag;

		for(int i = 0; i < tx.size(); i +=1) // run until .size is meet
		{
			flag = false; 

			for(int k = 0; k < sizeOf; k +=1)  
				if(f[k] == fileNumbers[i]) // if found same number 
				{
					flag = true; // found it 
					hit += 1; // hit 
				}

			if(!flag) { // if flag is false 
				f[j] = fileNumbers[i]; // assign what is in b[i]
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