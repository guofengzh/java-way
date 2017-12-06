package race.bqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread
{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		while(true)
		{
			System.out.println(getName() + "������׼�����Ѽ���Ԫ�أ�");
			try
			{
				Thread.sleep(200);

				bq.take();
			}
			catch (Exception ex){ex.printStackTrace();}
			System.out.println(getName() + "������ɣ�" + bq);
		}
	}
}