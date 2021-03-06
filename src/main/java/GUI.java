
//import com.mysql.cj.Session;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;

import java.util.Properties;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ernest
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public GUI() {
        initComponents();

        GUI gui = this;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);

                //Confirmation Panel
                JPanel confirmPanel = new JPanel();
                confirmPanel.add(new JLabel("Do you want to save your changes?"));
                int selectedOption = JOptionPane.showConfirmDialog(null, confirmPanel, "File",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                if (selectedOption == 0) {
                    System.out.println("Saving Emails...");
                    SaveEmails();
                    try {
                        // TODO add your handling code here:
                        SaveConfig.SaveConfiguration(new SaveConfig(gui.myNameField.getText(), gui.myEmailField.getText(), new String(gui.myPasswordFieldHidden.getPassword()), gui.emailContentField.getText(), "", Integer.parseInt(gui.daysUntilSendField.getValue().toString())));
                        System.out.println("Configuration Saved!");
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Closing Program...");

                }
            }

        });
    }

    public void SaveEmails() {

        try {
            Email.SaveEmails(emails);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emailTargetField = new javax.swing.JTextField();
        companyNameField = new javax.swing.JTextField();
        myNameField = new javax.swing.JTextField();
        jobTitleField = new javax.swing.JTextField();
        confirmationButton = new javax.swing.JButton();
        consoleLog = new javax.swing.JLabel();
        sendEmailTestButton = new javax.swing.JButton();
        subjectLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        myEmailLabel = new javax.swing.JLabel();
        myEmailField = new javax.swing.JTextField();
        saveConfigButton = new javax.swing.JButton();
        myEmailLabel1 = new javax.swing.JLabel();
        myPasswordFieldHidden = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        emailContentField = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        daysUntilSendField = new javax.swing.JSpinner();
        testTimeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Email Responder");

        emailTargetField.setText("SET COMPANY EMAIL HERE");
        emailTargetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTargetFieldActionPerformed(evt);
            }
        });

        companyNameField.setText("SET COMPANY NAME HERE");
        companyNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyNameFieldActionPerformed(evt);
            }
        });

        myNameField.setText("YOUR NAME HERE");
        myNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myNameFieldActionPerformed(evt);
            }
        });

        jobTitleField.setText("SET JOB TITLE HERE");
        jobTitleField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jobTitleFieldFocusLost(evt);
            }
        });
        jobTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTitleFieldActionPerformed(evt);
            }
        });
        jobTitleField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jobTitleFieldPropertyChange(evt);
            }
        });

        confirmationButton.setText("Confirm Email");
        confirmationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmationButtonActionPerformed(evt);
            }
        });

        consoleLog.setText("Info:");

        sendEmailTestButton.setText("TEST SEND EMAIL");
        sendEmailTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailTestButtonActionPerformed(evt);
            }
        });

        subjectLabel.setText("Subject Label            ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Target Email Address:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Company Name:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Your Name:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Job Title:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Preview / Edit Previous Emails");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        myEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        myEmailLabel.setText("Your Email:");

        myEmailField.setText("YOUR EMAIL HERE");
        myEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myEmailFieldActionPerformed(evt);
            }
        });

        saveConfigButton.setText("Save Configuration");
        saveConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveConfigButtonActionPerformed(evt);
            }
        });

        myEmailLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        myEmailLabel1.setText("Your Email Password:");

        myPasswordFieldHidden.setText("jPasswordField1");
        myPasswordFieldHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myPasswordFieldHiddenActionPerformed(evt);
            }
        });

        emailContentField.setColumns(20);
        emailContentField.setLineWrap(true);
        emailContentField.setRows(5);
        emailContentField.setText("Your Message Here");
        jScrollPane1.setViewportView(emailContentField);

        jLabel6.setText("Days Until Send");

        daysUntilSendField.setValue(3);
        daysUntilSendField.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                daysUntilSendFieldStateChanged(evt);
            }
        });

        testTimeButton.setText("jButton2");
        testTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testTimeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consoleLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(emailTargetField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jobTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(confirmationButton)
                                        .addComponent(sendEmailTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(daysUntilSendField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(myEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(myEmailLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(myPasswordFieldHidden, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(myEmailField)
                                    .addComponent(saveConfigButton, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(myNameField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(testTimeButton)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subjectLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTargetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(myNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jobTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myEmailLabel1)
                            .addComponent(myPasswordFieldHidden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(myEmailLabel)
                        .addComponent(myEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveConfigButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(daysUntilSendField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendEmailTestButton)
                    .addComponent(testTimeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consoleLog)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTargetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTargetFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTargetFieldActionPerformed

    private void myNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myNameFieldActionPerformed
        // TODO add your handling code here:
        this.config.setMyName(this.myNameField.getText());
    }//GEN-LAST:event_myNameFieldActionPerformed

    private void confirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmationButtonActionPerformed
        // TODO add your handling code here:

        Email e = new Email();
        e.companyName = companyNameField.getText();
        e.content = emailContentField.getText();
        e.targetEmail = emailTargetField.getText();
        e.jobTitle = jobTitleField.getText();
        e.myName = myNameField.getText();
        e.daysLeftToSend = Integer.parseInt(this.daysUntilSendField.getValue().toString());
        System.out.println(e.daysLeftToSend);

        emails.add(e);
        this.SaveEmails();
    }//GEN-LAST:event_confirmationButtonActionPerformed

    private void sendEmailTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailTestButtonActionPerformed
        // TODO add your handling code here:
        //Confirmation Panel
        JPanel confirmPanel = new JPanel();
        confirmPanel.add(new JLabel("Are you sure you want to test send this email?  It will send from your email to the target email"));
        int selectedOption = JOptionPane.showConfirmDialog(null, confirmPanel, "File",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (selectedOption == 0) {
            System.out.println("Sending Test Email from " + this.myEmailField.getText() + " to " + this.emailTargetField.getText());
            Email e = new Email();
            e.companyName = companyNameField.getText();
            e.content = emailContentField.getText();
            e.targetEmail = emailTargetField.getText();
            e.jobTitle = jobTitleField.getText();
            e.myName = myNameField.getText();
            
            this.emailTargetField.setText(("SET COMPANY EMAIL HERE"));
            this.jobTitleField.setText(("SET JOB TITLE HERE"));
            this.companyNameField.setText(("SET COMPANY NAME HERE"));
            
            this.SendEmail(e);
            this.consoleLog.setText("Sent Test Email from " + this.myEmailField.getText() + " to " + this.emailTargetField.getText());
        } else {
            System.out.println("Did not send the test email");

        }

    }//GEN-LAST:event_sendEmailTestButtonActionPerformed

    private void companyNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNameFieldActionPerformed
        // TODO add your handling code here:
        this.subjectLabel.setText(Email.subjectFormality + this.companyNameField.getText() + ",");
    }//GEN-LAST:event_companyNameFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        GUI mainFrame = this;

        if (editEmailsReady && emails.size() > 0) {

            editEmailsReady = false;

            //New Frame
            JFrame newFrame = new JFrame("Saved Emails");
            newFrame.setName("Saved Emails");
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFrame.setSize(300, 200);
            newFrame.setLocationRelativeTo(null);
            newFrame.setVisible(true);
            newFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

            newFrame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosed(WindowEvent e) {
                    editEmailsReady = true;
                }

            });
            int index = 0;
            for (Email email : this.emails) {
                //Panel
                JPanel p = new JPanel();
                //Label
                JLabel newLabel = new JLabel();
                newLabel.setText(email.companyName + ": " + email.jobTitle);

                //Delete Button
                JButton b = new JButton("Delete");
                JButton editButton = new JButton("Edit");

                //action listener for delete button
                b.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        //Confirmation Panel
                        JPanel confirmPanel = new JPanel();
                        confirmPanel.add(new JLabel("Are you sure you want to delete " + email.companyName + "'s " + email.jobTitle + " position follow up email?"));
                        int selectedOption = JOptionPane.showConfirmDialog(null, confirmPanel, "File",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE);
                        if (selectedOption == 0) {
                            emails.remove(email);
                            p.remove(b);
                            p.remove(newLabel);
                            p.remove(editButton);
                            newFrame.revalidate();
                            newFrame.repaint();
                            System.out.println("Removed: " + email.toString());
                            consoleLog.setText("Removed: " + email.toString());
                        }
                    }
                });

                //edit button action listener
                editButton.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        editEmailForm editForm = new editEmailForm(email);
                        editForm.setVisible(true);

                        editForm.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                if (editForm.confirmed) {
                                    System.out.println("Adjusted email");
                                    email.companyName = editForm.getEmail().companyName;
                                    email.jobTitle = editForm.getEmail().jobTitle;
                                    email.myName = editForm.getEmail().myName;
                                    email.targetEmail = editForm.getEmail().targetEmail;
                                    email.content = editForm.getEmail().content;
                                    email.daysLeftToSend = editForm.getEmail().daysLeftToSend;
                                }
                            }

                        });

                        newFrame.dispose();
                        System.out.println("Editing: " + email.toString());
                    }
                });
                //Add it all together and refresh
                p.add(newLabel);
                p.add(b);
                p.add(editButton);
                newFrame.add(p);
                newFrame.revalidate();
                newFrame.repaint();
                index++;
            }
            newFrame.pack();
            newFrame.revalidate();
            newFrame.repaint();
        } else {
            if (this.emails.size() <= 0) {
                System.out.println("No saved emails to edit or delete");
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void myEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myEmailFieldActionPerformed
        // TODO add your handling code here:
        this.config.setMyEmail(this.myEmailField.getText());
    }//GEN-LAST:event_myEmailFieldActionPerformed

    private void saveConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveConfigButtonActionPerformed
        try {
            // TODO add your handling code here:
            SaveConfig.SaveConfiguration(new SaveConfig(this.myNameField.getText(), this.myEmailField.getText(), new String(this.myPasswordFieldHidden.getPassword()), this.emailContentField.getText(), "", Integer.parseInt(this.daysUntilSendField.getValue().toString())));
            this.consoleLog.setText("Configuration Saved!");
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveConfigButtonActionPerformed

    private void myPasswordFieldHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myPasswordFieldHiddenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myPasswordFieldHiddenActionPerformed

    private void jobTitleFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jobTitleFieldPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTitleFieldPropertyChange

    private void jobTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTitleFieldActionPerformed
        // TODO add your handling code here:
        this.subjectLabel.setText("Dear " + this.jobTitleField.getText() + ",");
    }//GEN-LAST:event_jobTitleFieldActionPerformed

    private void jobTitleFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jobTitleFieldFocusLost
        // TODO add your handling code here:
        this.subjectLabel.setText("Dear " + this.jobTitleField.getText() + ",");
    }//GEN-LAST:event_jobTitleFieldFocusLost

    private void daysUntilSendFieldStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_daysUntilSendFieldStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_daysUntilSendFieldStateChanged

    private void testTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testTimeButtonActionPerformed
        // TODO add your handling code here:
        System.out.println(LocalDate.now().compareTo(LocalDate.now().plusDays(Integer.parseInt(this.daysUntilSendField.getValue().toString()))) == 0);
        System.out.println(LocalDate.now() + " : " + LocalDate.now().plusDays(Integer.parseInt(this.daysUntilSendField.getValue().toString())));
        System.out.println(new File(".").getAbsolutePath());
    }//GEN-LAST:event_testTimeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI frame = new GUI();
                frame.setVisible(true);

                //Set the subject label
                frame.subjectLabel.setText(Email.subjectFormality + frame.companyNameField.getText() + ",");

                //Load in the saved emails
                try {
                    frame.emails = Email.GetEmails();
                    if (frame.emails != null) {
                        frame.consoleLog.setText("Loaded " + frame.emails.size() + " emails");
                    }
                    else{
                        frame.emails = new LinkedList<>();
                    }
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    //Load in Save Configuration
                    frame.config = SaveConfig.LoadConfiguration(SaveConfig.path);
                    System.out.println("Loaded Save Configuration");
                    frame.myNameField.setText(frame.config.getMyName());
                    frame.myEmailField.setText(frame.config.getMyEmail());
                    frame.myPasswordFieldHidden.setText(frame.config.getMyPassword());
                    frame.emailContentField.setText(frame.config.getMyGenericMessage());
                    frame.daysUntilSendField.setValue(frame.config.getDaysTilSendValue());
                } catch (FileNotFoundException ex) {
                    frame.config = new SaveConfig();
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public LinkedList<Email> emails = new LinkedList<>();
    public String myEmail = "Blarbaman@gmail.com";
    public boolean editEmailsReady = true;
    private SaveConfig config;

    public void LoadEmail(Email email) {
        this.companyNameField.setText(email.companyName);
        this.emailContentField.setText(email.content);
        this.jobTitleField.setText(email.jobTitle);
        this.myNameField.setText(email.myName);
        this.emailTargetField.setText(email.targetEmail);
        this.repaint();
        this.revalidate();
    }

    //Sends an Email
    public void SendEmail(Email email) {

        // Recipient's email ID needs to be mentioned.
        String to = email.targetEmail;

        // Sender's email ID needs to be mentioned
        String from = myEmail;

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Blarbaman@gmail.com", "Blarbaman123");  //pass your email id and password here

            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(this.myNameField.getText() + " following up with the " + email.jobTitle + " position");

            // Now set the actual message
            message.setText(email.content);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companyNameField;
    private javax.swing.JButton confirmationButton;
    private javax.swing.JLabel consoleLog;
    private javax.swing.JSpinner daysUntilSendField;
    private javax.swing.JTextArea emailContentField;
    private javax.swing.JTextField emailTargetField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jobTitleField;
    private javax.swing.JTextField myEmailField;
    private javax.swing.JLabel myEmailLabel;
    private javax.swing.JLabel myEmailLabel1;
    private javax.swing.JTextField myNameField;
    private javax.swing.JPasswordField myPasswordFieldHidden;
    private javax.swing.JButton saveConfigButton;
    private javax.swing.JButton sendEmailTestButton;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JButton testTimeButton;
    // End of variables declaration//GEN-END:variables
}
