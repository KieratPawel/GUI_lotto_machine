import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.random;


/**
 * Created by Znakomity on 2017-09-13.
 */
public class Lotto {
    private int liczba_losowanych;
    private int liczba_liczb;
    private int[] tab;

    private ArrayList<Integer> List;


    public Lotto(int liczba_liczb_ogólna, int liczba_losowanych) {
        liczba_liczb = liczba_liczb_ogólna;
        this.liczba_losowanych = liczba_losowanych;
        tab = new int[liczba_losowanych];
    }

    public Lotto() {
        this(50, 5);
    }

    public static int losuj(int zakres_do) {
        int zwrot = (int) (random() * zakres_do + 1);
        return zwrot;
    }

    public String wyświetl() {
        Arrays.sort(tab);
        String result="";
        for(int i=0;i<tab.length;i++)
        {
            result=result+"   "+String.valueOf(tab[i]);
        }
        return result;
    }


    public void mechanizm2() {
        List=new ArrayList<Integer>(liczba_liczb);
        for(int i=0;i<liczba_liczb;i++){
            List.add(i,i+1);
        }
        for(int i=0;i<liczba_losowanych;i++){
            int los=losuj(liczba_liczb)-1;
            tab[i]=List.get(los);
            List.remove(los);
            liczba_liczb--;
        }
    }
}
