import java.util.ArrayList;

public class PacMan_DFS {
	static final int WALL = '%';
	static final int PACMAN = 'P';
	static final int FOOD = '.';
	static final int EMPTY = '-';
	static public class Point {
		int x, y, val, prev;
		String move;
		public String toString() { return "y=" + y + " x=" + x; }
		public Point(int y0, int x0, int val, int prev0, String move0) {
			y = y0; x = x0; this.val = val; prev = prev0; move = move0;
		}
	}
	static void dfs(int br, int bc, int pr, int pc, int fr, int fc, String[] board) {
		// br-c board, pr-c pacman, fr-c food
		int[][] grid = new int[br][bc];
		ArrayList<Point> al = new ArrayList<>();
		al.add(new Point(pr, pc, PACMAN, -1, ""));
		while (al.size()>0) {
			int i = al.size() - 1;
			if (al.get(i).val==FOOD)
				break;
			if (al.get(i).y>0 && board[al.get(i).y-1].charAt(al.get(i).x)!=WALL && grid[al.get(i).y-1][al.get(i).x]==0) {
				al.add(new Point(al.get(i).y - 1, al.get(i).x, board[al.get(i).y - 1].charAt(al.get(i).x), i, "UP"));
				grid[al.get(i).y - 1][al.get(i).x] = 1;
			} else if (al.get(i).x > 0 && board[al.get(i).y].charAt(al.get(i).x - 1) != WALL && grid[al.get(i).y][al.get(i).x - 1] == 0) {
				al.add(new Point(al.get(i).y, al.get(i).x - 1, board[al.get(i).y].charAt(al.get(i).x - 1), i, "LEFT"));
				grid[al.get(i).y][al.get(i).x - 1] = 1;
			} else if (al.get(i).x < bc - 1 && board[al.get(i).y].charAt(al.get(i).x + 1) != WALL && grid[al.get(i).y][al.get(i).x + 1] == 0) {
				al.add(new Point(al.get(i).y, al.get(i).x + 1, board[al.get(i).y].charAt(al.get(i).x + 1), i, "RIGHT"));
				grid[al.get(i).y][al.get(i).x + 1] = 1;
			} else if (al.get(i).y < br - 1 && board[al.get(i).y + 1].charAt(al.get(i).x) != WALL && grid[al.get(i).y + 1][al.get(i).x] == 0) {
				al.add(new Point(al.get(i).y + 1, al.get(i).x, board[al.get(i).y + 1].charAt(al.get(i).x), i, "DOWN"));
				grid[al.get(i).y + 1][al.get(i).x] = 1;
			} else {
				al.remove(i);
			}
		}
		if (al.size()==0)
			return;
		System.out.println(al.size() + 1);
		al.forEach(System.out::println);
	}
	static void bfs(int br, int bc, int pr, int pc, int fr, int fc, String[] board) {
		// br-c board, pr-c pacman, fr-c food
		int[][] grid = new int[br][bc];
		ArrayList<Point> al = new ArrayList<>();
		al.add(new Point(pr, pc, PACMAN, -1, ""));
		int i = 0;
		while (i < al.size() && al.get(i).val != FOOD) {
			if (al.get(i).y > 0 && board[al.get(i).y - 1].charAt(al.get(i).x) != WALL && grid[al.get(i).y - 1][al.get(i).x] == 0) {
				al.add(new Point(al.get(i).y - 1, al.get(i).x, board[al.get(i).y - 1].charAt(al.get(i).x), i, "UP"));
				grid[al.get(i).y - 1][al.get(i).x] = 1;
			}
			if (al.get(i).x > 0 && board[al.get(i).y].charAt(al.get(i).x - 1) != WALL && grid[al.get(i).y][al.get(i).x - 1] == 0) {
				al.add(new Point(al.get(i).y, al.get(i).x - 1, board[al.get(i).y].charAt(al.get(i).x - 1), i, "LEFT"));
				grid[al.get(i).y][al.get(i).x - 1] = 1;
			}
			if (al.get(i).x < bc - 1 && board[al.get(i).y].charAt(al.get(i).x + 1) != WALL && grid[al.get(i).y][al.get(i).x + 1] == 0) {
				al.add(new Point(al.get(i).y, al.get(i).x + 1, board[al.get(i).y].charAt(al.get(i).x + 1), i, "RIGHT"));
				grid[al.get(i).y][al.get(i).x + 1] = 1;
			}
			if (al.get(i).y < br - 1 && board[al.get(i).y + 1].charAt(al.get(i).x) != WALL && grid[al.get(i).y + 1][al.get(i).x] == 0) {
				al.add(new Point(al.get(i).y + 1, al.get(i).x, board[al.get(i).y + 1].charAt(al.get(i).x), i, "DOWN"));
				grid[al.get(i).y + 1][al.get(i).x] = 1;
			}
			i++;
		}
		if (i == al.size())
			return;
//		int nodeCnt = 0;
		ArrayList<Point> alRes = new ArrayList<>();
		while (i > 0) {
//			nodeCnt++;
			alRes.add(al.get(i));
			i = al.get(i).prev;
		}
		System.out.println(al.size()-1);
		al.forEach(System.out::println);
//		Collections.reverse(alRes);
//		System.out.println(nodeCnt + 1);
//		alRes.forEach(System.out::println);
	}
	public static void main(String[] args) {
		int pacman_r = 3, pacman_c = 9;
		int food_r = 5, food_c = 1;
		int r = 7, c = 20;
		String board[] = {
				"%%%%%%%%%%%%%%%%%%%%", 
				"%--------------%---%", 
				"%-%%-%%-%%-%%-%%-%-%", 
				"%--------P-------%-%", 
				"%%%%%%%%%%%%%%%%%%-%", 
				"%.-----------------%", 
				"%%%%%%%%%%%%%%%%%%%%" };
		bfs(r, c, pacman_r, pacman_c, food_r, food_c, board);
		System.out.println("AAAAAAAAAAAAAA");
		System.out.println("AAAAAAAAAAAAAA");
		System.out.println("AAAAAAAAAAAAAA");
		System.out.println("AAAAAAAAAAAAAA");
		System.out.println("AAAAAAAAAAAAAA");
	    System.out.println("AAAAAAAAAAAAAA");
	}
}