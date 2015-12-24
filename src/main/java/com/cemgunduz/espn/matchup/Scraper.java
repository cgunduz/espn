package com.cemgunduz.espn.matchup;

import com.cemgunduz.espn.Settings;
import com.cemgunduz.espn.entity.StatSheet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by cgunduz on 11/10/2015.
 */
public class Scraper {

    public static MatchupDetails scrapeMatchDetails() throws IOException {

        Document doc = Jsoup.connect(Settings.SCOREBOARD_URL).
                header("Host","games.espn.go.com").
                userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36").
                header("Cookie", "fbalm_playertableviewset_clubhouse=upcomingschedule#lastSeason; fbalm_playertableviewset_freeagency=stats#currSeason; FBA_LM_COOKIE=AAAAARoAAAAFAQALY291bnRyeUNvZGUBAANubGQBAA9jbGllbnRJUEFkZHJlc3MBAAs3Ny43Mi4xMTIuNQEACmZyb21UZWFtSWQDAAAAAwEACHNlYXNvbklkAwAAB#ABAAhsZWFndWVJZAMAAi1K; ESPN-FANTASYLM-PROD-ac=XTR; ESPN-FANTASYLM-PROD.auth=disneyid; s_fid=7C1475FE0F54CF09-04DBA90A1A5949A7; cookieMonster=1; __gads=ID=bad7767fb6e391b1:T=1445731099:S=ALNI_MYqi9LYoKmCZHwHtj7nysH0hk3pTA; userAB=1; DS=bmVkc3RhdC5uZXQ7OzA7O2NvbXNjb3JlIGIudi47A; DE2=bmxkO25oO2Ftc3RlcmRhbTticm9hZGJhbmQ7NTs1OzU7LTE7NTIuMzc4Mjc7NC45MDU5OTs1Mjg7Mzk2NjsxNzE4OzU7bmw7A; broadbandAccess=espn3-false%2Cnetworks-false; CRBLM=CBLM-001:AAAAAAABB3cAAAABB4sAAAABArAAAAABAEoAAAABBFEAAAABAzgAAAABB98AAAABA3gAAAABBNsAAAABBFMAAAAB; CRBLM_LAST_UPDATE=1447150097:{88C95830-C1E8-40D4-8958-30C1E850D4A1}; oidNAVY=XrZf5W7GhKsAkdTEUTljxWWoA2BRLjs#FkED3HnL3yiJoVml5vHW2OaVWn7mw8I5uYVLZQ7KphPHtAzba8p5nMQMl6Slmcd8z3IEYZrmhHs#tCeaFDzhuq1hkOO9IBomRRlxQkjoottt$tmae9$vgq8vLFUzpv$E5iPVTAskV7L14#6bXPFqmWrH1ZrkluCZB3dejwGlXRT20lc3crwioFZJiXUdNKBJrvPGNNcODEghNHj0IR0c8JcC7eB6pgSZg$ZOR7U1ZiviIh1r5Xb4TUoNPiMddkg7NbI0j1qNSuM; espn_s2=AECwXDLOOyMTBQ1vHL%2FXMmqdkqEw3wCpXAYz%2Fw3IaVCDzTzSfhnReUswHiOBeoYw62TsPbwGvUe0efiDlwtrwkArnCbk6BODOjiiSoSp734ddbycQfFgWrKJiiXwsKAyzJ%2BhXzVdsS80gW4M80y4ioWrN44GsnYu5%2F6QP8qK7xpPEMOEzkRkHDVxxEtKZIaiyOApsonOvpdVfS19sMWmlaDHXz5V%2BH%2B%2FSCvO%2F4kBdhFHuZHfK4Y78NWhD%2F0YYiA9tENiztjcdAb%2BCufdC0xBHayA; _omnicwtest=1447151042096; SWID={88C95830-C1E8-40D4-8958-30C1E850D4A1}; espnAuth={\"swid\":\"{88C95830-C1E8-40D4-8958-30C1E850D4A1}\"}; s_pers=%20s_c24%3D1447151084440%7C1541759084440%3B%20s_c24_s%3DLess%2520than%25207%2520days%7C1447152884440%3B%20s_gpv_pn%3Dfantasy%253Abasketball%253Afba%253Aflexpop-_ppc-OVERVIEW%7C1447152884449%3B; s_sess=%20s_ppv%3D88%3B%20s_cc%3Dtrue%3B%20s_omni_lid%3D%3B%20s_sq%3D%3B; s_vi=[CS]v1|2B12FFA70530D7FE-40000305A000462A[CE]").
                get();

        String header = doc.getElementsByTag("em").text();
        Integer matchupNo = Integer.valueOf(header.substring(0, header.indexOf(" (")).replace("Matchup ", ""));

        String paranthesis = header.substring(header.indexOf("(") + 1, header.indexOf(")"));
        Integer beginDate = Integer.valueOf(paranthesis.substring(paranthesis.indexOf(" ") + 1, paranthesis.indexOf(" -")));
        Integer endDate = Integer.valueOf(paranthesis.substring(paranthesis.indexOf("- ") + 2));

        MatchupDetails matchupDetails = new MatchupDetails();
        matchupDetails.setBegin(beginDate);
        matchupDetails.setEnd(endDate);
        matchupDetails.setMatchupNo(matchupNo);
        matchupDetails.setRemaining(endDate-beginDate);

        return matchupDetails;
    }

    public static List<TeamStats> scrapeTeamTotalsSoFar() throws IOException {

        Document doc = Jsoup.connect(Settings.SCOREBOARD_URL).
                header("Host","games.espn.go.com").
                userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36").
                header("Cookie", "fbalm_playertableviewset_clubhouse=upcomingschedule#lastSeason; fbalm_playertableviewset_freeagency=stats#currSeason; FBA_LM_COOKIE=AAAAARoAAAAFAQALY291bnRyeUNvZGUBAANubGQBAA9jbGllbnRJUEFkZHJlc3MBAAs3Ny43Mi4xMTIuNQEACmZyb21UZWFtSWQDAAAAAwEACHNlYXNvbklkAwAAB#ABAAhsZWFndWVJZAMAAi1K; ESPN-FANTASYLM-PROD-ac=XTR; ESPN-FANTASYLM-PROD.auth=disneyid; s_fid=7C1475FE0F54CF09-04DBA90A1A5949A7; cookieMonster=1; __gads=ID=bad7767fb6e391b1:T=1445731099:S=ALNI_MYqi9LYoKmCZHwHtj7nysH0hk3pTA; userAB=1; DS=bmVkc3RhdC5uZXQ7OzA7O2NvbXNjb3JlIGIudi47A; DE2=bmxkO25oO2Ftc3RlcmRhbTticm9hZGJhbmQ7NTs1OzU7LTE7NTIuMzc4Mjc7NC45MDU5OTs1Mjg7Mzk2NjsxNzE4OzU7bmw7A; broadbandAccess=espn3-false%2Cnetworks-false; CRBLM=CBLM-001:AAAAAAABB3cAAAABB4sAAAABArAAAAABAEoAAAABBFEAAAABAzgAAAABB98AAAABA3gAAAABBNsAAAABBFMAAAAB; CRBLM_LAST_UPDATE=1447150097:{88C95830-C1E8-40D4-8958-30C1E850D4A1}; oidNAVY=XrZf5W7GhKsAkdTEUTljxWWoA2BRLjs#FkED3HnL3yiJoVml5vHW2OaVWn7mw8I5uYVLZQ7KphPHtAzba8p5nMQMl6Slmcd8z3IEYZrmhHs#tCeaFDzhuq1hkOO9IBomRRlxQkjoottt$tmae9$vgq8vLFUzpv$E5iPVTAskV7L14#6bXPFqmWrH1ZrkluCZB3dejwGlXRT20lc3crwioFZJiXUdNKBJrvPGNNcODEghNHj0IR0c8JcC7eB6pgSZg$ZOR7U1ZiviIh1r5Xb4TUoNPiMddkg7NbI0j1qNSuM; espn_s2=AECwXDLOOyMTBQ1vHL%2FXMmqdkqEw3wCpXAYz%2Fw3IaVCDzTzSfhnReUswHiOBeoYw62TsPbwGvUe0efiDlwtrwkArnCbk6BODOjiiSoSp734ddbycQfFgWrKJiiXwsKAyzJ%2BhXzVdsS80gW4M80y4ioWrN44GsnYu5%2F6QP8qK7xpPEMOEzkRkHDVxxEtKZIaiyOApsonOvpdVfS19sMWmlaDHXz5V%2BH%2B%2FSCvO%2F4kBdhFHuZHfK4Y78NWhD%2F0YYiA9tENiztjcdAb%2BCufdC0xBHayA; _omnicwtest=1447151042096; SWID={88C95830-C1E8-40D4-8958-30C1E850D4A1}; espnAuth={\"swid\":\"{88C95830-C1E8-40D4-8958-30C1E850D4A1}\"}; s_pers=%20s_c24%3D1447151084440%7C1541759084440%3B%20s_c24_s%3DLess%2520than%25207%2520days%7C1447152884440%3B%20s_gpv_pn%3Dfantasy%253Abasketball%253Afba%253Aflexpop-_ppc-OVERVIEW%7C1447152884449%3B; s_sess=%20s_ppv%3D88%3B%20s_cc%3Dtrue%3B%20s_omni_lid%3D%3B%20s_sq%3D%3B; s_vi=[CS]v1|2B12FFA70530D7FE-40000305A000462A[CE]").
                get();

        List<Element> teamResults =  doc.getElementsByClass("tableBody");
        teamResults.remove(0);
        teamResults.remove(teamResults.size()-1);

        List<TeamStats> teamStatSheet = new ArrayList<TeamStats>();
        for(Element element : teamResults)
        {
            String teamName = element.getElementsByTag("a").get(0).attr("title");

            String hrefString =  element.getElementsByTag("a").get(0).attr("href");
            Integer teamId = Integer.valueOf(hrefString.substring(hrefString.indexOf("teamId=") + 7, hrefString.indexOf("teamId=") + 8));

            StatSheet statsheet = new StatSheet();
            statsheet.setFgp(Double.valueOf(element.getElementsByTag("td").get(2).text()));
            statsheet.setFtp(Double.valueOf(element.getElementsByTag("td").get(3).text()));
            statsheet.setP3m(Integer.valueOf(element.getElementsByTag("td").get(4).text()));
            statsheet.setReb(Integer.valueOf(element.getElementsByTag("td").get(5).text()));
            statsheet.setAst(Integer.valueOf(element.getElementsByTag("td").get(6).text()));
            statsheet.setStl(Integer.valueOf(element.getElementsByTag("td").get(7).text()));
            statsheet.setBlk(Integer.valueOf(element.getElementsByTag("td").get(8).text()));
            statsheet.setTo(Integer.valueOf(element.getElementsByTag("td").get(9).text()));
            statsheet.setPts(Integer.valueOf(element.getElementsByTag("td").get(10).text()));

            TeamStats teamStats = new TeamStats();
            teamStats.setSheet(statsheet);
            teamStats.setTeamName(teamName);
            teamStats.setTeamId(teamId);
            teamStatSheet.add(teamStats);
        }

        return teamStatSheet;
    }

    public static List<PlayerDetails> getPlayerDetails(TeamStats teamStats, MatchupDetails matchupDetails) throws IOException {

        String url = "http://games.espn.go.com/fba/playertable/prebuilt/manageroster?leagueId=142666&teamId=MYTEAMIDNUM&seasonId=2016&" +
                "view=upcomingschedule&context=clubhouse&ajaxPath=playertable/prebuilt/manageroster&managingIr=false&droppingPlayers=false&asLM=false&r=819906181";

        url = url.replace("MYTEAMIDNUM", teamStats.getTeamId().toString());

        Document doc = Jsoup.connect(url).
                header("Host","games.espn.go.com").
                userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36").
                header("Cookie", "fbalm_playertableviewset_clubhouse=upcomingschedule#lastSeason; fbalm_playertableviewset_freeagency=stats#currSeason; FBA_LM_COOKIE=AAAAARoAAAAFAQALY291bnRyeUNvZGUBAANubGQBAA9jbGllbnRJUEFkZHJlc3MBAAs3Ny43Mi4xMTIuNQEACmZyb21UZWFtSWQDAAAAAwEACHNlYXNvbklkAwAAB#ABAAhsZWFndWVJZAMAAi1K; ESPN-FANTASYLM-PROD-ac=XTR; ESPN-FANTASYLM-PROD.auth=disneyid; s_fid=7C1475FE0F54CF09-04DBA90A1A5949A7; cookieMonster=1; __gads=ID=bad7767fb6e391b1:T=1445731099:S=ALNI_MYqi9LYoKmCZHwHtj7nysH0hk3pTA; userAB=1; DS=bmVkc3RhdC5uZXQ7OzA7O2NvbXNjb3JlIGIudi47A; DE2=bmxkO25oO2Ftc3RlcmRhbTticm9hZGJhbmQ7NTs1OzU7LTE7NTIuMzc4Mjc7NC45MDU5OTs1Mjg7Mzk2NjsxNzE4OzU7bmw7A; broadbandAccess=espn3-false%2Cnetworks-false; CRBLM=CBLM-001:AAAAAAABB3cAAAABB4sAAAABArAAAAABAEoAAAABBFEAAAABAzgAAAABB98AAAABA3gAAAABBNsAAAABBFMAAAAB; CRBLM_LAST_UPDATE=1447150097:{88C95830-C1E8-40D4-8958-30C1E850D4A1}; oidNAVY=XrZf5W7GhKsAkdTEUTljxWWoA2BRLjs#FkED3HnL3yiJoVml5vHW2OaVWn7mw8I5uYVLZQ7KphPHtAzba8p5nMQMl6Slmcd8z3IEYZrmhHs#tCeaFDzhuq1hkOO9IBomRRlxQkjoottt$tmae9$vgq8vLFUzpv$E5iPVTAskV7L14#6bXPFqmWrH1ZrkluCZB3dejwGlXRT20lc3crwioFZJiXUdNKBJrvPGNNcODEghNHj0IR0c8JcC7eB6pgSZg$ZOR7U1ZiviIh1r5Xb4TUoNPiMddkg7NbI0j1qNSuM; espn_s2=AECwXDLOOyMTBQ1vHL%2FXMmqdkqEw3wCpXAYz%2Fw3IaVCDzTzSfhnReUswHiOBeoYw62TsPbwGvUe0efiDlwtrwkArnCbk6BODOjiiSoSp734ddbycQfFgWrKJiiXwsKAyzJ%2BhXzVdsS80gW4M80y4ioWrN44GsnYu5%2F6QP8qK7xpPEMOEzkRkHDVxxEtKZIaiyOApsonOvpdVfS19sMWmlaDHXz5V%2BH%2B%2FSCvO%2F4kBdhFHuZHfK4Y78NWhD%2F0YYiA9tENiztjcdAb%2BCufdC0xBHayA; _omnicwtest=1447151042096; SWID={88C95830-C1E8-40D4-8958-30C1E850D4A1}; espnAuth={\"swid\":\"{88C95830-C1E8-40D4-8958-30C1E850D4A1}\"}; s_pers=%20s_c24%3D1447151084440%7C1541759084440%3B%20s_c24_s%3DLess%2520than%25207%2520days%7C1447152884440%3B%20s_gpv_pn%3Dfantasy%253Abasketball%253Afba%253Aflexpop-_ppc-OVERVIEW%7C1447152884449%3B; s_sess=%20s_ppv%3D88%3B%20s_cc%3Dtrue%3B%20s_omni_lid%3D%3B%20s_sq%3D%3B; s_vi=[CS]v1|2B12FFA70530D7FE-40000305A000462A[CE]").
                get();

        Calendar calendar = Calendar.getInstance();

        List<PlayerDetails> playerDetailsList = new ArrayList<PlayerDetails>();

        int iterateFor = Math.abs(calendar.get(Calendar.DAY_OF_WEEK) - 9);
        iterateFor = iterateFor == 8 ? 1 : iterateFor;
        for(Element playerInfo : doc.select("[id^=plyr]"))
        {
            if(playerInfo.text().contains("title=\"Out\""))
                continue;

            String playerName = playerInfo.getElementsByTag("a").get(0).text();
            int totalMatches = 0;

            List<Element> tdList = playerInfo.getElementsByTag("td");
            if(!tdList.get(4).text().isEmpty())
                totalMatches++;
            for(int i = 0; i < iterateFor-1; i++)
            {
                if(!tdList.get(i+7).text().isEmpty())
                    totalMatches++;
            }

            playerDetailsList.add(new PlayerDetails(playerName, totalMatches));
        }

        return playerDetailsList;
    }

    public static void main(String[] args) throws IOException {

        getPlayerDetails(scrapeTeamTotalsSoFar().get(0), scrapeMatchDetails());
    }
}
