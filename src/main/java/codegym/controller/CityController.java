package codegym.controller;

import codegym.model.City;
import codegym.model.Country;
import codegym.service.ICityService;
import codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    ICityService iCityService;
    @Autowired
    ICountryService iCountryService;
    @RequestMapping("/home")
    public ModelAndView show1() {
        ModelAndView modelAndView = new ModelAndView("show1");
        modelAndView.addObject("ListCity", iCityService.ShowAllCity());
        modelAndView.addObject("ListCountry", iCountryService.ShowAllCountry());
        return modelAndView;
    }

    @RequestMapping("/show/{id}")
    public ModelAndView show(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("city",iCityService.findById(id));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city",new City());
        modelAndView.addObject("ListCountry", iCountryService.ShowAllCountry());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("city") City city,
                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        iCityService.delete(iCityService.findById(id));
        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showedit(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("city",iCityService.findById(id));
        modelAndView.addObject("ListCountry",iCountryService.ShowAllCountry());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute City city,@RequestParam long countryid){
        Country country = new Country();
        country.setId(countryid);
        city.setCountry(country);
        iCityService.save(city);
        return new ModelAndView("redirect:/home");
    }

}
