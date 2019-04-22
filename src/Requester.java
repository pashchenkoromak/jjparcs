import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class Requester implements AM {
    public void run(AMInfo info) {
    //Segment_tree tree = (Segment_tree)info.parent.readObject();
//	System.out.println(tree.getRequestCount());
    long l = info.parent.readLong();
    long r = info.parent.readLong();
	System.out.println(l + " " + r);
    //int sum = tree.getSum(l, r);
	info.parent.write(l);
    info.parent.write(r);
    info.parent.write(r);
	//info.parent.write(sum);
    }
}
