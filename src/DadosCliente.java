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
		Nome = nome;
		CPF = cPF;
		Telefone = telefone;
		Endereco = endereco;
		this.dataNasc = dataNasc;
		Email = email;
		BD = bD;
	}

	public DadosCliente(int iD) {
		super();
		DadosCliente dados = BD.RecuperaCliente(iD);
		ID=dados.ID;
		Nome = dados.Nome;
		CPF = dados.CPF;
		Telefone = dados.Telefone;
		Endereco=dados.Endereco;
		dataNasc=dados.dataNasc;
		Email=dados.Email;				
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;		
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
		BD.AtualizaCliente(this);
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
		BD.AtualizaCliente(this);
	}
	public int getTelefone() {
		return Telefone;
	}
	public void setTelefone(int telefone) {
		Telefone = telefone;
		BD.AtualizaCliente(this);
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
		BD.AtualizaCliente(this);
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
		BD.AtualizaCliente(this);
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
		BD.AtualizaCliente(this);
	}
}
