			package controller;
			
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.ConnectionFactory;
			
			/**
			 *
			 */
			public class ProjectDAO {
				private Connection conn; // conexao
				private PreparedStatement ps;
				private ResultSet rs;
				private Project projecto;
			
				
				public ProjectDAO() throws Exception {

					try {
						conn = ConnectionFactory.getConnection();
					} catch (Exception e) {
						throw new Exception("Erro: " + e.getMessage());
					}
					}
				
				
				
			    public void save(Project projecto) {
			        String sql = "INSERT INTO projects(id,"+ "name,description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";
			
			        try { 
			            
			            ps = conn.prepareStatement(sql);
			
			            ps.setString(1, projecto.getName());
			            ps.setString(2, projecto.getDescription());
			            ps.setDate(3, new java.sql.Date(projecto.getCreatedAt().getTime()));
			            ps.setDate(4, new java.sql.Date(projecto.getUpdatedAt().getTime()));
			            
			            ps.execute();
			        } catch (SQLException ex) {
			            throw new RuntimeException("Erro ao salvar o projeto", ex);
			        }/* finally {
			          
			            try {
			                if (ps != null) {
			                    ps.close();
			                }
			                if (conn != null) {
			                    conn.close();
			                }
			            } catch (SQLException ex) {
			                throw new RuntimeException("Erro ao fechar a conexÃ£o", ex);
			            }
			        }*/
			
			    }
			
			    public void update(Project project) {
			
			        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
			
			        Connection conn = null;
			        PreparedStatement stmt = null;
			
			        try {
			            //Cria uma conexï¿½o com o banco
			            conn = ConnectionFactory.getConnection();
			            //Cria um PreparedStatment, classe usada para executar a query
			            stmt = conn.prepareStatement(sql);
			
			            stmt.setString(1, project.getName());
			            stmt.setString(2, project.getDescription());
			            stmt.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
			            stmt.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
			            stmt.setInt(4, project.getId());
			
			            //Executa a sql para inserï¿½ï¿½o dos dados
			            stmt.execute();
			        } catch (SQLException ex) {
			            throw new RuntimeException("Erro em atualizar o projeto", ex);
			        } finally {
			            try {
			                if (stmt != null) {
			                    stmt.close();
			                }
			                if (conn != null) {
			                    conn.close();
			                }
			            } catch (SQLException ex) {
			                throw new RuntimeException("Erro ao fechar a conexÃ£o", ex);
			            }
			        }
			    }
			
			    public List<Project> getAll() {
			        String sql = "SELECT * FROM projects";
			
			        List<Project> projects = new ArrayList<>();
			
			        Connection conn = null;
			        PreparedStatement stmt = null;
			
			        //Classe que vai recuperar os dados do banco de dados
			        ResultSet rs = null;
			
			        try {
			            conn = ConnectionFactory.getConnection();
			            stmt = conn.prepareStatement(sql);
			
			            rs = stmt.executeQuery();
			
			            //Enquanto existir dados no banco de dados, faï¿½a
			            while (rs.next()) {
			
			                Project project = new Project();
			
			                project.setId(rs.getInt("id"));
			                project.setName(rs.getString("name"));
			                project.setDescription(rs.getString("description"));
			                project.setCreatedAt(rs.getDate("createdAt"));
			                project.setCreatedAt(rs.getDate("updatedAt"));
			
			                //Adiciono o contato recuperado, a lista de contatos
			                projects.add(project);
			            }
			        } catch (SQLException ex) {
			            throw new RuntimeException("Erro ao buscar os projetos", ex);
			        } finally {
			            try {
			                if (rs != null) {
			                    rs.close();
			                }
			                if (stmt != null) {
			                    stmt.close();
			                }
			                if (conn != null) {
			                    conn.close();
			                }
			            } catch (SQLException ex) {
			                throw new RuntimeException("Erro ao fechar a conexÃ£o", ex);
			            }
			        }
			        return projects;
			    }
			
			    public void removeById(int id) {
			
			        String sql = "DELETE FROM projects WHERE id = ?";
			
			        Connection conn = null;
			        PreparedStatement stmt = null;
			
			        try {
			            conn = ConnectionFactory.getConnection();
			            stmt = conn.prepareStatement(sql);
			            stmt.setInt(1, id);
			            stmt.execute();
			        } catch (SQLException ex) {
			            throw new RuntimeException("Erro ao deletar o projeto", ex);
			        } finally {
			            try {
			                if (stmt != null) {
			                    stmt.close();
			                }
			                if (conn != null) {
			                    conn.close();
			                }
			            } catch (SQLException ex) {
			                throw new RuntimeException("Erro ao fechar a conexÃ£o", ex);
			            }
			        }
			
			    }
			
			}