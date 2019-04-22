import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.lang.Math.*;

public class Segment_tree implements Serializable {
    private ArrayList<Integer> t;
    private Integer requestCount;

    public Segment_tree(String filepath) 
    {
        t = new ArrayList();
        requestCount = new Integer(0);

        try {
            Scanner s = new Scanner(new File(filepath));
            ArrayList<Integer> list = new ArrayList<Integer>(s.nextInt());
            while (s.hasNext()){
                list.add(s.nextInt());
        }
            s.close();
            build(list, 1, 0, list.size() - 1);
        } catch (Exception e)
        {
            
        }
        System.out.println(t.size());
    }
    
    private void build(ArrayList<Integer> a, Integer v, Integer tl, Integer tr)
    {
        System.out.println(a.size() + " " + v + " " + tl + " " + tr);
        if (tl == tr)
            t.add(v, a.get(tl));
        else {
            Integer tm = (tl + tr) / 2;
            build (a, v*2, tl, tm);
            build (a, v*2+1, tm+1, tr);
            t.add(v, t.get(v*2) + t.get(v*2+1));
        }
    }

    public Integer getRequestCount()
    {
        return requestCount;
    }

    public long getSum(long l, long r)
    {
        requestCount++;
        return sum(1, 0, t.size() - 1, l, r);
    }

    private long sum (Integer v, Integer tl, Integer tr, long l, long r) 
    {
        if (v < 0)
            return 0;
        System.out.println(v + " " + tl + " " + tr + " " + l + " " + r);
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t.get(v);
        Integer tm = (tl + tr) / 2;
        return sum (v*2, tl, tm, l, Math.min(r,tm))
            + sum (v*2+1, tm+1, tr, Math.max(l,tm+1), r);
    }
}
