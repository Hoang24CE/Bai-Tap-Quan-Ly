public class Date {
//
    private int day;
    private int month;
    private int year;
//
    public Date(int day, int month, int years) {
        this.day = day;
        this.month = month;
        this.year = years;
    }
 //

    public int getDay() {
        return day;
    }
//

    public int getMonth() {
        return month;
    }
//

    public int getYears() {
        return year;
    }
//
    public void setDay(int day) {
        this.day = day;
    }
//

    public void setMonth(int month) {
        this.month = month;
    }
//

    public void setYears(int years) {
        this.year = years;
    }
//
    public void setDate(int day, int month, int years) {
        this.day = day;
        this.month = month;
        this.year = years;
    }
//
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
