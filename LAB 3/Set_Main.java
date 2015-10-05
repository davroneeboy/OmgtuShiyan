import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Set_Main {

	public static void main(String[] args) {
		final String [] item = new String[]{"Set_1 и Set_2","Set_2 и Set_1"};
		final Random rand = new Random();
		final Set linkHS_1 = new Set();
		final Set linkHS_2 = new Set();
		final Set linkHS_3 = new Set();
		final Set linkHS_4 = new Set();
		final JFrame frame = new JFrame("Работа интерфейса Set");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		frame.setLocation(450, 200);
		final JTextField text_1 = new JTextField();
		frame.add(text_1,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_1 = new JButton("Довавить в Set_1");
		frame.add(btn_1,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_2 = new JButton("Довавить в Set_2");
		frame.add(btn_2,new GridBagConstraints(2,2,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_1_del = new JButton("Удалить из Set_1");
		frame.add(btn_1_del,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_2_del = new JButton("Удалить из Set_2");
		frame.add(btn_2_del,new GridBagConstraints(2,3,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_1_rand = new JButton("Случайные числа в Set_1");
		frame.add(btn_1_rand,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_2_rand = new JButton("Случайные числа в Set_2");
		frame.add(btn_2_rand,new GridBagConstraints(2,4,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_Poisk = new JButton("Найти вхождения");
		frame.add(btn_Poisk,new GridBagConstraints(1,6,2,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn_Sliyanie = new JButton("Обьединить");
		frame.add(btn_Sliyanie,new GridBagConstraints(1,7,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JComboBox<String> cb = new JComboBox<String>(item);
		frame.add(cb,new GridBagConstraints(2,7,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JTextField text_2 = new JTextField();
		frame.add(text_2,new GridBagConstraints(2,1,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JTextArea textArea_1 = new JTextArea(10,10);
		final JTextArea textArea_2 = new JTextArea(10,10);
		JScrollPane scrol_1 = new JScrollPane(textArea_1);
		frame.add(scrol_1, new GridBagConstraints(1,5,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1,1, 1, 1),0,0));
		JScrollPane scrol_2 = new JScrollPane(textArea_2);
		frame.add(scrol_2, new GridBagConstraints(2,5,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame.pack();
		frame.setVisible(true);
		
		
btn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					if(linkHS_1.add(Integer.parseInt(text_1.getText()))==true){
					linkHS_1.add(Integer.parseInt(text_1.getText()));
					String v1="";
					for (Integer integer : linkHS_1) {
						v1+=Integer.toString(integer)+"\n";
					}
					textArea_1.setText(v1);
					text_1.setText("");
				}else {
					text_1.setText("");
					JOptionPane.showMessageDialog(null,"Такой элемент уже есть", "Ошибка ввода", 0);}
					}catch(NumberFormatException w){ 
						JOptionPane.showMessageDialog(null, "Прoверьте правильность ввода", "Ошибка ввода", 0);
						text_1.setText("");
					}
			}
		});
btn_1_del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					if(linkHS_1.contains(Integer.parseInt(text_1.getText()))==true){
					linkHS_1.remove(Integer.parseInt(text_1.getText()));
					String v1="";
					for (Integer integer : linkHS_1) {
						v1+=Integer.toString(integer)+"\n";
					}
					textArea_1.setText(v1);
					text_1.setText("");
				}else {
					text_1.setText("");
					JOptionPane.showMessageDialog(null,"Такого элемента нет", "Ошибка ввода", 0);}
					}catch(NumberFormatException w){ 
						JOptionPane.showMessageDialog(null, "Прoверьте правильность ввода", "Ошибка ввода", 0);
						text_1.setText("");
					}
			}
		});
btn_1_rand.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		linkHS_1.clear();
		String v1="";
		for (int i = 0; i < 10; i++) {
			linkHS_1.add(rand.nextInt(10));	
		}
		for (Integer integer : linkHS_1) {
			v1+=Integer.toString(integer)+"\n";
		}
		textArea_1.setText(v1);
		text_1.setText("");
		
	}
});

btn_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				if(linkHS_2.add(Integer.parseInt(text_2.getText()))==true){
				linkHS_2.add(Integer.parseInt(text_2.getText()));
				String v2="";
				for (Integer integer : linkHS_2) {
					v2+=Integer.toString(integer)+"\n";
				}
				textArea_2.setText(v2);
				text_2.setText("");
			}else {
				
				JOptionPane.showMessageDialog(null,"Такой элемент уже есть", "Ошибка ввода", 0);
				text_2.setText("");}
				
				}catch(NumberFormatException w){ 
					JOptionPane.showMessageDialog(null, "Прoверьте правильность ввода", "Ошибка ввода", 0);
					text_2.setText("");
				}
				
			}
			
		});

btn_2_del.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(linkHS_2.contains(Integer.parseInt(text_2.getText()))==true){
			linkHS_2.remove(Integer.parseInt(text_2.getText()));
			String v2="";
			for (Integer integer : linkHS_2) {
				v2+=Integer.toString(integer)+"\n";
			}
			textArea_2.setText(v2);
			text_2.setText("");
		}else {
			text_2.setText("");
			JOptionPane.showMessageDialog(null,"Такого элемента нет", "Ошибка ввода", 0);}
			}catch(NumberFormatException w){ 
				JOptionPane.showMessageDialog(null, "Прoверьте правильность ввода", "Ошибка ввода", 0);
				text_2.setText("");
			}
	}
});
btn_2_rand.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		linkHS_2.clear();
		String v2="";
		for (int i = 0; i < 10; i++) {
			linkHS_2.add(rand.nextInt(10));	
		}
		for (Integer integer : linkHS_2) {
			v2+=Integer.toString(integer)+"\n";
		}
		textArea_2.setText(v2);
		text_2.setText("");
		
	}
});
btn_Sliyanie.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String v="";
		if (cb.getSelectedItem()==item[0]) {
			linkHS_1.sliyanie(linkHS_1, linkHS_2);
			for (Integer integer : linkHS_1) {
				v+=Integer.toString(integer)+"\n";
			}
			textArea_1.setText(v);
		}else{
			linkHS_2.sliyanie(linkHS_2, linkHS_1);
			for (Integer integer : linkHS_2) {
				v+=Integer.toString(integer)+"\n";
			}
			textArea_2.setText(v);
		}
			
		
		
	}
});

btn_Poisk.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		linkHS_4.clear();
		String v="Вжождения \n";
		String v2="Не вжождения \n";
		final JTextArea textArea_3 = new JTextArea(10,10);
		final JTextArea textArea_4 = new JTextArea(10,10);
		JScrollPane scrol_3 = new JScrollPane(textArea_3);
		frame.add(scrol_3, new GridBagConstraints(1,8,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1,1, 1, 1),0,0));
		JScrollPane scrol_4 = new JScrollPane(textArea_4);
		frame.add(scrol_4, new GridBagConstraints(2,8,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame.pack();
		linkHS_3.addAll(Set.vhozhdenia(linkHS_1, linkHS_2));
		for (Integer integer : linkHS_3) {
			v+=Integer.toString(integer)+"\n";
		}
		textArea_3.setText(v);
		linkHS_4.addAll(Set.nevhozhdenia(linkHS_1, linkHS_2));
		for (Integer integer : linkHS_4) {
			v2+=Integer.toString(integer)+"\n";
		}
		textArea_4.setText(v2);
	}
});
	}}
