/*# -*- coding: utf-8 -*-
# Problem 18
# Maximum path sum I

# By starting at the top of the triangle below and moving to adjacent numbers on
# the row below, the maximum total from top to bottom is 23.

# 3
# 7 4
# 2 4 6
# 8 5 9 3

# That is, 3 + 7 + 4 + 9 = 23.

# Find the maximum total from top to bottom of the triangle below:

# 75
# 95 64
# 17 47 82
# 18 35 87 10
# 20 04 82 47 65
# 19 01 23 75 03 34
# 88 02 77 73 07 63 67
# 99 65 04 28 06 16 70 92
# 41 41 26 56 83 40 80 70 33
# 41 48 72 33 47 32 37 16 94 29
# 53 71 44 65 25 43 91 52 97 51 14
# 70 11 33 28 77 73 17 78 39 68 17 57
# 91 71 52 38 17 14 91 43 58 50 27 29 48
# 63 66 04 68 89 53 67 30 73 16 69 87 40 31
# 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

# NOTE: As there are only 16384 routes, it is possible to solve this problem
# by trying every route. However, Problem 67, is the same challenge with a
# triangle containing one-hundred rows; it cannot be solved by brute force,
# and requires a clever method! ;o)

from time import time

start_time = time()

# 1. Save the triangle into a 15 X 15 grid
# 2. Each node is represent as (sum, i, j)
# 3. Initial the nodes as [grid[0, 0], 0, 0]
# 4. Just expand the nodes by adding a lefe & a right node to existing nodes
# 5. Until nodes[0][1] = 14

# Save the triangle into a 15 X 15 grid
triangle = map(int, open("problem 18.txt").read().split())
grid = [[] * 15 for i in xrange(15)]
i = 0       # index into the numbers in triangle
for j in xrange(15):
    for k in xrange(j + 1):
        grid[j].append(triangle[i])
        i += 1

# Initial & expand the nodes
nodes = [(grid[0][0], 0, 0)]
while nodes[0][1] < 14:
    new_nodes = []
    for node in nodes:
        i = node[1]
        j = node[2]
        left = (node[0] + grid[i + 1][j], i + 1, j)
        right = (node[0] + grid[i + 1][j + 1], i + 1, j + 1)
        new_nodes.append(left)
        new_nodes.append(right)

    nodes = new_nodes

# Print out the max
print max(map(lambda node: node[0], nodes))

print "Total Time: ", time() - start_time

# Completed on Sun, 9 Mar 2014, 05:08
# Solve by: 69425
# ---------------
# 1074
# Total Time:  0.0329999923706
# [Finished in 0.2s]
*/

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import java.util.*;

public class Problem18 {

	public static void main(String[] args) throws Exception{
		String str = new String(readAllBytes(get("/home/kevin/Repositories/LearnJava/HelloWorld/src/Problem18.txt")));
		String[] list = str.split("\\s");
		int[] triangle = new int[list.length];
		for (int i = 0; i < list.length; i++)
			triangle[i] = Integer.parseInt(list[i]);
		
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		int index = 0;
		for (int j = 0; j < 15; j++) {
			ArrayList<Integer> line = new ArrayList<Integer>();
			for (int k = 0; k < j + 1; k++) {
				line.add(triangle[index]);
				index++;
			}
			grid.add(line);
		}
		
		ArrayList<Problem18Node> nodes = new ArrayList<Problem18Node>();
		nodes.add(new Problem18Node(grid.get(0).get(0), 0, 0));
		while (nodes.get(0).i() < 14) {
			ArrayList<Problem18Node> newNodes = new ArrayList<Problem18Node>();
			for (Problem18Node node: nodes) {
				int i = node.i();
				int j = node.j();
				Problem18Node left = new Problem18Node(node.sum()+grid.get(i+1).get(j), i+1, j);
			    Problem18Node right = new Problem18Node(node.sum()+grid.get(i+1).get(j+1), i+1, j+1);
			    newNodes.add(left);
			    newNodes.add(right);
			}
			
			nodes = newNodes;
		}
		
		long max = 0;
		for (Problem18Node node: nodes)
			if (node.sum() > max)
				max = node.sum();
		
		System.out.println("Final nodes: " + nodes.size());
		System.out.println(max);
	}
}

//Completed on Sun, 22 Mar 2015, 02:17PM
//Final nodes: 16384
//1074
