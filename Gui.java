import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
	
	String[] buttons = {"EXT", "DEL", "CLR", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/", "(", "0", ")", "="};
	private JPanel calcuPanel;
	private JPanel convertPanel;
	private JPanel evaluatePanel;
	private JPanel panelButton;
	private JPanel textPanel;
	private JPanel convertTitle;
	private JPanel evaluateTitle;
	private JPanel panelCovert;
	private JPanel panelEvaluate;
	
	private JPanel readPanel;
	private JPanel parsePanel;
	private JPanel writePanel;
	private JPanel stackPanel;
	private JPanel queuePanel;
	private JPanel arrayPanel;
	
	private JPanel readP;
	private JPanel pushP;
	private JPanel popP;
	private JPanel evaluateP;
	private JPanel resultP;
	
	private JLabel read;
	private JLabel pushL;
	private JLabel popL;
	private JLabel evaluateL;
	private JLabel resultL;
	
	private JLabel readL;
	private JLabel parseL;
	private JLabel writeL;
	private JLabel stackL;
	private JLabel queueL;
	private JLabel arrayL;
	
	private JLabel label;
	private JLabel convertLabel;
	private JLabel evaluateLabel;
	
	private JButton[] button = new JButton[buttons.length];
	String str = "";
	int ctr = 0;
	
	public Gui(){
		super("A Crazy Calculator");
		setLayout(new GridLayout(1,3,3,3));
		
		calcuPanel = new JPanel();
		calcuPanel.setBackground(Color.BLACK);
		add(calcuPanel);
		
		convertPanel = new JPanel();
		convertPanel.setBackground(Color.BLACK); 
		add(convertPanel);
		
		evaluatePanel = new JPanel();
		evaluatePanel.setBackground(Color.BLACK); 
		add(evaluatePanel);
		
		convertTitle = new JPanel();
		convertTitle.setBackground(Color.BLACK); 
		convertTitle.setPreferredSize(new Dimension(320,120));
		convertPanel.add(convertTitle);
		
		evaluateTitle = new JPanel();
		evaluateTitle.setBackground(Color.BLACK); 
		evaluateTitle.setPreferredSize(new Dimension(320,120));
		evaluatePanel.add(evaluateTitle);
		
		convertLabel = new JLabel("INFIX TO POSTFIX",SwingConstants.CENTER);
		convertLabel.setForeground(Color.WHITE);
		convertLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		convertTitle.add(convertLabel);
		
		evaluateLabel = new JLabel("EVALUATION",SwingConstants.CENTER);
		evaluateLabel.setForeground(Color.WHITE);
		evaluateLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		evaluateTitle.add(evaluateLabel);
		
		panelCovert = new JPanel(new GridLayout(6,1,1,1));
		panelCovert.setBackground(Color.WHITE);
		convertPanel.add(panelCovert);
		
		panelEvaluate = new JPanel(new GridLayout(5,1,1,1));
		panelEvaluate.setBackground(Color.WHITE);
		evaluatePanel.add(panelEvaluate);
		
		readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		readPanel.setBackground(new Color(39, 39, 39));
		readPanel.setPreferredSize(new Dimension(320,66));
		panelCovert.add(readPanel);
		
		readP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		readP.setBackground(new Color(39, 39, 39));
		readP.setPreferredSize(new Dimension(320,80));
		panelEvaluate.add(readP);
		
		readL = new JLabel("READ: ", SwingConstants.LEFT);
		readL.setFont(new Font("Serif", Font.PLAIN, 20));
		readL.setForeground(Color.WHITE);
		readPanel.add(readL);
		
		read = new JLabel("READ: ", SwingConstants.LEFT);
		read.setFont(new Font("Serif", Font.PLAIN, 20));
		read.setForeground(Color.WHITE);
		readP.add(read);
		
		parsePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		parsePanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(parsePanel);
		
		pushP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pushP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(pushP);
		
		popP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		popP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(popP);
		
		parseL = new JLabel("PARSE: ", SwingConstants.LEFT);
		parseL.setFont(new Font("Serif", Font.PLAIN, 20));
		parseL.setForeground(Color.WHITE);
		parsePanel.add(parseL);
		
		pushL = new JLabel("PUSH: ", SwingConstants.LEFT);
		pushL.setFont(new Font("Serif", Font.PLAIN, 20));
		pushL.setForeground(Color.WHITE);
		pushP.add(pushL);
		
		popL = new JLabel("POP: ", SwingConstants.LEFT);
		popL.setFont(new Font("Serif", Font.PLAIN, 20));
		popL.setForeground(Color.WHITE);
		popP.add(popL);
		
		writePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		writePanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(writePanel);
		
		evaluateP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		evaluateP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(evaluateP);
		
		writeL = new JLabel("WRITTEN: ", SwingConstants.LEFT);
		writeL.setFont(new Font("Serif", Font.PLAIN, 20));
		writeL.setForeground(Color.WHITE);
		writePanel.add(writeL);
		
		evaluateL = new JLabel("EVALUATE: ", SwingConstants.LEFT);
		evaluateL.setFont(new Font("Serif", Font.PLAIN, 20));
		evaluateL.setForeground(Color.WHITE);
		evaluateP.add(evaluateL);
		
		stackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		stackPanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(stackPanel);
		
		resultP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		resultP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(resultP);
		
		stackL = new JLabel("STACK: ", SwingConstants.LEFT);
		stackL.setFont(new Font("Serif", Font.PLAIN, 20));
		stackL.setForeground(Color.WHITE);
		stackPanel.add(stackL);
		
		resultL = new JLabel("STACK: ", SwingConstants.LEFT);
		resultL.setFont(new Font("Serif", Font.PLAIN, 20));
		resultL.setForeground(Color.WHITE);
		resultP.add(resultL);
		
		queuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		queuePanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(queuePanel);
		
		queueL = new JLabel("QUEUE: ", SwingConstants.LEFT);
		queueL.setFont(new Font("Serif", Font.PLAIN, 20));
		queueL.setForeground(Color.WHITE);
		queuePanel.add(queueL);
		
		arrayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		arrayPanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(arrayPanel);
		
		arrayL = new JLabel("ARRAY: ", SwingConstants.LEFT);
		arrayL.setFont(new Font("Serif", Font.PLAIN, 20));
		arrayL.setForeground(Color.WHITE);
		arrayPanel.add(arrayL);
		
		
		
		textPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		textPanel.setPreferredSize(new Dimension(320,120));
		textPanel.setBackground(Color.BLACK);
		calcuPanel.add(textPanel);
		
		panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(5,4,1,1));
		panelButton.setBackground(Color.BLACK);
		calcuPanel.add(panelButton);
		
		label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		textPanel.add(label);
		
		ButtonHandler handler = new ButtonHandler();
		
		for(int i = 0; i < buttons.length; i++){
			button[i] = new JButton(buttons[i]);
            button[i].setPreferredSize(new Dimension(80, 80));
			button[i].setForeground(Color.WHITE);
			button[i].setFocusable(false);
			button[i].setFont(new Font("Serif", Font.PLAIN, 22));
			button[i].addActionListener(handler);
			panelButton.add(button[i]);
		}
		
		for(int i = 0; i < 4; i++){
			button[i].setBackground(new Color(39,39,39));
		}
		button[7].setBackground(new Color(39,39,39));
		button[11].setBackground(new Color(39,39,39));
		button[15].setBackground(new Color(39,39,39));
		button[16].setBackground(new Color(39,39,39));
		button[17].setBackground(new Color(0, 46, 70));
		button[18].setBackground(new Color(39,39,39));
		button[19].setBackground(new Color(39,39,39));
		
		for(int i = 4; i < 7; i++){
			button[i].setBackground(new Color(0, 46, 70));
		}
		
		for(int i = 8; i < 11; i++){
			button[i].setBackground(new Color(0, 46, 70));
		}
		
		for(int i = 12; i < 15; i++){
			button[i].setBackground(new Color(0, 46, 70));
		}
		
		
	}
	
	public class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			for(int i = 0; i < buttons.length; i++){
				if(event.getSource() == button[i]){
					if(i == 0 || i == 1 || i == 2 || i == 3 || i == 7 || i == 11 || i == 15 || i == 16 || i == 18){
						str += "";
						label.setText(str);
						
						if(event.getSource() == button[0]){
							System.exit(0);
						}
						
						if(event.getSource() == button[1]){
						
						}
					
						if(event.getSource() == button[2]){
							str = "";
							label.setText(str);
						}
						
						if(event.getSource() == button[3]){
							str += " + ";
							label.setText(str);
							for(int j = 3; j < button.length; j += 4){
								button[j].setEnabled(false);
							}
				
							button[16].setEnabled(true);
							button[18].setEnabled(false);
							
						}
						
						if(event.getSource() == button[7]){
							str += " - ";
							label.setText(str);
							for(int j = 3; j < button.length; j += 4){
								button[j].setEnabled(false);
							}
				
							button[16].setEnabled(true);
							button[18].setEnabled(false);
						}
						
						if(event.getSource() == button[11]){
							str += " * ";
							label.setText(str);
							for(int j = 3; j < button.length; j += 4){
								button[j].setEnabled(false);
							}
				
							button[16].setEnabled(true);
							button[18].setEnabled(false);
						}
						
						if(event.getSource() == button[15]){
							str += " / ";
							label.setText(str);
							for(int j = 3; j < button.length; j += 4){
								button[j].setEnabled(false);
							}
				
							button[16].setEnabled(true);
							button[18].setEnabled(false);
						}
						
						if(event.getSource() == button[16]){
							str += "( ";
							label.setText(str);
						}
						
						if(event.getSource() == button[18]){
							str += " )";
							label.setText(str);
						}
						
					}else if(event.getSource() == button[19]){
						Converter convert = new Converter();
						convert.infixToPostfix(str);
					}else{
						for(int j = 3; j < button.length; j += 4){
								button[j].setEnabled(true);
							}
				
							button[16].setEnabled(false);
							button[18].setEnabled(true);
						
						if(ctr < 15){
							str += buttons[i];
							label.setText(str);
							ctr++;
						}else{
							JOptionPane.showMessageDialog(null, "The input must contain 15 characters only.");
						}
					}
				}
			}
		}
	}
} 