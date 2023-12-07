/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2.ep.ServiceImpl;

import EjercicioPractico2.ep.Dao.RoleDao;
import EjercicioPractico2.ep.Domain.Role;
import EjercicioPractico2.ep.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleById(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    // Otros métodos implementados
}
