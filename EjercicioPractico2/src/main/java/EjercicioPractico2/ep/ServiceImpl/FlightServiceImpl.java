/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.ServiceImpl;

import EjercicioPractico2.ep.Dao.FlightDao;
import EjercicioPractico2.ep.Domain.Flight;
import EjercicioPractico2.ep.Service.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDao flightDao;

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.findAll();
    }
    public List<Flight> getAvailableFlights() {
        return flightDao.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightDao.findById(id).orElse(null);
    }

    // Otros métodos implementados
}