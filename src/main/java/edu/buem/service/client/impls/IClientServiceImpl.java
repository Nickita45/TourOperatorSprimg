package edu.buem.service.client.impls;

import edu.buem.model.Client;
import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.repository.client.ClientMongoRepository;
import edu.buem.repository.routelog.RouteLogMongoRepository;
import edu.buem.repository.voucherlog.VoucherLogMongoRepository;
import edu.buem.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IClientServiceImpl implements IClientService {
    private ArrayList<Client> clients = new ArrayList<Client>(Arrays.asList(
            new Client("1", "name1", "","Mykyta","Plotnikov","Stanislavovich","adress1","43939905","0"),
            new Client("2", "name1", "","Vova","Lakusta","-","adress2","656454353","0")

            ));
    @PostConstruct
    void init()
    {
        //repository.saveAll(clients);
    }
    @Autowired
    ClientMongoRepository repository;
    @Autowired
    RouteLogMongoRepository repositoryRouteLog;
    @Autowired
    VoucherLogMongoRepository repositoryVoucherLog;
    @Override
    public Client create(Client client) {
        client.setId(UUID.randomUUID().toString());
        client.setCreatedAt(LocalDateTime.now());
        client.setDiscountPercentage("0");
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Client update(Client client) {
        client.setUpdatedAt(LocalDateTime.now());

        var listRoutes = repositoryRouteLog.findAll().stream()
                .filter(routeLog -> routeLog.getClient().getId().equals(client.getId()))
                .collect(Collectors.toList());
        listRoutes.stream().forEach(routeLog -> {routeLog.setClient(client);});
        repositoryRouteLog.saveAll(listRoutes);

        var listVouchers = repositoryVoucherLog.findAll().stream()
                .filter(routeLog -> routeLog.getClient().getId().equals(client.getId()))
                .collect(Collectors.toList());
        listVouchers.stream().forEach(routeLog -> {routeLog.setClient(client);});
        repositoryVoucherLog.saveAll(listVouchers);

        return repository.save(client);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public List<String> getFullName() {
        var names = repository.findAll()
                .stream()
                .map(client -> String.format("%s_%s_%s", client.getFirstName(), client.getLastName(),client.getPatronymic()))
                .collect(Collectors.toList());
        return names;
    }

    @Override
    public void updatePercentage(Client client) {
        int countBuys = 4 + (int) repositoryVoucherLog.findAll().stream()
                .filter(voucherLog -> voucherLog.getClient().getId().equals(client.getId()))
                .count();
        client.setDiscountPercentage(""+countBuys);
        repository.save(client);
    }


}
