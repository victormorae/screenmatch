package br.com.screenmatch.principal;
import br.com.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.screenmatch.infraestrutura.GravadorDeArquivo;
import br.com.screenmatch.modelos.Titulo;
import br.com.screenmatch.servicos.OmdbServico;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        OmdbServico service = new OmdbServico(gson);

        GravadorDeArquivo gravador = new GravadorDeArquivo(gson);

        while (true) {
            System.out.println("Digite um filme para busca (ou 'sair'): ");
            String busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;

            }

            try {
                Titulo titulo = service.buscarTitulo(busca);
                titulos.add(titulo);
                System.out.println("Filme adicionado: " + titulo);

            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());

            }

        }

        gravador.salvar(titulos, "filmes.json");
        System.out.println("Programa finalizado com sucesso!");

    }

}

