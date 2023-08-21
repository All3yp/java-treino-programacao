package br.com.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class CaminhoArquivoTest {

    @Test
    // @Disabled
    public void deve_montar_caminho_para_arquivo() {

        CaminhoArquivo caminhoArquivo = CaminhoArquivo.getInstance(1);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/2"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1000);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1500);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/1500"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2000);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/2000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2001);
        assertEquals(Paths.get("/tmp/3"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/3/2001"), caminhoArquivo.getArquivo());

    }

    @Test
    public void teste_get_instance_sem_ID_deve_retornar_Null() {
        // given
        Integer id = null;

        // when e then
        assertThrows(Error.class, () -> {
            CaminhoArquivo.getInstance(id);
        });

    }

    @Test
    public void teste_get_instance_com_ID_invalido_deve_lancar_excecao() {
        // given
        Integer id = -123;

        // when e then
        assertThrows(IllegalArgumentException.class, () -> {
            CaminhoArquivo.getInstance(id);
        });
    }

}