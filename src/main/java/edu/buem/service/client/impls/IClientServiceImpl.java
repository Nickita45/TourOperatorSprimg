package edu.buem.service.client.impls;

import edu.buem.model.Client;
import edu.buem.model.ClimateTypes;
import edu.buem.model.Country;
import edu.buem.repository.client.ClientMongoRepository;
import edu.buem.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
}
