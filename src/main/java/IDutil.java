import java.awt.*;
import java.sql.Time;

public class IDutil {

    private static Object OBJ = new Object();

    private static int id = 0;

    private static long curSec = System.currentTimeMillis();

    public static void main(String[] args){

    }
    public static long getId(){
        int nowId;
        long nowCurSec = System.currentTimeMillis();
        synchronized (OBJ) {
            // ID增1
            id += 1;
            // 当前ID赋值id
            nowId = id;

            int max = 65535;
            if (id > max) {
                // 如果ID大于65535 这里其实是 2的16次方 = 65535 因为自增ID只能占16位，所以不能超过65000
                // ID大于65535后id复位，如果时间不增1，那么将会产生重复
                id = 0;
                // 每过65000当前秒数就增1
                curSec += 1L;
            }

            if (nowCurSec > curSec) {
                // 自增后的时间小于了当前时间，那么就更新自增时间为当前时间
                curSec = nowCurSec;
            } else {
                // 自增时间大于当前时间（这种情况在id获取速度过快，1秒中内获取了额超过65535个id的时候会出现），那么就以自增时间为准
                nowCurSec = curSec;
            }
        }
        return (GameContext.getInstance().getServerId() & 0x7_FFFFL) << 45 | (nowCurSec << 16) | (nowId & 0xFFFF);
    }

}
