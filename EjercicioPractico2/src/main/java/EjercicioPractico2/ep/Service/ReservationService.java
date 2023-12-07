/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.Service;

import EjercicioPractico2.ep.Domain.Reservation;


public interface ReservationService {
    Reservation getReservationById(Long id);
    // Otros métodos relacionados con reservas

    public Object getAllReservations();
}

