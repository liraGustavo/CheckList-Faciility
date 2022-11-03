/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.Task;
import util.ConnectionFactory;


public class TaskDAO {

	private Connection conn; // conexao
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TaskDAO() throws Exception {

		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}
		}
    public void save1(Project project) {

        String sql = "INSERT INTO projects (name"
                + "description,"
                + "createdAt,"
                + "updatedAt,"
                + "VALUES (?,?,?,?)";

    
        try {
            // Cria uma Statement, classe usada para executar a query 
            ps =  conn.prepareStatement(sql);

            ps.setString(1, project.getName());
            ps.setString(2, project.getDescription());
            ps.setDate(3, new Date(project.getCreatedAt().getTime()));
            ps.setDate(4, new Date(project.getUpdatedAt().getTime()));


            // executa o sql para inserÃ§Ã£o dos dados
            ps.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void update(Task task) throws SQLException {

        String sql = "UPDATE projects SET "
                + "name =? ,"
                + "description =? ,"
                + "createdAt = ?,"
                + "updateAt =? ,"
                + "WHERE id = ?";

        // cria conexÃ£o com banco de dados
        Connection connection = null;

        // cria PreparedStatement, classe usada para preparar a query
        PreparedStatement statement = null;

        try {
            // cria uma conexÃ£o com banco de dados
            connection = ConnectionFactory.getConnection();

            // Cria uma Statement, classe usada para executar a query 
            statement = connection.prepareStatement(sql);

            // setando os valores
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.setInt(5, task.getId());

            // executa a sql para inserÃ§Ã£o dos dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    
    public List<Project> getAll() {

        String sql = "SELECT *FROM projects";

        List<Project> projects = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
        try {
            // conexÃ£o com banco de dados    
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {

                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("update"));

                projects.add(project);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar o projeto", ex);
        } finally {
           //ConnectionFactory.closeConnetion(Connection, statement, resultSet);
        }
        return projects;
        
       
    }
    
public void removeById (int idProject){
 
    String sql = "Delete FROM projects Where by id = ?";
    
    Connection connection = null;
    PreparedStatement statemente = null;
    
    try {
        
       connection = ConnectionFactory.getConnection();
       statemente = connection.prepareStatement(sql);
       statemente.setInt(1, idProject);
       statemente.execute();
       
    } catch (Exception ex) {
        throw new RuntimeException ("Erro ao deletar o projeto", ex);   
    }
   finally{
     ConnectionFactory.closeConnection(connection, statemente);
    } 
    
}

    public void save(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	public void save(Task task) {
		// TODO Auto-generated method stub
		
	}

	public List<Task> getByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}
    
}


    