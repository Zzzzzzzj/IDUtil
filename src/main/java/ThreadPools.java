
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by Alivn on 2017/3/19.
 */
public class ThreadPools {

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        //线程池允许同时存在两个线程
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        System.out.println("****************************newFixedThreadPool*******************************");
        for(int i=0;i<4;i++)
        {
            final int index=i;
            newFixedThreadPool.execute(new ThreadForpools(index));
        }
    }
}