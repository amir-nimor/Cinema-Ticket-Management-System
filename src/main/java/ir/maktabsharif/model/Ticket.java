package ir.maktabsharif.model;

import ir.maktabsharif.model.BaseModel.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseModel<Long> {

    @CreationTimestamp
    private LocalDate pruchaseDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Ticket(LocalDate pruchaseDate, Customer customer, Movie movie) {
        this.pruchaseDate = pruchaseDate;
        this.customer = customer;
        this.movie = movie;
    }

    public Ticket() {

    }

    public LocalDate getPruchaseDate() {
        return pruchaseDate;
    }

    public void setPruchaseDate(LocalDate pruchaseDate) {
        this.pruchaseDate = pruchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "pruchaseDate=" + pruchaseDate +
                '}';
    }
}
