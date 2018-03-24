package autodungeoneering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;

import autodungeoneering.modules.Banking;
import autodungeoneering.modules.Combat;
import autodungeoneering.modules.Methods;
import autodungeoneering.modules.Teleport;
import autodungeoneering.modules.WalkTo;


@ScriptManifest(author = "joaomps", name = "AutoDungeoneering", category = Category.DUNGEONEERING, version = 1, description = "Automated 1-120 Dungeoneering", servers = {
"DreamScape"})
public class Core extends Script implements Paintable {
	Timer timer;
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	public static int START_EXP = Skill.DUNGEONEERING.getExperience();

	public static int getXpGained() {
		return Skill.DUNGEONEERING.getExperience() - START_EXP;
	}

	public boolean onExecute() {
		timer = new Timer();
		strategies.add(new Banking());
		strategies.add(new Teleport());
		strategies.add(new WalkTo());
		strategies.add(new Combat());
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
		paint.drawString("AutoDung v1", 5, 15);
		paint.drawString("Time running: " + timer.toString(), 5, 30);
		paint.drawString("Dungeoneering Level: " + Skill.DUNGEONEERING.getRealLevel(), 5,
				45);
		paint.drawString("Dungeoneering xp gained: " + Methods.formatValues(getXpGained()), 5, 60);
	}
}