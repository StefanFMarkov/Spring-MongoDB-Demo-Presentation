package com.example.mongodbrepo.service;

public interface ActionService {

    void findByColorCar();

    void findByUserNameTheCar();

    void findUserByNameMongoTemplate();

    void dataChangeOfManufacturerMongoTemplate();

    void findManufacturerByCarByUser_Name();

    void findPhoneByUser();

    void findBookByPagesGreaterThan();

    void findAllUsersByPagesSize();

    void getComplexUserDetails();

    void findAndUpdateAuthor();

    void findBookModelByModel_OneToManyExample();

    void findAllManufacturers();

    void findAndRemovePhoneBySizeGreaterThan_MongoTemplate();

    void findAllBooks_MongoOperations();
}
