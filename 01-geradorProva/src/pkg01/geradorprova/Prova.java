package pkg01.geradorprova;

/**
 *
 * @author George
 */
public class Prova {
    private String disciplina;
    private int peso;
    private String local;
    private String data;
    private int qtdQuestoesD;
    private int qtdQuestoesO;
    
    public Prova (){
        
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return this.disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return this.peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the qtdQuestoesD
     */
    public int getQtdQuestoesD() {
        return qtdQuestoesD;
    }

    /**
     * @param qtdQuestoesD the qtdQuestoesD to set
     */
    public void setQtdQuestoesD(int qtdQuestoesD) {
        this.qtdQuestoesD = qtdQuestoesD;
    }

    /**
     * @return the qtdQuestoesO
     */
    public int getQtdQuestoesO() {
        return qtdQuestoesO;
    }

    /**
     * @param qtdQuestoesO the qtdQuestoesO to set
     */
    public void setQtdQuestoesO(int qtdQuestoesO) {
        this.qtdQuestoesO = qtdQuestoesO;
    }
}
