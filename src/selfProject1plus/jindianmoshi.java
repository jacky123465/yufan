package selfProject1plus;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class jindianmoshi extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 12;
	private int height = 12;
	protected int[][] world = new int[50][50]; 
	
	protected Timer timer;
    private final int DELAY_TIME = 1200;  
    
    protected int[][] nextStatus = new int[world.length][world[0].length];  
    protected int[][] tempStatus = new int[world.length][world[0].length];  
    
	public jindianmoshi() {  
		//画图形
		for(int i=0; i<world.length; i++)
			for(int j=0; j<world.length; j++)
			{
				world[i][j] = 0;
			}
		for(int j=7; j<=14 ; j++)
		for(int i=j+10; i<=39-j; i++)
		world[i][j]=1;
		
		for(int j=41; j>=36 ; j--)
			for(int i=j-24; i<=73-j; i++)
			world[i][j]=1;
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
        // 如果实在边缘
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
    
    /** 
     * 画图形界面 
     *  
     */  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        for (int i = 1; i < nextStatus.length-1; i++) {  
            for (int j = 1; j < nextStatus[i].length-1; j++) {  
                if (nextStatus[i][j] == 1) {  
                    g.fillRect( j * width, i * height, width, height);  
                } else {  
                	 g.drawRect( j * width, i * height, width, height); 
                }  
            }  
        }  
    }
    
    public int[][] getNextStatus()
    {
    	return nextStatus;
    }
}
