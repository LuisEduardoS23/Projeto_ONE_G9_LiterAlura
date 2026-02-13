package br.com.luisEduardo.literAlura.principal;

import br.com.luisEduardo.literAlura.exceptions.*;
import br.com.luisEduardo.literAlura.service.LivroService;

import java.util.Scanner;

public class Principal {

    private LivroService service;

    public Principal(LivroService livroService) {
        this.service = livroService;
    }

    private String menuPrincipal = """
            \n============ LiterAlura ===========
            Opções do Sistema:
            1 - BUSCAR LIVRO PELO TÍTULO
            2 - LISTAR LIVROS REGISTRADOS
            3 - LISTAR AUTORES REGISTRADOS
            4 - LISTAR AUTORES VIVOS EM DETERMINADO ANO
            5 - LISTAR LIVROS EM UM DETERMINADO IDIOMA
            6 - LISTAR O TOP 3 LIVROS MAIS BAIXADOS DA COLEÇÃO
            0 - ENCERRAR PROGRAMA
            Escolha o número correspondente a uma das opções acima:     """;

    private Integer opcao = -1;
    Scanner input = new Scanner(System.in);

    public void menu(){
        do{
            System.out.println(menuPrincipal);

            try {
                opcao = Integer.parseInt(input.nextLine());


                switch (opcao) {
                    case 1:
                        service.buscarCadastrarLivro();
                        break;
                    case 2:
                        service.listarLivrosRegistrados();
                        break;
                    case 3:
                        service.listarAutoresRegistrados();
                        break;
                    case 4:
                        service.listarAutoresVivosEmDeterminadoPeriodo();
                        break;
                    case 5:
                        service.listarLivrosEmDeterminadoIdioma();
                        break;
                    case 6:
                        service.listarTop3LivrosBaixados();
                        break;
                    case 0:
                        System.out.println("Obrigado por usar o LiterAlura!");
                        break;
                    default:
                        System.out.println("Opção Inválida, escolha apenas um dos números acima!");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("\nResposta Invalida! Digite apenas o número da opção!\n");
            } catch (NenhumAutorEncontradoException e) {
                System.out.println("\nNenhum autor com essas especificações encontrado!\n");
            } catch (NenhumLivroEncontradoException e){
                System.out.println("\nNenhum livro com essas especificações encontrado!\n");
            } catch (NenhumLivroRegistradoException e) {
                System.out.println("\nNenhum livro registrado no sistema, cadastre com a opção 1 do menu\n");
            } catch (NenhumAutorRegistradoException e) {
                System.out.println("\nNenhum autor registrado no sistema!\n");
            } catch (LivroRepetidoException e) {
                System.out.println("\nLivro já cadastrado no sistema!\n");
            } catch (idiomaInvalidoException e) {
                System.out.println("\nIdioma inválido! escolha apenas entre uma das siglas acima!\n");
            }
        } while (opcao != 0);
    }
}
