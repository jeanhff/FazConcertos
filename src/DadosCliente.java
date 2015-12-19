import java.util.Date;

public class DadosCliente {

	private int ID;
	private String Nome;
	private String CPF;
	private int Telefone;
	private String Endereco;
	private Date dataNasc;
	private String Email;
	static private 	BDConecta BD =new BDConecta("FazConsertos.db");
	
	public DadosCliente(String nome, String cPF, int telefone, String endereco,
			Date dataNasc, String email, BDConecta bD) {
		super();
		this.Nome = nome;
		this.CPF = cPF;
		this.Telefone = telefone;
		this.Endereco = endereco;
		this.dataNasc = dataNasc;
		this.Email = email;
		this.BD = bD;
	}

	public DadosCliente(int iD) {
		super();
		DadosCliente dados = BD.RecuperaCliente(iD);
		this.ID = dados.ID;
		this.Nome = dados.Nome;
		this.CPF = dados.CPF;
		this.Telefone = dados.Telefone;
		this.Endereco = dados.Endereco;
		this.dataNasc = dados.dataNasc;
		this.Email = dados.Email;				
	}
	
	public int getID() {
		return this.ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getNome() {
		return this.Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
		BD.AtualizaCliente(this);
	}
	public String getCPF() {
		return this.CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
		BD.AtualizaCliente(this);
	}
	public int getTelefone() {
		return this.Telefone;
	}
	public void setTelefone(int telefone) {
		this.Telefone = telefone;
		BD.AtualizaCliente(this);
	}
	public String getEndereco() {
		return this.Endereco;
	}
	public void setEndereco(String endereco) {
		this.Endereco = endereco;
		BD.AtualizaCliente(this);
	}
	public Date getDataNasc() {
		return this.dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
		BD.AtualizaCliente(this);
	}
	public String getEmail() {
		return this.Email;
	}
	public void setEmail(String email) {
		this.Email = email;
		BD.AtualizaCliente(this);
	}
}
