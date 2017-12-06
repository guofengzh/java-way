package race.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountCanFail {
	private String accountNo;
	private double balance;

	private final Lock lock = new ReentrantLock();

	public AccountCanFail(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void withdraw(double amount) {
		lock.lock();
		try {
			if (balance < amount) {
				System.out.println("没有钱了");
				return ;
			}
			balance -= amount;
			System.out.println("取钱成功");
		} finally {
			lock.unlock();
		}
	}

	public void deposit(double depositAmount) {
		lock.lock();
		try {
			balance += depositAmount;
			System.out.println("存钱成功");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		AccountCanFail acct = new AccountCanFail("1234567", 0);
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