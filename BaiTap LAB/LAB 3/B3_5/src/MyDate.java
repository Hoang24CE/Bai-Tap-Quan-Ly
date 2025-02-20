public class MyDate {
    private int year;
    private int month;
    private int day;

    private static final String[] MONTHS =
            {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] DAYS =
            {"Sunday", "Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_IN_MONTHS =
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Constructor
    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    // Kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Kiểm tra ngày hợp lệ
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || month < 1 || month > 12) return false;
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) maxDay = 29;
        return day >= 1 && day <= maxDay;
    }

    // Lấy ngày trong tuần (Zeller’s Congruence)
    public static int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (day + (13 * (month + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        return (h + 5) % 7; // Điều chỉnh về 0 (Chủ Nhật) - 6 (Thứ Bảy)
    }

    // Đặt ngày mới
    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date!");
        }
    }

    // Getters
    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    // Setters
    public void setYear(int year) { this.year = year; }
    public void setMonth(int month) { this.month = month; }
    public void setDay(int day) { this.day = day; }

    // Hiển thị chuỗi ngày
    @Override
    public String toString() {
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

    // Ngày tiếp theo
    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            day++;
        } else {
            day = 1;
            nextMonth();
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month == 12) {
            month = 1;
            nextYear();
        } else {
            month++;
        }
        if (day > DAYS_IN_MONTHS[month - 1]) {
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) day = 29;
        }
        return this;
    }

    public MyDate nextYear() {
        if (month == 2 && day == 29 && !isLeapYear(year + 1)) {
            day = 28;
        }
        year++;
        return this;
    }

    // Ngày trước đó
    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else {
            previousMonth();
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) day = 29;
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month == 1) {
            month = 12;
            previousYear();
        } else {
            month--;
        }
        if (day > DAYS_IN_MONTHS[month - 1]) {
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) day = 29;
        }
        return this;
    }

    public MyDate previousYear() {
        if (month == 2 && day == 29 && !isLeapYear(year - 1)) {
            day = 28;
        }
        year--;
        return this;
    }
}
