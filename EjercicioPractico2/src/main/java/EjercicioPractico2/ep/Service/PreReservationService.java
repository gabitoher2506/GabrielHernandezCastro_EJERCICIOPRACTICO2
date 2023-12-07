/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.Service;

import EjercicioPractico2.ep.Domain.PreReservation;
import java.util.List;

public interface PreReservationService {
    List<PreReservation> getAllPreReservations();
    PreReservation getPreReservationById(Long id);
    // Otros métodos relacionados con pre-reservas
}
