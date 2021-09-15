package codegym.service;

import codegym.model.City;

import java.util.ArrayList;

public interface ICityService {
    ArrayList<City> ShowAllCity();
    City findById(long id);

    void delete(City city);

    void save(City city);

    void edit(City city);
}
