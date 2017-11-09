
import java.util.Random;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Pokewash {
    public static void main(String[] args) {
        Poker poke = new Poker();
        Scanner sc = new Scanner(System.in);
        poke.Origin();
        System.out.println("请选择洗牌方式：suffer/exchange/better");
        String x = sc.next();
        if (x.equals("suffer")) {
            poke.suffer();
        }
        if (x.equals("exchange")) {
            poke.exchange();
        }
        if(x.equals("better")){
            poke.better();
        }
    }
}

class Poker {
    String[] suit = {"♥", "♠", "♣", "♦"};
    String[] point = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] allcard = new String[54];

    void Origin() {
        int k = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < point.length; j++) {
                allcard[k] = suit[i] + point[j];
                k++;
            }
        }
        allcard[52] = "小鬼";
        allcard[53] = "大鬼";
    }  //初始化扑克牌

    void suffer() {
        String mid[] = new String[54];
        System.arraycopy(allcard, 0, mid, 0, allcard.length);//设置媒介牌组
        String result[] = new String[54];
        for (int i = 0; i < 3; i++) {
            int r = 0;
            for (int j = 0; j < 27; j++) {
                result[r] = mid[j];
                r += 2;
            }
            r = 1;
            for (int k = 27; k < 54; k++) {
                result[r] = mid[k];
                r += 2;
            }
            System.arraycopy(result, 0, mid, 0, allcard.length);
        }
        for (int i = 0; i < 54; i++) {
            System.out.println(result[i]);
        }
    }  //中间分开，2撂牌交叉洗，3次

    void exchange() {
        String temp = "0";
        for (int i = 53; i > 0; i--) {
            temp = allcard[i];
            allcard[i] = allcard[(int) ((Math.random()) * (i - 1))];
            allcard[(int) ((Math.random()) * (i - 1))] = temp;
        }
        for (int i = 0; i < 54; i++) {
            System.out.println(allcard[i]);
        }
    }  //最后i张与前面（54-i）张交换洗牌
    void better(){
        String temp="0";
        Random rd=new Random();
        for(int i=0;i<54;i++){
            int j=rd.nextInt(54);
            temp=allcard[i];
            allcard[i]=allcard[j];
            allcard[j]=temp;
        }
        for (int i = 0; i < 54; i++) {
            System.out.println(allcard[i]);
        }
    }  //更优算法？？
}
