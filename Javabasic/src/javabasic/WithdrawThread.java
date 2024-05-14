package javabasic;

// 출금 쓰레드
public class WithdrawThread extends Thread {

	Account account;
	int amount;

	WithdrawThread(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {

		for(int i=0 ; i<10 ; i++) {
			if(this.account.getMoney()>=500) {
				this.account.withdraw(this.amount);
			}
			System.err.println(this.amount + "원 출금됨!");
			System.out.println(account);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}

	}
}
