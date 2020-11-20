package tool;

import java.util.concurrent.TimeUnit;

public class SleepTools {
	/**
	 * ��������
	 * @param seconds ����
	 */
    public static final void second(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
    
    /**
     * ������������
     * @param seconds ������
     */
    public static final void ms(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
