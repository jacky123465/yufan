package selfProject1plus;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
//import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.*;

public class jiemian extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Container c = this.getContentPane();
	protected JTextField Speed = new JTextField();
	private JButton ok = new JButton("ȷ��");
	private JButton cancel = new JButton("ȡ��");
	protected JFrame world;
	protected int speed1;
	public static boolean isNumeric1;
	
	JPanel titlePanel = new JPanel();
	JPanel fieldPanel = new JPanel();
	JLabel a1 = new JLabel("�ٶȣ�����2000��:");
	JLabel a2 = new JLabel("<html>�ٶȱ�����0��2200<br>�����ǿ���˳�</html>");
	
	public jiemian(){
	this.setSize(300,200);
	this.setLocation(500,300);
	c.setLayout(new BorderLayout());
	initFrame();
	}
	protected void initFrame(){
	//����
	titlePanel.setLayout(new FlowLayout());
	titlePanel.add(new JLabel("����"));
	c.add(titlePanel,"North");

	//�в���
	fieldPanel.setLayout(null);
	a1.setBounds(50,20,130,20);
	a2.setBounds(50,60,130,40);
	fieldPanel.add(a1);
	fieldPanel.add(a2);
	Speed.setBounds(175,20,95,20);
	fieldPanel.add(Speed);
	c.add(fieldPanel,"Center");

	//�ײ���ť
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	buttonPanel.add(ok);
	buttonPanel.add(cancel);
	c.add(buttonPanel,"South");
	
	ok.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.dispose();
		world = new JFrame();
		world.setSize(650,600);  
		world.setTitle("������Ϸ");  
		
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        world.setLocationRelativeTo(null);  
        world.setResizable(false); 
        
        //����ٶȺͱ߳�
        String speed = Speed.getText();
        
        
//        System.out.println(speed1);
        if(isNumeric(speed)) {
        world.add(new suijimoshi(speed1));
        world.setVisible(true);}
        else {
        	System.exit(0);
        }
	}
	
    public boolean isNumeric(String str){ 
        Pattern pattern = Pattern.compile("[0-9]*"); 
        boolean flag = pattern.matcher(str).matches();
        if(!flag) {
        	isNumeric1 = false;
        	return false; }
        	else {
        		speed1 = Integer.parseInt(str);
        		if(speed1<=2200 && speed1>0) {
        			isNumeric1 = true;
        			return true;}
        		else {
        			isNumeric1 = false;
        			return false;
        		}
        	}
     }
    
	public boolean getisNumeric() {
		// TODO Auto-generated method stub
		return isNumeric1;
	}
}
