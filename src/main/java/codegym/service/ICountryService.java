package codegym.service;

import codegym.model.Country;

import java.util.ArrayList;

public interface ICountryService {
    ArrayList<Country> ShowAllCountry();
    Country findById(long id);
}
