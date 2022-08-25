package edu.buem.service.client.interfaces;

import edu.buem.model.Client;
import edu.buem.model.Country;

import java.util.List;

public interface IClientService {
    //Crud
    Client create(Client discount);
    Client get(String id);
    Client update(Client discount);
    void delete(String id);
    List<Client> getAll();
    List<String> getFullName();

    void updatePercentage(Client client);
}