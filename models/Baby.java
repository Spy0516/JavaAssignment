package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Baby {

    List<Gift> gifts = new ArrayList<>();

    private String strBirthday;
    private String name;
    private char gender;
    private Date birthday;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy/HH:mm");
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy/HH:mm");

    public Baby() {

    }

    public Baby(String strBirthday, String name, char gender) {

        this.strBirthday = strBirthday;
        this.name = name;
        this.gender = gender;

    }

    public Baby(Date birthday, String name, char gender) {

        this.birthday = birthday;
        this.name = name;
        this.gender = gender;
    }

    // Getters and Setters
    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrBirthday() {
        return strBirthday;
    }

    public void setStrBirthday(String strBirthday) {
        this.strBirthday = strBirthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    // If a given kid is older than the current one
    //boolean isOlder(Baby baby)
    public boolean isOlder(Baby baby) throws ParseException {

        boolean checker = false;
        Date date1;
        Date date2;
        int ok1 = 0;
        int ok2 = 0;
        if (baby.getBirthday() instanceof Date) {
            if (this.getStrBirthday() instanceof String) {
                ok2 = 1;
                date1 = format.parse(this.getStrBirthday());
                date2 = baby.getBirthday();
            } else {
                date1 = this.getBirthday();
                date2 = baby.getBirthday();
            }

        } else {

            ok1 = 1;
            if (this.getStrBirthday() instanceof String) {
                ok2 = 1;
                date1 = format.parse(this.getStrBirthday());
                date2 = format.parse(baby.getStrBirthday());
            } else {
                date1 = this.getBirthday();
                date2 = format.parse(baby.getStrBirthday());
            }
        }

        if ((ok1 == 0 && ok2 == 0) || (ok1 == 1 && ok2 == 1)) {

            //System.out.println("Date " + date1);
            //System.out.println("Date " + date2);
            if (date1.before(date2)) {
                checker = true;
            }
        } else {
            int month;
            int year;

            if (ok2 == 0) {

                year = date1.getYear() - 1900;
                date1.setYear(year);

                month = date1.getMonth() - 1;
                date1.setMonth(month);
                //System.out.println("Date " + date1);
                //System.out.println("String " + date2);

            } else {

                year = date2.getYear() - 1900;
                date2.setYear(year);

                month = date2.getMonth() - 1;
                date2.setMonth(month);

                //System.out.println("String " + date1);
                //System.out.println("Date " + date2);
            }

            if (date1.before(date2)) {
                checker = true;
            }

        }

        return checker;
    }

    // The actual age of the kid in days
    //int howOld()
    public int howOld() throws ParseException {

        Date birthDate;
        int s;
        int isString = 0;
        Date now = new Date("07/11/2017/19:25");
        Date today = format.parse(formatter.format(now));

        if (this.getStrBirthday() instanceof String) {
            birthDate = format.parse(this.getStrBirthday());
            s = now.getYear() - birthDate.getYear();
            isString = 1;
            //System.out.println("str " + s);
        } else {
            birthDate = this.getBirthday();
            s = now.getYear() - birthDate.getYear() + 1900;
            //System.out.println("Date " + s);

        }

        int birthMonth;
        if (isString == 0) {
            birthMonth = birthDate.getMonth() - 1;
        } else {
            birthMonth = birthDate.getMonth();
        }

        if (today.getMonth() > birthMonth) {
            s--;
        } else if (today.getMonth() == birthMonth) {
            if (today.getDate() > birthDate.getDate()) {
                s--;
            } else if (today.getDate() == birthDate.getDate()) {
                if (today.getHours() > birthDate.getHours()) {
                    s--;
                } else if (today.getHours() == birthDate.getHours()) {
                    if (today.getMinutes() > birthDate.getMinutes()) {
                        s--;
                    }
                }
            }
        }

        return s;
    }

}
