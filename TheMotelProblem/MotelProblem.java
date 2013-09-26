
import java.util.Arrays;


public class MotelProblem
{

    private static int dist = 0;
    private static MyArrayList<Motel> list;

    public MotelProblem()
    {
        list = new MyArrayList<Motel>();
    }

    public MotelProblem(int dist)
    {
        list = new MyArrayList<Motel>();
        this.dist = dist;
    }

    public static void motel(String name, int value)
    {
        list.add(new Motel(name, value));
    }

    public static void solve()
    {
        int n = list.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j] = 0;
        
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++)
                dp[i][j] = (200-(list.get(j).getValue() - list.get(i).getValue()))*(200-(list.get(j).getValue() - list.get(i).getValue()));

        for(int k=1;k<n-1;k++)
            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++)
                    if(dp[i][k]+dp[k][j] < dp[i][j])
                        dp[i][j] = dp[i][k]+dp[k][j];

        System.out.println("Minimized Penalty : " + dp[0][n-1]);
    }

    public static void main(String[] args)
    {
        MotelProblem MP;
        /*System.out.println("----------------------------------------");
        MP = new MotelProblem(200);
        MP.motel("motel-0", 0);
        MP.motel("motel-1", 10);
        MP.motel("motel-2", 180);
        MP.motel("motel-3", 350);
        MP.motel("motel-4", 450);
        MP.motel("motel-5", 600);
        MP.solve();
        System.out.println("----------------------------------------");*/
        MP = new MotelProblem(200);
        MP.motel("motel-0", 0);
        MP.motel("motel-1", 1);
        MP.motel("motel-2", 2);
        MP.motel("motel-3", 3);
        MP.motel("motel-201", 201);
        MP.motel("motel-202", 202);
        MP.motel("motel-203", 203);
        MP.motel("motel-403", 403);
        MP.solve();
        System.out.println("----------------------------------------");
        //MP.solve();
    }
}
/// End-of-File

