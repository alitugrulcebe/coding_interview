package MySolutions.String;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        for(String email:emails) {
            StringBuilder sb = new StringBuilder(email);
            int emailSignIndex = sb.indexOf("@");
            while(sb.indexOf(".") < sb.indexOf("@")) {
                sb.deleteCharAt(sb.indexOf("."));
                sb = new StringBuilder(sb.toString());
            }

            if(sb.indexOf("@") > sb.indexOf("+"))
                sb.delete(sb.indexOf("+"),sb.indexOf("@"));

            emailSet.add(sb.toString());
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));

        String[] emails1 = new String[]{"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com","fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com","fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com","r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"};
        //System.out.println(numUniqueEmails(emails1));
    }
}
