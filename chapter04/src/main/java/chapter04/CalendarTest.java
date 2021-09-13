package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// Calendar는 추상. 
		/* getInstance로 구체화 -> Factory Method Pattern
		 * 목적: Singleton Pattern 유지 -> Spring은 Singleton */
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 11);	// 12월(Month-1)
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		cal.set(1998, 7, 27);
		cal.add(Calendar.DATE, 1000);
		System.out.print("1,000일 뒤: ");
		printDate(cal);
		
		
		cal.set(1998, 7, 27);
		cal.add(Calendar.DATE, 10000);
		System.out.print("10,000일 뒤: ");
		printDate(cal);
		
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);		// 0~11 +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);	// 1(SUN)~7(SAT)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "년 " + (month + 1) + "월 " + date + "일 " + DAYS[day-1] + "요일 " + 
				hour + "시 " + minute + "분 " + second + "초");
	}

}
