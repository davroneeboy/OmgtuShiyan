import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Регулярные выражения");
		frame.setSize(500, 500);
		frame.setLayout(new GridBagLayout());
		String zad ="извлечь из списка цен,цены в USD,RUR,EU" ;
		JLabel zadanie = new JLabel(zad);
		frame.add(zadanie,new GridBagConstraints(1,1,2,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JTextArea textVvod = new JTextArea(10,10);
		textVvod.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textVvod);
		frame.add(scrollPane,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JTextArea textVivod = new JTextArea(10,10);
		textVivod.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(textVivod);
		frame.add(scrollPane2,new GridBagConstraints(2,2,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btnRand = new JButton("Генерация случайных цен");
		frame.add(btnRand,new GridBagConstraints(1,4,2,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn1 = new JButton("Поиск регулярных выражений");
		frame.add(btn1,new GridBagConstraints(1,5,2,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		JButton btn3 = new JButton("Сбросить значения");
		frame.add(btn3,new GridBagConstraints(1,6,2,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame.pack();
		frame.setVisible(true);
		ActionListener actionRand = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Random rand = new Random();
				Double vremDouble;
				String vremString="";
				String[] valuta=new String[3];
				valuta[0]="USD";valuta[1]="RUR";valuta[2]="EU";
				String[] Bukvi="A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
				String vivod="";
				int viborValut=0;
				for (int i = 0; i < 1000; i++) {
					viborValut=rand.nextInt(50);
					switch (viborValut) {
					case 0:
						vremString=valuta[0];
						break;
					case 1:
						vremString=valuta[1];
						break;
					case 2:
						vremString=valuta[2];
						break;
					default:
						vremString=Bukvi[rand.nextInt(20)]+Bukvi[rand.nextInt(20)]+Bukvi[rand.nextInt(20)];
						break;
					
					}
					String a="%.2f";String b="%.3f";String c="%.4f";
					int r = rand.nextInt(3);
					switch (r) {
					case 0:
						vremDouble = rand.nextDouble()*99;
						vivod+=String.format(a, vremDouble)+vremString+"\n";
						vremString="";
						break;
					case 1:
						vremDouble = rand.nextDouble()*99;
						vivod+=String.format(b, vremDouble)+vremString+"\n";
						vremString="";
						break;
					case 2:
						vremDouble = rand.nextDouble()*99;
						vivod+=String.format(c, vremDouble)+vremString+"\n";
						vremString="";
						break;
					}
					
					
				}
				
				textVvod.setText(vivod);
				
			}
		};
		btnRand.addActionListener(actionRand);
		
		ActionListener actionPoisk = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String vremString = textVvod.getText();
				String[]sort=vremString.split("\n");
				String vivodRes="";
				for (int i = 0; i < sort.length; i++) {
				
					if(Proverka.regular(sort[i])==true)
					{
						vivodRes+=sort[i]+"\n";
					}
				
				}
				
				textVivod.setText(vivodRes);
			}
		};	
		btn1.addActionListener(actionPoisk);
		
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textVivod.setText("");
				textVvod.setText("");
				
			}
		};
        btn3.addActionListener(al);
	}

}
