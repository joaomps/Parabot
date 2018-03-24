package autodungeoneering.modules;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Prayer;

public class Prayers {

	public static void turnOnSoulSplitAndRange() {
		Prayer.enable(Prayer.Curse.SOUL_SPLIT);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Prayer.isEnabled(Prayer.Curse.SOUL_SPLIT);
			}
		}, 2500);
		Prayer.enable(Prayer.Curse.LEECH_RANGE);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Prayer.isEnabled(Prayer.Curse.LEECH_RANGE);
			}
		}, 2500);
	}

	public static boolean isPrayerEnabled() {
		return Prayer.isEnabled(Prayer.Curse.LEECH_RANGE) && Prayer.isEnabled(Prayer.Curse.SOUL_SPLIT);
	}

}
