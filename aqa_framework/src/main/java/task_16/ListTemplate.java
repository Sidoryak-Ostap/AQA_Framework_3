package task_16;

import java.util.Objects;

public class ListTemplate {
    String id;
    String name;
    boolean closed;
    String color;
    String idBoard;
    String pos;
    String type;
    Object datasource;
    Object limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getDatasource() {
        return datasource;
    }

    public void setDatasource(Object datasource) {
        this.datasource = datasource;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "ListTemplate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", color='" + color + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", pos='" + pos + '\'' +
                ", type='" + type + '\'' +
                ", datasource=" + datasource +
                ", limits=" + limits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTemplate that = (ListTemplate) o;
        return closed == that.closed && Objects.equals(name, that.name) && Objects.equals(idBoard, that.idBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, closed, idBoard);
    }
}


//{
//    "id": "67322e48e3db98267abe69e8",
//    "name": "To do",
//    "closed": false,
//    "color": null,
//    "idBoard": "67322d3d23789718748edb8b",
//    "pos": 8192,
//    "type": null,
//    "datasource": {
//        "filter": false
//    },
//    "limits": {}
//}