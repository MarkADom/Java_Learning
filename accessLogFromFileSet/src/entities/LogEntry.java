package entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {

    private String username;
    private Date date;

    public LogEntry(String name, Date date) {
        this.username = name;
        this.date = date;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry logEntry)) return false;
        return username.equals(logEntry.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
