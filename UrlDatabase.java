import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UrlDatabase {

    private static Map<String, UrlData> urlMap = new HashMap<>();
    private static int counter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to URL Database. Enter commands or type 'exit' to terminate.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "storeurl":
                    if (parts.length < 2) {
                        System.out.println("Invalid command. Usage: storeurl <url>");
                        continue;
                    }
                    storeUrl(parts[1]);
                    break;

                case "get":
                    if (parts.length < 2) {
                        System.out.println("Invalid command. Usage: get <url>");
                        continue;
                    }
                    getUrl(parts[1]);
                    break;

                case "count":
                    if (parts.length < 2) {
                        System.out.println("Invalid command. Usage: count <url>");
                        continue;
                    }
                    getCount(parts[1]);
                    break;

                case "list":
                    listUrls();
                    break;

                case "geturlbyshortkey":
                    if (parts.length < 2) {
                        System.out.println("Invalid command. Usage: geturlbyshortkey <shortKey>");
                        continue;
                    }
                    getUrlByShortKey(parts[1]);
                    break;

                case "delete":
                    if (parts.length < 2) {
                        System.out.println("Invalid command. Usage: delete <shortKey>");
                        continue;
                    }
                    deleteUrlByShortKey(parts[1]);
                    break;

                case "update":
                    if (parts.length < 3) {
                        System.out.println("Invalid command. Usage: update <shortKey> <newUrl>");
                        continue;
                    }
                    updateUrlByShortKey(parts[1], parts[2]);
                    break;

                default:
                    System.out.println("Unknown command. Please enter a valid command.");
            }
        }

        System.out.println("Exiting URL Database. Goodbye!");
    }

    private static void storeUrl(String url) {
        String shortKey = "url" + counter++;
        UrlData urlData = new UrlData(url, 0);
        urlMap.put(shortKey, urlData);
        System.out.println("URL stored with short key: " + shortKey);
    }

    private static void getUrl(String url) {
        for (Map.Entry<String, UrlData> entry : urlMap.entrySet()) {
            if (entry.getValue().getUrl().equals(url)) {
                entry.getValue().incrementCount();
                System.out.println("Short key for " + url + ": " + entry.getKey());
                return;
            }
        }
        System.out.println("URL not found.");
    }

    private static void getCount(String url) {
        for (UrlData urlData : urlMap.values()) {
            if (urlData.getUrl().equals(url)) {
                System.out.println("Usage count for " + url + ": " + urlData.getCount());
                return;
            }
        }
        System.out.println("URL not found.");
    }

    private static void listUrls() {
        System.out.println("URLs and counts in the database:");
        for (Map.Entry<String, UrlData> entry : urlMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getUrl() +
                    " (Usage Count: " + entry.getValue().getCount() + ")");
        }
    }

    private static void getUrlByShortKey(String shortKey) {
        UrlData urlData = urlMap.get(shortKey);
        if (urlData != null) {
            System.out.println("URL for short key " + shortKey + ": " + urlData.getUrl());
        } else {
            System.out.println("Short key not found.");
        }
    }

    private static void deleteUrlByShortKey(String shortKey) {
        if (urlMap.containsKey(shortKey)) {
            urlMap.remove(shortKey);
            System.out.println("URL with short key " + shortKey + " deleted.");
        } else {
            System.out.println("Short key not found.");
        }
    }

    private static void updateUrlByShortKey(String shortKey, String newUrl) {
        if (urlMap.containsKey(shortKey)) {
            UrlData urlData = urlMap.get(shortKey);
            urlData.setUrl(newUrl);
            System.out.println("URL with short key " + shortKey + " updated to: " + newUrl);
        } else {
            System.out.println("Short key not found.");
        }
    }

    private static class UrlData {
        private String url;
        private int count;

        public UrlData(String url, int count) {
            this.url = url;
            this.count = count;
        }

        public String getUrl() {
            return url;
        }

        public int getCount() {
            return count;
        }

        public void incrementCount() {
            count++;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
