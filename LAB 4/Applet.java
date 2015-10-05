import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Applet extends JApplet {
	
private static final long serialVersionUID = 1L;
String a= "Текст";
int x=1;
int y;
int xMax ;
int shirina=60;
int nomCvet=5;
Boolean flagUdara=false;

Color []naborCvetov = new Color[]{Color.red,Color.green,Color.blue,Color.white,Color.yellow,Color.black} ;
Color cvet=naborCvetov[5];
@Override
	public void init() {
	setSize(500, 150);
		super.init();
		
	}


	public Applet() {
		
		
		setSize(500, 100);
		setLayout(new BorderLayout(0, 0));
		final Paint p = new Paint();
		add(p,BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JMenu menu = new JMenu("Цвет");
		JMenuBar menuBar = new JMenuBar();
		final JMenuItem red = new JMenuItem("красный");
		menu.add(red); 
		JMenuItem green = new JMenuItem("зеленый");
		menu.add(green);
		JMenuItem blue = new JMenuItem("синий");
		menu.add(blue);
		JMenuItem white = new JMenuItem("белый");
		menu.add(white); 
		JMenuItem yelow = new JMenuItem("желтый");
		menu.add(yelow);
		JMenuItem black = new JMenuItem("черный");
		menu.add(black);
		final JTextField text =new JTextField(10);
		final JButton btn = new JButton("Введите текст");
		menuBar.add(menu);
		panel.add(text);
		panel.add(btn);
		add(panel, BorderLayout.SOUTH);
		add(menuBar, BorderLayout.NORTH);
		btn.setFocusable(true);
		text.setFocusable(false);
		Timer tm = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				shirina=getHeight()/5;
				xMax = getWidth()-a.length()*(shirina/2+shirina/12);
				y=p.getHeight()/2;
				add(p,BorderLayout.CENTER);
				
			}
		});
		tm.start();
		//оброботка пунктов меню
		red.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomCvet=0;
				
			}
		});
	red.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomCvet=0;
				
			}
		});
	green.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nomCvet=1;
			
		}
	});
	blue.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nomCvet=2;
			
		}
	});
	white.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nomCvet=3;
			
		}
	});
	yelow.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nomCvet=4;
			
		}
	});
black.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nomCvet=5;
			
		}
	});
//обработка кнопок
btn.addKeyListener(new KeyListener() {
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_R:
			nomCvet=0;
			break;
case KeyEvent.VK_G:
	nomCvet=1;
			break;
case KeyEvent.VK_B:
	nomCvet=2;
	break;
case KeyEvent.VK_W:
	nomCvet=3;
	break;
case KeyEvent.VK_Y:
	nomCvet=4;
	break;
case KeyEvent.VK_BACK_SPACE:
	nomCvet=5;
	break;

		default:
			break;
		}
		
	}
});

text.addKeyListener(new KeyAdapter() {
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==  KeyEvent.VK_ENTER){
			if (text.getText().length()<1||text.getText().length()>10) {
				JOptionPane.showMessageDialog(null, "Не вводите больше 10-ти символов\n и менее 1-го ", "ERROR", 0);
			}else{
			a=text.getText();
			btn.requestFocus();			}
		}
	}
});

text.addMouseListener(new MouseAdapter() {
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		text.setFocusable(true);
		text.requestFocus();
	}
});
	btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (text.getText().length()<1||text.getText().length()>10) {
				JOptionPane.showMessageDialog(null, "Не вводите больше 10-ти символов\n и менее 1-го ", "ERROR", 0);;
			}else{
			a=text.getText();
			}
		}
	});}

	

	class Paint extends Canvas
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 583340809120154196L;
	Boolean flag = true;
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		 if (x>0 && x<xMax&& flag)
		 {
			 flag=true;
			
			 
		 }
		 if(x>0 && x>xMax&& flag) {
			flagUdara=true;
			flag=false;
			
			}
		 if (flag) {
			 if (flagUdara) {
				cvet=naborCvetov[nomCvet];
			}
			x+=getWidth()/20;
			
			
			g2.setColor(cvet);
			g2.setFont(new java.awt.Font("Courier", 1, shirina));
			g2.drawString(a, x, y);
			flagUdara=false;
		}else {
			if (flagUdara) {
				cvet=naborCvetov[nomCvet];
				flagUdara=false;
			}
			x-=getWidth()/20;
			g2.setColor(cvet);
			g2.setFont(new java.awt.Font("Courier", 1, shirina));
			g2.drawString(a, x, y);
			if(x<0)
			{
			flagUdara=true;	
			flag =true;
			x=1;
			}
		}
		
	}
}
}
