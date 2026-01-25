package br.com.alura.screenmatch.infraestrutura;
import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GravadorDeArquivo {
    private Gson gson;

    public GravadorDeArquivo(Gson gson) {
        this.gson = gson;

    }

    public void salvar(List<Titulo> titulos, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(gson.toJson(titulos));

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gravar arquivo", e);

        }

    }

}
