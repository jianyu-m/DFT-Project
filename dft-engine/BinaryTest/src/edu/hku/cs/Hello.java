package edu.hku.cs;
/**
 * Created by jianyu on 2/27/17.
 */
import com.sun.security.auth.module.UnixSystem;
import edu.columbia.cs.psl.phosphor.runtime.Tainter;
public class Hello {
    public int InstThis(int a, int b) {
        return Tainter.getTaint(Rating.getCombined(Tainter.taintedInt(a, 1), Tainter.taintedInt(b, 2)));
    }
    private int add(int a, int b) {
        return Tainter.getTaint(Rating.getCombined(Tainter.taintedInt(a, 1), Tainter.taintedInt(b, 2)));
    }

    static public void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(hello.InstThis(1, 2));
        System.out.println(hello.add(1, 2));
/*        long sum = 0;
        for (int i = 0;i < 1000;i++) {
            for (long j = 0;j < 10000000;j++) {
                sum = j*j*j*i;
            }
        }*/
//        System.out.println(sum);
    }
}
