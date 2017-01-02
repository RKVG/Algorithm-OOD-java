/*
 sliding maze。 一个迷宫，一个球， 球一直走直到遇到障碍物才能停下。 问这个迷宫是不是solvable， followup 找最短path。
 
 bfs
*/

// 1 means obstalce, 0 means empty
class Node {
	int x;
	int y;
	Node (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Pair {
	Node pos;
	int dir;
	Pair (Node pos, int dir) {
		this.pos = pos;
		this.dir = dir;
	}
}

public int shortestPath (int[][] field, Node start, Node end) {
	if (field == null || field.length == 0 || field[0].length == 0 || start == end) {
		return 0;
	}
	int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	Map<Node, Integer> map = new HashMap<>();
	map.put(start, 0);

	Queue<Pair> queue = new LinkedList<>();
	for (int d = 0; d < 4; d++) {
		queue.offer(start, d);
	}
	
	
	while (!queue.isEmpty()) {
		Pair cur = queue.poll();

		Node pos = cur.pos;
		int dir = cur.dir;

		numTurns = map.get(pos);

		//if the cell in the direciton is empty
		while (pos != end && helper(field, cur, dir)) {
			continue;
		}
		Node newPos = new Node(pos.x + dir[cur.dir % 4][0], pos.y + dir[cur.dir % 4][1]);
		// find the end pos
		if (newPos == end) {
			return numTurns;
		}

		if (map.containsKey(newPos)) {
			continue;
		}
		queue.offer(new Pair(newPos, dir + 1));
		queue.offer(new Pair(newpOS, dir + 3));

		map.put(newPos, numTurns + 1);
	}

	return -1;

}
public boolean helper (int[][] filed, Pair cur, int[][] dir) {
	int x = cur.x + dir[cur.dir % 4][0];
	int y = cur.y + dir[cur.dir % 4][1];

	if (x < 0 || x >= filed.length 
		|| y < 0 || y >= field[0].length || field[x][y] == 1) {
		return false;
	}

	return true;
}
