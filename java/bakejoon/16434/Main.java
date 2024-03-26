import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static Hero h;
    private static final int MONSTER = 1;
    private static final int NO_MONSTER = 2;
    public static void main(String[] args) throws IOException {
        int atk, type, first, second;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        h = new Hero(1, 1,atk);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            switch(type) {
                case MONSTER:
                    h.damaged(first, second);
                    break;
                case NO_MONSTER:
                    h.upgrade(first, second);
                    break;
            }
        }
        System.out.println(h.maxHp);

    }
}

class Hero {
    public long maxHp;
    public long curHp;
    public long atk;

    public Hero(long maxHp, long curHp ,long atk) {
        this.maxHp = maxHp;
        this.curHp = curHp;
        this.atk = atk;
    }

    public void reset(int _maxHp) {
        this.maxHp = _maxHp;
        this.curHp = _maxHp;
    }

    public void damaged(int mAtk, int mHp) {
        long attackedCount;
        if(mHp % atk == 0) {
            attackedCount = (mHp / atk) - 1;
        } else {
            attackedCount = (mHp / atk);
        }
        this.curHp -= mAtk * attackedCount;
        if(curHp <= 0) {
            long additionalHp = (curHp * -1) + 1;
            this.maxHp += additionalHp;
            this.curHp = 1;
        }
    }

    public void upgrade(int _atk, int _hp) {
        this.atk += _atk;
        this.curHp += _hp;
        if(this.maxHp < this.curHp) {
            this.curHp = this.maxHp;
        }
        return;
    }
}

