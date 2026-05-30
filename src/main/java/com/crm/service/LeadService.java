package com.crm.service;

import java.util.List;
import com.crm.dao.LeadDAO;
import com.crm.model.Lead;

public class LeadService {
    LeadDAO leadDAO = new LeadDAO();


    public void createClient(String nome, String telefone) {

        if (!telefone.matches("^[0-9]{11}$")) {
            throw new IllegalArgumentException("Telefone inválido! Digite 11 números.");
        }

        Lead lead = new Lead(nome, telefone);

        leadDAO.createLead(lead);

    }

    public List<Lead> listClients() {

        return leadDAO.listLeads();


    }


    public Lead findLeadById(int id){

        return leadDAO.findLeadById(id);

    }

    public void updateLead(int id,String newName, String newPhone, String newStatus, double newDeal) {

        if (!newPhone.matches("^[0-9]{11}$")) {
            throw new IllegalArgumentException("Telefone inválido! Digite 11 números.");
        }

        leadDAO.updateLead(id, newName, newPhone, newStatus, newDeal);

    }

    public boolean archiveLead(int id) {

        return leadDAO.archiveLead(id);



    }

    public boolean closeDeal(int id, double deal) {

        
      Lead lead = findLeadById(id);

       if (lead == null) {
        throw new IllegalArgumentException("Cliente nao existe !");

       }

       if (deal <= 0) {
        throw new IllegalArgumentException("A won deal must have a value > 0");
       }

       return leadDAO.closeDeal(deal, id);


    }

    public boolean importLead(Lead lead){

      double dealValue = lead.getDealValue();

      
      if (dealValue > 0) {
        lead.setStatus("CONTACTED");
      } else {  lead.setStatus("NEW");}


      return leadDAO.createLead(lead);


    } 
}
