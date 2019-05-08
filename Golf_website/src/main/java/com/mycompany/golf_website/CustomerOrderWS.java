package com.mycompany.golf_website;



import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customer")
public class CustomerOrderWS {

    @EJB
    private CustomerOrderService customerOrderService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        String lastOrder = customerOrderService.findLastOrder();
        List<CustomerOrder> orders = customerOrderService.findByName(lastOrder);
        CustomerOrderDTO[] dtos = toDTOs(orders);
        System.out.println("dtos!!!!!!!!!"+ dtos);
        return Response.ok(dtos).build();
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response write(CustomerOrderDTO dto) {
        CustomerOrder u = new CustomerOrder();
        u.setCreditNumber(dto.getCreditNumber());
        u.setPhoneNumber(dto.getPhoneNumber());
        u.setCustomerName(dto.getCustomerName());
        u.setItemName(dto.getItemName());
        u.setItemQuantity(dto.getItemQuantity());
        u.setPrice(dto.getPrice());
        customerOrderService.persist(u);
        return Response.ok("").build();
    }
    
    private CustomerOrderDTO[] toDTOs(List<CustomerOrder> customers) {
        CustomerOrderDTO[] dtos = new CustomerOrderDTO[customers.size()];
        for (int i = 0; i < dtos.length; i++) {
            CustomerOrder Co = customers.get(i);
            dtos[i] = new CustomerOrderDTO(Co);
        }
        return dtos;
    }
}
