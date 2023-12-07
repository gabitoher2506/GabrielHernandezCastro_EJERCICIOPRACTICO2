/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.ServiceImpl;

import EjercicioPractico2.ep.Dao.ReservationDao;
import EjercicioPractico2.ep.Domain.Reservation;
import EjercicioPractico2.ep.Service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public Reservation getReservationById(Long id) {
        return reservationDao.findById(id).orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    // Otros métodos implementados
}
