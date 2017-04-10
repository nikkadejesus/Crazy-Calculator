import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{

	String[] buttons = {"EXT", "DEL", "CLR", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/", "(", "0", ")", "="};
	public static JPanel calcuPanel;
	public static JPanel convertPanel;
	public static JPanel evaluatePanel;
	public static JPanel panelButton;
	public static JPanel textPanel;
	public static JPanel convertTitle;
	public static JPanel evaluateTitle;
	public static JPanel panelCovert;
	public static JPanel panelEvaluate;

	public static JPanel readPanel;
	public static JPanel parsePanel;
	public static JPanel writePanel;
	public static JPanel stackPanel;
	public static JPanel queue1Panel;
	public static JPanel queue2Panel;
	public static JPanel arrayPanel;
	
	public static JLabel readL;
	public static JLabel parseL;
	public static JLabel writeL;
	public static JLabel stackL;
	public static JLabel queue1L;
	public static JLabel queue2L;
	public static JLabel arrayL;
	
	public static JPanel readP;
	public static JPanel stackP;
	public static JPanel queue1P;
	public static JPanel queue2P;
	public static JPanel arrayP;
	public static JPanel evaluateP;
	public static JPanel resultP;

	public static JLabel readLabel;
	public static JLabel stackLabel;
	public static JLabel queue1Label;
	public static JLabel queue2Label;
	public static JLabel arrayLabel;
	public static JLabel evaluateL;
	public static JLabel resultLabel;
	
	public static JLabel label;
	public static JLabel convertLabel;
	public static JLabel evaluateLabel;
	
	public static JLabel[][] labelConvert = new JLabel[7][15];
	public static JLabel[][] labelEvaluate = new JLabel[7][15];
	public JButton[] button = new JButton[buttons.length];
	String str = "";
	int ctr = 0;
	int ctr2 = 0;

	public Gui(){
		super("A Crazy Calculator");
		setLayout(new GridLayout(1,3,3,3));
		
		//Calculator Panel
		calcuPanel = new JPanel();
		calcuPanel.setBackground(Color.BLACK);
		add(calcuPanel);
		
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
		
		//Convert Panel
		convertPanel = new JPanel();
		convertPanel.setBackground(Color.BLACK);
		add(convertPanel);
		
		convertTitle = new JPanel();
		convertTitle.setBackground(Color.BLACK);
		convertTitle.setPreferredSize(new Dimension(320,120));
		convertPanel.add(convertTitle);
		
		convertLabel = new JLabel("INFIX TO POSTFIX",SwingConstants.CENTER);
		convertLabel.setForeground(Color.WHITE);
		convertLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		convertTitle.add(convertLabel);
		
		panelCovert = new JPanel(new GridLayout(7,1,1,1));
		panelCovert.setBackground(Color.WHITE);
		convertPanel.add(panelCovert);
		
		readPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		readPanel.setBackground(new Color(39, 39, 39));
		readPanel.setPreferredSize(new Dimension(320,56));
		panelCovert.add(readPanel);
		
		readL = new JLabel("READ: ", SwingConstants.LEFT);
		readL.setFont(new Font("Serif", Font.PLAIN, 20));
		readL.setForeground(Color.WHITE);
		readPanel.add(readL);
		
		parsePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		parsePanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(parsePanel);
		
		parseL = new JLabel("PARSE: ", SwingConstants.LEFT);
		parseL.setFont(new Font("Serif", Font.PLAIN, 20));
		parseL.setForeground(Color.WHITE);
		parsePanel.add(parseL);
		
		writePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		writePanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(writePanel);
		
		writeL = new JLabel("WRITTEN: ", SwingConstants.LEFT);
		writeL.setFont(new Font("Serif", Font.PLAIN, 20));
		writeL.setForeground(Color.WHITE);
		writePanel.add(writeL);
		
		stackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		stackPanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(stackPanel);
		
		stackL = new JLabel("STACK: ", SwingConstants.LEFT);
		stackL.setFont(new Font("Serif", Font.PLAIN, 20));
		stackL.setForeground(Color.WHITE);
		stackPanel.add(stackL);
		
		queue1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		queue1Panel.setBackground(new Color(39, 39, 39));
		panelCovert.add(queue1Panel);

		queue1L = new JLabel("QUEUE 1: ", SwingConstants.LEFT);
		queue1L.setFont(new Font("Serif", Font.PLAIN, 20));
		queue1L.setForeground(Color.WHITE);
		queue1Panel.add(queue1L);
		
		queue2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		queue2Panel.setBackground(new Color(39, 39, 39));
		panelCovert.add(queue2Panel);

		queue2L = new JLabel("QUEUE 2: ", SwingConstants.LEFT);
		queue2L.setFont(new Font("Serif", Font.PLAIN, 20));
		queue2L.setForeground(Color.WHITE);
		queue2Panel.add(queue2L);

		arrayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		arrayPanel.setBackground(new Color(39, 39, 39));
		panelCovert.add(arrayPanel);

		arrayL = new JLabel("ARRAY: ", SwingConstants.LEFT);
		arrayL.setFont(new Font("Serif", Font.PLAIN, 20));
		arrayL.setForeground(Color.WHITE);
		arrayPanel.add(arrayL);

		//Evaluate Panel
		evaluatePanel = new JPanel();
		evaluatePanel.setBackground(Color.BLACK);
		add(evaluatePanel);

		evaluateTitle = new JPanel();
		evaluateTitle.setBackground(Color.BLACK);
		evaluateTitle.setPreferredSize(new Dimension(320,120));
		evaluatePanel.add(evaluateTitle);

		evaluateLabel = new JLabel("EVALUATION",SwingConstants.CENTER);
		evaluateLabel.setForeground(Color.WHITE);
		evaluateLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		evaluateTitle.add(evaluateLabel);

		panelEvaluate = new JPanel(new GridLayout(7,1,1,1));
		panelEvaluate.setBackground(Color.WHITE);
		evaluatePanel.add(panelEvaluate);

		readP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		readP.setBackground(new Color(39, 39, 39));
		readP.setPreferredSize(new Dimension(320,56));
		panelEvaluate.add(readP);

		readLabel = new JLabel("READ: ", SwingConstants.LEFT);
		readLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		readLabel.setForeground(Color.WHITE);
		readP.add(readLabel);

		stackP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		stackP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(stackP);

		queue1P = new JPanel(new FlowLayout(FlowLayout.LEFT));
		queue1P.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(queue1P);
		
		queue2P = new JPanel(new FlowLayout(FlowLayout.LEFT));
		queue2P.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(queue2P);
		
		arrayP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		arrayP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(arrayP);

		stackLabel = new JLabel("STACK: ", SwingConstants.LEFT);
		stackLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		stackLabel.setForeground(Color.WHITE);
		stackP.add(stackLabel);

		queue1Label = new JLabel("QUEUE 1: ", SwingConstants.LEFT);
		queue1Label.setFont(new Font("Serif", Font.PLAIN, 20));
		queue1Label.setForeground(Color.WHITE);
		queue1P.add(queue1Label);
		
		queue2Label = new JLabel("QUEUE 2: ", SwingConstants.LEFT);
		queue2Label.setFont(new Font("Serif", Font.PLAIN, 20));
		queue2Label.setForeground(Color.WHITE);
		queue2P.add(queue2Label);
		
		arrayLabel = new JLabel("ARRAY: ", SwingConstants.LEFT);
		arrayLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		arrayLabel.setForeground(Color.WHITE);
		arrayP.add(arrayLabel);

		evaluateP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		evaluateP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(evaluateP);

		evaluateL = new JLabel("EVALUATE: ", SwingConstants.LEFT);
		evaluateL.setFont(new Font("Serif", Font.PLAIN, 20));
		evaluateL.setForeground(Color.WHITE);
		evaluateP.add(evaluateL);

		resultP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		resultP.setBackground(new Color(39, 39, 39));
		panelEvaluate.add(resultP);

		resultLabel = new JLabel("RESULT: ", SwingConstants.LEFT);
		resultLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		resultLabel.setForeground(Color.WHITE);
		resultP.add(resultLabel);

		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 15; j++){
				labelConvert[i][j] = new JLabel();
				labelConvert[i][j].setForeground(Color.WHITE);
				labelConvert[i][j].setFont(new Font("Serif", Font.PLAIN, 25));
				if(i == 0){
					readPanel.add(labelConvert[0][j]);
				}else if(i == 1){
					parsePanel.add(labelConvert[1][j]);
				}else if(i == 2){
					writePanel.add(labelConvert[2][j]);
				}else if(i == 3){
					stackPanel.add(labelConvert[3][j]);
				}else if(i == 4){
					queue1Panel.add(labelConvert[4][j]);
				}else if(i == 5){
					queue2Panel.add(labelConvert[5][j]);
				}else if(i == 6){
					arrayPanel.add(labelConvert[6][j]);
				}			
			}
		}
		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 15; j++){
				labelEvaluate[i][j] = new JLabel();
				labelEvaluate[i][j].setForeground(Color.WHITE);
				labelEvaluate[i][j].setFont(new Font("Serif", Font.PLAIN, 25));
				if(i == 0){
					readP.add(labelEvaluate[0][j]);
				}else if(i == 1){
					stackP.add(labelEvaluate[1][j]);
				}else if(i == 2){
					queue1P.add(labelEvaluate[2][j]);
				}else if(i == 3){
					queue2P.add(labelEvaluate[3][j]);
				}else if(i == 4){
					arrayP.add(labelEvaluate[4][j]);
				}else if(i == 5){
					evaluateP.add(labelEvaluate[5][j]);
				}else if(i == 6){
					resultP.add(labelEvaluate[6][j]);
				}			
			}
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
							//label.setText(getText().substring(0, getText().length()-1));
							if(label.getText().length() == 0){
								button[1].setEnabled(false);
							}
							if(label.getText().charAt(label.getText().length()-1) == ' '){
								label.setText(label.getText().substring(0, label.getText().length()-1));

								if(label.getText().charAt(label.getText().length()-1) == '('){
									 label.setText(label.getText().substring(0, label.getText().length()-1));
										str = label.getText();
										label.setText(str);


										ctr2--;
								}else{
									for(int j = 0; j < 2; j++){
										label.setText(label.getText().substring(0, label.getText().length()-1));
									}
									str = label.getText();
								}
								for(int j = 3; j < button.length; j += 4){
									button[j].setEnabled(true);
								}

								button[16].setEnabled(false);
								button[18].setEnabled(false);

							}else if(label.getText().charAt(label.getText().length()-1) == ')'){
								for(int j = 0; j < 2; j++){
									label.setText(label.getText().substring(0, label.getText().length()-1));
								}
								str = label.getText();
								button[18].setEnabled(true);
								ctr2++;
							}else{
									label.setText(label.getText().substring(0, label.getText().length()-1));
									str = label.getText();
							}
							ctr--;
						}//end if button[1]

						if(event.getSource() == button[2]){
							str = "";
							label.setText(str);
							ctr = 0;
							ctr2 = 0;
							for(int j = 3; j < button.length; j += 4){
								button[j].setEnabled(false);
							}
							button[18].setEnabled(false);
							button[16].setEnabled(true);
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
								ctr2++;
								button[18].setEnabled(false);
						}

						if(event.getSource() == button[18]){
							str += " )";
							label.setText(str);
							ctr2--;
						}

					}else if(event.getSource() == button[19]){
						if(ctr2 == 0){
							Converter convert = new Converter();
							convert.inputToArray(str);
							convert.start();
						}else{
							label.setText("Math Error!");
						}
					}else{
						for(int j = 3; j < button.length; j += 4){
							button[j].setEnabled(true);
						}

						button[16].setEnabled(false);
						button[18].setEnabled(false);

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
