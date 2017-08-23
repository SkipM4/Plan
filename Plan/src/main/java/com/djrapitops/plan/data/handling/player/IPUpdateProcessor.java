/* 
 * Licence is provided in the jar as license.yml also here:
 * https://github.com/Rsl1122/Plan-PlayerAnalytics/blob/master/Plan/src/main/resources/license.yml
 */
package main.java.com.djrapitops.plan.data.handling.player;

import main.java.com.djrapitops.plan.Log;
import main.java.com.djrapitops.plan.Plan;
import main.java.com.djrapitops.plan.data.cache.GeolocationCacheHandler;

import java.sql.SQLException;
import java.util.UUID;

/**
 * //TODO Class Javadoc Comment
 *
 * @author Rsl1122
 */
public class IPUpdateProcessor extends PlayerProcessor {

    private final String ip;

    public IPUpdateProcessor(UUID uuid, String ip) {
        super(uuid);
        this.ip = ip;
    }

    @Override
    public void process() {
        UUID uuid = getUUID();
        String country = GeolocationCacheHandler.getCountry(ip);
        try {
            Plan.getInstance().getDB().getIpsTable().updateIP(uuid, ip, country);
        } catch (SQLException e) {
            Log.toLog(this.getClass().getName(), e);
        }
    }
}