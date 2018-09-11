package four.ways.algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import cache.simulador.readfile.ReadFileArray;
import cache.simulador.readfile.UX;

public class RANDOM4WAYS {

	static ReadFileArray r = new  ReadFileArray(); // static instance of ReadFileArray class
	public int hit = 0;
	public int miss = 0;
	public long endTime = 0;
	public long startTime = 0;
	public float timeseconds = 0;
	static UX ob = new UX();

	public void randomAlgorithm() throws IOException, FileNotFoundException  {

		startTime = System.currentTimeMillis();

		int j = 0;
		int sizeOf = 0;

		r.readFile(); // read fie 
		ArrayList<Integer> tx = r.convert(); // call array from method convert() in class ReadFileArray

		// random selector 
		Random removeAddn = new Random();
		System.out.println("Available items: " + tx); // shows input ArrayList<Integer>

		// selecting the index numbers 
		for(int b = 0; b < 50; b +=1) {
			int theIndexInNumber = removeAddn.nextInt(tx.size()); // size 
			int a = tx.get(theIndexInNumber);    // which element is going to be removed 			
			System.out.println("allright this is the number selected" + a); // print which ones were selected 
			tx.remove(theIndexInNumber); // remove
			int pick = removeAddn.nextInt(b+1);
			tx.add(pick);
		}

		System.out.println("New added items: " + tx); // show output ArrayList<Integer> 

		int fileNumbers[] = new int[tx.size()]; // array size to initialize array size of b[]

		sizeOf = ob.stringToConvert()/4;

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
