/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Article;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import javax.swing.DefaultListModel;

public class SqlRepository implements Repository{
    
    //user part
    private static final String USERNAME = "Uname";
    private static final String PASSWORD = "Upass";
    private static final String USERTYPE = "Utype";
    
    private static final String CREATE_USER = "{ CALL createUser (?,?,?) }";
    private static final String CHECK_USER = "{ CALL checkUser (?,?,?) }";
    private static final String GET_ALL_USERS = "{ CALL getAllUsers () }";
    private static final String PROMOTE_USERS = "{ CALL promoteUsers (?) }";
    

    //media part
    private static final String ID_ARTICLE = "IDArticle";
    private static final String TITLE = "Title";
    private static final String LINK = "Link";
    private static final String DESCRIPTION = "Description";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String CATEGORY = "Category";
    private static final String CATEGORY_NAME = "Name";

    private static final String CREATE_ARTICLE = "{ CALL createArticle (?,?,?,?,?,?) }";
    private static final String UPDATE_ARTICLE = "{ CALL updateArticle (?,?,?,?,?,?) }";
    private static final String DELETE_ARTICLE = "{ CALL deleteArticle (?) }";
    private static final String SELECT_ARTICLE = "{ CALL selectArticle (?) }";
    private static final String SELECT_ARTICLES = "{ CALL selectArticles }";
    private static final String DELETE_ALL_ARTICLES = "{ CALL deleteAllArticles }";
    private static final String SELECT_ALL_CATEGORIES = "{ CALL selectAllCategories }";
    private static final String CREATE_CATEGORY = "{ CALL createCategory (?) }";
    

    // user
    @Override
    public void createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {
            stmt.setString(USERNAME, user.getUsername());
            stmt.setString(PASSWORD, user.getPassword());
            stmt.setInt(USERTYPE, user.getUserType());

            stmt.executeUpdate();
        }
    }
    
    @Override
    public int checkUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CHECK_USER)) {
            
            stmt.setString(USERNAME, user.getUsername());
            stmt.setString(PASSWORD, user.getPassword());
            stmt.registerOutParameter(USERTYPE, Types.INTEGER);
            
            stmt.executeUpdate();
            return stmt.getInt(USERTYPE);
        }
    }

    @Override
    public DefaultListModel<String> getAllUsers() throws Exception {
        DefaultListModel<String> allUsers = new DefaultListModel<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_USERS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                allUsers.addElement(rs.getString(USERNAME));
            }
        }
        return allUsers;
    }
    
    @Override
    public void promoteUsers(DefaultListModel<String> userList) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection()) {
            for (int i = 0; i < userList.size(); i++){
                String username = userList.getElementAt(i);
                try(CallableStatement stmt = con.prepareCall(PROMOTE_USERS)){              
                    stmt.setString(USERNAME, username);
                    stmt.executeUpdate();   
                }
            }
        }
    }
    
    
    // media
    @Override
    public int createArticle(Article article) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            stmt.setString(TITLE, article.getTitle());
            stmt.setString(LINK, article.getLink());
            stmt.setString(DESCRIPTION, article.getDescription());
            stmt.setString(PICTURE_PATH, article.getPicturePath());
            stmt.setString(CATEGORY, article.getCategory());
            stmt.registerOutParameter(ID_ARTICLE, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(ID_ARTICLE);
        }
    }
    
    @Override
    public void deleteAllArticles() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_ARTICLES)) {

            stmt.executeUpdate();
        }
    }

    @Override
    public void createArticles(List<Article> articles) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            for (Article article : articles) {
                stmt.setString(TITLE, article.getTitle());
                stmt.setString(LINK, article.getLink());
                stmt.setString(DESCRIPTION, article.getDescription());
                stmt.setString(PICTURE_PATH, article.getPicturePath());
                stmt.setString(CATEGORY, article.getCategory());
                stmt.registerOutParameter(ID_ARTICLE, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateArticle(int id, Article data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_ARTICLE)) {

            stmt.setString(TITLE, data.getTitle());
            stmt.setString(LINK, data.getLink());
            stmt.setString(DESCRIPTION, data.getDescription());
            stmt.setString(PICTURE_PATH, data.getPicturePath());
            stmt.setString(CATEGORY, data.getCategory());
            stmt.setInt(ID_ARTICLE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteArticle(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ARTICLE)) {

            stmt.setInt(ID_ARTICLE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Article> selectArticle(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ARTICLE)) {

            stmt.setInt(ID_ARTICLE, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Article(
                            rs.getInt(ID_ARTICLE),
                            rs.getString(TITLE),
                            rs.getString(LINK),
                            rs.getString(DESCRIPTION),
                            rs.getString(PICTURE_PATH),
                            rs.getString(CATEGORY)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Article> selectArticles() throws Exception {
        List<Article> articles = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ARTICLES); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                articles.add(new Article(
                        rs.getInt(ID_ARTICLE),
                        rs.getString(TITLE),
                        rs.getString(LINK),
                        rs.getString(DESCRIPTION),
                        rs.getString(PICTURE_PATH),
                        rs.getString(CATEGORY)));
            }
        }
        return articles;
    }
    
    @Override
    public ArrayList<String> selectAllCategories() throws Exception {
        ArrayList<String> categories = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_CATEGORIES); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString(CATEGORY_NAME));
            }
        }
        return categories;
    }

    @Override
    public void createCategory(String category) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_CATEGORY)) {
            stmt.setString(CATEGORY_NAME, category);
            
            stmt.executeUpdate();
        }
    }
    
}
