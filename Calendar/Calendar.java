import java.util.List;
import java.util.ArrayList;

public class Calendar {
    public static void main(String[] args) {
            int month = 1;//Integer.parseInt(args[0]);
            int year = 1998;//Integer.parseInt(args[1]);

            String selectedMonth = "January";
            int firstDay = DayOfWeek(1, month, year);
            int end = 31;

            switch(month)
            {
                case 2:    selectedMonth = "February"; end = 28;  break;
                case 3:    selectedMonth = "March";   end = 31;  break;
                case 4:    selectedMonth = "April"; end = 30;  break;
                case 5:    selectedMonth = "May"; end = 31;  break;
                case 6:    selectedMonth = "June";  end = 30;  break;
                case 7:    selectedMonth = "July";  end = 31;  break;
                case 8:    selectedMonth = "August"; end = 31;  break;
                case 9:    selectedMonth = "September"; end = 30;  break;
                case 10:   selectedMonth = "October"; end = 31;  break;
                case 11:   selectedMonth = "November"; end = 30;  break;
                case 12:   selectedMonth = "December"; end = 31; break; 
            }

            if((year % 400 == 0) || (year % 4 == 0 && (year % 100 != 0))) {
                if(month == 2) {
                    end = 29;
                }
            }
            System.out.println("+-----------------------------------------+");
            System.out.printf("|              %s %4d              |\n",selectedMonth, year);
            System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
            System.out.println("| Sun | Mon | Tue | Wed | Thu | Fri | Sat |");
            System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
            List<Integer> days = new ArrayList<Integer>();

            for(int i = 1; i <= firstDay; i++) {
                days.add(0);
            }
            for(int i = 1; i <= end; i++) {
                days.add(i);
            }

            int count = -1;
            int lineNum = 12;

            if(days.size() > 28)
            lineNum = 15;
            if(firstDay > 4)
            lineNum += 3;          

            for(int i = 1; i <= lineNum; i++) {
                if(i % 3 == 1) {
                    for(int j = 1; j <= 7; j++) {
                        count++;

                        try {
                            if(days.get(count) == 0)
                                System.out.printf("|%4s ", "");
                            else
                                System.out.printf("|%4d ", days.get(count));
                        } catch (Exception e) {
                            System.out.printf("|%4s ", "");
                        }
                    }
                    System.out.println("|");
                }
                if(i % 3 == 2) {
                    System.out.println("|     |     |     |     |     |     |     |");
                }
                if(i % 3 == 0)
                {
                    System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
                }
            }
    }
    public static int DayOfWeek(int day, int month, int year) {
        int y = year - ((14 - month) / 12);
        int x = y + (y / 4) - (y / 100) + (y / 400);
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;
        return d;
    }
}