package race.bqueue;


import java.util.concurrent.*;

public class BlockingQueueTest2
{
	public static void main(String[] args)
	{
		// ����һ������Ϊ1��BlockingQueue
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		// ����3���������߳�
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		// ����һ���������߳�
		new Consumer(bq).start();
	}
}