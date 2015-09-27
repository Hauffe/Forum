package freeforum.dao;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransacao();
    void abortarTransacao();
    IAssuntoDAO getAssuntoDao();
    ITopicoDAO getTopicoDao();
    IMensagemDAO getMensagemDao();
}
