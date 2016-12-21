public class Fibonacci{
    public int fibonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else {
            int second =1;
            int first = 0;
            int fib = 0;
            for(int i=2;i<=n;i++){
                fib = second + first;
                first = second;
                second = fib;
               
            }
            return fib;
        }
 
    }
}