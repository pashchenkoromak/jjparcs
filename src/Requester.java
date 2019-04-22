import java.util.List;
import java.util.ArrayList;
import parcs.*;

public class Requester implements AM {
    public void run(AMInfo info) {
        Segment_tree tree = (Segment_tree)info.parent.readObject();
        Integer l = info.parent.readInt();
        Integer r = info.parent.readInt();
        Integer sum = tree.getSum(l, r);
        info.parent.write(l);
        info.parent.write(r);
        info.parent.write(sum);
    }
}
