package codegym.repository;

import codegym.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountryRepo extends CrudRepository<Country,Long> {
}
