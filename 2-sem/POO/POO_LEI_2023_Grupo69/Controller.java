import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Controller implements Serializable{
    private Vintage model;

    public Controller(Vintage model) {
        this.model = model;
    }

    public LocalDate data(){
        return model.getDataAtual();
    }

    public void loadficheiroSistema(String filename) throws ExceptionData{
        model.loadficheiro(filename);
    }

    public void reiniciarSistema(){
        this.model = model.reiniciarSistemaInterativo();
    }

    public void salvaEstadoObjSistema() throws IOException{
        model.salvaEstadoObj();
    }

    public void carregaEstadoObjSistema(String path) throws IOException, ClassNotFoundException{
        model.loadEstadoObj(path);
    }

    public void setDataSistema(LocalDate dataAtual){
        model.setDataAtual(dataAtual);
    }

    public void maiorVendedorAdmin(String dataInferior, String dataSuperior) throws ExceptionData{
        model.maiorVendedorInterativo(dataInferior, dataSuperior);
    }

    public void maiorTransportadoraAdmin(){
        model.maiorTransportadora();
    }

    public void encomendasVendedorAdmin(String emailVendedor) throws ExceptionUser{
        model.encomendasVendedorInterativo(emailVendedor);
    }

    public void ordenarUtilizadoresPorFaturamento(String dataInferior, String dataSuperior) throws ExceptionData{
    model.ordenarUtilizadoresPorFaturamentoInterativo(dataInferior, dataSuperior);
    }

    public double faturamentoSistema(){
        return model.getTotalAuferido();
    }

    public void registaUser(String email, String nome, String morada, int nif) {
        model.registaUtilizadorInterativo(email, nome, morada, nif);
    }

    public void removeUser(String emailUser)throws ExceptionUser {
        model.removeUtilizadorInterativo(emailUser);
    }

    //inicializa e retornar as duas transportadoras por omissão
    public Map<String, Transportadora> transportadorasDisp(){
        return model.getTranspDisponiveis();
    }

    //inicializa e retornar as duas transportadoras por omissão
    public void addTranspAdmin(String nome, double cp,  double cm, double cg, double imposto, double custoAdicional){
        model.addTransportadoraInterativo(nome, cp, cm, cg, imposto, custoAdicional);
    }

    public Utilizador retornarLoggedUser(String email){
       return model.getCreds().get(email);
    }

    public void avancaDataSistema(String dataAtual) throws ExceptionData{
        model.avancaData(dataAtual);
    }

    public void colocaAVendaUser(Utilizador user, String tipoArtigo, String classeArtigo, Artigo.St estado, int numDonos, String transportadora, String descricao, String marca, double precoBase, double correcaoPreco, Mala.Dim dimensao, String material, int anoLancamento, Boolean atacadores, String cor, int tamanho, Tshirt.Tam tamTshirt, Tshirt.Pad padTshirt){
        model.colocaAvendaUserInterativo(user, tipoArtigo, classeArtigo, estado, numDonos, transportadora, descricao, marca, precoBase, correcaoPreco, dimensao, material, anoLancamento, atacadores, cor, tamanho, tamTshirt, padTshirt);
    }

    public void encomendarArtigoUser(Utilizador user, int codBarras){
        model.encomendarArtigoUserInterativo(user, codBarras);
    }

    //mostra a encomenda do utilizador
    public Map<Integer, Encomenda>  encomendaUser(Utilizador user){
        return model.encomendaUserInterativo(user.clone());
    }

    public void finalizaEncomendaUser(Utilizador user){
        model.finalizaEncomendaUserInterativo(user);
    }

    public Map<Integer, Artigo> artigosCompradosUser(Utilizador user){
        return model.getCreds().get(user.getEmail()).getComprou();
    }

    public List<String> utilizadoresDisponiveis() {
        return new ArrayList<>(model.getCreds().keySet());
    }

    public Map<Integer, Artigo>  artigosDisponiveis(Utilizador user){
        return model.getStockInterativo(user.clone());
    }

    //mostra os artigos à venda do utilizador
    public Map<Integer, Artigo>  artigosAvendaUser(Utilizador user){
        return model.artigosAVendaUserInterativo(user.clone());
    }

    //mostra os artigos vendidos do utilizador
    public Map<Integer, Artigo>  artigosVendidosUser(Utilizador user){
        return model.artigosVendidosUserInterativo(user.clone());
    }

    public void devolverEncomendaUser(Utilizador user){
        model.devolveEncomendaInterativo(user);
    }
}
