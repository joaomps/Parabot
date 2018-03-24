package autodungeoneering.modules;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

public class Combat implements Strategy {
	private final Npc[] monster = Npcs.getNearest(Variables.npcID);
	@Override
	public boolean activate() {
		return !Inventory.isFull() && monster != null && !Players.getMyPlayer().isInCombat();
	}

	@Override
	public void execute() {
		if (!Prayers.isPrayerEnabled()) {
			Prayers.turnOnSoulSplitAndRange();
		}

		if (monster != null && Prayers.isPrayerEnabled()) {
			monster[0].interact(Npcs.Option.ATTACK);
		}
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Players.getMyPlayer().isInCombat();
			}
		}, 60000);
	}

}
