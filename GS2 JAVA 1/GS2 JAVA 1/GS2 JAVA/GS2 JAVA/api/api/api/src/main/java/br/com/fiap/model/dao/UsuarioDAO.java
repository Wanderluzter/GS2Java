package br.com.fiap.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Usuario;
public class UsuarioDAO {
    public Connection minhaConexao;
    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }
    // Insert
    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement
                ("INSERT INTO USUARIO (EMAIL_US, NOME_US, TELEFONE_US, CEP_US, SENHA_US) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, usuario.getEmailUs());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getCepUs());
            stmt.setString(5, usuario.getSenha());
            stmt.execute();
            return "Cadastrado com Sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    // Delete
    public String deletar(String emailUs) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement
                ("DELETE FROM USUARIO WHERE EMAIL_US = ?");
            stmt.setString(1, emailUs);
            stmt.execute();
            return "Deletado com Sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    // Update
    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement
                ("UPDATE USUARIO SET NOME_US = ?, TELEFONE_US = ?, CEP_US = ?, SENHA_US = ? WHERE EMAIL_US = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getCepUs());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmailUs());
            stmt.executeUpdate();
            return "Atualizado com Sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    // Select
    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM USUARIO");
            rs = stmt.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setEmailUs(rs.getString(1));
                usuario.setNome(rs.getString(2));
                usuario.setTelefone(rs.getString(3));
                usuario.setCepUs(rs.getString(4));
                usuario.setSenha(rs.getString(5));
                listaUsuario.add(usuario);
            }
            return listaUsuario;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
    public Usuario selecionarUm(String email) throws SQLException {
        // Prepare a consulta SQL
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL_US = ?");
        stmt.setString(1, email);
        // Execute a consulta e obtenha o ResultSet
        ResultSet rs = stmt.executeQuery();
        // Processa o resultado, se houver
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setEmailUs(rs.getString(1));
            usuario.setNome(rs.getString(2));
            usuario.setTelefone(rs.getString(3));
            usuario.setCepUs(rs.getString(4));
            usuario.setSenha(rs.getString(5));
            // Fecha recursos
            rs.close();
            stmt.close();
            minhaConexao.close();
            return usuario;
        }
        // Fecha recursos caso não haja resultados
        rs.close();
        stmt.close();
        minhaConexao.close();
        return null;
    }
}