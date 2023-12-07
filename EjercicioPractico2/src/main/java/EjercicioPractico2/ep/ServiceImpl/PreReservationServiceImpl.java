/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.ServiceImpl;

import EjercicioPractico2.ep.Dao.PreReservationDao;
import EjercicioPractico2.ep.Domain.PreReservation;
import EjercicioPractico2.ep.Service.PreReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreReservationServiceImpl implements PreReservationService {

    @Autowired
    private PreReservationDao preReservationDao;

    @Override
    public PreReservation getPreReservationById(Long id) {
        return preReservationDao.findById(id).orElse(null);
    }
    public List<PreReservation> getAllPreReservations() {
        return preReservationDao.findAll();
    }

    // Otros métodos implementados
}
