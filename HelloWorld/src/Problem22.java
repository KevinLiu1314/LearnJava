/*# Problem 22
# Names scores

# Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
# containing over five-thousand first names, begin by sorting it into
# alphabetical order. Then working out the alphabetical value for each name,
# multiply this value by its alphabetical position in the list to obtain a name
# score.

# For example, when the list is sorted into alphabetical order, COLIN, which is
# worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would
# obtain a score of 938 X 53 = 49714.

# What is the total of all the name scores in the file?

names = sorted(open("problem 22.txt").read().replace('"', "").split(","))
avalues = [sum(map(lambda x: ord(x) - ord("A") + 1, list(name))) for name in names]
scores = [(names.index(names[i]) + 1) * avalues[names.index(names[i])] for i in range(len(names))]
print names
print avalues
print names.index("COLIN")
print avalues[937]
print scores[937]

print sum(scores)

# Completed on Mon, 3 Mar 2014, 02:33
# Solve by: 64123
# ---------------
# 937
# 53
# 49714
# 871198282
# [Finished in 1.0s]
*/

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import java.util.*;

public class Problem22 {

	public static void main(String[] args) throws Exception{
		String str = new String(readAllBytes(get("/home/kevin/Repositories/LearnJava/HelloWorld/src/Problem 22.txt")));
		str = str.replace("\"", "");
		String[] names = str.split(",");
		Arrays.sort(names);
		
		int sum = 0;
		for (int i = 0; i < names.length; i ++) {
			sum += (i + 1) * nameValue(names[i]);
		}
		
		System.out.println(sum);
	}

	public static int nameValue(String name) {
		int value = 0;
		int AValue = (int)'A';
		
		for (int i = 0; i < name.length(); i++) {
			value += (int)name.charAt(i) - AValue + 1;
		}
		
		return value;
	}
}

// Completed on Sun, 12 Apr 2015, 09:05PM
// 871198282