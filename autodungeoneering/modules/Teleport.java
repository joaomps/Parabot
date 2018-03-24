package autodungeoneering.modules;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Interfaces;
import org.rev317.min.api.methods.Menu;

public class Teleport implements Strategy {

	@Override
	public boolean activate() {
		return Variables.DUNG.distanceTo() > 20;
	}

	@Override
	public void execute() {
		if (Interfaces.getBackDialogId() == 2492) {
            Menu.clickButton(2498);
            Time.sleep(1000);
            Menu.clickButton(2496);
            Time.sleep(1000);
            Menu.clickButton(2471);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Variables.DUNG.distanceTo() < 20;
                }
            }, 5000);
        } else {
            Menu.clickButton(1540);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Interfaces.getBackDialogId() == 2492;
                }
            }, 1500);
        }
	}
}
