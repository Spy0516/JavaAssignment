package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Baby {

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
        Date date1;
        Date date2;
        if (this.getBirthday() instanceof Date) {
            if (baby.getBirthday() instanceof Date) {
                if (this.getBirthday().getTime() > baby.getBirthday().getTime()) {
                    return true;
                } else {
                    return false;
                }
            }else{
                date1 = format.parse(baby.getStrBirthday());
                if (this.getBirthday().getTime() > date1.getTime()) {
                    return true;
                } else {
                    return false;
                }
                
            }
            
        } else {
            date2 = format.parse(this.getStrBirthday());
            if (baby.getBirthday() instanceof Date) {
                
                if (date2.getTime() > baby.getBirthday().getTime()) {
                    return true;
                } else {
                    return false;
                }
            }else{
                date1 = format.parse(baby.getStrBirthday());
                if (date2.getTime() > date1.getTime()) {
                    return true;
                } else {
                    return false;
                }
                
            }
        }
    }


    // The actual age of the kid in days
    //int howOld()
    public int howOld() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date Today = calendar.getTime();
        Date date;
        float ageInMiliseconds;
        if (this.getBirthday() instanceof Date) {
            ageInMiliseconds = Today.getTime() - this.getBirthday().getTime();
        } else {
            date = format.parse(this.getStrBirthday());
            ageInMiliseconds = Today.getTime() - date.getTime();
        }
        
        return (int) (ageInMiliseconds / 86400000);
    }

    
}
