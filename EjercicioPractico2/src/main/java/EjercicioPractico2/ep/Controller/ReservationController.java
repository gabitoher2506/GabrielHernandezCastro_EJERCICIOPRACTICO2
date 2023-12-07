/*
 * Controlador para la gestión de reservas.
 */
package EjercicioPractico2.ep.Controller;

import EjercicioPractico2.ep.Domain.Reservation;
import EjercicioPractico2.ep.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Mapeo para mostrar la lista de reservas
    @GetMapping("/list")
    public String listReservations(Model model, Authentication authentication) {
        // Lógica para mostrar la lista de reservas
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations/list";
    }

    // Mapeo para mostrar el formulario de agregar reserva
    @GetMapping("/add")
    public String showAddReservationForm(Model model) {
        // Lógica para mostrar el formulario de agregar reserva
        return "reservations/add";
    }

    // Mapeo para agregar una nueva reserva
    @PostMapping("/add")
    public String addReservation(@ModelAttribute Reservation reservation, RedirectAttributes redirectAttributes) {
        // Lógica para agregar reserva
        // Redirigir a la lista de reservas después de agregar
        return "redirect:/reservations/list";
    }

    // Mapeo para mostrar el formulario de editar reserva
    @GetMapping("/edit/{id}")
    public String showEditReservationForm(@PathVariable Long id, Model model) {
        // Lógica para mostrar el formulario de editar reserva
        return "reservations/edit";
    }

    // Mapeo para editar una reserva existente
    @PostMapping("/edit/{id}")
    public String editReservation(@PathVariable Long id, @ModelAttribute Reservation reservation, RedirectAttributes redirectAttributes) {
        // Lógica para editar reserva
        // Redirigir a la lista de reservas después de editar
        return "redirect:/reservations/list";
    }

    // Mapeo para eliminar una reserva
    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Lógica para eliminar reserva
        // Redirigir a la lista de reservas después de eliminar
        return "redirect:/reservations/list";
    }
}
