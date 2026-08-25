package ir.maktabsharif.model;

import ir.maktabsharif.model.BaseModel.BaseModel;
import ir.maktabsharif.model.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name = "findMovieByTitle",
                query = "SELECT m from Movie m where m.title like lower(concat('%' ,:nameTitel,'%') )  "
        ),
        @NamedQuery(name = "findAvailableMovies",
                query = "SELECT m from Movie m WHERE m.status = 'AVAILABLE'"
        ),
        @NamedQuery(name = "findMoviePurchasedByCustomer",
        query = "SELECT m from Movie m JOIN Ticket t on m.id = t.id where t.customer.id = ?1"
        )
})


@Entity
@Table(name = "movies")
public class Movie extends BaseModel<Long> {

    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false)
    @Check(constraints = "price > 0")
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Status status;


    public Movie(String title, BigDecimal price, Status status) {
        this.title = title;
        this.price = price;
        this.status = status;
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}

