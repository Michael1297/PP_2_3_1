package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImp;

@Controller
public class CarController {
    private final CarService cars;

    @Autowired
    public CarController(CarServiceImp cars) {
        this.cars = cars;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count", defaultValue = "" + Integer.MAX_VALUE) int count,
                          Model model) {
        model.addAttribute("carsList", cars.getCars(count));
        return "cars";
    }
}