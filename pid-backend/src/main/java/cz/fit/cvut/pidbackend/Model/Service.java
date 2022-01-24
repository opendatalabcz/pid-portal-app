package cz.fit.cvut.pidbackend.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Service {

    @Id
    @Column(name = "uid")
    private String uid;

    @Column(name = "end_time")
    private Timestamp end_time;
    @Column(name = "monday")
    private boolean monday;
    @Column(name = "tuesday")
    private boolean tuesday;
    @Column(name = "wednesday")
    private boolean wednesday;
    @Column(name = "thursday")
    private boolean thursday;
    @Column(name = "friday")
    private boolean friday;
    @Column(name = "saturday")
    private boolean saturday;
    @Column(name = "sunday")
    private boolean sunday;
    @Column(name = "created_time")
    private Timestamp created_time;
    @Column(name = "modified_time")
    private Timestamp modified_time;
}
