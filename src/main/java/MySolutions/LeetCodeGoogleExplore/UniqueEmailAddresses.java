package MySolutions.LeetCodeGoogleExplore;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailSet = new HashSet<>();
        for(int i=0;i<emails.length;i++) {
            int indexOfLocalName = emails[i].indexOf("@");
            String localName = emails[i].substring(0,indexOfLocalName);
            String domain = emails[i].substring(indexOfLocalName,emails[i].length());

            if(localName.contains("+")) {
                while(localName.indexOf("+") > 0) {
                    int index = localName.indexOf("+");
                    localName = localName.substring(0,index);
                }
            }

            if(localName.contains(".")) {
                while(localName.indexOf(".") > 0) {
                    int index = localName.indexOf(".");
                    StringBuilder sb = new StringBuilder(localName);
                    sb.deleteCharAt(index);
                    localName = sb.toString();
                }
            }

            if(!uniqueEmailSet.contains(localName+"@"+domain))
                uniqueEmailSet.add(localName + "@" + domain);
        }
        return uniqueEmailSet.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
