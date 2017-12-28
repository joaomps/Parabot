package automatedthieving.modules;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Menu;

import java.awt.event.KeyEvent;

/**
 * Made by:
 * @author EmmaStone
 */
public class HandleLogin implements org.parabot.environment.scripts.framework.Strategy {

    public boolean activate() {
        return !Game.isLoggedIn();
    }

    public void execute() {
        Time.sleep(2500);
        Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
        Time.sleep(250);
        Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Game.isLoggedIn();
            }
        }, 6000);

        if (Game.isLoggedIn()) {
            Time.sleep(5000);
            Menu.clickButton(17764);
        }
    }
}