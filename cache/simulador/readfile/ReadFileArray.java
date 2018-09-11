package cache.simulador.readfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFileArray {
	
	int count = 0;
	int a = 0;
	private Scanner r = null;

	UX object = new UX();
	
	public void readFile() throws IOException {
		
		try {

			r = new Scanner(object.fileMethod()); // UX.file
			
			while(r.hasNextInt()) {
				count++;
				r.nextInt();
			}
			
		} catch(Exception fnf) {
			System.out.println(fnf.getMessage() + "The file could not be open, try again");
			System.exit(0);
		}
	 
	}
	
	public ArrayList<Integer> convert() throws FileNotFoundException, IOException  {
				
		int[] array = new int[count];
		
		ArrayList<Integer> dynamic = new ArrayList<>(count);
		Scanner fg = new Scanner(object.fileMethod());
		
		
		for(int i = 0; i < array.length; i++) {
			Integer letTheGameBegin = fg.nextInt();
				array[i] = letTheGameBegin;
			
				double saveNum = array[i];
				
				double x = saveNum / 16;
			
			if(x % 1 != 0 || x % 1 == 0) {
				
				int rslt = (int) Math.ceil(x);
				dynamic.add(rslt);
			}
		}
			
			fg.close();
		
		return dynamic;

	  	}

	public static void main(String[] args) throws FileNotFoundException, IOException  {

		ReadFileArray r = new  ReadFileArray();
		r.readFile();
		
		ArrayList<Integer> tx = r.convert();
		
		for(int i = 0; i < tx.size(); i +=1) {
			System.out.println(tx.get(i));
		}
	}
}