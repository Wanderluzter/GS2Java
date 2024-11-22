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

import br.com.fiap.model.bo.ContaBO;
import br.com.fiap.model.vo.Conta;

@Path("/conta") // Nome da página
public class ContaResource {

    private ContaBO contaBO = new ContaBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Conta conta, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        contaBO.inserirBO(conta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(conta.getId()));
        return Response.created(builder.build()).build();
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{idConta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaRs(Conta conta, @PathParam("idConta") int idConta) throws ClassNotFoundException, SQLException {
        conta.setId(idConta);
        contaBO.atualizarBO(conta);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{idConta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idConta") int idConta) throws ClassNotFoundException, SQLException {
        contaBO.deletarBO(idConta);
        return Response.ok().build();
    }

    // Consultar (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Conta> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Conta>) contaBO.selecionarBO();
    }

    // Consultar por ID (GET)
    @GET
    @Path("/{idConta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("idConta") int idConta) throws ClassNotFoundException, SQLException {
        Conta conta = contaBO.selecionarUmBO(idConta);
        if (conta != null) {
            return Response.ok(conta).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
