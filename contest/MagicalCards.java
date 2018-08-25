import java.util.ArrayList;
import java.util.List;

public class MagicalCards {

    public void test() {
        prime(12288);
        solve(12288);
//        for (int i=2; i<=100000; i++)
//            solve(i);
    }

    int[] primeArray;

    public void prime(int n) {
        primeArray = new int[n + 1];
        for (int i=2; i<=n; i++) {
            if (primeArray[i]==0) {
                primeArray[i] = i;
                for (int j=2*i; j<=n; j=j+i)
                    if (primeArray[j]==0)
                        primeArray[j]=-1;
            }
        }
    }

    public int nextPrime(int p) {
        for (int i=p+1; i<primeArray.length; i++)
            if (primeArray[i]>0)
                return i;
        return -1;
    }

    public void solve(int n) {
        int p = 2;
        int tot = 0;
        List<Integer> divs = new ArrayList<>();
        while (n>1) {
            while (p<n && n%p != 0)
                p = nextPrime(p);
            divs.add(0);
            while (n>1 && n%p==0) {
                divs.set(divs.size()-1, divs.get(divs.size()-1)+1);
                n /= p;
                tot++;
            }
        }

        long[] fact = new long[tot + 1];
        fact[1] = 1;
        for (int i=2; i<=tot; i++)
            fact[i] = fact[i-1] * i;

        long res = fact[tot];
        for (int i=0; i<divs.size(); i++)
            res = res / fact[divs.get(i)];

        System.out.println(res);
    }
}