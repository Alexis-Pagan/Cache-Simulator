package cache.simulador.readfile;

import javax.swing.JFrame;	
import javax.swing.JOptionPane;

public class ErrorChecking extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public void radioButtonsException() {
		
		JOptionPane.showMessageDialog(null, "Do not select: direct mapping and replacements algorithms. Select: "
				+ "Direct Mapping and then start simulation button. However, if you select 'Fully', then select an option of replacement algorithm and then press start simulation.");
	}
	
	public void sizeOfCacheException() {
		JOptionPane.showMessageDialog(null, "Decimal values or special  or any characters are not permitted for this type of program, please enter positive integers or non-decimal numbers.");
	}
	
	public void fileNotPresentException() {
		JOptionPane.showMessageDialog(null, "File not selected");
	}
}
