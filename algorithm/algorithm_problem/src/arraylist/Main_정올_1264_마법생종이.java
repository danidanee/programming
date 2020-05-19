package arraylist;

import java.io.*;
import java.util.*;

public class Main_정올_1264_마법생종이 {

	static class Paper{
		int sx;
		int sy;
		int ex;
		int ey;
		int color;
		
		public Paper(int sx, int sy, int ex, int ey, int color) {
			super();
			this.sy = sy;
			this.sx = sx;
			this.ey = ey;
			this.ex = ex;
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int nx = Integer.parseInt(st.nextToken());
		int ny = Integer.parseInt(st.nextToken());
		
		// 시작값 넣어주기
		ArrayList<Paper> list = new ArrayList<>();
		list.add(new Paper(0, 0, nx, ny, 0));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<list.size(); j++) {
				Paper paper = list.get(j);
				if(paper.sy < y && paper.ey > y && paper.sx < x && paper.ex > x) {
					// 가로
					if(paper.color == 0) {
						list.add(new Paper(paper.sx, paper.sy, paper.ex, y, 1));
						list.add(new Paper(paper.sx, y, paper.ex, paper.ey, 1));
					}
					//세로
					else {
						list.add(new Paper(paper.sx, paper.sy, x, paper.ey, 0));
						list.add(new Paper(x, paper.sy, paper.ex, paper.ey, 0));
					}
					list.remove(j);
					break;
				}
			}
		}
		
		int min = ny*nx;
		int max = 0;
		for(int i=0; i<list.size(); i++) {
			Paper paper = list.get(i);
			int size = (paper.ey - paper.sy) * (paper.ex - paper.sx);
			if(size < min) min = size;
			if(size > max) max = size;
		}
		
		System.out.println(max + " " + min);
		
		br.close();
		
	}

}
