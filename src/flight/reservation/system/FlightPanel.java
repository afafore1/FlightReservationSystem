/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.reservation.system;

import dbModel.DbInteraction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ayomitunde
 */
public class FlightPanel extends javax.swing.JFrame {

    /**
     * Creates new form Flight
     */
    IUser _customer;
    DefaultTableModel _flightModel = new DefaultTableModel(0, 0);
    final String [] _eventModel = {"Flight Name", "DepartTime", "ArrivalTime", "DepartureDate", "ArrivalDate", "From City", "To City"};
    DbInteraction db = new DbInteraction();
    ArrayList<Flight> allFlights;
    public FlightPanel(IUser customer) {
        initComponents();
        _flightModel.setColumnIdentifiers(_eventModel);
        _customer = customer;
        if(_customer.canAddNewFlights()) // this is an admin if they can do this
        {
            mnuAdmin.setVisible(true);
        }else
        {
            mnuAdmin.setVisible(false);
        }
        FillFlightInformation();
    }

    
    private void FillFlightInformation()
    {
        try {
            allFlights = db.getAllFlights();
            fillFlight(allFlights);
        } catch (SQLException ex) {
            Logger.getLogger(FlightPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtSearchFlight = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            };
        }
        ;
        btnSearchFlight = new javax.swing.JButton();
        btnAllFlights = new javax.swing.JButton();
        btnBookFlight = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuAdmin = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        btnAddFlight = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFlights.setModel(_flightModel);
        jScrollPane1.setViewportView(tblFlights);

        btnSearchFlight.setText("Search Flight");
        btnSearchFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFlightActionPerformed(evt);
            }
        });

        btnAllFlights.setText("All Flights");
        btnAllFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllFlightsActionPerformed(evt);
            }
        });

        btnBookFlight.setText("Book Flight");
        btnBookFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookFlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearchFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchFlight)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnAllFlights)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBookFlight)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchFlight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAllFlights)
                    .addComponent(btnBookFlight)))
        );

        jMenu1.setText("My Account");

        jMenuItem1.setText("My flights");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        mnuAdmin.setText("Admin");

        jMenu3.setText("Flight");

        btnAddFlight.setText("Add Flight");
        btnAddFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFlightActionPerformed(evt);
            }
        });
        jMenu3.add(btnAddFlight);

        jMenuItem4.setText("Update Flight");
        jMenu3.add(jMenuItem4);

        jMenuItem3.setText("Delete Flight");
        jMenu3.add(jMenuItem3);

        mnuAdmin.add(jMenu3);

        jMenuBar1.add(mnuAdmin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //gets the users flights
        try
        {
            ArrayList<Flight> result = db.getUserFlight(_customer.getId());
            for(Iterator<Flight> iterator = _customer.getUserFlights().iterator(); iterator.hasNext();)
            {
                Flight f = iterator.next();
                if(!result.contains(f))
                {
                    result.add(f);
                    //_customer.addToUserFlight(f); causing concurency error
                }
            }
            
            fillFlight(result);
        }catch (SQLException ex) {
            Logger.getLogger(FlightPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnAddFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFlightActionPerformed
        // TODO add your handling code here:
        new AddFlight().setVisible(true);
    }//GEN-LAST:event_btnAddFlightActionPerformed

    private void btnSearchFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFlightActionPerformed
        // TODO add your handling code here:
        String flightdata = txtSearchFlight.getText();
        ArrayList<Flight> result = new ArrayList<>();
        for(Flight f : allFlights)
        {
            //complete for all of them ... E
            if(f.getName().equals(flightdata) || f.fromCity().equals(flightdata) || f.toCity().equals(flightdata) || f.getDepartureTime().equals(flightdata))
            {
                result.add(f);
            }
        }
        fillFlight(result);
    }//GEN-LAST:event_btnSearchFlightActionPerformed

    private void btnAllFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllFlightsActionPerformed
        // TODO add your handling code here:
        fillFlight(allFlights);
    }//GEN-LAST:event_btnAllFlightsActionPerformed

    private void btnBookFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookFlightActionPerformed
        // TODO add your handling code here:
        int row = tblFlights.getSelectedRow();
        int column = tblFlights.getSelectedColumn();
        Object selected = _flightModel.getValueAt(row, column);
        if(selected != null)
        {
            String flightName = _flightModel.getValueAt(row, 0).toString();
            String departTime = _flightModel.getValueAt(row, 1).toString();
            String arrivalTime = _flightModel.getValueAt(row, 2).toString();
            for(Flight f : allFlights)
            {
                if(f.getName().equals(flightName) && f.getDepartureTime().equals(departTime) && f.getArrivalTime().equals(arrivalTime))
                {
                    _customer.addToUserFlight(f);
                }
            }
        }
    }//GEN-LAST:event_btnBookFlightActionPerformed

    private void fillFlight(ArrayList<Flight> result)
    {
        _flightModel.setRowCount(0);
        for(Flight f : result)
        {
            _flightModel.addRow(new Object[]{f.getName(), f.getDepartureTime(), f.getArrivalTime(), f.departDate(), f.arrivalDate(), f.fromCity(), f.toCity()});
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAddFlight;
    private javax.swing.JButton btnAllFlights;
    private javax.swing.JButton btnBookFlight;
    private javax.swing.JButton btnSearchFlight;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuAdmin;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTextField txtSearchFlight;
    // End of variables declaration//GEN-END:variables
}
