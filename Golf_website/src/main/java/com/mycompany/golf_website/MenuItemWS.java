package com.mycompany.golf_website;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("menu")
public class MenuItemWS {

    @EJB
    private MenuItemService menuitemService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        List<MenuItem> menuitems = menuitemService.selectAll();
        MenuItemDTO[] dtos = toDTOs(menuitems);
        return Response.ok(dtos).build();
    }
    
    private MenuItemDTO[] toDTOs(List<MenuItem> menuitems) {
        MenuItemDTO[] dtos = new MenuItemDTO[menuitems.size()];
        for (int i = 0; i < dtos.length; i++) {
            MenuItem p = menuitems.get(i);
            dtos[i] = new MenuItemDTO(p);
        }
        return dtos;
    }
}
