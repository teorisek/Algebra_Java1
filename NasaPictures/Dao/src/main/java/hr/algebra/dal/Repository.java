/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.Article;
import hr.algebra.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultListModel;

/**
 *
 * @author trisek
 */
public interface Repository {
    

    void createUser(User user) throws Exception;

    int checkUser(User user) throws Exception;
    
    int createArticle(Article article) throws Exception;

    void createArticles(List<Article> articles) throws Exception;

    void updateArticle(int id, Article data) throws Exception;

    void deleteArticle(int id) throws Exception;
    
    void deleteAllArticles() throws Exception;

    Optional<Article> selectArticle(int id) throws Exception;

    List<Article> selectArticles() throws Exception;
    
    ArrayList<String> selectAllCategories() throws Exception;
    
    void createCategory(String category) throws Exception;
    
    DefaultListModel<String> getAllUsers()throws Exception;
    
    void promoteUsers(DefaultListModel<String> UserList) throws Exception;

}
