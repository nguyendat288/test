package codegym.service;

import codegym.model.City;
import codegym.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CityService implements ICityService {
@Autowired
    ICityRepo iCityRepo;
    @Override
    public ArrayList<City> ShowAllCity() {
        return (ArrayList<City>) iCityRepo.findAll();
    }

    @Override
    public City findById(long id) {
        return iCityRepo.findById(id).get();
    }
    @Override
    public void delete(City city) {
iCityRepo.delete(city);
    }

    @Override
    public void save(City city) {
iCityRepo.save(city);
    }

    @Override
    public void edit(City city) {
        iCityRepo.save(city);
    }
}
