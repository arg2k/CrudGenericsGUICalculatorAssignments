package GUICalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Consumer;

import javax.swing.*;

public class MyCalculator implements ActionListener {
	JFrame f;
	JTextField t;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, badd, bsub, bdiv, bmul, bdec, beq, bdel, bclr;

	static double a = 0, b = 0, result = 0, isDecimalPresent = 0;
	static int operator = 0;

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	void setResult(String s) {
		double res = 0;
		if (s != null && s.length() > 0) {
			Stack<Double> nums = new Stack<Double>();
			char lastOperator = '+';
			String num = "";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				// find the number
				if (c >= '0' && c <= '9' || c == '.') {
					num += c;
				}
				// if the character is operator OR last character
				if (isOperator(c) || i == s.length() - 1) {
					// if the last operation was addition, add the number to stack
					if (lastOperator == '+') {
						nums.push(Double.parseDouble(num));
					}
					// if the last operation was deletion, add the negative of the number to stack
					else if (lastOperator == '-') {
						nums.push((double) -1 * Double.parseDouble(num));
					}
					/*
					 * if the last operation was multiplication or division, pop the last number
					 * from stack and perform the operation on current number and the number from
					 * stack and add the result back to the stack.
					 */
					else if (lastOperator == '*') {
						nums.push(nums.pop() * Double.parseDouble(num));
					} else if (lastOperator == '/') {
						nums.push(nums.pop() / Double.parseDouble(num));
					}
					// set the number back to empty string
					num = "";
					// set the current operator as last operator
					lastOperator = c;
				}
			}
			/*
			 * at this point , the stack will have only the numbers that need to be added.
			 * get those from stack and add to the result.
			 */
			while (!nums.isEmpty()) {
				res = res + nums.pop();
			}
		}

		MyCalculator.result = res;
	}

	public MyCalculator() {
		f = new JFrame("My Calculator");
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(20, 20, 300, 350);
		f.setResizable(false);

		Font fo = new Font("Arial", Font.BOLD, 20);
		t = new JTextField();
		t.setFont(fo);
		t.setBackground(Color.cyan);
		t.setForeground(Color.darkGray);
		t.setBounds(40, 40, 200, 50);

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		badd = new JButton("+");
		bsub = new JButton("-");
		bdiv = new JButton("/");
		bmul = new JButton("*");
		bdec = new JButton(".");
		beq = new JButton("=");
		bdel = new JButton("DEL");
		bclr = new JButton("CLR");

		b7.setBounds(40, 100, 50, 40);
		b8.setBounds(90, 100, 50, 40);
		b9.setBounds(140, 100, 50, 40);
		bdiv.setBounds(190, 100, 50, 40);

		b4.setBounds(40, 140, 50, 40);
		b5.setBounds(90, 140, 50, 40);
		b6.setBounds(140, 140, 50, 40);
		bmul.setBounds(190, 140, 50, 40);

		b1.setBounds(40, 180, 50, 40);
		b2.setBounds(90, 180, 50, 40);
		b3.setBounds(140, 180, 50, 40);
		bsub.setBounds(190, 180, 50, 40);

		b0.setBounds(40, 220, 50, 40);
		bdec.setBounds(90, 220, 50, 40);
		badd.setBounds(140, 220, 50, 40);
		beq.setBounds(190, 220, 50, 40);

		bdel.setBounds(40, 260, 100, 40);
		bclr.setBounds(140, 260, 100, 40);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		badd.addActionListener(this);
		bsub.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		bdec.addActionListener(this);
		bdel.addActionListener(this);
		bclr.addActionListener(this);
		beq.addActionListener(this);

		f.add(t);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(b0);
		f.add(badd);
		f.add(bdel);
		f.add(bclr);
		f.add(bsub);
		f.add(bmul);
		f.add(bdiv);
		f.add(beq);
		f.add(bdec);
	}

	public void checkAndAdd(String curText, String ch) {
		if (curText.charAt(curText.length() - 1) != '.') {
			if (isOperator(curText.charAt(curText.length() - 1))) {
				t.setText(curText.substring(0, curText.length() - 1));
			}
			t.setText(t.getText().concat(ch));
			isDecimalPresent = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyCalculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Map<ActionEvent,Consumer<ActionEvent>> map = new HashMap<>();
//		map.get(e).accept(arg0);
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			t.setText(t.getText().concat("1"));
		}
		if (e.getSource() == b2) {
			t.setText(t.getText().concat("2"));
		}
		if (e.getSource() == b3) {
			t.setText(t.getText().concat("3"));
		}
		if (e.getSource() == b4) {
			t.setText(t.getText().concat("4"));
		}
		if (e.getSource() == b5) {
			t.setText(t.getText().concat("5"));
		}
		if (e.getSource() == b6) {
			t.setText(t.getText().concat("6"));
		}
		if (e.getSource() == b7) {
			t.setText(t.getText().concat("7"));
		}
		if (e.getSource() == b8) {
			t.setText(t.getText().concat("8"));
		}
		if (e.getSource() == b9) {
			t.setText(t.getText().concat("9"));
		}
		if (e.getSource() == b0) {
			t.setText(t.getText().concat("0"));
		}
		if (e.getSource() == badd) {
			String curText = t.getText();
			checkAndAdd(curText, "+");
		}
		if (e.getSource() == bsub) {
			String curText = t.getText();
			if (curText.isEmpty()) {
				t.setText(curText.concat("0"));
			}
			checkAndAdd(t.getText(), "-");
		}
		if (e.getSource() == bmul) {
			String curText = t.getText();
			checkAndAdd(curText, "*");
		}
		if (e.getSource() == bdiv) {
			String curText = t.getText();
			checkAndAdd(curText, "/");
		}
		if (e.getSource() == bdec) {
			if (isDecimalPresent == 0) {
				isDecimalPresent = 1;
				t.setText(t.getText().concat("."));
			}
		}
		if (e.getSource() == bclr) {
			isDecimalPresent = 0;
			t.setText("");
		}
		if (e.getSource() == bdel) {
			String s = t.getText();
			if (t.getText().charAt(t.getText().length() - 1) == '.') {
				isDecimalPresent = 0;
			}
			s = s.substring(0, s.length() - 1);
			t.setText(s);
		}
		if (e.getSource() == beq) {
			setResult(t.getText());
			t.setText(Double.toString(result));
			isDecimalPresent = (t.getText().contains(".") == true ? 1 : 0);
		}
	}

}