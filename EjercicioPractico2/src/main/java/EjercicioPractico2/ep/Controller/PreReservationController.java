/*
 * Controlador para la gestión de pre-reservas.
 */
package EjercicioPractico2.ep.Controller;

import EjercicioPractico2.ep.Domain.PreReservation;
import EjercicioPractico2.ep.Service.PreReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/prereservations")
public class PreReservationController {

    @Autowired
    private PreReservationService preReservationService;

    // Mapeo para mostrar la lista de pre-reservas
    @GetMapping("/list")
    public String listPreReservations(Model model, Authentication authentication) {
        // Lógica para mostrar la lista de pre-reservas
        model.addAttribute("prereservations", preReservationService.getAllPreReservations());
        return "prereservations/list";
    }

    // Mapeo para mostrar el formulario de agregar pre-reserva
    @GetMapping("/add")
    public String showAddPreReservationForm(Model model) {
        // Lógica para mostrar el formulario de agregar pre-reserva
        return "prereservations/add";
    }

    // Mapeo para agregar una nueva pre-reserva
    @PostMapping("/add")
    public String addPreReservation(@ModelAttribute PreReservation preReservation, RedirectAttributes redirectAttributes) {
        // Lógica para agregar pre-reserva
        // Redirigir a la lista de pre-reservas después de agregar
        return "redirect:/prereservations/list";
    }

    // Mapeo para mostrar el formulario de editar pre-reserva
    @GetMapping("/edit/{id}")
    public String showEditPreReservationForm(@PathVariable Long id, Model model) {
        // Lógica para mostrar el formulario de editar pre-reserva
        return "prereservations/edit";
    }

    // Mapeo para editar una pre-reserva existente
    @PostMapping("/edit/{id}")
    public String editPreReservation(@PathVariable Long id, @ModelAttribute PreReservation preReservation, RedirectAttributes redirectAttributes) {
        // Lógica para editar pre-reserva
        // Redirigir a la lista de pre-reservas después de editar
        return "redirect:/prereservations/list";
    }

    // Mapeo para eliminar una pre-reserva
    @GetMapping("/delete/{id}")
    public String deletePreReservation(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Lógica para eliminar pre-reserva
        // Redirigir a la lista de pre-reservas después de eliminar
        return "redirect:/prereservations/list";
    }
}
