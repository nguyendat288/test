package codegym.service;

import codegym.model.Country;
import codegym.repository.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService implements ICountryService{
    @Autowired
    ICountryRepo iCountryRepo;
    @Override
    public ArrayList<Country> ShowAllCountry() {
        return (ArrayList<Country>) iCountryRepo.findAll();
    }
    @Override
    public Country findById(long id) {
        return iCountryRepo.findById(id).get();
    }
}
