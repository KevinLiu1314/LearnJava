//# Problem 17
//# Number letter counts
//
//# If the numbers 1 to 5 are written out in words: one, two, three, four, five,
//# then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//# If all the numbers from 1 to 1000 (one thousand) inclusive were written out in
//# words, how many letters would be used?
//
//# NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
//# forty-two) contains 23 letters and 115 (one hundred and fifteen)
//# contains 20 letters. The use of "and" when writing out numbers is in
//# compliance with British usage.
//
//words = {1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five', 6: 'six',
//         7: 'seven', 8: 'eight', 9: 'nine', 10: 'ten', 11: 'eleven',
//         12: 'twelve', 13: 'thirteen', 14: 'fourteen', 15: 'fifteen',
//         16: 'sixteen', 17: 'seventeen', 18: 'eighteen', 19: 'nineteen',
//         20: 'twenty', 30: 'thirty', 40: 'forty', 50: 'fifty', 60: 'sixty',
//         70: 'seventy', 80: 'eighty', 90: 'ninety', 1000: 'one thousand'}
//
//
//def to_words(n):
//    if n in words:
//        return words[n]
//
//    beginning = ""
//    hundreds = n / 100
//    if hundreds > 0:
//        beginning = words[hundreds] + " hundred"
//
//    n = n - hundreds * 100
//    tens = n / 10 * 10
//    units = n % 10
//    ending = ""
//
//    if n in words:
//        ending = words[n]
//    else:
//        if tens > 0:
//            ending = words[tens]
//        if units > 0:
//            if ending != "":
//                ending = ending + " " + words[units]
//            else:
//                ending = words[units]
//
//    if beginning != "":
//        if ending != "":
//            return beginning + " and " + ending
//        else:
//            return beginning
//    else:
//        return ending
//
//# for i in range(800, 901):
//#     print to_words(i)
//
//oneline = ""
//for i in range(1, 1001):
//    oneline += to_words(i)
//
//print len(oneline.replace(" ", ""))
//
//# Completed on Sun, 2 Mar 2014, 21:45
//# Solve by: 70549
//# ---------------
//# 21124
//# [Finished in 0.2s]

import java.util.HashMap;
import java.util.Map;

public class Problem17 {

	public static void main(String[] args) {
		String oneLine = "";
		
		for (int i = 1; i <= 1000; i++)
			oneLine += toWords(i);
		
		oneLine = oneLine.replace(" ", "");
		System.out.println(oneLine.length());
	}
	
	public static String toWords(int n) {
		Map<Integer, String> words = new HashMap<Integer, String>() {
			{
				put(1, "one");
				put(2, "two");
				put(3, "three");
				put(4, "four");
				put(5, "five");
				put(6, "six");
				put(7, "seven");
				put(8, "eight");
				put(9, "nine");
				put(10, "ten");
				put(11, "eleven");
				put(12, "twelve");
				put(13, "thirteen");
				put(14, "fourteen");
				put(15, "fifteen");
				put(16, "sixteen");
				put(17, "seventeen");
				put(18, "eighteen");
				put(19, "nineteen");
				put(20, "twenty");
				put(30, "thirty");
				put(40, "forty");
				put(50, "fifty");
				put(60, "sixty");
				put(70, "seventy");
				put(80, "eighty");
				put(90, "ninety");
				put(1000, "one thousand");
			}
		};
		
		if (words.containsKey(n))
			return words.get(n);
		
		String beginning = "";
		int hundreds = n / 100;
		if (hundreds > 0)
			beginning = words.get(hundreds) + " hundred";
		
		n = n - hundreds * 100;
		int tens = n / 10 * 10;
		int units = n % 10;
		
		String ending = "";
		if (words.containsKey(n))
			ending = words.get(n);
		else {
			if (tens > 0)
				ending = words.get(tens);
			if (units > 0)
				if (ending != "")
					ending = ending + " " + words.get(units);
				else
					ending = words.get(units);
		}
		
		if (beginning != "")
			if (ending != "")
				return beginning + " and " + ending;
			else
				return beginning;
		else
			return ending;
	}
}

//Completed on Sat, 21 Mar 2015, 11:49PM
//21124