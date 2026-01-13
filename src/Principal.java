import br.com.alura.screenmatch.modelos.Filme;

public class Principal {

    public static void main(String[] args) {
        Filme favorito = new Filme();

        favorito.setNome("The Matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        favorito.exibeFichaTecnica();
        favorito.avalia(9);
        favorito.avalia(8);
        favorito.avalia(9);

        System.out.println("Total de avaliações: " + favorito.getTotalDeAvaliacoes());
        //System.out.println(favorito.pegaMedia());

        //favorito.somaDasAvaliacoes = 10;
        //favorito.totalDeAvaliacoes = 1;


    }

}