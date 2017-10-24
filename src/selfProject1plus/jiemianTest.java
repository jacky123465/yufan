package selfProject1plus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class jiemianTest {
	private static jiemian jiemian1 = new jiemian();
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testJiemian() {
		int weight = jiemian1.getWidth();
		int height = jiemian1.getHeight();
		int x = jiemian1.getX();
		int y = jiemian1.getY();
		boolean flag = false;
		if(weight == 300 && height==200 && x==500 && y==300)
			flag = true;
		
		assertEquals(true,flag);
	}

	@Test
	public void testinitFrame() {
		jiemian1.initFrame();
		//对a1的测试
		int x1 = jiemian1.a1.getX();
		int y1 = jiemian1.a1.getY();
		int weight1 = jiemian1.a1.getWidth();
		int Height1 = jiemian1.a1.getHeight();
		//对a2的测试
		int x2 = jiemian1.a2.getX();
		int y2 = jiemian1.a2.getY();
		int weight2 = jiemian1.a2.getWidth();
		int Height2 = jiemian1.a2.getHeight();
		boolean flag = false;
		if(x1==50 && y1==20 && x2==50 && y2==60 && weight1==130 && Height1==20 && weight2==130 && Height2==40)
			flag = true;
		assertEquals(true,flag);
	}
	
	@Ignore
	public void testActionPerformed() {
	}

	@Test
	public void testIsNumeric() {
		jiemian1.isNumeric("yufan");
		assertEquals(false,jiemian1.getisNumeric());
		jiemian1.isNumeric("220");
		assertEquals(true,jiemian1.getisNumeric());
		jiemian1.isNumeric("2200");
		assertEquals(true,jiemian1.getisNumeric());
		jiemian1.isNumeric("0");
		assertEquals(false,jiemian1.getisNumeric());
	}
}
