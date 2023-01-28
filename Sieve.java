import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Sieve
{

  public boolean[] boolArray;
  public ArrayList<Integer> primes;
  public int maxNumber;
  public Counter counter;

  public Sieve(int n)
  {
    maxNumber = n;
    primes = new ArrayList<Integer>();
    boolArray = new boolean[n + 1];
    Arrays.fill(boolArray, true);
    counter = new Counter(2);
  }

  public class primeThread implements Runnable{
    public void run()
    {
        try {
          int i = counter.getAndIncrement();

          while (i * i <= maxNumber){
            if (boolArray[i] == true)
            {
              for (int j = i * i; j <= maxNumber; j+=i)
              {
                boolArray[j] = false;
              }
            }
            i = counter.getAndIncrement();
          }
          return;

          /*
          for (int i = 2; i * i <= maxNumber; i+=1)
          {
            if (boolArray[i].equals(Boolean.TRUE))
            {
              for (int j = i * i; j <= maxNumber; j+=i)
              {
                boolArray[j] = Boolean.FALSE;
              }
            }
          }
          */
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println(e);
        }
    }
  }

  public ArrayList<Integer> getPrimesBetter(){
    ArrayList<Thread> threads = new ArrayList<Thread>();

    for(int i = 0; i < 8; i++)
    {
      Thread primeFinder
          = new Thread(new primeThread());
      threads.add(primeFinder);

      primeFinder.start();
    }

    for (int i = 0; i < 8; i++)
    {
      try{
        threads.get(i).join();
      }
      catch (Exception e){
        System.out.println(e);
      }
    }
    addPrimes();
    return getList();
  }

  public void addPrimes()
  {
    for (int i = 2; i <= maxNumber; i+=1)
    {
      if (boolArray[i] == true)
      {
        primes.add(i);
      }
    }
  }

  public ArrayList<Integer> getList()
  {
    return this.primes;
  }

}
