import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.lang.Math.*;
import static java.lang.Math.toIntExact;

public class Segment_tree implements Serializable {
    private long t[];
    private Integer size;
    private Integer requestCount;

    public Segment_tree(String filepath) 
    {
        requestCount = new Integer(0);

        try {
            Scanner s = new Scanner(new File(filepath));
            size = s.nextInt();
            t = new long[size];
            for(int i = 0; i < size; i++)
                t[i] = s.nextLong();
            s.close();
        } catch (Exception e)
        {
            
        }
        System.out.println(size);
    }
    
    public Integer getRequestCount()
    {
        return requestCount;
    }

    public long getSum(long l, long r)
    {
        requestCount++;
        return sum(1, 0, size - 1, l, r);
    }

    private long sum (Integer v, Integer tl, Integer tr, long l, long r) 
    {
        long ans = 0;
        for(long i = l; i <= r; i++)
            ans += (t[(int)i]);
        return ans;
    }
}
