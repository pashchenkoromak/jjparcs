import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import parcs.*;

public class Bluck {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("Requester.jar");
        Segment_tree tree = new Segment_tree(curtask.findFile("nums"));
        
        AMInfo info = new AMInfo(curtask, null);
        List<point> points = new ArrayList<>();
        List<channel> chans = new ArrayList<>();
        
        Scanner sc = new Scanner(new File("quests"));
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            point p = info.createPoint();
            channel c = p.createChannel();

            p.execute("Requester");    
            c.write(tree);
            c.write(sc.nextInt());
            c.write(sc.nextInt());
            
            points.add(p);
            chans.add(c);
        }

        for (channel c: chans) {
            System.out.println("Answer for " + c.readInt() + " to " + c.readInt() + " is " + c.readInt());
        }
        System.out.println("Total requests handled: " + tree.getRequestCount());
        curtask.end();
    }
}
