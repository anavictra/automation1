package utility;

import pages.BasePage;

public class Navigation extends BasePage {

    public static String getTrunkPortalURL() {

        String dir = null;
        String env = System.getProperty("env");

        if (env == null)
            env = "test";

        switch (env) {

            case "devel":
                dir = "https://montage-devel.displaynote.com/web";
                break;
            case "test":
                dir = "https://montage-stg.displaynote.com/web/login";
                break;
            case "uat":
                //dir = "";
                break;
            case "local":
                String address = System.getProperty("serverAddress");
                String port = System.getProperty("serverPort");
                if (address != null && !address.isEmpty()) {
                    dir = "http://" + address;
                    if (port != null && !port.isEmpty()) {
                        dir += ":" + port;
                    }
                } else
                    dir = "http://localhost:8888";
                break;
        }

        return dir;
    }

    public static void goToPage(String page) {

        String url = Navigation.getTrunkPortalURL();
        switch (page) {
            case "LoginPage":
                url = url;
                break;
        }

        driver.get(url);
    }
}
