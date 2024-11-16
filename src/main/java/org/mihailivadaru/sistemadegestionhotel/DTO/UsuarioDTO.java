package org.mihailivadaru.sistemadegestionhotel.DTO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private String email;
    private String password;
    private List<Long> rolesIds = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRolesIds() {
        return rolesIds;
    }

    public void setRolesIds(List<Long> rolesIds) {
        this.rolesIds = rolesIds;
    }
}
