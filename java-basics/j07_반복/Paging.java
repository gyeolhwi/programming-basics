package j07_반복;

import java.util.Scanner;

public class Paging {
	public static void main(String[] args) {
		/*
		 * 총 게시물 수 : 85
		 * 1 페이지
		 * 85
		 * 84
		 * 83
		 * ...
		 * 76
		 * 2페이지
		 * 75
		 * 74
		 *
		 * 66
		 * 
		 * 
		 */
		
		int page, feed;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("게시물 수 :");	feed = scanner.nextInt();
		System.out.print("페이지 수 :");	page = scanner.nextInt();
		 
		int n = feed / page;				// 페이지수 자르기
		if (feed % page != 0) n += 1;		// 만일, 페이지수가 나누어떨어지지않으면 +1
		
		for (int i = 0; i < n; i++) {
			System.out.println(i+1+"페이지");
			
			for(int j = 0; j < page; j ++) // 안의반복횟수 : 한페이지에 들어갈 갯수
				if (feed != 0) {
				System.out.println(feed--);}
		}
		
	}
}