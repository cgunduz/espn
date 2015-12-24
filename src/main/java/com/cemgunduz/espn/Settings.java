package com.cemgunduz.espn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by cgunduz on 11/10/2015.
 */
public class Settings {

    public static final String SCOREBOARD_URL;
    public static final String PROPERTIES_FILE_PATH = "espn.properties";

    static{

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        SCOREBOARD_URL = (String)properties.get("espn_scrape_player_url.scoreboard");
    }


}
