package scheduled;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component(value = "swork")
public class ScheduledWork {
	static int i=0;
	public void work() {
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
		System.out.println("현재시간:"+hour+"시"+minute+"분"+second+"초");
	}
}