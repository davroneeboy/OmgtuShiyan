import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class WinMain {
	
	
	public  int flagFinish=0;
	public  Point2D[] points;
	public  double[] crdX=new double [100];
	public  double[] crdY=new double [100];
	public  int razmerPoints=0;
	public  int[]result=new int[3];
	public static void main(String[] args) {
		WinMain w = new WinMain();
		w.winStart();
	}
	public void winStart(){
		for (int i = 0; i < crdX.length; i++) {
			crdX[i]=0;
			
		}
		for (int i = 0; i < crdY.length; i++) {
			crdY[i]=0;
		}
		
		final JFrame frame_1 = new JFrame("Поиск треуголька");
		frame_1.setLocation(new Point(500,200));
		frame_1.setLayout(new GridBagLayout());
		final JTextArea  textVivod =new JTextArea (5,25);
		JScrollPane scr1 = new JScrollPane(textVivod);
		frame_1.add(scr1, new GridBagConstraints(3,0,2,6,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		textVivod.setEditable(false);
		textVivod.setText( "  Координаты точек:  ");
		final JLabel labelX= new JLabel("Введите коардинату Х, точки №1");
		final JLabel labelY = new JLabel("Введите коардинату Y, точки №1");
		frame_1.add(labelX,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame_1.add(labelY,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JTextField textY =new JTextField(4);
		final JTextField textX =new JTextField(4);
		frame_1.add(textX,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame_1.add(textY,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JButton btnAdd = new JButton("Добавить точку");
		final JButton btnFinish = new JButton("Найти треугольник");
		frame_1.add(btnAdd,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		btnFinish.setEnabled(false);
		final JButton btnRand = new JButton("Заполнить случайными координатами");
		frame_1.add(btnRand,new GridBagConstraints(1,6,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JButton btnRefresh = new JButton("Сбросить массив координат");
		frame_1.add(btnRefresh,new GridBagConstraints(3,6,1,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame_1.add(btnFinish,new GridBagConstraints(1,5,1,1,1,1,GridBagConstraints.NORTH,
						GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JLabel label = new JLabel("Выбрать три разные точки заданного на плоскости множества точек,");
		frame_1.add(label,new GridBagConstraints(1,7,4,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		final JLabel label2 = new JLabel("составляющие треугольник наибольшего периметра.");
		frame_1.add(label2,new GridBagConstraints(1,8,4,1,1,1,GridBagConstraints.NORTH,
				GridBagConstraints.BOTH,new Insets(1, 1, 1, 1),0,0));
		frame_1.setVisible(true);
		frame_1.pack();
		ActionListener al = new ActionListener() {
			int nomPoint=0;
			String xVivod="";
			String yVivod="";
			String Vivod="  Координаты точек:  \n";
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					flagFinish++;
					if(flagFinish<3)
					{ btnFinish.setEnabled(false);}else
					{ btnFinish.setEnabled(true);}
				crdX[nomPoint]=Double.parseDouble(textX.getText());
				crdY[nomPoint]=Double.parseDouble(textY.getText());
				Vivod+="точка №"+Integer.toString(nomPoint+1)+
						" ("+String.format("%10.3f", crdX[nomPoint])   +" , "+ String.format("%10.3f", crdY[nomPoint]) +")\n";
				textVivod.setText(Vivod);
				nomPoint++;
				razmerPoints++;
				labelX.setText("Введите коардинату Х, точки №"+ Integer.toString(nomPoint+1));
				labelY.setText("Введите коардинату Y, точки №"+ Integer.toString(nomPoint+1));
				textX.setText("");
				textY.setText("");}
				catch(NumberFormatException a){
					JOptionPane.showMessageDialog(null, "Проверте правельность ввода", "Ошибка ввода", 0);
				}
				
			}
		};
	
		btnAdd.addActionListener(al);
ActionListener al2 = new ActionListener() {
	
	
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				final Point2D[] points = new Point2D[razmerPoints];
				for (int i = 0; i < points.length; i++) {
					points[i]=new Point2D.Double(crdX[i],crdY[i]);
				}
				
				result = Treugol.maximum(points);
				JFrame drawPanel = new JFrame();
				drawPanel.setSize(new Dimension(1300,760));
				drawPanel.setBackground(Color.BLACK);
				class convasio extends Canvas
				{
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void paint(Graphics g){
						Graphics2D g2 = (Graphics2D)g; 
						for (int i = 0; i < points.length; i++) {
							int x = (int)crdX[i];
							int y = (int)crdY[i];
							g2.setBackground(Color.white);
							g2.setColor(Color.white);
							g2.fillOval(x, y, 5,5);
							g2.drawString(Integer.toString(i+1),x-5, y);
							g2.setColor(Color.RED);
							g2.draw(new Line2D.Double(points[result[0]], points[result[1]])); 
					        g2.draw(new Line2D.Double(points[result[1]], points[result[2]])); 
					        g2.draw(new Line2D.Double(points[result[2]], points[result[0]]));
					        g2.setColor(Color.white);
					        g2.drawString("Треугольник с самым большим периметром состоит из точек  "+
					        Integer.toString(result[0]+1)+ " & "+Integer.toString(result[1]+1)+ 
					        " & "+Integer.toString(result[02]+1), 30, 650);
							}
						
						
					}
				}
				convasio con = new convasio();
				con.setBackground(Color.black);
				drawPanel.add(con);
				int a=result[0]+1;
				int b=result[1]+1;
				int c=result[2]+1;
				System.out.println("точки "+Integer.toString(a)+"   $   "
				+Integer.toString(b)+"  $ "+Integer.toString(c));
				drawPanel.setTitle("Результат поиска ");
				drawPanel.setResizable(true);
				drawPanel.setVisible(true);
				drawPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		};
	    btnFinish.addActionListener(al2);
	    
	    
	    
	    ActionListener al3 = new ActionListener() {
			Random rand = new Random();
			int nomPoint=0;
			String xVivod="";
			String yVivod="";
			String Vivod="  Координаты точек:  \n";
			@Override
			public void actionPerformed(ActionEvent e) {
				razmerPoints=0;
				for (int i = 0; i < crdX.length; i++) {
					crdX[i]=rand.nextDouble()*1300;
					crdY[i]=rand.nextDouble()*600;
						Vivod+="точка №"+Integer.toString(nomPoint+1)+
								" ("+String.format("%10.3f", crdX[nomPoint])+" , "+String.format("%10.3f", crdY[nomPoint])+")\n";
						textVivod.setText(Vivod);
						nomPoint++;
						razmerPoints++;
						textX.setText("");
						textY.setText("");
				}
				nomPoint=0;
				flagFinish=100;
				btnFinish.setEnabled(true);
				btnAdd.setEnabled(false);
				
			}
		};
		btnRand.addActionListener(al3);
		
		ActionListener al4 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textVivod.setText("  Координаты точек:  ");
				razmerPoints=0;
				flagFinish=0;
				btnFinish.setEnabled(false);
				btnAdd.setEnabled(true);
				for (int i = 0; i < crdX.length; i++) {
					crdX[i]= 0;
					crdY[i]=0;
				}
				
				
			}
			
		};
		btnRefresh.addActionListener(al4);
	}
	

	
}
