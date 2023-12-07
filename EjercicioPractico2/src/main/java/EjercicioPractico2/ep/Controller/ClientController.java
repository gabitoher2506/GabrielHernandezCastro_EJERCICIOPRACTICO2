/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.Controller;

import EjercicioPractico2.ep.Domain.Client;
import EjercicioPractico2.ep.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Mapeo para mostrar la lista de clientes
    @GetMapping("/list")
    public String listClients(Model model, Authentication authentication) {
        // Obtener el nombre de usuario del objeto Authentication
        String username = authentication.getName();

        // Verificar si el usuario tiene el rol de administrador
        boolean isAdmin = clientService.getClientByUsername(username).getRole().getNombre().equals("ROLE_ADMIN");

        if (isAdmin) {
            // Si es administrador, cargar la lista de clientes y mostrar la vista correspondiente
            model.addAttribute("clients", clientService.getAllClients());
            return "clients/list";
        } else {
            // Si no es administrador, redirigir a la página principal
            return "redirect:/";
        }
    }

    // Mapeo para mostrar el formulario de agregar cliente
    @GetMapping("/add")
    public String showAddClientForm(Model model) {
        // Lógica para mostrar el formulario de agregar cliente
        return "clients/add";
    }

    // Mapeo para agregar un nuevo cliente
    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client, RedirectAttributes redirectAttributes) {
        // Lógica para agregar cliente
        // Redirigir a la lista de clientes después de agregar
        return "redirect:/clients/list";
    }

    // Mapeo para mostrar el formulario de editar cliente
    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable Long id, Model model) {
        // Lógica para mostrar el formulario de editar cliente
        return "clients/edit";
    }

    // Mapeo para editar un cliente existente
    @PostMapping("/edit/{id}")
    public String editClient(@PathVariable Long id, @ModelAttribute Client client, RedirectAttributes redirectAttributes) {
        // Lógica para editar cliente
        // Redirigir a la lista de clientes después de editar
        return "redirect:/clients/list";
    }

    // Mapeo para eliminar un cliente
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Lógica para eliminar cliente
        // Redirigir a la lista de clientes después de eliminar
        return "redirect:/clients/list";
    }
}
