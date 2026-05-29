package com.crm.view;

import java.util.Scanner;
import com.crm.model.Lead;
import com.crm.service.LeadService;

public class SalesConsole {

    public void viewConsole() {

        int option = 0;

        Scanner scanner = new Scanner(System.in);

        LeadService leadService = new LeadService();

        while (option != 7) {

            System.out.println("Escolha uma opcao no menu");
            System.out.println("1. Criar Lead");
            System.out.println("2. Listar Leads");
            System.out.println("3. Atualizar Cadastro");
            System.out.println("4. Arquivar Lead");
            System.out.println("5. Fechamento de Venda");
            System.out.println("6. Importar");
            System.out.println("7. Sair");




            option = Integer.parseInt(scanner.nextLine());

            switch (option) {

                case 1:

                    try {
                        System.out.println("Digite o nome do cliente: ");
                        String nomeLead = scanner.nextLine();

                        System.out.println("Digite o telefone do cliente: ");
                        String telefoneLead = scanner.nextLine();

                        leadService.createClient(nomeLead, telefoneLead);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());

                    }

                    break;

                case 2:
                    System.out.println(leadService.listClients());
                    break;


                case 3:
                    System.out.println("Qual o id do usuário que deseja alterar ? ");
                    int id = Integer.parseInt(scanner.nextLine());

                    Lead userId = leadService.findLeadById(id);

                    if (userId == null) {
                        System.out.println("Erro: Nenhum cliente encontrado com este ID.");
                    } else {
                        System.out.println("--- DADOS ATUAIS ---");
                        System.out.println("Nome: " + userId.getClientName());
                        System.out.println("Telefone: " + userId.getPhoneNumber());
                        System.out.println("Status: " + userId.getStatus());
                        System.out.println("Contrato: " + userId.getDealValue());

                        String oldName = userId.getClientName();
                        System.out.println(
                                "Novo nome (Deixe em branco para manter '" + oldName + "'");
                        String inputName = scanner.nextLine();

                        if (inputName.isEmpty()) {
                            inputName = oldName;

                        }

                        String inputPhone;

                        while (true) {
                            String oldPhone = userId.getPhoneNumber();
                            System.out.println("Novo Telefone (Deixe em branco para manter '"
                                    + oldPhone + "'): ");
                            inputPhone = scanner.nextLine();

                            if (inputPhone.isEmpty()) {
                                inputPhone = oldPhone;
                                break;

                            }


                            if (inputPhone.matches("\\d{11}")) {
                                break;
                            } else {

                                System.out.println(
                                        "Erro: O telefone deve conter exatamente 11 números. Tente novamente.");
                            }
                        }

                        String oldStatus = userId.getStatus();
                        System.out.println(
                                "Novo Status (Deixe em branco para manter '" + oldStatus + "'");
                        String inputStatus = scanner.nextLine();

                        if (inputStatus.isEmpty()) {
                            inputStatus = oldStatus;

                        }


                        double oldDeal = userId.getDealValue();

                        System.out.println(
                                "Novo Contrato (Deixe em branco para manter '" + oldDeal + "'");

                        String inputDealStr = scanner.nextLine();

                        double finalDeal;
                        if (inputDealStr.isEmpty()) {
                            finalDeal = oldDeal;

                        } else {
                            finalDeal = Double.parseDouble(inputDealStr);
                        }


                        try {
                            leadService.updateLead(id, inputName, inputPhone, inputStatus,
                                    finalDeal);
                            System.out.println("Cadastro atualizado com sucesso!");
                        } catch (IllegalArgumentException e) {

                            System.out.println("Falha na atualização: " + e.getMessage());
                        }

                    }



                    break;

                case 4:
                    System.out.println("Qual o id do usuário que deseja Arquivar ? ");
                    int archiveId = Integer.parseInt(scanner.nextLine()); 

                    Lead clienteEncontrado = leadService.findLeadById(archiveId); 
                    if (clienteEncontrado == null) {
                        
                        System.out.println("Erro: Nenhum cliente encontrado com este ID.");
                    } else {
                        
                        boolean sucesso = leadService.archiveLead(archiveId);

                        if (sucesso) {
                            System.out.println(
                                    "Cliente arquivado com sucesso! Status alterado para LOST e contrato zerado.");
                        } else {
                            System.out.println("Falha interna ao tentar arquivar o cliente.");
                        }
                    }
                    break;

                    case 5: 
                        


                default:
                    System.out.println("Opcao invalida!");



            }



        }
        scanner.close();

    }

}
