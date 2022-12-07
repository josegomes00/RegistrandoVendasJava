package registrandovendas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("DIGITE [1] PARA CADASTRAR UM VENDEDOR");
        System.out.println("DIGITE [2] PARA REGISTRAR UMA VENDA");
        System.out.println("DIGITE [3] EXIBIR O RESUMO DE UMA VENDA\n");
        System.out.println("DIGITE [100] PARA FINALIZAR O PROGRAMA\n");
    }

    public static void main(String[] args) {
        int option = 0;
        Scanner scan = new Scanner(System.in);
        Vendedor v = new Vendedor("","","");
        Produto p = new Produto("", "", 0, 0, false);
        Venda ven = new Venda();

        do {
            menu();
            try {
                option = scan.nextInt();
                if (option == 1){
                    Scanner scanVendendor = new Scanner(System.in);
                    String nome;
                    String codigo;
                    String endereco;

                    System.out.println("Digite o Nome do Vendedor: ");
                    nome = scanVendendor.nextLine();
                    nome = nome.toUpperCase();
                    System.out.println();

                    System.out.println("Digite o Código do Vendedor: ");
                    codigo = scanVendendor.nextLine();
                    System.out.println();

                    System.out.println("Digite o Endereço do Vendedor: ");
                    endereco = scanVendendor.nextLine();
                    endereco = endereco.toUpperCase();
                    System.out.println();

                    v.setNome(nome);
                    v.setCodigo(codigo);
                    v.setEndereco(endereco);

                } else if (option == 2) {

                    Scanner scanVenda = new Scanner(System.in);
                    String codigo;
                    String descricao;
                    int qtdItens = 0;
                    double desconto = 0;
                    double valorVenda = 0;
                    double valorCusto = 0;
                    boolean promocao = false;
                    String aux;

                    System.out.println("Digite o Código do Produto: ");
                    codigo = scanVenda.nextLine();
                    System.out.println();

                    System.out.println("Digite a Descrição do Produto: ");
                    descricao = scanVenda.nextLine();
                    descricao = descricao.toUpperCase();
                    System.out.println();

                    System.out.println("Digite o Valor de Venda do Produto(R$): ");
                    valorVenda = scanVenda.nextDouble();

                    System.out.println("Digite o Valor de Custo do Produto(R$): ");
                    valorCusto = scanVenda.nextDouble();

                    System.out.println("O Produto está em Promoção? [S/N]"); //CASO ESTEJA EM PROMOÇÃO, DESCONTO APLICADO DE 10%.
                    aux = scanVenda.next();

                    if (aux.equalsIgnoreCase("S")) {
                        desconto = 10;
                        promocao = true;
                    } else if (aux.equalsIgnoreCase("N")) {
                        promocao = false;
                    }else{
                        System.out.println("Opção Inexistente, Produto Não Ficará em Promoção");
                    }
                    System.out.println();

                    System.out.println("Quantidade de Itens: ");
                    qtdItens = scanVenda.nextInt();

                    p.setCodigo(codigo);
                    p.setDescricao(descricao);
                    p.setValorVenda(valorVenda);
                    p.setValorCusto(valorCusto);
                    p.setPromocao(promocao);

                    ven.setVendedor(v);
                    ven.setProduto(p);
                    ven.setQtdItens(qtdItens);
                    ven.setValor(valorVenda);

                    if (p.isPromocao()){
                        ven.efetuarDesconto(desconto);
                    }


                } else if (option == 3) {
                    ven.calcularValor();
                    ven.imprimeVenda();
                    System.out.println();

                } else if (option == 100) {
                    System.out.println("Finalizando...");

                } else {
                    System.out.println("Opção Inválida!!");

                }
            }catch (InputMismatchException e){
                System.out.println("TENTE DIGITAR SOMENTE NÚMEROS!!");
                scan.next();
            }catch (NullPointerException e){
                System.out.println("Possível Erro na Leitura de Dados, Repita [CADASTRAR UM VENDEDOR] e/ou [REGISTRAR UMA VENDA] de Forma Correta!!");
            }catch (Exception e){
                System.out.println("ERRO INESPERADO!!");
            }


        }while (option != 100);
    }
}