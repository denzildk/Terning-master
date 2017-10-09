package terning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {
	Dice test;

	@Before
	public void setUp() throws Exception {
		test = new Dice();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		for (int i = 0; i < 1000; i++) {
			int d1 = test.roll();
			boolean value1;
			if (d1 < 7 && d1 > 0)
				value1 = true;
			else
				value1 = false;
			assertEquals(true, value1);
		}

		boolean value2;
		int value_one = 0, value_two = 0, value_three = 0, value_four = 0, value_five = 0, value_six = 0,
				error_count = 0;
		for (int i = 0; i < 60000; i++) {
			int d2 = test.roll();
			switch (d2) {
			case (1):
				value_one++;
				break;
			case (2):
				value_two++;
				break;
			case (3):
				value_three++;
				break;
			case (4):
				value_four++;
				break;
			case (5):
				value_five++;
				break;
			case (6):
				value_six++;
				break;
			default:
				error_count++;
			}
		}
		System.out.println("1: " + value_one + ", 2: " + value_two + ", 3: " + value_three + ", 4: " + value_four
				+ ", 5: " + value_five + ", 6: " + value_six);
		int val_one_dif = Math.abs(value_one - (60000 / 6));
		int val_two_dif = Math.abs(value_two - (60000 / 6));
		int val_three_dif = Math.abs(value_three - (60000 / 6));
		int val_four_dif = Math.abs(value_four - (60000 / 6));
		int val_five_dif = Math.abs(value_five - (60000 / 6));
		int val_six_dif = Math.abs(value_six - (60000 / 6));
		// System.out.println(val_one_dif);
		System.out.println(val_one_dif - 4000 <= 400 && val_two_dif - 2000 <= 400 && val_three_dif - 2000 <= 400
				&& val_four_dif - 2000 <= 400 && val_five_dif - 2000 <= 400 && val_six_dif - 4000 <= 400);
		if (error_count > 0)
			value2 = false;
		else if (val_one_dif <= 400 && val_two_dif <= 400 && val_three_dif <= 400 && val_four_dif <= 400
				&& val_five_dif <= 400 && val_six_dif <= 400)
			value2 = true;
		else {
		System.out.println("uligheder i terningen på mere end 4%, men alle slag er mellem 1 og 6");
			value2 = false;
		}
		assertEquals(true, value2);

		test.rollMultiple(-5);

	}

}
