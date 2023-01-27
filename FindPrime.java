import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;


public class FindPrime
{
    public static ArrayList<Integer> getPrimes(int n)
    {
      Boolean[] boolArray = new Boolean[n + 1];
      Arrays.fill(boolArray, Boolean.TRUE);
      for (int i = 2; i * i <= n; i+=1)
      {
        if (boolArray[i].equals(Boolean.TRUE))
        {
          for (int j = i * i; j <= n; j+=i)
          {
            boolArray[j] = Boolean.FALSE;
          }
        }
      }
      ArrayList<Integer> result = new ArrayList<Integer>();
      for (int i = 2; i <= n; i+=1)
      {
        if (boolArray[i].equals(Boolean.TRUE))
        {
          result.add(i);
        }
      }
      return result;

    }

    public static void main(String[] args) throws IOException
    {
      // ArrayList<Integer> array = getPrimes(100000000);
      Sieve sieve = new Sieve(100000000);
      PrintWriter output = new PrintWriter("primes.txt");
      long sum = 0;
      float time = sieve.getPrimesBetter();
      ArrayList<Integer> primeList = sieve.getList();
      int size = primeList.size();
      for (Integer i : primeList)
      {
        sum += i.longValue();
      }


      output.print(time + " s");
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
