import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.random;


/**
 * Created by Znakomity on 2017-09-13.
 */
public class Lotto {
    private int drawRange;
    private int entireRange;
    private int[] tab;

    private ArrayList<Integer> List;


    public Lotto(int generalEntireRange, int drawRange) {
        entireRange = generalEntireRange;
        this.drawRange = drawRange;
        tab = new int[drawRange];
    }

    public Lotto() {
        this(50, 5);
    }

    public static int draw(int rangeTo) {
        int result = (int) (random() * rangeTo + 1);
        return result;
    }

    public String display() {
        Arrays.sort(tab);
        String result="";
        for(int i=0;i<tab.length;i++)
        {
            result=result+"   "+String.valueOf(tab[i]);
        }
        return result;
    }


    public void drawNumbers() {
        List=new ArrayList<Integer>(entireRange);
        for(int i=0;i<entireRange;i++){
            List.add(i,i+1);
        }
        for(int i=0;i<drawRange;i++){
            int los=draw(entireRange)-1;
            tab[i]=List.get(los);
            List.remove(los);
            entireRange--;
        }
    }
}
