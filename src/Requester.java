import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class Requester implements AM {
    public void run(AMInfo info) {
        Segment_tree tree = (Segment_tree)info.parent.readObject();
	System.out.println(tree.getRequestCount());
        Integer l = info.parent.readInt();
        Integer r = info.parent.readInt();
	System.out.println(l + " " + r);
        //Integer sum = tree.getSum(l, r);
	try {

		            Thread.sleep(1000);

			            } catch (InterruptedException e) {

					                e.printStackTrace();

							            return;
        }
        
	info.parent.write(l);
        info.parent.write(r);
        info.parent.write(0);
	//info.parent.write(sum);
    }
}
