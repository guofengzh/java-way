package race.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private String accountNo;
	private double balance;

	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void withdraw(double amount) {
		lock.lock();
		try {
			while (balance < amount) {
				cond.await();
			}
			balance -= amount;
			System.out.println("取钱成功");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void deposit(double depositAmount) {
		lock.lock();
		try {
			balance += depositAmount;
			cond.signalAll();
			System.out.println("存钱成功");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Account acct = new Account("1234567", 0);
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