package ir.maktabsharif;

import ir.maktabsharif.model.Customer;
import ir.maktabsharif.model.Movie;
import ir.maktabsharif.model.Ticket;
import ir.maktabsharif.model.enums.Status;
import ir.maktabsharif.service.Impl.customer.CustomerServiceImpl;
import ir.maktabsharif.service.Impl.movie.MovieServiceImpl;
import ir.maktabsharif.service.Impl.ticket.TicketServiceImpl;
import ir.maktabsharif.service.Impl.ticket.chainOfResponsibility.CustomerValidationHandler;
import ir.maktabsharif.service.Impl.ticket.chainOfResponsibility.Handler;
import ir.maktabsharif.service.Impl.ticket.chainOfResponsibility.MovieAvailabilityHandler;
import ir.maktabsharif.service.Impl.ticket.chainOfResponsibility.TicketCreation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Services
        TicketServiceImpl ticketService = new TicketServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        MovieServiceImpl movieService = new MovieServiceImpl();


        // -----------------------------------------
        // 1. Create and save two Movies
        System.out.println("Create and save two Movies");
        System.out.println();
        // -----------------------------------------
        Movie movie1 = new Movie(
                "Interstellar",
                new BigDecimal("15.00"),
                Status.AVAILABLE
        );

        Movie movie2 = new Movie(
                "Inception",
                new BigDecimal("12.00"),
                Status.AVAILABLE
        );
        movieService.save(movie1);
        movieService.save(movie2);


        // -----------------------------------------
        // 1. Create and save two Customers
        System.out.println("Create and save two Customers");
        System.out.println();
        // -----------------------------------------
        Customer customer1 = new Customer(
                "Amir",
                "amir@gmail.com"
        );

        Customer customer2 = new Customer(
                "Ali",
                "ali@gmail.com"
        );

        customerService.save(customer1);
        customerService.save(customer2);

        System.out.println("Movies and Customers saved successfully.");


        // -----------------------------------------
        // 2. Retrieve a Movie by ID and update price
        System.out.println("Retrieve a Movie by ID and update price");
        System.out.println();
        // -----------------------------------------



        Movie retrievedMovie = movieService.findById(movie1.getId());

        System.out.println("Movie before update:");
        System.out.println(retrievedMovie);


        movie1.setStatus(Status.NOT_AVAILABLE);
        movie1.setPrice(new BigDecimal("20.00"));

        System.out.println();


        retrievedMovie.setPrice(new BigDecimal("20.00"));

        retrievedMovie.setStatus(Status.NOT_AVAILABLE);

        movieService.update(retrievedMovie);


        System.out.println("Movie after update:");
        System.out.println(retrievedMovie);


        // -----------------------------------------
        // 3. Find available Movies using Repository
        System.out.println("Find available Movies using Repository");
        System.out.println();
        // -----------------------------------------

        List<Movie> availableMovies = movieService.findAvailable();

        System.out.println("\nAvailable Movies:");

        availableMovies.forEach(System.out::println);


        // -----------------------------------------
        // 4. Purchase Ticket using Chain of Responsibility
        System.out.println("Purchase Ticket using Chain of Responsibility");
        System.out.println();
        // -----------------------------------------

        Ticket ticket1 = new Ticket(
                LocalDate.now(),
                customer1,
                movie1
        );


        Ticket ticket2 = new Ticket(
                LocalDate.now(),
                customer2,
                movie2
        );

        // Chain of responsibility
        Handler customerValidationHandler = new CustomerValidationHandler();
        Handler movieAvailabilityHandler = new MovieAvailabilityHandler();
        Handler ticketCreation = new TicketCreation();

        ticketCreation.setNext(movieAvailabilityHandler);
        movieAvailabilityHandler.setNext(customerValidationHandler);

        ticketCreation.handel(ticket1);

        ticketCreation.handel(ticket2);


        // -----------------------------------------
        // 5. Print created Ticket
        System.out.println("Print created Ticket");
        System.out.println();
        // -----------------------------------------
        System.out.println();


        System.out.println("\nCreated Ticket:");

        ticketService.findAll().forEach(System.out::println);


    }
}
