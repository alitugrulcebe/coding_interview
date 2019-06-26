package MySolutions.LinkList;




import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteNodeWholeFoods {

    public DeleteNodeWholeFoods() {
    }

    static int getCountries(String s, int p) throws Exception {
        String url = "https://jsonmock.hackerrank.com/api/countries/search?name=" + s;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        // add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
        JSONArray msg = (JSONArray) jsonObject.get("data");
        Iterator<JSONObject> iterator = msg.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            JSONObject country = iterator.next();
            if((long)country.get("population") < p)
                count++;
        }

        return count;
    }

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<a.size();i++) {
            int count = 0;
            int[] chars = new int[26];

            String aStr = a.get(i);
            String bStr = b.get(i);

            for(int j=0; j<aStr.length();j++) {
                chars[aStr.charAt(j) - 'a']++;
            }

            for (int j = 0; j < bStr.length(); j++) {
                if(chars[bStr.charAt(j) - 'a']-- <= 0)
                    count++;
            }

            if(aStr.length() == bStr.length())
                result.add(count);
            else
                result.add(-1);
        }
        return result;
    }

    public static ListNode delete(ListNode listHead, int x) {

        ListNode temp = listHead;
        ListNode prev = null;

        // If head node itself holds the value greater than 'x'
        while (temp != null && temp.val > x) {
            listHead = temp.next; // Changed head
            temp = listHead; // Change temp
        }

        // Delete occurrences other than head
        while (temp != null) {

            // Search for the node to be deleted,
            // keep track of the previous node as we
            // need to change 'prev->next'
            while (temp != null && temp.val <= x) {
                prev = temp;
                temp = temp.next;
            }

            // If required value node was not present
            // in linked list
            if (temp != null) // Unlink the node from linked list
                prev.next = temp.next;

            //temp = null;

            // Update Temp for next iteration of
            // outer loop
            temp = prev.next;
        }

        return listHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
        //delete(head,3);
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("aaa");
//        a.add("abb");
//        a.add("mn");
//        a.add("abc");

        List<String> b = new ArrayList<>();
        b.add("bba");
        b.add("bbb");
//        b.add("bbc");
//        b.add("op");
//        b.add("def");

        //getMinimumDifference(a,b);

        try {
            System.out.println(getCountries("un",100090));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
