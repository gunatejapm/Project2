package sa.com.stc.demo1.config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="Subject")
public class Subject {
    @Id
    @Column(name="id")
    private String Id;
    private String name;
    public Subject() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
