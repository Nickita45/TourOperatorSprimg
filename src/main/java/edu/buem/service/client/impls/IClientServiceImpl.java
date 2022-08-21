package edu.buem.service.client.impls;

import edu.buem.model.Client;
import edu.buem.repository.client.ClientMongoRepository;
import edu.buem.repository.country.CountryMongoRepository;
import edu.buem.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class IClientServiceImpl implements IClientService {
    @Autowired
    ClientMongoRepository repository;
    @Override
    public Client create(Client client) {
        client.setId(UUID.randomUUID().toString());
        client.setCreatedAt(LocalDateTime.now());
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
