package clustering_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Clustering {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		String inputFileName = "kwansei.txt";
		String outputFileName = "output.txt";

		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

		//ID_list
		List<ID> list = new ArrayList<>();
		//要素数
		int counter = 0;
//仮IDを交付
		String buffer;
		while((buffer = br.readLine()) != null)
		{
			String[] a = buffer.split(",");
			list.add(new ID(counter,Double.parseDouble(a[0]),Double.parseDouble(a[1]),Double.parseDouble(a[2]),Double.parseDouble(a[3])));

			counter++;
	//		bw.write(buffer + "\n");
		}

//debag箇所1
/*
		for(int i = 0;i<counter;i++)
		{
			System.out.println("ID"+" "+list.get(i).id+" "+list.get(i).sepal_length+" "+list.get(i).sepal_width+" "+list.get(i).petal_length+" "+list.get(i).petal_width);
		}
*/
		//-----------------------------------------------
		//グループ数
		int group = 2;

		for(int k = 0; k < counter- group;k++)
		{
		//ユーグリッド距離
		double result1;
		double min = Double.MAX_VALUE;

		//最小距離区間番号
		int number1 = 0;
		int number2 = 0;

		for(int i = 0;i < counter-1;i++)
		{
			for(int j = i + 1; j < counter;j++)
			{
				if(list.get(i).id != list.get(j).id)
				{
					result1 = Math.pow(list.get(i).sepal_length-list.get(j).sepal_length, 2)+Math.pow(list.get(i).sepal_width-list.get(j).sepal_width, 2)+Math.pow(list.get(i).petal_length-list.get(j).petal_length,2)+Math.pow(list.get(i).petal_width-list.get(j).petal_width, 2);
					if(result1 < min)
					{
						number1 = i;
						number2 = j;
						min = result1;
					}
				}
				else
				{
					//IDが同じであればpass
				}
			}

		}

//		System.out.println(number1);
//		System.out.println(number2);

		//念のためnumber1 < number2
		//IDの書き換え
		if(number1 < number2)
		{
			int id1 = list.get(number2).id;
			for(int i = 0;i < counter;i++)
			{
				if(list.get(i).id == id1)
				{
					ID tmp = new ID(list.get(number1).id,list.get(i).sepal_length,list.get(i).sepal_width,list.get(i).petal_length,list.get(i).petal_width);
					list.set(i, tmp);
				}
			}
		}

		}
		//output.txtに書き出す
		for(int i = 0;i <counter;i++)
		{
			bw.write("ID"+" "+list.get(i).id+" "+list.get(i).sepal_length+" "+list.get(i).sepal_width+" "+list.get(i).petal_length+" "+list.get(i).petal_width +"\n");
		}
//		bw.write("counter"+ counter +"\n");
		//-----------------------------------------------

		br.close();
		bw.close();
	}
}
