import java.util.*;

public class Calendar {
    public static void main(String[] args) {

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        String monthChosen = "January";
        int firstDay = DayOfWeek(1, month, year);
        int lastDay = 31;

        switch(month) {
            case 2:    monthChosen = "February"; lastDay = 28;  break;
            case 3:    monthChosen = "March";   lastDay = 31;  break;
            case 4:    monthChosen = "April"; lastDay = 30;  break;
            case 5:    monthChosen = "May"; lastDay = 31;  break;
            case 6:    monthChosen = "June";  lastDay = 30;  break;
            case 7:    monthChosen = "July";  lastDay = 31;  break;
            case 8:    monthChosen = "August"; lastDay = 31;  break;
            case 9:    monthChosen = "September"; lastDay = 30;  break;
            case 10:   monthChosen = "October"; lastDay = 31;  break;
            case 11:   monthChosen = "November"; lastDay = 30;  break;
            case 12:   monthChosen = "December"; lastDay = 31; break;
        }

        if((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0)) {
            if(month == 2) {
                lastDay = 29;
            }
        }
        System.out.println("+-----------------------------------------+");//43 nodes in the line
        //used multiple if statment to help deal with the formating error that I've been running into.
        if (month == 9) {
            System.out.println("|             " + monthChosen +" "+ year +"              |");
        }
        if (month == 2 || month == 11 || month == 12) {
            System.out.println("|              " + monthChosen +" "+ year +"              |");
        }
        if (month == 1 || month == 10) {
            System.out.println("|              " + monthChosen +" "+ year +"               |");
        }
        if (month == 8) {
            System.out.println("|               " + monthChosen +" "+ year +"               |");
        }
        if (month == 3 || month == 4) {
            System.out.println("|               " + monthChosen +" "+ year +"                |");
        }
        if (month == 6 || month == 7) {
            System.out.println("|                " + monthChosen +" "+ year +"                |");
        }
        if (month == 5) {
            System.out.println("|                " + monthChosen +" "+ year +"                 |");
        }
        
        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
        System.out.println("| Sun | Mon | Tue | Wed | Thu | Fri | Sat |");
        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
        List<Integer> listOfDays = new ArrayList<Integer>();

            for(int i = 1; i <= firstDay; i++) {
                listOfDays.add(0);
            }
            for(int i = 1; i <= lastDay; i++) {
                listOfDays.add(i);
            }

            int count = -1;
            int numberLine = 12;

            if(listOfDays.size() > 28)
                numberLine = 15;
            if(firstDay > 4)
                numberLine += 3;          

            for(int i = 1; i <= numberLine; i++) {
                if(i % 3 == 1) {
                    for(int j = 1; j <= 7; j++) {
                        count++;

                        try {

                            if(listOfDays.get(count) == 0)
                                System.out.printf("|%4s ", "");
                            else
                                System.out.printf("|%4d ", listOfDays.get(count));
                        } catch (Exception e) {
                            System.out.printf("|%4s ", "");
                        }

                    }
                    System.out.println("|");
                }

                if(i % 3 == 2) {
                    System.out.println("|     |     |     |     |     |     |     |");
                }

                if(i % 3 == 0) {
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