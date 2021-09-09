package prob05;

public class Account {
	private String accountNo;	// 계좌번호
	private int balance;		// 잔고
	
	public Account() {};
	public Account(String inputAccount) {
		setAccountNo(inputAccount);
		System.out.println(inputAccount + " 계좌가 개설되었습니다.");
	}
	public void save(int depositAmount) {
		setBalance(balance + depositAmount);
	}
	public void deposit(int withdrawalAmount) {
		setBalance(balance - withdrawalAmount);
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
