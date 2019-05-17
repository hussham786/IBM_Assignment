import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
class DateDifference{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date in dd/mm/yyyy format");
		String dateStr = sc.nextLine();
		new DateDifference().dateDiff(dateStr);
	}

	void dateDiff(String dateStr){
		String[] dateSplit = dateStr.split("/");
		Date date = new Date();
		Calendar calOne = Calendar.getInstance();
		int year = calOne.get(Calendar.YEAR);
		//System.out.println("Date : " + date.getDate() +", Month : " + date.getMonth() + ", Year : " + year);
		
		if (Integer.parseInt(dateSplit[0]) != date.getDate()) {
			if(Integer.parseInt(dateSplit[0]) > date.getDate())
				System.out.println("The difference in date is : " + (Integer.parseInt(dateSplit[0]) - date.getDate()));
			else
				System.out.println("The difference in date is : " + (date.getDate() - Integer.parseInt(dateSplit[0])));
		} else {
			System.out.println("The dates are same");
		}

		if (Integer.parseInt(dateSplit[1]) != date.getMonth()) {
			if(Integer.parseInt(dateSplit[1]) > date.getMonth())
				System.out.println("The difference in Month is : " + (Integer.parseInt(dateSplit[1]) - (date.getMonth() + 1)));
			else
				System.out.println("The difference in Month is : " + ((date.getMonth() + 1) - Integer.parseInt(dateSplit[1])));
		} else {
			System.out.println("The Months are same");
		}

		if (Integer.parseInt(dateSplit[2]) != year) {
			if(Integer.parseInt(dateSplit[2]) > year)
				System.out.println("The difference in year is : " + (Integer.parseInt(dateSplit[2]) - year));
			else
				System.out.println("The difference in year is : " + (year - Integer.parseInt(dateSplit[2])));
		} else {
			System.out.println("The years are same");
		}
	}
}