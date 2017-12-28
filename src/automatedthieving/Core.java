package automatedthieving;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;

import automatedthieving.modules.HandleLogin;
import automatedthieving.modules.Methods;
import automatedthieving.modules.Thieve;

import java.awt.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

@ScriptManifest(author = "joaomps", name = "AutoThiever", category = Category.THIEVING, version = 1, description = "Automated 1-99 Stall Thiever", servers = {
		"DreamScape"})
public class Core extends Script implements Paintable {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	Timer timer;
	public static int START_EXP = Skill.THIEVING.getExperience();

	public static int getXpGained() {
		return Skill.THIEVING.getExperience() - START_EXP;
	}

	public boolean onExecute() {
		timer = new Timer();
		strategies.add(new Thieve());
		strategies.add(new HandleLogin());
		provide(strategies);
		return true;
	}

	public void paint(Graphics g) {
		Graphics2D paint = (Graphics2D) g;
		Color tBlack = new Color(0, 0, 0, 128);
		paint.setFont(new Font("Arial", Font.PLAIN, 12));
		paint.setColor(tBlack);
		paint.fillRect(0, 0, 200, 90);
		paint.setColor(Color.WHITE);
		paint.drawRect(0, 0, 200, 90);
		paint.drawString("Stall Thiever v1", 5, 15);
		paint.drawString("Time running: " + timer.toString(), 5, 30);
		paint.drawString("Thieving Level: " + Skill.THIEVING.getRealLevel(), 5,
				45);
		paint.drawString("Thieving xp gained: " + Methods.formatValues(getXpGained()), 5, 60);
		paint.drawString("Current Stall: " + Thieve.getStall(), 5, 75);
	}
}