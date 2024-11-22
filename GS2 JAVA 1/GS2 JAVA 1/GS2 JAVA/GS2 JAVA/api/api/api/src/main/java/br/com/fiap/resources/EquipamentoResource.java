package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.model.bo.EquipamentoBO;
import br.com.fiap.model.vo.Equipamento;



@Path("/equipamento") // Nome da página
public class EquipamentoResource {
	
    private EquipamentoBO equipamentoBO = new EquipamentoBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Equipamento equipamento, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
    	equipamentoBO.inserirBO(equipamento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder(); // Recebe a informação do front (página)
        builder.path(String.valueOf(equipamento.getId())); // Identifica o e-mail do usuário
        return Response.created(builder.build()).build(); // Composição -> caminho (carregar o que foi carregado) - http -> 200
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{idEquip}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaRs(Equipamento equipamento, @PathParam("idEquip") int idEquip) throws ClassNotFoundException, SQLException {
    	equipamento.setId(idEquip); // Define o e-mail para atualizar o usuário correto
    	equipamentoBO.atualizarBO(equipamento);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{idEquip}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idEquip") int idEquip) throws ClassNotFoundException, SQLException {
    	equipamentoBO.deletarBO(idEquip);
        return Response.ok().build();
    }

    // Consultar (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Equipamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Equipamento>) equipamentoBO.selecionarBO();
    }
    
 // Consultar usuário por e-mail (GET)
    @GET
    @Path("/{idEquip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorEmail(@PathParam("idEquip") int idEquip) throws ClassNotFoundException, SQLException {
    	Equipamento equipamento = equipamentoBO.selecionarUmBO(idEquip); // Usa o método na camada BO
        if (equipamento != null) {
            return Response.ok(equipamento).build(); // Retorna o usuário encontrado com status 200 OK
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); // Retorna 404 se o usuário não for encontrado
        }
    }

}
