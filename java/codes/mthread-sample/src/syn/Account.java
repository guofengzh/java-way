package syn;
public class Account
{
	private String accountNo;
	private double balance;

	public Account(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public synchronized void withdraw(double amount)
	{
		try
		{
			while (balance < amount)
			{
				wait();
			}
			balance -= amount;
			System.out.println("ȡǮ�ɹ�");
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public synchronized void deposit(double depositAmount)
	{
		balance += depositAmount;
		notify();
		System.out.println("��Ǯ�ɹ�");
	}
	
	public static void main(String[] args)
	{
		Account acct = new Account("1234567" , 0);
		new Thread(new Runnable() {
			@Override
			public void run() {
				acct.withdraw(80);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				acct.deposit(80);
			}
		}).start();
	}
	
}