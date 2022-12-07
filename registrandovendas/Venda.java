package registrandovendas;

public class Venda {
    private Produto produto;
    private Vendedor vendedor;
    private double desconto;
    private int qtdItens;
    private double valor;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean efetuarDesconto(double desconto){
        this.desconto = (produto.getValorVenda() * desconto)/100;

        if ((this.produto.getValorVenda() - this.desconto) < this.produto.getValorCusto()){
            return false;
        }else {
            this.produto.setValorVenda(this.produto.getValorVenda() - this.desconto);
            return true;
        }
    }

    public double calcularValor(){
        this.valor = (this.produto.getValorVenda()) * qtdItens;
        return this.valor;
    }

    public double calcularComissao(){
        if (this.produto.isPromocao()){
            double comissaoTotal = ((this.produto.getValorVenda() * this.vendedor.getComissao()) * this.qtdItens)/2;
            return comissaoTotal;
        }else {
            double comissaoTotal = (this.produto.getValorVenda() * this.vendedor.getComissao()) * this.qtdItens;
            return comissaoTotal;
        }


    }

    public void imprimeVenda(){

        System.out.println("Vendedor: " + this.vendedor.getNome());
        System.out.println("Código Vendedor: " + this.vendedor.getCodigo());

        if (this.produto.isPromocao()){
            System.out.println("Comissão: " + (this.vendedor.getComissao()/2) * 100 + "%");
        }else {
            System.out.println("Comissão: " + (this.vendedor.getComissao()) * 100 + "%");
        }

        System.out.println();

        System.out.println("Quantidade Itens Vendidos: " + this.qtdItens);
        System.out.println("Código do Produto: " + this.produto.getCodigo());
        System.out.println("Descrição do Produto: " + this.produto.getDescricao());
        System.out.println();

        System.out.println("Valor da Venda (unidade): R$" + this.produto.getValorVenda());

        if (this.produto.isPromocao()){
            System.out.println("Produto em promoção?: Sim");
            System.out.println("Valor do Desconto sobre Produto (unidade): R$" + this.desconto);
        }else {
            System.out.println("Produto em promoção?: Não");
        }

        System.out.println("VALOR TOTAL: R$" + this.valor);
    }
}
