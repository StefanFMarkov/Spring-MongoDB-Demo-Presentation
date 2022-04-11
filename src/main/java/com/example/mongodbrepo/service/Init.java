package com.example.mongodbrepo.service;

import com.example.mongodbrepo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final PhoneRepository phoneRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookModelRepository bookModelRepository;
    private final ActionService actionService;
    private final MongoTemplate mongoTemplate;

    public Init(UserRepository userRepository, CarRepository carRepository, ManufacturerRepository manufacturerRepository, PhoneRepository phoneRepository, BookRepository bookRepository, AuthorRepository authorRepository, BookModelRepository bookModelRepository, ActionService actionService, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.phoneRepository = phoneRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookModelRepository = bookModelRepository;
        this.actionService = actionService;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

//        List<Book> books =   (List<Book>) this.bookRepository.findAllById(List.of("6251da6d3ce5fd1f56b22096", "6251da6d3ce5fd1f56b22095"));
//        User user = this.userRepository.findByName("MongoUser6");
//        Author author = new Author().setAge(29).setBooks(books).setName("my-name");
//
//        user.setFavouritesAuthors(List.of(author));
//        this.authorRepository.save(author);
//        this.userRepository.save(user);


//        Book  book = new Book().setPages(100).setTitle("new one");
//        this.bookRepository.save(book);

//        User user = new User().setName("MongoUser6");
//        Phone phone = new Phone()
//                .setModel("New")
//                .setUser(user)
//                .setSize(6);


//        Car car = new Car()
//                .setColor("Red")
//                .setModel("Random-red")
//                .setUser(user);
//
//        Car car2 = new Car()
//                .setColor("Orange")
//                .setModel("Random-orange")
//                .setUser(user);
//
//        Book book1 = new Book().setPages(6).setTitle("title6");
//        Book book2 = new Book().setPages(12).setTitle("title12");
//
//        user.setBooks(List.of(book1, book2));
//        this.bookRepository.saveAll(List.of(book1, book2));
//        this.userRepository.save(user);
//        this.phoneRepository.save(phone);
//        this.carRepository.save(car);
//        this.carRepository.save(car2);
//
//        Manufacturer manufacturer = new Manufacturer()
//                .setCars(List.of(car, car2));
//
//        this.manufacturerRepository.save(manufacturer);

//        BookModel bookModel = this.bookModelRepository.findByModel("hard cover book");
//
//        List<Book> books = (List<Book>) this.bookRepository.findAllById(List.of("6251da6d3ce5fd1f56b22096", "6251da6d3ce5fd1f56b22095"));
//        books.forEach(b->b.setBookModel(bookModel));
//
//
//        this.bookRepository.saveAll(books);
//
//        this.bookModelRepository.save(bookModel);

//        this.actionService.findByColorCar();
//        this.actionService.findByUserNameTheCar();
//        this.actionService.findUserByNameMongoTemplate();

//        this.actionService.dataChangeOfManufacturerMongoTemplate();
//        this.actionService.findManufacturerByCarByUser_Name();
//        this.actionService.findPhoneByUser();

//        this.actionService.findBookByPagesGreaterThan();
//        this.actionService.findAllUsersByPagesSize();
//        this.actionService.getComplexUserDetails();


//        this.actionService.findAndUpdateAuthor();

//        this.actionService.findBookModelByModel_OneToManyExample();

        this.actionService.findAllManufacturers();
    }

}
