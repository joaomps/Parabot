package autodungeoneering.modules;

import java.text.NumberFormat;

import org.parabot.environment.api.utils.Timer;
import org.rev317.min.api.wrappers.Tile;

public class Variables {
	public static final Tile DUNG = new Tile(3481, 9504);
	public static final int npcID = 8597;
	
    private final Timer time = new Timer();
    private static int kills;

    public String getPerHour(long arg) {
        return NumberFormat.getIntegerInstance().format(//credits to creator
                arg * 3600000D / time.getElapsedTime());
    }
    
    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        Variables.kills = kills;
    }
}
