package br.com.bank;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {
        String diretorioBase = "/tmp/";
        int indice = (id -1) / 1000 + 1; // Calculando o valor do 'indice' usando divisão inteira

        String diretorio = String.format("%s%d", diretorioBase, indice);
        String caminhoArquivo = String.format("%s/%d", diretorio, id);
        return new CaminhoArquivo(Paths.get(diretorio), Paths.get(caminhoArquivo));
    }

}
