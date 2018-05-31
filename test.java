import jdates.JDate;

public class test {
    public static void main(String[] args) {
        JDate test = new JDate(31,5,2018,1,19,0);
        JDate test2 = new JDate(10,9,1995,10,0,0);
        String date = test.getDateAndTime();
        String date2 = test2.getDateAndTime();
        System.out.println(date);
        System.out.println(date2);
        System.out.println(test.getDiff(test2).getDateAndTime());
    }
}
