package basic.array;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class YMD {
    int y; // 년
    int m; // 월
    int d; // 일

    static final int[][] days = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };

    public YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public YMD after(int n) {
        // n일 뒤의 날짜를 반환
        if(n < 0) {
            return before(-n);
        }
        // d + n해서 해당 달보다 날짜가 많으면 해당 날을 뺸 수 구하기 == days
        int day = d + n;

        int year = y, month = m;

        while(day > getDays(year, month)) {
            day -= getDays(year, month);

            // 그럼 m++ 12 넘으면, y++
            month += 1;
            if(month > 12) {
                month = 1;
                year += 1;
            }
        }

        return new YMD(year, month, day);
    }

    private int isLeap(int y) {
        return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) ? 1 : 0;
    }

    public YMD before(int n) {
        // n일 앞의 날짜를 반환
        if(n < 0) {
            return after(-n);
        }
        // day = d - n, -가 나오면 이전 달의 날짜 - day
        int day = d - n;
        int year = y, month = m;
        while(day < 1) {
            month -= 1;

            // 이전 달이 0이면 12월로 y--
            if(month <= 0) {
                month = 12;
                year -= 1;
            }

            day += getDays(year, month);

        }



        return new YMD(year,month,day);
    }

    private int getDays(int y, int m) {
        return m >=1 ? days[isLeap(y)][m-1] : days[isLeap(y)][days.length-1];
    }

    @Override
    public String toString() {
        return y + "-" + m + "-" + d;
    }

    public static void main(String[] args) {
        YMD ymd = new YMD(2025, 2, 10);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("before 3650 " + ymd.before(3650));
        System.out.println("minusDays 3650 " + formatter.format(now.minusDays(3650)));
        System.out.println("before 367 " + ymd.before(367));
        System.out.println("minusDays 367 " + formatter.format(now.minusDays(367)));
        System.out.println("after 368 " + ymd.after(368));
        System.out.println("plusDays 368 " + formatter.format(now.plusDays(368)));
        System.out.println("after 369 " + ymd.after(369));
        System.out.println("plusDays 369 " + formatter.format(now.plusDays(369)));
        System.out.println("after 3610 " + ymd.after(3610));
        System.out.println("plusDays 3610 " + formatter.format(now.plusDays(3610)));
    }
}
