//Este sistema gerencia um sistema de lavação de carros simples.

import java.util.Locale;
import java.util.Scanner;

public class SistemaLavacao {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Locale.setDefault(Locale.US);

      int nAtendimentos, contVeiculos1 = 0, contVeiculos2 = 0, contVeiculos3 = 0, maiorVeiculo = -1, maiorServico = -1,
            contServicos1 = 0, contServicos2 = 0, contServicos3 = 0,
            somaPrecos = 0;

      System.out.println("---Início do Programa - Atendimento de Clientes - Lavação de Carros---");
      System.out.println("Digite a quantidade de atendimentos a serem realizados: ");

      nAtendimentos = scan.nextInt();
      scan.nextLine();

      String[] clientes = new String[nAtendimentos];

      int[] veiculos = new int[nAtendimentos];

      int[] servicos = new int[nAtendimentos];

      int[] valoresPagos = new int[nAtendimentos];

      int[][] precos = {
            { 50, 70, 90 },
            { 70, 90, 110 },
            { 90, 110, 130 }
      };

      for (int i = 0; i < nAtendimentos; i++) {
         System.out.println("Digite o nome do cliente: ");
         clientes[i] = scan.nextLine();

         do {
            System.out.println("Digite o tipo do veículo conforme o tamanho: (1)Pequeno (2)Médio (3)Grande ");
            veiculos[i] = scan.nextInt();
            scan.nextLine();

            if (veiculos[i] == 1) {
               contVeiculos1++;
            } else if (veiculos[i] == 2) {
               contVeiculos2++;
            } else {
               contVeiculos3++;

            }

            if (veiculos[i] > maiorVeiculo) {
               maiorVeiculo = veiculos[i]; // maior veiculo
            }

         } while (!(veiculos[i] >= 1 && veiculos[i] <= 3));

         do {
            System.out.println(
                  "Digite o tipo de serviço: (1)Lavação externa (2)Lavação externa/interna (3)Lavação externa/interna/cera");
            servicos[i] = scan.nextInt();
            scan.nextLine();

            if (servicos[i] == 1) {
               contServicos1++;
            } else if (veiculos[i] == 2) {
               contServicos2++;
            } else {
               contServicos3++;

            }

            if (servicos[i] > maiorServico) {
               maiorServico = servicos[i]; // maior servico
            }

         } while (!(servicos[i] >= 1 && servicos[i] <= 3));

         System.out.println("O cliente " +
               clientes[i] +
               " solicitou o serviço do tipo: " +
               servicos[i] +
               "\n" +
               "Veículo do tipo: " +
               veiculos[i]);

         System.out.println("O valor total pago foi de: " + "R$" + precos[veiculos[i] - 1][servicos[i] - 1]);

         valoresPagos[i] = precos[veiculos[i] - 1][servicos[i] - 1];

         somaPrecos += precos[veiculos[i] - 1][servicos[i] - 1];

         // ---- FIM PRIMEIRA PARTE DO PROGRAMA ----

      }

      double percentContServicos1 = (double) contServicos1 / nAtendimentos;
      double percentContServicos2 = (double) contServicos2 / nAtendimentos;
      double percentContServicos3 = (double) contServicos3 / nAtendimentos;

      double percentContVeiculos1 = (double) contServicos1 / nAtendimentos;
      double percentContVeiculos2 = (double) contServicos2 / nAtendimentos;
      double percentContVeiculos3 = (double) contServicos3 / nAtendimentos;

      System.out.println("Percentual de atendimento por tipo de veículo : " +
            percentContVeiculos1 * 100 +
            "%" +
            "->tipo 1 /// " +
            percentContVeiculos2 * 100 +
            "%" +
            "->tipo 2 /// " +
            percentContVeiculos3 * 100 +
            "%" +
            "->tipo 3");

      System.out.println("Percentual de atendimento por tipo de serviço : " +
            percentContServicos1 * 100 +
            "%" +
            "->tipo 1 /// " +
            percentContServicos2 * 100 +
            "%" +
            "->tipo 2 /// " +
            percentContServicos3 * 100 +
            "%" +
            "->tipo 3");

      System.out.println("O valor total arrecadado foi de: " + "R$" + somaPrecos);

      System.out.println("O serviço mais atendido foi do tipo: " + maiorServico);

      System.out.println("O tipo de veículo mais atendido foi do tipo: " + maiorVeiculo);

      System.out.println("---Relatório final dos clientes---");

      for (int i = 0; i < nAtendimentos; i++) {
         System.out.printf("Cliente: %s, Tipo de Veículo: %d, Tipo de Serviço: %d, Valor Pago: R$%d%n",
               clientes[i], veiculos[i], servicos[i], valoresPagos[i]);
      }

      scan.close();

      System.out.println("---Fim do programa---");

   }

}