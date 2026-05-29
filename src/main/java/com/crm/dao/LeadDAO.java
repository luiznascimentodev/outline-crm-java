package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.crm.infra.DatabaseConnection;
import com.crm.model.Lead;

public class LeadDAO {


    public void createLead(Lead lead) {

        String name = lead.getClientName();
        String phone = lead.getPhoneNumber();

        String status = lead.getStatus();
        double deal = lead.getDealValue();

        String sql =
                "INSERT INTO leads (client_name, phone_number, status, deal_value) VALUES (?, ?, ?, ?)";

        try (Connection database = DatabaseConnection.getConnection();
                PreparedStatement stmt = database.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, status);
            stmt.setDouble(4, deal);

            int response = stmt.executeUpdate();

            if (response == 0) {
                throw new RuntimeException(
                        "Erro interno: O banco de dados não inseriu o registro.");
            }

        } catch (SQLException e) {

            System.out.println("Erro de conexão com o banco de dados ! ");

        }



    }

    public List<Lead> listLeads() {

        List<Lead> list = new ArrayList<>();

        String queryLeads = "SELECT * FROM leads";

        try (Connection database = DatabaseConnection.getConnection();
                PreparedStatement stmt = database.prepareStatement(queryLeads)) {


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String name = rs.getString("client_name");
                String phone = rs.getString("phone_number");
                String status = rs.getString("status");
                double deal = rs.getDouble("deal_value");

                Lead lead = new Lead(name, phone, status, deal);

                list.add(lead);


            }



        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco de dados ! ");
        }

        return list;
    }


    public Lead findLeadById(int findId) {



        String queryId = "SELECT * FROM leads WHERE id = ?";

        try (Connection database = DatabaseConnection.getConnection();
                PreparedStatement stmt = database.prepareStatement(queryId)) {


            stmt.setInt(1, findId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String name = rs.getString("client_name");
                String phone = rs.getString("phone_number");
                String status = rs.getString("status");
                double deal = rs.getDouble("deal_value");

                Lead lead = new Lead(name, phone, status, deal);

                return lead;

            }



        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco de dados ! ");
        }

        return null;

    }


    public void updateLead(int id, String newName, String newPhone, String newStatus,
            double newDeal) {


        String queryUpdate =
                "UPDATE leads SET client_name = ?, phone_number = ?, status = ?, deal_value = ? WHERE id = ?";

        try (Connection database = DatabaseConnection.getConnection();
                PreparedStatement stmt = database.prepareStatement(queryUpdate)) {


            stmt.setString(1, newName);

            stmt.setString(2, newPhone);

            stmt.setString(3, newStatus);

            stmt.setDouble(4, newDeal);

            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o banco: " + e.getMessage());
        }


    }

    public boolean archiveLead(int id) {
        String queryUpdate = "UPDATE leads SET deal_value = ?, status = ? WHERE id = ?";

        try (Connection database = DatabaseConnection.getConnection();
                PreparedStatement stmt = database.prepareStatement(queryUpdate)) {

            stmt.setDouble(1, 0.0);
            stmt.setString(2, "LOST");
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o banco: " + e.getMessage());
            return false;
        }
    }
}
