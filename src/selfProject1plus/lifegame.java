package selfProject1plus;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import selfProject1plus.jiemian;
import selfProject1plus.lifegame;

public class lifegame extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Button bu1 = new Button("���ģʽ");
    protected Button bu2 = new Button("����ģʽ");
    protected JLabel jb = new JLabel("<html>���ģʽͼ��������ɶ���<br>��ɫ�仯���,������ģʽ<br>��������С��ı仯</html>");
    protected jiemian youxi;
    protected String moshi;
	protected JFrame world = new JFrame();
    lifegame(){  
        this.setSize(630,600);  
        this.setTitle("������Ϸ");  
        this.setLayout(null);
        
        this.add(jb);
        this.add(bu1);
        this.add(bu2);
        bu1.setSize(100, 100);
        bu1.setLocation(100, 100);
        bu2.setSize(100,100);
        bu2.setLocation(100, 300);
        jb.setSize(500,200);
        jb.setLocation(300,100);
//        
        bu1.addActionListener(this);
        bu2.addActionListener(this);  
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false); 
    }  
      
    public static void main(String[] args){  
        lifegame game = new lifegame();  
        game.setVisible(true);  
    }

//	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		world.setSize(650,600);  
		world.setTitle("������Ϸ");  
		
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        world.setLocationRelativeTo(null);  
        world.setResizable(false); 
        
		if(e.getSource() == bu1) {
	        youxi = new jiemian();
	        youxi.setVisible(true);
	        moshi = "���ģʽ";
		}
		else if(e.getSource() == bu2)
		{
	        world.add(new jindianmoshi());
	        world.setVisible(true);
	        moshi = "����ģʽ";
		}
	}  
}