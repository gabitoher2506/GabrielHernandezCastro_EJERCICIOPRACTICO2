/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.Service;


import EjercicioPractico2.ep.Domain.Client;
import java.util.List;

public interface ClientService {
    Client getClientById(Long id);
    Client getClientByUsername(String username);
    List<Client> getAllClients();
    // Otros métodos relacionados con clientes
}