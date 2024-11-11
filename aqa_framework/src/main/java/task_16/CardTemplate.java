package task_16;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardTemplate {
    String id;
    int votes;
    int checkItems;

    boolean description;
    boolean closed;

    String idList;
    String due;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(int checkItems) {
        this.checkItems = checkItems;
    }

    public boolean isDescription() {
        return description;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "CardTemplate{" +
                "id='" + id + '\'' +
                ", votes=" + votes +
                ", checkItems=" + checkItems +
                ", description=" + description +
                ", closed=" + closed +
                ", idList='" + idList + '\'' +
                ", due='" + due + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardTemplate that = (CardTemplate) o;
        return votes == that.votes && checkItems == that.checkItems && description == that.description && closed == that.closed && Objects.equals(idList, that.idList) && Objects.equals(due, that.due);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votes, checkItems, description, closed, idList, due);
    }
}
