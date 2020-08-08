package ChatApplication;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener{
	
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	
	static Socket s;
	static DataInputStream dIn;
	static DataOutputStream dOut;
	
	Client(){
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(29,161,242));
		p1.setBounds(0, 0, 450, 70);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/femalecodertocat.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel l1 = new JLabel(i1);
		l1.setBounds(5, 17, 30, 30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				System.exit(0);
			}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Images/Octocat.png"));
		Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		
		JLabel l2 = new JLabel(i6);
		l1.setBounds(40, 5, 60, 60);
		p1.add(l2);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Images/3icon.png"));
		Image i8 = i7.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		
		
		JLabel l5 = new JLabel(i9);
		l5.setBounds(410, 20, 13, 25);
		p1.add(l5);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Images/video.png"));
		Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		
		JLabel l6 = new JLabel(i12);
		l6.setBounds(350, 20, 35, 30);
		p1.add(l6);
		
		JLabel l3 = new JLabel("Samaresh");
		l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110, 15, 100, 18);
		p1.add(l3);
		
		JLabel l4 = new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 12));
		l4.setForeground(Color.WHITE);
		l4.setBounds(110, 35, 100, 20);
		p1.add(l4);
		
		a1 = new JTextArea();                                   
		a1.setBounds(5, 75, 440, 550);                          
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));      
		a1.setEditable(false);                                  
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);
		
		t1 = new JTextField();
		t1.setBounds(5, 630, 330, 40);
		t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
		add(t1);
		
		b1 = new JButton("Send");
		b1.setBounds(342, 630, 100, 40);
		b1.setBackground(new Color(29, 161, 242));
		b1.setForeground(Color.BLUE);
		b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		b1.addActionListener(this);
		add(b1);
		
		
		setLayout(null);
		setSize(450, 700);
		setLocation(400, 200);
		
		
//		setUndecorated(true);
		setVisible(true);

		

	}
	public void actionPerformed(ActionEvent ae) {
		try{ 
		String out = t1.getText();
		a1.setText( a1.getText()+"\n\t\t\t"+out);
		dOut.writeUTF(out);
		t1.setText("");
		}catch(Exception e) {
			 
		}
		
	}
	public static void main(String[] args) {
		new Client().setVisible(true);
		
		try {
			s = new Socket("127.0.0.1",4001);
			dIn = new DataInputStream(s.getInputStream());
			dOut = new DataOutputStream(s.getOutputStream());
			
			String messageInput = "";
			
			messageInput = dIn.readUTF();
			a1.setText( a1.getText()+"\n"+messageInput);
			
		}catch(Exception e) {
			
			
		}
	}

}
