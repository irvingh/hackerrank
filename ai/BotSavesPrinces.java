public class BotSavesPrinces {
	public BotSavesPrinces() {
		String[] grid = {"---", "-m-", "p--"};
		solution(3, grid);
	}
	final static String[] goH = {"LEFT", "RIGHT"};
	final static String[] goV = {"UP", "DOWN"};
	public void solution(int n, String[] grid) {
		int mx = -1, my = -1, px = -1, py = -1;
		for (int row=0; row<n; row++) {
			px = grid[row].indexOf("p");
			if (px!=-1) { py = row; break; }
		}
		for (int row=0; row<n; row++) {
			mx = grid[row].indexOf("m");
			if (mx!=-1) { my = row; break; }
		}
		int xDir = (mx<=px) ? 1 : -1;
		int yDir = (my<=py) ? 1 : -1;
		for (int i=mx; i!=px; i=i+xDir)
			System.out.println(goH[(xDir+1)/2]);
		for (int i=my; i!=py; i=i+yDir)
			System.out.println(goV[(yDir+1)/2]);
	}
}
