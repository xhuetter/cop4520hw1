import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;


public class FindPrime
{

    // Single-Threaded Implementation of getting primes
    public static ArrayList<Integer> getPrimes(int n)
    {
      boolean[] boolArray =  new boolean[n + 1];
      Arrays.fill(boolArray, Boolean.TRUE);
      for (int i = 2; i * i <= n; i+=1)
      {
        if (boolArray[i] == true)
        {
          for (int j = i * i; j <= n; j+=i)
          {
            boolArray[j] = false;
          }
        }
      }
      ArrayList<Integer> result = new ArrayList<Integer>();
      for (int i = 2; i <= n; i+=1)
      {
        if (boolArray[i] == true)
        {
          result.add(i);
        }
      }
      return result;

    }

    public static void main(String[] args) throws IOException
    {
      // ArrayList<Integer> array = getPrimes(100000000);
      long start = System.currentTimeMillis();
      Sieve sieve = new Sieve(Integer.parseInt(args[0]));
      PrintWriter output = new PrintWriter("primes.txt");
      long sum = 0;
      ArrayList<Integer> primeList = sieve.getPrimesBetter();
      int size = primeList.size();
      for (Integer i : primeList)
      {
        sum += i.longValue();
      }
      long end = System.currentTimeMillis();
      float timeElapsed = (end - start) / 1000F;


      output.print(timeElapsed + "s");
      output.print(" ");
      output.print(primeList.size());
      output.print(" ");
      output.print(sum);
      output.print(" ");
      for (int i = size - 10; i < size; i++)
      {
        output.print(primeList.get(i) + " ");
      }
      output.println("");
      output.close();
    }
}
