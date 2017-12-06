package race.bqueue;

import java.util.concurrent.BlockingQueue;

class Producer extends Thread
{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		String[] strArr = new String[]
		{
			"Java",
			"Struts",
			"Spring"
		};
		for (int i = 0 ; i < 999999999 ; i++ )
		{
			System.out.println(getName() + "������׼����������Ԫ�أ�");
			try
			{
				Thread.sleep(200);
				// ���Է���Ԫ�أ���������������̱߳�����
				bq.put(strArr[i % 3]);
			}
			catch (Exception ex){ex.printStackTrace();}
			System.out.println(getName() + "������ɣ�" + bq);
		}
	}
}