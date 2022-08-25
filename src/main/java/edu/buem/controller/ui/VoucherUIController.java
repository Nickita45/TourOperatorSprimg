package edu.buem.controller.ui;

import edu.buem.form.RouteClientCountry;
import edu.buem.form.RoutesClient;
import edu.buem.model.*;
import edu.buem.service.client.impls.IClientServiceImpl;
import edu.buem.service.country.impls.ICountryServiceImpl;
import edu.buem.service.route.impls.IRouteServiceImpl;
import edu.buem.service.routelog.impls.IRouteLogServiceImpl;
import edu.buem.service.voucher.impls.IVoucherServiceImpl;
import edu.buem.service.voucherlog.impls.IVoucherLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ui/v1/vouchers/")
@Controller
public class VoucherUIController {
    @Autowired
    IVoucherServiceImpl service;
    @Autowired
    IVoucherLogServiceImpl serviceVoucherLog;
    @Autowired
    IClientServiceImpl serviceClient;
    @Autowired
    ICountryServiceImpl serviceCountry;
    @Autowired
    IRouteLogServiceImpl serciveRoute;
    @GetMapping("")
    public String showAll(Model model)
    {
        var countries = serviceCountry.getAll().stream().map(Country::getName).collect(Collectors.toList());

        var clients = serviceClient.getFullName();
        //System.out.printf(serviceIRouteLog.getAll().get(0).toString());

        model.addAttribute("vouchers",serviceVoucherLog.getAll());

        //model.addAttribute("countries", countries);
        model.addAttribute("routes", serciveRoute.getAll());
        model.addAttribute("clients", clients);

        return "vouchers";
    }
    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id)
    {
        service.delete(serviceVoucherLog.get(id).getVoucher().getId());
        serviceVoucherLog.delete(id);
        return "redirect:/ui/v1/vouchers/";
    }
    @RequestMapping( method = RequestMethod.POST)
    public String addVoucher(@ModelAttribute RoutesClient route, Model model) {
        model.addAttribute("country", route);

        List<String> names = Arrays.stream(route.getClients().split("_")).toList();
        Client client = serviceClient.getAll().
                stream().
                filter(client1 -> client1.getFirstName().equals(names.get(0))
                        && client1.getLastName().equals(names.get(1))
                        && client1.getPatronymic().equals(names.get(2))
                ).findFirst().get();

        List<String> routes = Arrays.stream(route.getRoutes().split("_")).toList();
        System.out.printf(routes.toString());
        RouteLog routeLog = serciveRoute.getAll().
                stream().
                filter(routeLog1 -> routeLog1.getCountry().getName().equals(routes.get(0))
                        && routeLog1.getCountry().getLevelTourism()==Integer.parseInt(routes.get(1).replace("LevelTourism:",""))
                        && routeLog1.getRoute().getCost()==Integer.parseInt(routes.get(2).replace("Cost:",""))
                        && routeLog1.getCountry().getClimateTypes().toString().equals(routes.get(3).replace("Climate:",""))
                        && routeLog1.getRoute().getDuration().toString().equals(routes.get(4).replace("Duration:","")))
                .findFirst().get();

        Voucher voucher = new Voucher();
        voucher.setName(route.getName());
        voucher.setNumber(route.getNumber());
        voucher.setStart(LocalDateTime.now());
        int percentage = Integer.parseInt(client.getDiscountPercentage());
        if(percentage == 0)
            percentage = 1;
        voucher.setTotalCost((double) ((route.getNumber()*routeLog.getRoute().getCost())/percentage));



        voucher.setDescription(route.getDescription());

        VoucherLog voucherLog = new VoucherLog();

        voucherLog.setVoucher(voucher);
        voucherLog.setClient(client);
        voucherLog.setName("");
        voucherLog.setDescription("");

        service.create(voucher);
        serviceVoucherLog.create(voucherLog);

        serviceClient.updatePercentage(client);
//
//        Route route1 = new Route();
//        route1.setDuration(route.getDuration());
//        route1.setCost(route.getCost());
//        route1.setName(route.getName());
//        route1.setDescription(route.getDescription());
//
//        service.create(route1);
//

//        Country country = serviceCountry.getAll().stream()
//                .filter(country1 -> country1.getName().equals(route.getCountries()))
//                .findFirst().get();
//
//        RouteLog routeLog = new RouteLog();
//        routeLog.setRoute(route1);
//        routeLog.setClient(client);
//        routeLog.setCountry(country);
//        routeLog.setHotel(route.getHotel());
//        serviceIRouteLog.create(routeLog);

        return "redirect:/ui/v1/vouchers/";
    }
    @GetMapping(value = "/edit/{id}")
    public String updateItem(Model model, @PathVariable("id") String id){
//        RouteLog itemForm = serviceIRouteLog.get(id);
//        RouteLog itemToUpdate = new RouteLog();
//
//        itemToUpdate.setId(itemForm.getId());
//        itemToUpdate.setName(itemForm.getName());
//        itemToUpdate.setDescription(itemForm.getDescription());
//        itemToUpdate.setCreatedAt(itemForm.getCreatedAt());
//        //itemToUpdate.setUpdatedAt(LocalDateTime.now());////????????
//
//        //itemToUpdate.setCost(itemForm.getCost());
//        //itemToUpdate.setDuration(itemForm.getDuration());
//
//        var countries = serviceCountry.getAll().stream().map(Country::getName).collect(Collectors.toList());
//        var clients = serviceClient.getFullName();
//
//        model.addAttribute("item", itemForm);
//        model.addAttribute("countries", countries);
//        model.addAttribute("clients", clients);
//        model.addAttribute("hotels", Hotels.values());
        //model.addAttribute("enums", ClimateTypes.values());
        return "updateRoute";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateCountry( @ModelAttribute("form") RouteClientCountry form){
        //System.out.println(form);

//        formRouteLog itemForm = serviceIRouteLog.get(form.getId());
//
//
//        RouteLog itemtoUpdate = new RouteLog();
//        itemtoUpdate.setId(form.getId());
//        itemtoUpdate.setName(form.getName());
//        itemtoUpdate.setDescription(form.getDescription());
//        itemtoUpdate.setCreatedAt(itemForm.getCreatedAt());
//        //itemtoUpdate.setUpdatedAt(LocalDateTime.now());////????????
//
//        List<String> names = Arrays.stream(form.getClients().split("_")).toList();
//        Client client = serviceClient.getAll().
//                stream().
//                filter(client1 -> client1.getFirstName().equals(names.get(0))
//                        && client1.getLastName().equals(names.get(1))
//                        && client1.getPatronymic().equals(names.get(2))
//                ).findFirst().get();
//        Country country = serviceCountry.getAll().stream()
//                .filter(country1 -> country1.getName().equals(form.getCountries()))
//                .findFirst().get();
//        Route routeLog = itemForm.getRoute();
//        routeLog.setCost(form.getCost());
//        routeLog.setDuration(form.getDuration());
//
//        itemtoUpdate.setCountry(country);
//        itemtoUpdate.setClient(client);
//        itemtoUpdate.setHotel(form.getHotel());
//        itemtoUpdate.setRoute(routeLog);
//
//        service.update(routeLog);
//
//        serviceIRouteLog.update(itemtoUpdate);

        return "redirect:/ui/v1/vouchers/";
    }
}
