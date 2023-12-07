package EjercicioPractico2.ep.Controller;

import EjercicioPractico2.ep.Domain.Flight;
import EjercicioPractico2.ep.Service.ClientService;
import EjercicioPractico2.ep.Service.FlightService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private ClientService clientService;

    // Mapeo para mostrar la lista de vuelos
    @GetMapping("/list")
    public String listFlights(Model model, Authentication authentication) {
        // Obtener el nombre de usuario del objeto Authentication
        String username = authentication.getName();
        
        // Verificar si el usuario tiene el rol de administrador
        boolean isAdmin = clientService.getClientByUsername(username).getRole().getNombre().equals("ROLE_ADMIN");

        if (isAdmin) {
            // Si es administrador, cargar la lista completa de vuelos y mostrar la vista correspondiente
            model.addAttribute("flights", flightService.getAllFlights());
            return "flights/list";
        } else {
            // Si no es administrador, cargar la lista de vuelos disponibles para usuarios finales y mostrar la vista correspondiente
            model.addAttribute("flights", flightService.getAvailableFlights());
            return "flights/user-list";
        }
    }

    // Mapeo para mostrar el formulario de reserva de vuelo
    @GetMapping("/reserve/{id}")
    public String showReserveFlightForm(@PathVariable Long id, Model model) {
        // Lógica para mostrar el formulario de reserva de vuelo
        Flight flight = flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        return "flights/reserve";
    }

    // Mapeo para procesar la reserva del vuelo
    @PostMapping("/reserve/{id}")
    public String reserveFlight(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Lógica para procesar la reserva del vuelo
        // Redirigir a la página de confirmación
        return "redirect:/flights/confirm/{id}";
    }

    // Mapeo para mostrar la página de confirmación
    @GetMapping("/confirm/{id}")
    public String showConfirmationPage(@PathVariable Long id, Model model) {
        // Lógica para mostrar la página de confirmación
        Flight flight = flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        return "flights/confirm";
    }

    // Mapeo para finalizar la compra del boleto
    @PostMapping("/confirm/{id}")
    public String confirmBooking(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Lógica para finalizar la compra del boleto
        // Redirigir a la página de agradecimiento o a la lista de vuelos
        return "redirect:/flights/list";
    }
}
