package jdates;

public class JDate {
    public int DD, MM, YYYY, hh, mm, ss;

    void setDate(int DD, int MM, int YYYY) {
        if (DD < 1 || MM < 1 || YYYY < 1 || DD > 31 || MM > 12 || DD > 29 & MM == 2) {
            throw new RuntimeException("invalid date format");
        }
        this.DD = DD;
        this.MM = MM;
        this.YYYY = YYYY;
    }

    void setTime(int hh, int mm, int ss) {
        if (hh < 0 || mm < 0 || ss < 0 ||
                hh > 23 || mm > 59 || ss > 59) {
            throw new RuntimeException("invalid time format");
        }
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public String getTime() {
        String time = Integer.toString(hh) + ":" + Integer.toString(mm) + ":" + Integer.toString(ss);
        return time;
    }

    public String getDate() {
        String date = Integer.toString(DD) + "." + Integer.toString(MM) + "." + Integer.toString(YYYY);
        return date;
    }

    public String getDateAndTime() {
        String dateAndTime = this.getTime() + " " + this.getDate();
        return dateAndTime;
    }

    public JDate(int DD, int MM, int YYYY) {
        setDate(DD, MM, YYYY);
        setTime(0, 0, 0);
    }

    public JDate(int DD, int MM, int YYYY, int hh, int mm, int ss) {
        setDate(DD, MM, YYYY);
        setTime(hh, mm, ss);
    }

    public JDate getDiff(JDate date2) {
        int[] diffs = {this.YYYY - date2.YYYY, this.MM - date2.MM, this.DD - date2.DD, this.hh - date2.hh, this.mm - date2.mm, this.ss - date2.ss};
        int i;
        for (i = 0; i < diffs.length; i++) {
            if (diffs[i] < 0) {
                for (int j = i; j < diffs.length; j++)
                    diffs[j] *= -1;
                break;
            } else if (diffs[i] > 0)
                break;
        }
        int[] maxTime = {0, 12, 30, 24, 60, 60};
        for (i = diffs.length - 1; i > 0; i--) {
            if (diffs[i] < 0) {
                diffs[i] += maxTime[i];
                diffs[i - 1] -= 1;
            }
        }

        JDate result = new JDate(diffs[2], diffs[1], diffs[0], diffs[3], diffs[4], diffs[5]);
        return result;
    }
}
