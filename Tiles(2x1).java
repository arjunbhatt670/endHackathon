    //   ......    Find the number of cases where a 3×N wall is filled with 2×1 and 1×2 tiles.
                       //  The first line is given N(1 ≤ N ≤ 30).
                       //  Print the number of cases on the first line
                       
     /*      SOLUTION:-
            It was too difficult to understand... First of all, when n=2, d[2] = 3. You can see it by drawing it yourself. 
            And because the tile can be filled only when n is an even number (you can see it by drawing, there is always 1 space for odd numbers), 
            so we put the condition n%2 == 0. If d[4] is considered as two 32 squares, there are the number of cases d[2]d[2]. 
            However, there are shapes that can be made only when they have 34 shapes, and there are two types. So d[4] = d[2]d[2] + 2. 
            Considering that d[6] has 34 and 32 squares, there are the number of cases of d[4]d[2], and there are two cases that are possible only when it is 36. 
            However, in addition to the structure consisting of 34 and 32 in front, we must also think of a structure with 32 and 34 in front. 
            However, if d[2]d[4] is added again, a duplicate shape occurs, so a special case that exists only at 34 is added once more.
            (At this time, since the large square is 36, add '34 special case' x '32 case' and '32 case' x '3*4 special case'.)           */     
     
     
 import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] dp = new int[n+1];
		if(n > 1 && n % 2 == 0) {
			dp[0] = 1; dp[2] = 3;
			
			for(int i = 4; i < n+1; i+=2) {
				dp[i] = dp[2]*dp[i-2];
				for(int j = 4; j <= i; j+=2)
					dp[i] += 2*dp[i-j];
			}
		}
		System.out.println(dp[n]);
	}
}
