/*# Problem 19
# Counting Sundays

# You are given the following information, but you may prefer to do some research
# for yourself.

#     1 Jan 1900 was a Monday.
#     Thirty days has September,
#     April, June and November.
#     All the rest have thirty-one,
#     Saving February alone,
#     Which has twenty-eight, rain or shine.
#     And on leap years, twenty-nine.
#     A leap year occurs on any year evenly divisible by 4, but not on a century
#     unless it is divisible by 400.

# How many Sundays fell on the first of the month during the twentieth century
# (1 Jan 1901 to 31 Dec 2000)?


days_in_month = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31,
                 9: 30, 10: 31, 11: 30, 12: 31}


def is_leap_year(year):
    result = False
    if year % 4 == 0:
        result = True
    if year % 100 == 0:
        if year % 400 == 0:
            result = True
        else:
            result = False

    return result


def df():
    year = 1900
    month = 1
    date = 1
    day = 1

    while True:
        yield year, month, date, day

        # advance day of week
        day = (day + 1) % 7

        # February needs special attention
        if month == 2:
            if date == 29:
                month = 3
                date = 1
            elif date == 28:
                if is_leap_year(year):
                    date = 29
                else:
                    month = 3
                    date = 1
            else:
                date += 1
        else:
            if date == days_in_month[month]:
                month = month + 1
                if month == 13:
                    year += 1
                    month = 1
                date = 1
            else:
                date += 1

date_stream = df()

# Skip until 1/1/1901
while True:
    year, month, date, day = next(date_stream)
    if year == 1901:
        break
print year, month, date, day

# Stop counting when we hit 1/1/2001
count = 0
while True:
    year, month, date, day = next(date_stream)
    if year == 2001:
        break
    if date == 1 and day == 0:
        count += 1

print year, month, date, day
print count

# Completed on Mon, 3 Mar 2014, 00:40
# Solve by: 63862
# ---------------
# 1901 1 1 2
# 2001 1 1 1
# 171
# [Finished in 0.3s]
*/

import java.util.HashMap;
import java.util.Map;

public class Problem19 {
	private int year = 1900;
	private int month = 1;
	private int date = 1;
	private int day = 1;
	
	public static void main(String[] args) {
		Problem19 problem19 = new Problem19();
		Problem19Date today;
		
//		Skip until 1/1/1901
		while (true) {
			today = problem19.nextDate();
		    if (today.year == 1901)
		        break;
		}
		
//		Stop counting when we hit 1/1/2001
		long count = 0;
		while (true) {
		    if (today.year == 2001)
		        break;
		    if (today.date == 1 && today.day == 0)
		        count += 1;
		    today = problem19.nextDate();
		}
		
		System.out.println(count);
	}

	private boolean isLeapYear(int year) {
		boolean result = false;
		
		if (year % 4 == 0)
			result = true;
		if (year % 100 == 0)
			if (year % 400 == 0)
				result = true;
			else
				result =false;
		
		return result;
	}
	
	public Problem19Date nextDate() {
		Map<Integer, Integer> daysInMonth = new HashMap<Integer, Integer>() {
			{
				put(1, 31);
				put(2, 28);
				put(3, 31);
				put(4, 30);
				put(5, 31);
				put(6, 30);
				put(7, 31);
				put(8, 31);
				put(9, 30);
				put(10, 31);
				put(11, 30);
				put(12, 31);
			}
		};

//		Return current date after finishing calculating the next one
		Problem19Date today = new Problem19Date(year, month, date, day);
		
//		advance day of week
		day = (day + 1) % 7;
		
//		February needs special attention
		if (month == 2) {
			if (this.date == 29) {
				month = 3;
				date = 1;
			}
			else if (this.date == 28) {
				if (isLeapYear(year)) 
					date = 29;
				else {
					month = 3;
					date = 1;
				}
			}
			else
				date += 1;
		}
		else {
			if (date == daysInMonth.get(month)) {
				month += 1;
				if (month == 13) {
					year += 1;
					month = 1;
				}
				date = 1;
			}
			else
				date += 1;
		}

		return today;
	}
}

//Completed on Sun, 22 Mar 2015, 05:52PM
//171