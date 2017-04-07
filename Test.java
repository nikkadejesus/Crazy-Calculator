import javax.swing.*;
import java.awt.*;

public class Test{
	public static void main(String[] args){
		Gui gui = new Gui();
		gui.getContentPane().setBackground(Color.BLACK);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(1000,565);
		gui.setResizable(false);
		gui.setVisible(true);
	}
}
