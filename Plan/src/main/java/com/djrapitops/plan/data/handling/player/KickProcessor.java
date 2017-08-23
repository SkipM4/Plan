/* 
 * Licence is provided in the jar as license.yml also here:
 * https://github.com/Rsl1122/Plan-PlayerAnalytics/blob/master/Plan/src/main/resources/license.yml
 */
package main.java.com.djrapitops.plan.data.handling.player;

import main.java.com.djrapitops.plan.Log;
import main.java.com.djrapitops.plan.Plan;

import java.sql.SQLException;
import java.util.UUID;

/**
 * //TODO Class Javadoc Comment
 *
 * @author Rsl1122
 */
public class KickProcessor extends PlayerProcessor {
    public KickProcessor(UUID uuid) {
        super(uuid);
    }

    @Override
    public void process() {
        UUID uuid = getUUID();
        try {
            Plan.getInstance().getDB().getUsersTable().kicked(uuid);
        } catch (SQLException e) {
            Log.toLog(this.getClass().getName(), e);
        }
    }
}