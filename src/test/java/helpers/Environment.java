package helpers;

public class Environment {
    // config is common for all the tests
    public static String
        //gradle search_tests -Durlstring="" -Dsearchstring="" -D=selenoid_url=""
    selenoid_url = System.getProperty("selenoid_url","null"),
    urlstring = System.getProperty("urlstring", "http://google.com"),
    searchstring =  System.getProperty("searchstring", "wikipedia");

}

