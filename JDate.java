package jdates;

public class JDate {
    int DD, MM, YYYY, hh, mm, ss;

    void setDate(int DD, int MM, int YYYY) {
        if (DD < 1 || MM < 1 || YYYY < 1 || DD > 31 || MM > 12 ||
                DD > 29 & MM == 2 || DD == 31) {
            throw new RuntimeException("invalid date format");
        }
        this.DD = DD;
        this.MM = MM;
        this.YYYY = YYYY;
    }

    void setTime(int hh, int mm, int ss) {
        if (hh < 1 || mm < 1 || ss < 1 ||
                hh > 23 || mm > 59 || ss > 60) {
            throw new RuntimeException("invalid time format");
        }
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public JDate(int DD, int MM, int YYYY) {
        setDate(DD, MM, YYYY);
        setTime(0,0,0);
    }

    public JDate(int DD, int MM, int YYYY, int hh, int mm, int ss) {
        setDate(DD, MM, YYYY);
        setTime(hh, mm, ss);
    }

    int diff (int t1, int t2) {
        if (t1>t2) return 1; else if (t1<t2) return -1; else return 0;
    }
    JDate compareDate(JDate date1, JDate date2) {
        JDate result = new JDate(0,0,0);
        int YYYY, MM, DD, hh, mm, ss;
        if (diff(date1.YYYY,date2.YYYY)==1) {
            return date1;
        } else {
            return date2;
        }
    }

    JDate diff(JDate date1, JDate date2) {
        JDate result = new JDate(0,0,0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
