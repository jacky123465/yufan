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
	protected Button bu1 = new Button("随机模式");
    protected Button bu2 = new Button("经典模式");
    protected JLabel jb = new JLabel("<html>随机模式图形随机生成而且<br>颜色变化多端,而经典模式<br>则是两条小鱼的变化</html>");
    protected jiemian youxi;
    protected String moshi;
	protected JFrame world = new JFrame();
    lifegame(){  
        this.setSize(630,600);  
        this.setTitle("生命游戏");  
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
		world.setTitle("生命游戏");  
		
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        world.setLocationRelativeTo(null);  
        world.setResizable(false); 
        
		if(e.getSource() == bu1) {
	        youxi = new jiemian();
	        youxi.setVisible(true);
	        moshi = "随机模式";
		}
		else if(e.getSource() == bu2)
		{
	        world.add(new jindianmoshi());
	        world.setVisible(true);
	        moshi = "经典模式";
		}
	}  
}