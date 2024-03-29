/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author emmascott
 */
public class ChatDisplay extends javax.swing.JFrame implements Display {

    private static ChatDisplay instance = null;
    UserManager info = UserManager.getInstance();


    private ChatDisplay() {
        initComponents();
    }

    public static ChatDisplay getInstance() {
        if (instance == null) {
            instance = new ChatDisplay();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField = new javax.swing.JTextField();
        messageSomeone = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        ids = new javax.swing.JList<>(info.getIds());
        jScrollPane3 = new javax.swing.JScrollPane();
        ips = new javax.swing.JList<>(info.getIps());
        jScrollPane4 = new javax.swing.JScrollPane();
        ports = new javax.swing.JList<>(info.getPorts());
        addFriend = new javax.swing.JButton();
        receiveFromTitle = new javax.swing.JTextField();
        sendToTitle = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        sendToIds = new javax.swing.JList<>(info.getSendToIds());
        jScrollPane6 = new javax.swing.JScrollPane();
        sendToIps = new javax.swing.JList<>(info.getSendToIps());
        jScrollPane7 = new javax.swing.JScrollPane();
        sendToPorts = new javax.swing.JList<>(info.getSendToPorts());
        messageAll = new javax.swing.JButton();
        coordId = new javax.swing.JTextField();
        coordIp = new javax.swing.JTextField();
        coordPort = new javax.swing.JTextField();
        coordTitle = new javax.swing.JTextField();
        removeUser = new javax.swing.JButton();
        removeSendTo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messageSomeone.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        messageSomeone.setText("Send Message To All");
        messageSomeone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageSomeoneActionPerformed(evt);
            }
        });

        textArea.setEditable(false);
        textArea.setColumns(1);
        textArea.setRows(5);
        textArea.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(textArea);

        jScrollPane1.setViewportView(ids);

        jScrollPane3.setViewportView(ips);

        jScrollPane4.setViewportView(ports);

        addFriend.setText("Add friend");
        addFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendActionPerformed(evt);
            }
        });

        receiveFromTitle.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        receiveFromTitle.setText("You're receiving messages from");

        sendToTitle.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        sendToTitle.setText("Who's receiving your messages?");

        jScrollPane5.setViewportView(sendToIds);

        jScrollPane6.setViewportView(sendToIps);

        jScrollPane7.setViewportView(sendToPorts);

        messageAll.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        messageAll.setText("Send Message To Somone");
        messageAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageAllActionPerformed(evt);
            }
        });

        coordId.setEditable(false);
        coordId.setColumns(1);

        coordTitle.setEditable(false);
        coordTitle.setText(" Coordinator-");

        removeUser.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        removeUser.setText("<- Remove User");
        removeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUserActionPerformed(evt);
            }
        });

        removeSendTo.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        removeSendTo.setText("<- Remove User");
        removeSendTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSendToActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(coordTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coordId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coordIp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(coordPort, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 474, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                            .addComponent(textField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(receiveFromTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(messageSomeone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(messageAll, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sendToTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeSendTo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coordId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(receiveFromTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(sendToTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(removeSendTo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageSomeone, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addFriend)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messageAll))
                    .addComponent(textField))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void messageSomeoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageSomeoneActionPerformed
        for (PrintWriter writer : info.getWriters()) {
            writer.println(textField.getText());
        }
        textField.setText("");
    }//GEN-LAST:event_messageSomeoneActionPerformed

    private void addFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("What is the id of the person you'd like to connect to?"));
        String ip = JOptionPane.showInputDialog("What ip would you like to connect to?");
        int port = Integer.parseInt(JOptionPane.showInputDialog("Which port do you want to connect to?"));
        User friend = new User(id,ip,port);
        ReceiverManager listener = ReceiverManager.getInstance();
        ChatDisplay display = ChatDisplay.getInstance();
        SetupSocket socket = new SetupSocket(friend,listener,info);
        socket.start();
        info.addSendToInfo(friend);
    }//GEN-LAST:event_addFriendActionPerformed

    private void messageAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageAllActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("Who would you like to send a message to? (ID NUMBER)"));
        PrintWriter writer = info.getWriterBK(id);
        writer.println(textField.getText());
        textField.setText("");
    }//GEN-LAST:event_messageAllActionPerformed

    private void removeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUserActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("Who would you like to remove? (ID number)"));
        User member = info.getUserById(id);
        info.removeInfo(member);
        
    }//GEN-LAST:event_removeUserActionPerformed

    private void removeSendToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSendToActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog("Who would you like to remove? (ID number)"));
        User member = info.getUserById(id);
        info.removeSendToInfo(member);
        info.removeWriterBK(id);
    }//GEN-LAST:event_removeSendToActionPerformed

    public void setCoordinator(User coordinator){
        coordId.setText(Integer.toString(coordinator.id));
        coordIp.setText(coordinator.ip);
        coordPort.setText(Integer.toString(coordinator.port));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriend;
    private javax.swing.JTextField coordId;
    private javax.swing.JTextField coordIp;
    private javax.swing.JTextField coordPort;
    private javax.swing.JTextField coordTitle;
    public javax.swing.JList<Integer> ids;
    public javax.swing.JList<String> ips;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton messageAll;
    public javax.swing.JButton messageSomeone;
    public javax.swing.JList<Integer> ports;
    private javax.swing.JTextField receiveFromTitle;
    private javax.swing.JButton removeSendTo;
    private javax.swing.JButton removeUser;
    private javax.swing.JList<Integer> sendToIds;
    private javax.swing.JList<String> sendToIps;
    private javax.swing.JList<Integer> sendToPorts;
    private javax.swing.JTextField sendToTitle;
    public javax.swing.JTextArea textArea;
    public javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables

}
