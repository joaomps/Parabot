package autodungeoneering.modules;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.Walking;

public class WalkTo implements Strategy{

	@Override
	public boolean activate() {
		return !Players.getMyPlayer().getLocation().equals(Variables.DUNG) && Npcs.getNearest(Variables.npcID) != null
                || !Players.getMyPlayer().getLocation().equals(Variables.DUNG) && Variables.DUNG.getLocation().distanceTo() < 20;
	}

	@Override
	public void execute() {
		Walking.walkTo(Variables.DUNG);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Players.getMyPlayer().getLocation().equals(Variables.DUNG);
            }
        }, 2000);
		
	}

}
