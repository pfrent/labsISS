package Domain;

import java.io.Serializable;

public class Task implements Serializable {
    private Integer id;
    private Integer employeeId;
    private String description;
    private Integer rating;
    private Integer duration;

    public Task(Integer id,Integer eId, String description, Integer rating, Integer duration) {
        this.id = id;
        this.employeeId=eId;
        this.description = description;
        this.rating = rating;
        this.duration = duration;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
