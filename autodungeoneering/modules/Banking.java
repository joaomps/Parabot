package autodungeoneering.modules;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Inventory;

public class Banking implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.isFull();
	}

	@Override
	public void execute() {
		if (!Bank.isOpen()) {
			Keyboard.getInstance().sendKeys("::bank");
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Bank.isOpen();
				}
			}, 2500);
		} else {
			Bank.depositAll();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return !Inventory.isFull();
				}
			}, 1700);
			Bank.close();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return !Bank.isOpen();
				}
			}, 1700);
		}
	}
}
