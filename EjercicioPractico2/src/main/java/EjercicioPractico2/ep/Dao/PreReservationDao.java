/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.Dao;


import EjercicioPractico2.ep.Domain.PreReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreReservationDao extends JpaRepository<PreReservation, Long> {
    // Métodos personalizados si es necesario
}