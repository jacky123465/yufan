package selfProject1plus;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class lifegameTest {
	private lifegame lg = new lifegame();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLifegame() {
		int chang = lg.getWidth();
		int weight = lg.getWidth();
		String bu1name = lg.bu1.getLabel();
		String bu2name = lg.bu2.getLabel();
		String jbname = lg.jb.getText();
		int x1 = lg.bu1.getX();
		int y1 = lg.bu1.getX();
		int x2 = lg.bu2.getX();
		int y2 = lg.bu2.getY();
		boolean flag = false;
		if(bu1name.equals("随机模式") && bu2name.equals("经典模式") && x1==100 && y1==100 && x2==100 && y2==300 && chang==630 && weight==630 && jbname.equals("<html>随机模式图形随机生成而且<br>颜色变化多端,而经典模式<br>则是两条小鱼的变化</html>"))
			flag = true;
		assertEquals(true,flag);
	}

	@Ignore
	public void testMain() {
		
	}

	@Test
	public void testActionPerformed() {
		ActionEvent e = new ActionEvent(lg.bu1, 0, null);
		lg.actionPerformed(e);
		int x = lg.youxi.getX();
		int y = lg.youxi.getY();
		int weight = lg.youxi.getWidth();
		int height = lg.youxi.getHeight();

		Boolean flag = false;
		if(lg.moshi.equals("随机模式") && x==500 && y==300 && weight==300 && height==200)
			flag = true;
		assertEquals(true,flag);
		
		
		//增加代码覆盖率
		ActionEvent e1 = new ActionEvent(lg.bu2, 0, null);
		lg.actionPerformed(e1);
		weight = lg.world.getWidth();
		height = lg.world.getHeight();
		x = lg.world.getX();
		y = lg.world.getY();
		
		flag = false;
		if(lg.moshi.equals("经典模式") && weight==650 && height==600)
			flag = true;
		assertEquals(true,flag);
		
	}

}
