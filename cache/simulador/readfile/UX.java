package cache.simulador.readfile;

import java.awt.BorderLayout;		
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import four.ways.algorithms.DirectMapping4WAYS;
import four.ways.algorithms.FIFO4WAYS;
import four.ways.algorithms.LFU4WAYS;
import four.ways.algorithms.LRU4WAYS;
import four.ways.algorithms.OPTIMO4WAYS;
import four.ways.algorithms.RANDOM4WAYS;
import two.ways.algorithms.DirectMapping2WAYS;
import two.ways.algorithms.FIFO2WAYS;
import two.ways.algorithms.LFU2WAYS;
import two.ways.algorithms.LRU2WAYS;
import two.ways.algorithms.OPTIMO2WAYS;
import two.ways.algorithms.RANDOM2WAYS;

public class UX extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton selectFile, simulate, reset, exit;
	private JTextField cs;
	private JTextField search;
	private JLabel miss, hits, timeExec, searching, cache;
	private JLabel mappings, algorithms;
	private ButtonGroup options, options2, options3;
	private JRadioButton fifo, lru, lfu, optimum, random;
	private JRadioButton direct, fully;
	private JRadioButton settwo, setfour;
	private JPanel left;
	JFileChooser filechooser = new JFileChooser();
	static File file;
	public String number;
	public static int size;
	
	public UX() {
		super("Cache Simlulator Version: 1.0 By AGP Technologies");
		
		mappings = new JLabel("<HTML><U>Select Type of Mappings</U><HTML>");
		algorithms = new JLabel("<HTML><U>Replacement Algorithms</U><HTML>");
		searching = new JLabel("Search file:");
		cache = new JLabel("Size Cache:");
		cs = new JTextField(10);
		cs.setPreferredSize(new Dimension(4, 30));
		
		selectFile = new JButton("Select file");
		selectFile.setPreferredSize(new Dimension(100, 29));
		simulate = new JButton("Start simulation");
		reset = new JButton("Reset simulation");
		exit = new JButton("Exit simulation");
		
		search = new JTextField();
		search.setPreferredSize(new Dimension(250, 30));
		search.setEditable(false);
		search.setBackground(Color.white);
		
		fifo = new JRadioButton("fifo");
		lru = new JRadioButton("lru");
		lfu = new JRadioButton("lfu");
		optimum = new JRadioButton("optimum");
		random = new JRadioButton("random");
		
		direct = new JRadioButton("direct mapping");
		fully = new JRadioButton("fully");
		
		settwo = new JRadioButton("Set 2-way");
		setfour = new JRadioButton("Set 4-way");
		
		options = new ButtonGroup();
		options.add(fifo);
		options.add(lru);
		options.add(lfu);
		options.add(optimum);
		options.add(random);
		
		options2 = new ButtonGroup();
		options2.add(direct);
		options2.add(fully);
		
		
		options3 = new ButtonGroup();
		options3.add(settwo);
		options3.add(setfour);
		
		hits = new JLabel("Number of Hit:");
		hits.setFont(new Font("Serif", Font.PLAIN, 20));
		miss = new JLabel("Number of Miss:");
		miss.setFont(new Font("Serif", Font.PLAIN, 20));
		timeExec = new JLabel("Time of Execution:");
		timeExec.setFont(new Font("Serif", Font.PLAIN, 20));
		
		left = new JPanel(new GridBagLayout());
		left.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		GridBagConstraints one = new GridBagConstraints();
		one.fill = GridBagConstraints.HORIZONTAL;
		one.gridx = 0;
		one.gridy = 0;
		one.ipadx = 0;
		one.ipady = 0;
		one.insets = new Insets(0, 0, 0, 0);
		left.add(searching, one);
	
		GridBagConstraints two = new GridBagConstraints();
		two.fill = GridBagConstraints.HORIZONTAL;
		two.gridx = 0;
		two.gridy = 1;
		two.ipadx = 0;
		two.gridwidth = 2;
		two.ipady = 0;
		two.insets = new Insets(5, 0, 0, 0);
		left.add(search, two);
		
		GridBagConstraints three = new GridBagConstraints();
		three.fill = GridBagConstraints.HORIZONTAL;
		three.gridx = 2;
		three.gridy = 1;
		three.ipady = 0;
		three.ipadx = 0;
		three.insets = new Insets(5, 5, 0, 0); 
		left.add(selectFile, three);
		
		GridBagConstraints four = new GridBagConstraints();
		four.fill = GridBagConstraints.HORIZONTAL;
		four.gridx = 0;
		four.gridy = 2;
		four.ipady = 0;
		four.ipadx = 0;
		four.insets = new Insets(20, 0, 0, 0);
		left.add(cache, four);
		
		GridBagConstraints five = new GridBagConstraints();
		five.fill = GridBagConstraints.HORIZONTAL;
		five.gridx = 0;
		five.gridy = 3;
		five.ipady = 0;
		five.ipadx = 0;
		five.gridwidth = 1;
		five.insets = new Insets(5, 0, 0, 0);
		left.add(cs, five);
		
		GridBagConstraints label = new GridBagConstraints();
		label.fill = GridBagConstraints.HORIZONTAL;
		label.gridx = 0;
		label.ipadx = 0;
		label.ipady = 0;
		label.gridy = 4;
		label.insets = new Insets(20, 0, 0, 0);
		left.add(mappings, label);
		
		GridBagConstraints buttons = new GridBagConstraints();
		buttons.fill = GridBagConstraints.HORIZONTAL;
		buttons.gridx = 0;
		buttons.gridy = 5;
		buttons.ipadx = 0;
		buttons.ipady = 0;
		left.add(direct, buttons);
		
		GridBagConstraints buttons2 = new GridBagConstraints();
		buttons2.fill = GridBagConstraints.HORIZONTAL;
		buttons2.gridx = 0;
		buttons2.ipadx = 0;
		buttons2.ipady = 0;
		buttons2.gridy = 6;
		left.add(fully, buttons2);
		
		///////////////////////////////////////////////////////
		GridBagConstraints set2 = new GridBagConstraints();
		set2.fill = GridBagConstraints.HORIZONTAL;
		set2.gridx = 0;
		set2.ipadx = 0;
		set2.ipady = 0;
		set2.gridy = 7;
		left.add(settwo, set2);
		
		
		GridBagConstraints set4 = new GridBagConstraints();
		set4.fill = GridBagConstraints.HORIZONTAL;
		set4.gridx = 0;
		set4.ipadx = 0;
		set4.ipady = 1;
		set4.gridy = 8;
		left.add(setfour, set4);
		
		GridBagConstraints algo = new GridBagConstraints();
		algo.fill = GridBagConstraints.HORIZONTAL;
		algo.gridx = 0;
		algo.ipadx = 0;
		algo.ipady = 0;
		algo.gridy = 9;
		algo.insets = new Insets(20, 0, 0, 0);
		left.add(algorithms, algo);
		
		
		GridBagConstraints ff = new GridBagConstraints();
		ff.fill = GridBagConstraints.HORIZONTAL;
		ff.gridx = 0;
		ff.ipadx = 0;
		ff.ipady = 0;
		ff.gridy = 10;
		left.add(fifo, ff);
		
		GridBagConstraints ll = new GridBagConstraints();
		ll.fill = GridBagConstraints.HORIZONTAL;
		ll.gridx = 0;
		ll.ipadx = 0;
		ll.ipady = 0;
		ll.gridy = 11;
		left.add(lru, ll);
		
		GridBagConstraints lr = new GridBagConstraints();
		lr.fill = GridBagConstraints.HORIZONTAL;
		lr.gridx = 0;
		lr.ipadx = 0;
		lr.ipady = 0;
		lr.gridy = 12;
		left.add(lfu, lr);
		
		GridBagConstraints op = new GridBagConstraints();
		op.fill = GridBagConstraints.HORIZONTAL;
		op.gridx = 1;
		op.ipadx = 0;
		op.ipady = 0;
		op.gridy = 10;
		left.add(optimum, op);
		
		GridBagConstraints ran = new GridBagConstraints();
		ran.fill = GridBagConstraints.HORIZONTAL;
		ran.gridx = 1;
		ran.ipadx = 0;
		ran.ipady = 0;
		ran.gridy = 11;
		left.add(random, ran);
		
		GridBagConstraints btn1 = new GridBagConstraints();
		btn1.fill = GridBagConstraints.HORIZONTAL;
		btn1.gridx = 0;
		btn1.ipadx = 0;
		btn1.ipady = 0;
		btn1.gridy = 13;
		btn1.insets = new Insets(20, 0, 0, 0); 
		left.add(simulate, btn1);
		
		GridBagConstraints h = new GridBagConstraints();
		h.fill = GridBagConstraints.HORIZONTAL;
		h.gridx = 0;
		h.ipadx = 0;
		h.ipady = 0;
		h.gridy = 14;
		h.insets = new Insets(20, 0, 0, 0); 
		left.add(hits, h);
		
		GridBagConstraints m = new GridBagConstraints();
		m.fill = GridBagConstraints.HORIZONTAL;
		m.gridx = 0;
		m.ipadx = 0;
		m.ipady = 0;
		m.gridy = 15;
		m.insets = new Insets(5, 0, 0, 0); 
		left.add(miss, m);
		
		GridBagConstraints exec = new GridBagConstraints();
		exec.fill = GridBagConstraints.HORIZONTAL;
		exec.gridx = 0;
		exec.ipadx = 0;
		exec.ipady = 0;
		exec.gridy = 16;
		exec.insets = new Insets(5, 0, 0, 0); 
		left.add(timeExec, exec);
		
		/*right = new JPanel(new GridBagLayout());
		right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		right.add(area);
		right.add(hits);
		right.add(miss);*/
		
		
		setLayout(new BorderLayout());
		add(left, BorderLayout.WEST);
//		add(right, BorderLayout.EAST);
		
		selectFile.addActionListener(this);
		fifo.addActionListener(this);
		lru.addActionListener(this);
		lfu.addActionListener(this);
		direct.addActionListener(this);
		fully.addActionListener(this);
		optimum.addActionListener(this);
		random.addActionListener(this);
		simulate.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
		cs.addActionListener(this);
		
	}
	
	public void openFile() {
	
	
	filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	
	 int retVal = filechooser.showOpenDialog(null);
	
		if(retVal == JFileChooser.APPROVE_OPTION) {
			file = filechooser.getSelectedFile();
		} else {
			
			// replace with JOPtionPane 
			System.out.print("File was not selected.");
		}
	
	}
	
	public File fileMethod() {
		
		return file;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	if(direct.isSelected() && fifo.isSelected()) {
		ErrorChecking object = new ErrorChecking();
		object.radioButtonsException();
	} else if(direct.isSelected() && lru.isSelected()) {
		ErrorChecking object = new ErrorChecking();
		object.radioButtonsException();
	} else if(direct.isSelected() && lfu.isSelected()) {
		ErrorChecking object = new ErrorChecking();
		object.radioButtonsException();
	} else if(direct.isSelected() && optimum.isSelected()) {
		ErrorChecking object = new ErrorChecking();
		object.radioButtonsException();
	} else if(direct.isSelected() && random.isSelected()) {
		ErrorChecking object = new ErrorChecking();
		object.radioButtonsException();
	}
	
	if(number == "^[a-zA-Z]+$" || number == "." || number == "," || number == "") {
		ErrorChecking object = new ErrorChecking();
		object.sizeOfCacheException();
	}

	if(e.getSource() != exit) {
		if(e.getSource() == selectFile) {			
			UX object = new UX();
			object.openFile();
			search.setText(object.filechooser.getSelectedFile().getAbsolutePath());
		}
		
		if(fully.isSelected()) {
			
			if(fifo.isSelected() && e.getSource() == simulate) {
			FIFO ob = new FIFO();
				try {
					number = cs.getText();
					size = Integer.parseInt(number);
					ob.fifoAlgorithm();
					hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
					miss.setText(String.format("Number of Miss: " + ob.missReturn()));
					timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			if(fifo.isSelected() && settwo.isSelected() && e.getSource() == simulate) {
				FIFO2WAYS ob1 = new FIFO2WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob1.fifoAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob1.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob1.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob1.timeExecution()));

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
			if(fifo.isSelected() && setfour.isSelected() && e.getSource() == simulate) {
				FIFO4WAYS ob1 = new FIFO4WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob1.fifoAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob1.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob1.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob1.timeExecution()));

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
			if(optimum.isSelected() && e.getSource() == simulate) {
				OPTIMO ob = new OPTIMO();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.Optimo();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(optimum.isSelected() && settwo.isSelected() && e.getSource() == simulate) {
				OPTIMO2WAYS ob = new OPTIMO2WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.optimusPrime();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(optimum.isSelected() && setfour.isSelected() && e.getSource() == simulate) {
				OPTIMO4WAYS ob = new OPTIMO4WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.optimusPrime();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			
			if(lru.isSelected() && e.getSource() == simulate) {
				LRU ob = new LRU();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.lruAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(lru.isSelected() && settwo.isSelected() && e.getSource() == simulate) {
				LRU2WAYS ob = new LRU2WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.lruAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(lru.isSelected() && setfour.isSelected() && e.getSource() == simulate) {
				LRU4WAYS ob = new LRU4WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.lruAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			
			if(random.isSelected() && e.getSource() == simulate) {
				RANDOM ob = new RANDOM();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.randomAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(random.isSelected() && settwo.isSelected() && e.getSource() == simulate) {
				RANDOM2WAYS ob = new RANDOM2WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.randomAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(random.isSelected() && setfour.isSelected() && e.getSource() == simulate) {
				RANDOM4WAYS ob = new RANDOM4WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.randomAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(lfu.isSelected() && e.getSource() == simulate) {
				LFU ob = new LFU();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.lfuAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(lfu.isSelected() && settwo.isSelected() && e.getSource() == simulate) {
				LFU2WAYS ob = new LFU2WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.lfuAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			if(lfu.isSelected() && setfour.isSelected() && e.getSource() == simulate) {
				LFU4WAYS ob = new LFU4WAYS();
					try {
						number = cs.getText();
						size = Integer.parseInt(number);
						ob.lfuAlgorithm();
						hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
						miss.setText(String.format("Number of Miss: " + ob.missReturn()));
						timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
		
		if(direct.isSelected() && e.getSource() == simulate) {
			DirectMap ob = new DirectMap();
				try {
					number = cs.getText();
					size = Integer.parseInt(number);
					ob.directMap();
					hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
					miss.setText(String.format("Number of Miss: " + ob.missReturn()));
					timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		if(direct.isSelected() && settwo.isSelected() && e.getSource() == simulate) {
			DirectMapping2WAYS ob = new DirectMapping2WAYS();
				try {
					number = cs.getText();
					size = Integer.parseInt(number);
					ob.directMap();
					hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
					miss.setText(String.format("Number of Miss: " + ob.missReturn()));
					timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		if(direct.isSelected() && setfour.isSelected() && e.getSource() == simulate) {
			DirectMapping4WAYS ob = new DirectMapping4WAYS();
				try {
					number = cs.getText();
					size = Integer.parseInt(number);
					ob.directMap();
					hits.setText(String.format("Number of Hits: " + ob.hitReturn()));
					miss.setText(String.format("Number of Miss: " + ob.missReturn()));
					timeExec.setText(String.format("Time of Execution:" + ob.timeExecution()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		
		
		}	
	}

	public int stringToConvert() {
		return size;
	}
	
	public static void main(String[] args) {
		
		UX frame = new UX();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 750);
		frame.setVisible(true);
		frame.setResizable(true);
	}
}
