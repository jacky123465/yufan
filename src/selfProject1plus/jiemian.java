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
	private JButton ok = new JButton("确定");
	private JButton cancel = new JButton("取消");
	protected JFrame world;
	protected int speed1;
	public static boolean isNumeric1;
	
	JPanel titlePanel = new JPanel();
	JPanel fieldPanel = new JPanel();
	JLabel a1 = new JLabel("速度（建议2000）:");
	JLabel a2 = new JLabel("<html>速度必须在0到2200<br>否则会强制退出</html>");
	
	public jiemian(){
	this.setSize(300,200);
	this.setLocation(500,300);
	c.setLayout(new BorderLayout());
	initFrame();
	}
	protected void initFrame(){
	//顶部
	titlePanel.setLayout(new FlowLayout());
	titlePanel.add(new JLabel("设置"));
	c.add(titlePanel,"North");

	//中部表单
	fieldPanel.setLayout(null);
	a1.setBounds(50,20,130,20);
	a2.setBounds(50,60,130,40);
	fieldPanel.add(a1);
	fieldPanel.add(a2);
	Speed.setBounds(175,20,95,20);
	fieldPanel.add(Speed);
	c.add(fieldPanel,"Center");

	//底部按钮
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
		world.setTitle("生命游戏");  
		
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        world.setLocationRelativeTo(null);  
        world.setResizable(false); 
        
        //获得速度和边长
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
