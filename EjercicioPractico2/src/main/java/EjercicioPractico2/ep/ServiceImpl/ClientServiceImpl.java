/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.ServiceImpl;

import EjercicioPractico2.ep.Dao.ClientDao;
import EjercicioPractico2.ep.Domain.Client;
import EjercicioPractico2.ep.Service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getClientById(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientDao.findByUsername(username);
    }
     @Override
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }
    // Otros métodos implementados
}
