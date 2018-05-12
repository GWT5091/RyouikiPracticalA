import java.util.Random;

public class Practice10_1_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		int arg = Integer.parseInt(args[0]);
		Random generator = new Random();
		int sum = 0;

		 if (args.length != 1)
		 {
			    for(int i = 0;i <100;i++)
			    {
			    	sum += generator.nextInt();
			    }
			    System.out.println(sum/100);
		}
		 else
		 {
			 int arg = Integer.parseInt(args[0]);
			    for(int i = 0;i <arg;i++)
			    {
			    	sum += generator.nextInt();
			    }

			    System.out.println("sum = "+ sum +" arg = "+ arg +" "+ sum/arg);
		 }
/*
		if(arg == 0)
		{
			System.out.println(arg);
		}
		*/
	}

}
