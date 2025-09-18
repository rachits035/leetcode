import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int limit = 10000;  // but not really needed
        Set<Integer> primeSet = primes(limit);

        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                int g = gcd(top, num);
                if (g > 1) {
                    stack.remove(stack.size() - 1);
                    num = lcm(top, num, g);
                } else {
                    break;
                }
            }
            stack.add(num);
        }
        
       
        return stack;
    }

    Set<Integer> primes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        Set<Integer> s1 = new HashSet<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) s1.add(i);
        }
        return s1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private int lcm(int a, int b, int g) {
        return (int)((long)a * (long)b / g);
    }
}
