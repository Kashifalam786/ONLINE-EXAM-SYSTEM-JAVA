import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext,btnPrevious, btnMark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
        btnPrevious = new JButton("Previous");
		btnMark = new JButton("Mark");
		btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
		btnMark.addActionListener(this);
		add(btnNext);
        add(btnPrevious);
		add(btnMark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(50, 240, 100, 30);
        btnPrevious.setBounds(170, 240, 100, 30);
		btnMark.setBounds(290, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
            if (current == 9){
                btnNext.setText("Summit");
            
            }
			if (current == 10) {
				btnNext.setEnabled(false);
				btnMark.setText("Result");
                btnPrevious.setEnabled(false);
			}
		}
           
        if (e.getSource() == btnPrevious) {
			if (check())
				count = count - 1;
			current--;
			set();
            if (current == 10) {
				btnPrevious.setEnabled(false);
         }
        if (current == 8){
                btnNext.setText("Next");
        }
    }
		if (e.getActionCommand().equals("Mark")) {
			JButton bk = new JButton("Mark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnMark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Mark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "Correct Answers = " + count + " /10");
			System.exit(0);
		}
	}
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:   Who invented Java Programming?");
			radioButton[0].setText("Guido van Rossum");
			radioButton[1].setText("James Gosling");
			radioButton[2].setText("Dennis Ritchie");
			radioButton[3].setText("Bjarne Stroustrup");
		}
		if (current == 1) {
			label.setText("Que2:   Which component is used to compile and execute Java programs?");
			radioButton[0].setText("JRE");
			radioButton[1].setText("JDK");
			radioButton[2].setText("JIT");
			radioButton[3].setText("JVM");
		}
		if (current == 2) {
			label.setText("Que3: What is the extension of java code files?");
			radioButton[0].setText(".java");
			radioButton[1].setText(".txt");
			radioButton[2].setText(".js");
			radioButton[3].setText(".class");
		}
		if (current == 3) {
			label.setText("Que4: Which one of the following is not a Java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText(" Portable");
			radioButton[2].setText("Use of pointers");
			radioButton[3].setText("Dynamic and Extensible");
		}
		if (current == 4) {
			label.setText("Que5: What is the extension of compiled java classes?");
			radioButton[0].setText(" .txt");
			radioButton[1].setText(".class");
			radioButton[2].setText(".js");
			radioButton[3].setText(".java");
		}
		if (current == 5) {
			label.setText("Que6: Which of these are selection statements in Java?");
			radioButton[0].setText("break");
			radioButton[1].setText("continue");
			radioButton[2].setText("for()");
			radioButton[3].setText("if()");
		}
		if (current == 6) {
			label.setText("Que7:   Which of the following is a superclass of every class in Java?");
			radioButton[0].setText("ArrayList");
			radioButton[1].setText("Abstract class");
			radioButton[2].setText("Object class");
			radioButton[3].setText("String");
		}
		if (current == 7) {
			label.setText("Que8:  Which one of the following is not an access modifier?");
			radioButton[0].setText("Protected");
			radioButton[1].setText("Void");
			radioButton[2].setText("Public");
			radioButton[3].setText("Private");
		}
		if (current == 8) {
			label.setText("Que9: What is the size of float and double in java?");
			radioButton[0].setText("32 and 64");
			radioButton[1].setText("32 and 32");
			radioButton[2].setText("64 and 32");
			radioButton[3].setText("64 and 64");
		}
		if (current == 9) {
			label.setText("Que10: Number of primitive data types in Java are?");
			radioButton[0].setText("8");
			radioButton[1].setText("6");
			radioButton[2].setText("7");
			radioButton[3].setText("9");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[3].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("LLYOD TEST APP");
	}

}