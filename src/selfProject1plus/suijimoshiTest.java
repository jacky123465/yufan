package selfProject1plus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class suijimoshiTest {
	suijimoshi sj = new suijimoshi(2200);
	@Before
	public void setUp() throws Exception {
	}

	@Ignore
	public void testSuijimoshi() {
		
	}

	@Test
	public void testChangeCellStatus() {
		//±ﬂ‘µ≤‚ ‘
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				sj.nextStatus[i][j] = 0;
				sj.tempStatus[i][j] = 0;
			}
		sj.changeCellStatus();
		int[][] a = new int[50][50];
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++)
				a[i][j] = 0;
		boolean flag = true;
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				if(sj.nextStatus[i][j] != a[i][j])
					flag = false;
			}
		assertEquals(true,flag);
		
		//¥ÌŒÛ≤‚ ‘
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				sj.nextStatus[i][j] = 0;
				sj.tempStatus[i][j] = 0;
			}
		sj.tempStatus[24][24] = 1;
		sj.tempStatus[25][24] = 1;
		sj.tempStatus[24][25] = 1;
		sj.tempStatus[25][25] = 1;
		sj.changeCellStatus();
		flag = true;
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				if(sj.nextStatus[i][j] != a[i][j])
					flag = false;
			}
		assertEquals(false,flag);
		
		//“ª∞„≤‚ ‘
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				sj.nextStatus[i][j] = 0;
				sj.tempStatus[i][j] = 0;
			}
		sj.tempStatus[24][24] = 1;
		sj.tempStatus[25][24] = 1;
		sj.tempStatus[24][25] = 1;
		sj.tempStatus[25][25] = 1;
		sj.tempStatus[42][41] = 1;
		sj.tempStatus[42][42] = 1;
		sj.changeCellStatus();
		
		a[25][25] = 1;
		a[24][25] = 1;
		a[25][24] = 1;
		a[24][24] = 1;
		flag = true;
		for(int i=0; i<50; i++)
			for(int j=0; j<50; j++) {
				if(sj.nextStatus[i][j] != a[i][j])
					flag = false;
			}
		assertEquals(true,flag);
	}

	@Ignore
	public void testPaintComponentGraphics() {
		fail("Not yet implemented");
	}

}
