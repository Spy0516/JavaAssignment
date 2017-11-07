package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gift {

    private String whoGave;
    private String description;
    private Date whenGave;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    public Gift(String whoGave, String description, Date whenGave) {
        this.whoGave = whoGave;
        this.description = description;
        this.whenGave = whenGave;
    }

    public String getWhoGave() {
        return whoGave;
    }

    public String getDescription() {
        return description;
    }

    public Date getWhenGave() {
        return whenGave;
    }

    @Override
    public String toString() {
        return whoGave + " gave " + description + " in " + whenGave;
    }

}