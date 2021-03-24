package collections;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> nums = new LinkedList<>();
//		System.out.println("Enter numbers:");
//		Scanner in = new Scanner(System.in);
//		for(int i = 0; i<5; i++) {
//			Integer num = in.nextInt();
//			if (!nums.contains(num)) {
//				nums.add(num);
//			}
//		}
		
		JFrame frame = new JFrame("Numbers");
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.PINK);
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JTextArea numbersArea = new JTextArea();
		numbersArea.setBounds(100, 20, 165, 25);
		numbersArea.setEditable(false);
		mainPanel.add(numbersArea);
		
		JTextField inputNums = new JTextField();
		inputNums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer num = Integer.parseInt(inputNums.getText());
				if (!nums.contains(num)) {
					nums.add(num);
				}
				
				System.out.println(nums);
			}
		});
		mainPanel.add(inputNums);
		
		JButton sortButton = new JButton("Sort");
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(nums);
			}
		});
		mainPanel.add(sortButton);
		
		JButton reverseSortButton = new JButton("Reverse");
		reverseSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(nums, Collections.reverseOrder());
			}
		});
		mainPanel.add(reverseSortButton);
		
		JButton shuffleButton = new JButton("Shuffle");
		shuffleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Collections.shuffle(nums);
			}
		});
		mainPanel.add(shuffleButton);
		
		frame.setVisible(true);
	}

}
