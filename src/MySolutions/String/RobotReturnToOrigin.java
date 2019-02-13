package MySolutions.String;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int x = 0,y = 0;
        for(int i=0;i<chars.length;i++) {
            char m = chars[i];
            if(m == 'U')
                y++;
            else if(m == 'D')
                y--;
            else if(m == 'R')
                x++;
            else if(m == 'L')
                x--;
        }
        if(x == 0 && y ==0)
            return true;
        else
            return false;
    }
}
