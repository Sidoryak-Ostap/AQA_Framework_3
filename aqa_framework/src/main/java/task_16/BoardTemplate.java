package task_16;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardTemplate {
    String name;
    boolean closed;
    String idOrganization;
    boolean pined;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public boolean isPined() {
        return pined;
    }

    public void setPined(boolean pined) {
        this.pined = pined;
    }

    @Override
    public String toString() {
        return "BoardTemplate{" +
                "name='" + name + '\'' +
                ", closed=" + closed +
                ", idOrganization='" + idOrganization + '\'' +
                ", pined=" + pined +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardTemplate that = (BoardTemplate) o;
        return closed == that.closed && pined == that.pined && Objects.equals(name, that.name) && Objects.equals(idOrganization, that.idOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, closed, idOrganization, pined);
    }
}
