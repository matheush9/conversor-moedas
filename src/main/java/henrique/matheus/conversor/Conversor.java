package henrique.matheus.conversor;

import java.util.Arrays;
import java.util.Scanner;

import static henrique.matheus.conversor.ConsoleWriter.Log;

public class Conversor {
    public static void main(String args[]) {
        Log("Obs: Todos os valores serão convertidos da data: 06/07/2024 ás 16h00.");

        Float valorInicial = SolicitaValor("Insira um valor para ser convertido: ");

        TaxasCambioUSD moedaInicial = SolicitaMoeda("O valor digitado foi em qual dessas moedas?");
        TaxasCambioUSD moedaFinal = SolicitaMoeda("Para qual moeda você deseja converter?");

        Log(String.format("%s %s é equivalente a %s %s.",
                valorInicial.toString(),
                moedaInicial.toString(),
                Converter(moedaInicial, moedaFinal, valorInicial).toString(),
                moedaFinal.toString()));
    }

    private static Float Converter(TaxasCambioUSD moedaInicial, TaxasCambioUSD moedaFinal, Float valor) {
        return (valor * moedaInicial.valor) * 1/moedaFinal.valor;
    }

    private static TaxasCambioUSD SolicitaMoeda(String mensagem) {
        Scanner input = new Scanner(System.in);
        Log(String.format("%s %s", mensagem, Arrays.toString(TaxasCambioUSD.values())));
        try {
            return TaxasCambioUSD.valueOf(input.nextLine());
        } catch (IllegalArgumentException e) {
            Log("Por favor, digite uma das moedas solicitadas!");
            return SolicitaMoeda(mensagem);
        }
    }

    private static Float SolicitaValor(String mensagem) {
        Scanner input = new Scanner(System.in);
        Log(String.format("%s", mensagem));
        try {
            return Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            Log("Por favor, digite um valor válido!");
            return SolicitaValor(mensagem);
        }
    }
}

