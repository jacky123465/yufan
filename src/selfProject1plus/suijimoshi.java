package selfProject1plus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
public class suijimoshi extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 12;
	private int height = 12;
	private int[][] world = new int[50][50]; 
	
	private Timer timer;
    private int DELAY_TIME = 12000;  
    
    int[][] nextStatus = new int[world.length][world[0].length];  
    int[][] tempStatus = new int[world.length][world[0].length];  
    
    
	public suijimoshi(int speed) {  
		DELAY_TIME = 2400-speed;
		//开始游戏,先赋值
		 for(int i=1; i<world.length-1; i++)
			 for(int j=1; j<world.length-1; j++)
			 {
				 Random r = new Random(); 
				 int suiji = r.nextInt(2);
				 world[i][j] = suiji;
			 }
		 for(int i=0; i<world.length; i++)
			 {world[i][0] = 0;		world[i][world.length-1] = 0;}
		 for(int j=0; j<world.length; j++)
		 	 {world[0][j] = 0;		world[world.length-1][j] = 0;}
		 
        for (int row = 0; row < world.length; row++) {  
            for (int col = 0; col < world[0].length; col++) {  
                nextStatus[row][col] = world[row][col];  
                tempStatus[row][col] = world[row][col];  
            }  
        }  
        
        // 创建计时器  
        timer = new Timer(DELAY_TIME, new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                changeCellStatus();  
                repaint();  
            }  
        });  
        // 开启计时器  
        timer.start();  
	}  
    
    public void changeCellStatus() {
    	
    	int flag = 0;
        for (int row = 1; row < nextStatus.length-1; row++) {  
            for (int col = 1; col < nextStatus[row].length-1; col++) {  
        flag = 0;
        // 用flag寻找该点周围活的细胞个数
        // 因为边缘一周没有算在内，所以没有影响
        for(int i=row-1; i<=row+1; i++)
        	for(int j=col-1; j<=col+1; j++) {
        		if(i==row && j==col)
        			continue;
        		if(tempStatus[i][j]==1)
        			flag++;
        	}
        
        
        switch (flag) {  
        case 0:  
        case 1:  
        case 4:  
        case 5:  
        case 6:  
        case 7:  
        case 8:  
           nextStatus[row][col] = 0;  
           break;  
        case 2:  
           nextStatus[row][col] = tempStatus[row][col];  
           break;  
         case 3:  
           nextStatus[row][col] = 1;  
           break;  
                }  
            }  
        }
		 
        copyWorldMap();  
    }
    
    private void copyWorldMap() {  
        for (int row = 0; row < nextStatus.length; row++) {  
            for (int col = 0; col < nextStatus[row].length; col++) {  
                tempStatus[row][col] = nextStatus[row][col];  
            }  
        }  
    }  
    
    //画图形界面
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        for (int i = 1; i < nextStatus.length-1; i++) {  
            for (int j = 1; j < nextStatus[i].length-1; j++) {  
                if (nextStatus[i][j] == 1) {  
                	Color color = new Color(0,0,0);
                	Random ran = new Random();
                	color = new Color((int)(ran.nextFloat()*255),(int)(ran.nextFloat()*255),(int)(ran.nextFloat()*255));
                	g.setColor(color);
                	g.fillRect( j * width, i * height, width, height);  
                   
                } else {  
                	 g.drawRect( j * width, i * height, width, height); 
                }  
            }  
        }  
    }
}
