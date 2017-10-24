package selfProject1plus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class jindianmoshiTest {
	private jindianmoshi jindian = new jindianmoshi();
	@Before
	public void setUp() throws Exception {
	}

	@Ignore
	public void testJindianmoshi() {
		int[][] a = new int [50][50]; 
		boolean flag = true;
		//»­Í¼ÐÎ
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a.length; j++)
			{
				if(a[i][j]!=jindian.world[i][j] || a[i][j]!=jindian.nextStatus[i][j] || a[i][j]!=jindian.tempStatus[i][j])
					flag = false;
			}
		assertEquals(true,flag);
	}

//	@SuppressWarnings("deprecation")
	@Test
	public void testChangeCellStatus() {
		//±ßÔµ²âÊÔ
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				jindian.nextStatus[i][j] = 0;
				jindian.tempStatus[i][j] = 0;
			}
		jindian.changeCellStatus();
		int[][] a = new int[50][50];
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++)
				a[i][j] = 0;
		boolean flag = true;
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				if(jindian.nextStatus[i][j] != a[i][j])
					flag = false;
			}
		assertEquals(true,flag);
		
		//´íÎó²âÊÔ
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				jindian.nextStatus[i][j] = 0;
				jindian.tempStatus[i][j] = 0;
			}
		jindian.tempStatus[24][24] = 1;
		jindian.tempStatus[25][24] = 1;
		jindian.tempStatus[24][25] = 1;
		jindian.tempStatus[25][25] = 1;
		jindian.changeCellStatus();
		flag = true;
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				if(jindian.nextStatus[i][j] != a[i][j])
					flag = false;
			}
		assertEquals(false,flag);
		
		//Ò»°ã²âÊÔ
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				jindian.nextStatus[i][j] = 0;
				jindian.tempStatus[i][j] = 0;
			}
		jindian.tempStatus[24][24] = 1;
		jindian.tempStatus[25][24] = 1;
		jindian.tempStatus[24][25] = 1;
		jindian.tempStatus[25][25] = 1;
		jindian.tempStatus[42][41] = 1;
		jindian.tempStatus[42][42] = 1;
		jindian.changeCellStatus();
		
		a[25][25] = 1;
		a[24][25] = 1;
		a[25][24] = 1;
		a[24][24] = 1;
		flag = true;
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				if(jindian.nextStatus[i][j] != a[i][j])
					flag = false;
			}
		assertEquals(true,flag);
	}

	@Ignore
	public void testPaintComponentGraphics() {
		
	}

}
