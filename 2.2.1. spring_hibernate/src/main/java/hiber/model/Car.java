package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "car")
    private User user;

    public User setUser(User user) {
        this.user = user;
        return user;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}
