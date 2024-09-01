/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.utilities.FileUtils;
import hr.algebra.utilities.IconUtils;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.model.ArticleTableModel;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author trisek
 */
public class UserPanel extends javax.swing.JPanel {
    
    private static final String DIR = "assets";

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;
    private ArrayList<String> categories;

    private Repository repository;
    private ArticleTableModel articlesTableModel;

    private Article selectedArticle;
    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbLink = new javax.swing.JLabel();
        tfLink = new javax.swing.JTextField();
        lbDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticles = new javax.swing.JTable();
        lbIcon = new javax.swing.JLabel();
        tfPicturePath = new javax.swing.JTextField();
        btnChooseImage = new javax.swing.JButton();
        cbCategory = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();
        lbDescriptionError = new javax.swing.JLabel();
        lbTitleError = new javax.swing.JLabel();
        lbLinkError = new javax.swing.JLabel();
        lbPicturePathError = new javax.swing.JLabel();
        lbCategoryError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        tfAddCategory = new javax.swing.JTextField();

        setBackground(new java.awt.Color(238, 243, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbTitle.setText("Title");

        lbLink.setText("Link");

        lbDescription.setText("Description");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tbArticles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Link", "Title 3", "Title 4"
            }
        ));
        tbArticles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArticlesMouseClicked(evt);
            }
        });
        tbArticles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbArticlesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbArticles);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lbIcon.setMaximumSize(new java.awt.Dimension(349, 264));
        lbIcon.setMinimumSize(new java.awt.Dimension(349, 264));
        lbIcon.setPreferredSize(new java.awt.Dimension(349, 264));

        tfPicturePath.setEditable(false);

        btnChooseImage.setText("Choose");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        btnAddCategory.setText("Add Category");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        lbDescriptionError.setForeground(new java.awt.Color(204, 0, 0));
        lbDescriptionError.setText("X");

        lbTitleError.setForeground(new java.awt.Color(204, 0, 0));
        lbTitleError.setText("X");

        lbLinkError.setForeground(new java.awt.Color(204, 0, 0));
        lbLinkError.setText("X");

        lbPicturePathError.setForeground(new java.awt.Color(204, 0, 0));
        lbPicturePathError.setText("X");

        lbCategoryError.setForeground(new java.awt.Color(204, 0, 0));
        lbCategoryError.setText("X");

        jLabel2.setText("Category");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCategoryError)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChooseImage))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfAddCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddCategory)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPicturePathError)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbDescriptionError))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbLink, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbLinkError))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbTitleError))
                                    .addComponent(jLabel2)
                                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                        .addComponent(tfLink))
                    .addContainerGap(429, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChooseImage)
                            .addComponent(lbPicturePathError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddCategory)
                            .addComponent(tfAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLink, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(lbLinkError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lbDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCategoryError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd)
                                    .addComponent(btnUpdate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addGap(28, 28, 28)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(459, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
            return;
        }
        if (!formValid()) {
            return;
        }
        try {
            if (!tfPicturePath.getText().trim().equals(selectedArticle.getPicturePath())) {
                if (selectedArticle.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
                }
                String localPicturePath = uploadPicture();
                selectedArticle.setPicturePath(localPicturePath);
            }

            selectedArticle.setTitle(tfTitle.getText().trim());
            selectedArticle.setLink(tfLink.getText().trim());
            selectedArticle.setDescription(taDescription.getText().trim());
            selectedArticle.setCategory((String) cbCategory.getSelectedItem());
            repository.updateArticle(selectedArticle.getId(), selectedArticle);
            articlesTableModel.setArticles(repository.selectArticles());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to update article!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!formValid()) {
            return;
        }
        try {
            String localPicturePath = uploadPicture();
            
            Article article = new Article(
                tfTitle.getText().trim(),
                tfLink.getText().trim(),
                taDescription.getText().trim(),
                localPicturePath,
                (String)cbCategory.getSelectedItem()
            );
            repository.createArticle(article);
            articlesTableModel.setArticles(repository.selectArticles());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to create article!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
            "Delete article",
            "Do you really want to delete article?")) {
        try {
            if (selectedArticle.getPicturePath() != null) {
                Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
            }
            repository.deleteArticle(selectedArticle.getId());
            articlesTableModel.setArticles(repository.selectArticles());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to delete article!");
        }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbArticlesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbArticlesKeyReleased
        showArticle();
    }//GEN-LAST:event_tbArticlesKeyReleased

    private void tbArticlesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArticlesMouseClicked
        showArticle();
    }//GEN-LAST:event_tbArticlesMouseClicked

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to set icon!");
        }
    }
    
    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        File file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (file == null) {
            return;
        }
        tfPicturePath.setText(file.getAbsolutePath());
                setIcon(lbIcon, file);
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        try {
            if (tfAddCategory.getText().trim().isEmpty()) {
                MessageUtils.showErrorMessage("Warning", "Name of the category can't be empty!");
            } else {
                String category = tfAddCategory.getText().trim();
                repository.createCategory(category);
                loadCategoryListModel();
                MessageUtils.showInformationMessage("Info", "New category successfully created!");
            }
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error", "Failed to create new category!");
        }
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCategoryError;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbDescriptionError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbLink;
    private javax.swing.JLabel lbLinkError;
    private javax.swing.JLabel lbPicturePathError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbArticles;
    private javax.swing.JTextField tfAddCategory;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
            initTable();
            loadCategoryListModel();
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfTitle, tfLink, taDescription, tfPicturePath);
        errorLabels = Arrays.asList(lbTitleError, lbLinkError, lbDescriptionError, lbCategoryError, lbPicturePathError);
    }

    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbArticles.setAutoCreateRowSorter(true);
        tbArticles.setRowHeight(25);
        articlesTableModel = new ArticleTableModel(repository.selectArticles());
        tbArticles.setModel(articlesTableModel);
    }

    private boolean formValid() {
        hideErrors();
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
        }
        return ok;
    }

    private void clearForm() {
        hideErrors();
        validationFields.forEach(e -> e.setText(""));
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png")));
        selectedArticle = null;
    }

    private void loadCategoryListModel() {
        try {
        categories = new ArrayList(repository.selectAllCategories());
        cbCategory.setModel(new DefaultComboBoxModel<>(categories.toArray(String[]::new)));
        } catch (Exception ex) {
        }
    }
    private String uploadPicture() throws IOException {
        String picturePath = tfPicturePath.getText();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;

        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private void showArticle() {
        clearForm();
        int selectedRow = tbArticles.getSelectedRow();
        int rowIndex = tbArticles.convertRowIndexToModel(selectedRow);
        int selectedArticleId = (int) articlesTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Article> optArticle = repository.selectArticle(selectedArticleId);
            if (optArticle.isPresent()) {
                selectedArticle = optArticle.get();
                fillForm(selectedArticle);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show article!");
        }
    }

    private void fillForm(Article article) {
        if (article.getPicturePath() != null && Files.exists(Paths.get(article.getPicturePath()))) {
            tfPicturePath.setText(article.getPicturePath());
            setIcon(lbIcon, new File(article.getPicturePath()));
        }
        tfTitle.setText(article.getTitle());
        tfLink.setText(article.getLink());
        taDescription.setText(article.getDescription());
        cbCategory.setSelectedItem(article.getCategory());
    }
}
