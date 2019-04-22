import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class DFS implements AM {
    public void run(AMInfo info) {
        Node node = (Node)info.parent.readObject();
        System.out.println("[" + node.getId() + "] Build started.");

        List<point> points = new ArrayList<>();
        List<channel> chans = new ArrayList<>();
        
        for (Node node_on_n: node.getDeps()) {
            
            point p = info.createPoint();
            channel c = p.createChannel();

            p.execute("DFS");    
            c.write(node_on_n);
            
            points.add(p);
            chans.add(c);
        }

        long sum = node.getTime();
        for (channel c: chans) {
        
            sum += c.readLong();
        
        }
        try {
            Thread.sleep(node.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("[" + node.getId() + "] Build finished.");
        info.parent.write(sum);
    }
}
