import java.util.Scanner;

public class DiasNoMes {
    public static boolean eBissexto(int ano) {
        // Um ano é bissexto se é divisível por 4 mas não por 100, exceto se for divisível por 400
        return (ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0);
    }

    public static int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return eBissexto(ano) ? 29 : 28;
            default:
                return -1; // mês inválido
        }
    }

    public static int mesParaNumero(String entrada) {
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            entrada = entrada.trim().toLowerCase();
            switch (entrada) {
                case "janeiro": return 1;
                case "fevereiro": return 2;
                case "março": case "marco": return 3;
                case "abril": return 4;
                case "maio": return 5;
                case "junho": return 6;
                case "julho": return 7;
                case "agosto": return 8;
                case "setembro": return 9;
                case "outubro": return 10;
                case "novembro": return 11;
                case "dezembro": return 12;
                default: return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o mês (nome ou número): ");
        String entradaMes = sc.nextLine();
        int mes = mesParaNumero(entradaMes);

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido!");
            sc.close();
            return;
        }

        int ano = 0;
        if (mes == 2) {
            System.out.print("Informe o ano (para verificar se é bissexto): ");
            ano = sc.nextInt();
        } else {
            ano = 1; // valor qualquer, pois não é usado
        }

        int dias = diasNoMes(mes, ano);
        System.out.printf("O mês %s tem %d dias.%n", entradaMes, dias);
        sc.close();
    }
}