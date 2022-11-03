package controller;

import javax.swing.JOptionPane;

import model.Project;

public class teste {

	public static void main(String[] args) throws Exception {

		try {
			Project p = new Project(0,"Gustavo", "Teste", null, null, null);
			ProjectDAO dao = new ProjectDAO();
			dao.save(p);
			JOptionPane.showInputDialog("Produto inserido com Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

/*
 * public class Main {
 * 
 * Connection c = ConnectionFactory.getConnection();
 * 
 * //ConnectionFactory.closeConnection(c);
 * 
 * 
 * 
 * 
 * /* public static void main(String[] args) throws Exception {
 * 
 * 
 * ProjectDAO projectDAO = new ProjectDAO();
 * 
 * 
 * // Insere Projeto Project project = new Project(1, 2, "Faculdade",
 * "Estudar para a prova de Java"); projectDAO.save(project);
 * JOptionPane.showMessageDialog(null, "Produto inserido com Sucesso");
 * 
 * 
 * 
 * 
 * // Atualiza Proojecto Pelo CODIGO //Project project1 = new Project(2, 6,
 * "Celular","Samsung 15 p"); //projectDAO.update(project);
 * //JOptionPane.showMessageDialog(null, "Produto Atualizado com sucesso");
 * 
 * 
 * 
 * // Exclui Projeto Pelo CODIGO //projectDAO.removeById(1);
 * //JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
 * 
 * 
 * 
 * // Procurar projeto //System.out.println(projectDAO.getAll());
 * 
 * //JOptionPane.showMessageDialog(null, " projeto encontrado");
 * 
 * 
 * 
 * 
 * // Listar Projetos
 * 
 * //System.out.println(projectDAO.getAll());
 * 
 * 
 * 
 * 
 * } }
 */
