package com.example.mongodbrepo.service;

import com.example.mongodbrepo.model.*;
import com.example.mongodbrepo.repositories.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ActionServiceImpl implements ActionService {
    private final MongoTemplate mongoTemplate;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final PhoneRepository phoneRepository;
    private final BookRepository bookRepository;
    private final BookModelRepository bookModelRepository;
    private final MongoOperations mongoOperations;

    public ActionServiceImpl(MongoTemplate mongoTemplate, AuthorRepository authorRepository, UserRepository userRepository, CarRepository carRepository, ManufacturerRepository manufacturerRepository, PhoneRepository phoneRepository, BookRepository bookRepository, BookModelRepository bookModelRepository, MongoOperations mongoOperations) {
        this.mongoTemplate = mongoTemplate;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.phoneRepository = phoneRepository;
        this.bookRepository = bookRepository;
        this.bookModelRepository = bookModelRepository;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public void findByColorCar() {
        Car car = this.carRepository.findCarByColor("Blue");

        User user = car.getUser();
        System.out.println(user.toString());
        System.out.println("*".repeat(25));
        System.out.println(car.toString());
    }

    @Override
    public void findByUserNameTheCar() {


        Car car = this.carRepository.findCarByUser_UserId("6251b97bf6664e374701886d");

        System.out.println(".".repeat(50));
        System.out.println(car.toString());
    }

    @Override
    public void findUserByNameMongoTemplate() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("MongoUser1")
                .and("userId").is("6251b8016f576672bfb63b44"));

        User user = mongoTemplate.findOne(query, User.class);

        System.out.println("-".repeat(30));
        System.out.println(user.toString());
    }

    @Override
    public void dataChangeOfManufacturerMongoTemplate() {
        Query query = new Query();
        query.addCriteria(Criteria.where("manufacturerId").is("6251c126bf617e507db127f5"));

        Manufacturer manufacturer = mongoTemplate.findOne(query, Manufacturer.class);

        manufacturer.setYearOfStarting(1990);
        this.mongoTemplate.save(manufacturer);

        System.out.println(manufacturer);


    }

    @Override
    public void findManufacturerByCarByUser_Name() {
        Query query = new Query();

        String id = "6251c31a1f04044976ffd15d";
        Manufacturer manufacturer = this.manufacturerRepository.findById(id).get();
        manufacturer.setYearOfStarting(1992);
        this.manufacturerRepository.save(manufacturer);
        System.out.println(manufacturer);

    }

    @Override
    public void findPhoneByUser() {
        String id = "6251d42a986f801096371c3a";
//        Phone phone = this.phoneRepository.findPhoneById(id);

        String username = "MongoUser4";
        User user = this.userRepository.findByName("MongoUser4");
        Phone phone = this.phoneRepository.findPhoneByUser(user);
        System.out.println(".".repeat(50));
        System.out.println(phone.toString());
    }

    @Override
    public void findBookByPagesGreaterThan() {

        List<Book> books = this.bookRepository.findAllByPagesGreaterThan(5);

        books.forEach(System.out::println);

    }

    @Override
    public void findAllUsersByPagesSize() {

        Query query = new Query();

        query.addCriteria(Criteria
                        .where("books")
                        .elemMatch(
                                Criteria.where("pages").gte(3)
                                        .and("title").regex("tit")
                        ).orOperator(
                                Criteria.where("name").regex("^MongoUser?")
                        )
                )
                .with(
                        Sort.by(Sort.Direction.DESC, "name")
                                .and(Sort.by(Sort.Direction.DESC, "pages")))
                .limit(3);


        List<User> users = mongoTemplate.find(query, User.class);
        users.forEach(System.out::println);
    }

    @Override
    public void getComplexUserDetails() {

        User user = this.userRepository.findByName("MongoUser6");

        System.out.println(user);
        System.out.println(".".repeat(100));
        List<Author> favouritesAuthors = user.getFavouritesAuthors();

        System.out.println(favouritesAuthors.toString());
        System.out.println(".".repeat(100));

        List<Book> books = user.getBooks();
        System.out.println(books);
        System.out.println(".".repeat(100));
    }

    @Override
    public void findAndUpdateAuthor() {
        Query query = new Query();

        query.addCriteria(Criteria.where("name").regex("Stef"));

        Update update = new Update();

        update.set("author_name", "Stefancho");
        mongoTemplate.updateFirst(query, update, Author.class);

        Author updated = this.authorRepository.findByNameContaining("Stef");

        System.out.println(updated);
    }

    @Override
    public void findBookModelByModel_OneToManyExample() {
        BookModel digital = this.bookModelRepository.findByModel("hard cover book");

        List<Book> books = digital.getBooks();

        System.out.println(books);
        System.out.println(digital);
    }

    @Override
    public void findAllManufacturers() {
        AtomicInteger count = new AtomicInteger();
        List<Manufacturer> manufacturers = this.manufacturerRepository.findAll();

        manufacturers.forEach(m -> {

            count.getAndIncrement();
            System.out.println(">".repeat(30) + count + "<".repeat(30));

            System.out.println(m);
            System.out.println("*".repeat(100));
        });


    }

    @Override
    public void findAndRemovePhoneBySizeGreaterThan_MongoTemplate() {
        Query query = new Query();

        query.addCriteria(Criteria.where("size").gte(10).and("user").isNull());
        Phone removed = mongoTemplate.findAndRemove(query, Phone.class);

        if (removed == null) {
            System.out.println("No match!");

        } else {
            System.out.println("Successful removed " + removed);
        }
    }

    @Override
    public void findAllBooks_MongoOperations() {

        List<Book> books = mongoOperations.findAll(Book.class);
        AtomicInteger count = new AtomicInteger();

        books.forEach(b -> {
            count.getAndIncrement();
            System.out.println(">".repeat(30) + count + "<".repeat(30));
            System.out.println(b);
        });
    }
}
