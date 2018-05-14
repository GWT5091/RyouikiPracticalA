import java.util.Random;

public class Practice10_1_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int i;

		Random generator1 = new Random(334);
		for( i = 0;i < 10;i++)
		{
			System.out.println("Random1 = "+generator1.nextInt());
		}
		Random generator2 = new Random(334);
		for( i = 0;i < 10;i++)
		{
			System.out.println("Random2 = "+generator2.nextInt());
		}

	}

}
