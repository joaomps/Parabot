package automatedthieving.modules;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.Skill;
import org.rev317.min.api.wrappers.SceneObject;
import org.parabot.environment.api.utils.Time;

public class Thieve implements Strategy {

	public static Stalls getStall() {
		int level = Skill.THIEVING.getRealLevel();
		if (level < 50) {
			return Stalls.Crafting;
		} else if (level >= 50 && level < 70) {
			return Stalls.Food;
		} else if (level >= 70 && level < 85) {
			return Stalls.General;
		} else if (level >= 85 && level < 99) {
			return Stalls.Magic;
		} else if (level >= 99) {
			return Stalls.Scimitar;
		}
		return Stalls.Crafting;
	}

	public int getID(Stalls stall) {
		if (stall == Stalls.Crafting) {
			return 4874;
		} else if (stall == Stalls.Food) {
			return 4875;
		} else if (stall == Stalls.General) {
			return 4876;
		} else if (stall == Stalls.Magic) {
			return 4877;
		} else if (stall == Stalls.Scimitar) {
			return 4878;
		}
		return 4874;
	}

	public boolean activate() {
		return Players.getMyPlayer().getAnimation() == -1
				&& !Inventory.isFull();
	}

	public void execute() {
		SceneObject[] stall = SceneObjects.getNearest(getID(getStall()));
		if (stall != null && stall.length > 0) {
			stall[0].interact(SceneObjects.Option.STEAL_FROM);
			Time.sleep(3000, 4250);
		}
	}
}