package it.alfasoft.andrea.servizio;

import java.util.List;

import model.Rubrica;
import model.Voce;
import it.alfasoft.andrea.bean.Admin;
import it.alfasoft.andrea.bean.BustaPaga;
import it.alfasoft.andrea.bean.Cliente;
import it.alfasoft.andrea.bean.Dipendente;
import it.alfasoft.andrea.bean.Utente;
import it.alfasoft.andrea.dao.AdminDao;
import it.alfasoft.andrea.dao.BustaPagaDao;
import it.alfasoft.andrea.dao.ClienteDao;
import it.alfasoft.andrea.dao.DipendenteDao;
import it.alfasoft.andrea.dao.RubricaDao;
import it.alfasoft.andrea.dao.UtenteDao;
import it.alfasoft.andrea.dao.VoceDao;
import it.alfasoft.andrea.utility.CodificationOfPassword;

public class Servizi {

	UtenteDao uDao = new UtenteDao();
	AdminDao aDao = new AdminDao();
	ClienteDao cDao = new ClienteDao();
	DipendenteDao dDao = new DipendenteDao();
	RubricaDao rDao = new RubricaDao();
	VoceDao vDao = new VoceDao();
	BustaPagaDao bDao=new BustaPagaDao();

	// Metodi di registrazione
	public boolean registraUtente(Utente u) {
		return uDao.creaUtente(u);
	}

	public boolean registraCliente(Cliente c) {
		return cDao.creaCliente(c);
	}

	public boolean registraDipendente(Dipendente d) {
		return dDao.creaDipendente(d);
	}

	// Metodi di lettura
	public Utente leggiUtenteConUser(String username) {
		return uDao.leggiUtenteConUser(username);
	}

	public Utente leggiUtenteConNomeCognome(String nome, String cognome) {
		return uDao.leggiUtenteConNomeCognome(nome, cognome);
	}

	// metodo per eliminare un utente
	public boolean eliminaUtente(Utente u) {

		return uDao.eliminaUtente(u);
	}

	public boolean eliminaUtenteConId(long id_u) {

		return uDao.eliminaUtenteConId(id_u);
	}

	

	// Liste
	public List<Cliente> getListClienti() {
		return cDao.leggiTuttiClienti();
	}

	public List<Dipendente> getListDipendenti() {
		return dDao.leggiTuttiDipendenti();
	}
	


	// Trova utente da username
	public Utente getUtente(String username) {
		Utente u = uDao.leggiUtenteConUser(username);
		return u;
	}

	public Admin getAdmin(String username) {
		Admin a = aDao.leggiAdminConUser(username);
		return a;
	}

	public Cliente getCliente(String username) {
		Cliente c = cDao.leggiClienteConUser(username);
		return c;
	}

	public Dipendente getDipendente(String username) {
		Dipendente d = dDao.leggiDipendenteConUser(username);
		return d;
	}

	// Metodo codifica password
	public String codificaPass(String pass) {

		return CodificationOfPassword.codificatePass(pass);
	}

	// Creazione rubrica
	public boolean registraRubrica(String username) {

		Rubrica r = new Rubrica(username);
		return rDao.creaRubrica(r);
	}
	
	// Cerca rubrica
		public Rubrica cercaRubricaConUser(String username) {

			
			return rDao.leggiRubricaConNome(username);
		}

	// Registrazione voce rubrica
	public boolean registraVoce(Rubrica r, Voce v) {
		v.setRubrica(r);
		r.aggiungiVoce(v);
		boolean res = vDao.creaVoce(v);

		rDao.aggiornaRubrica(r);

		return res;
	}

	public List<Voce> getVoci(Rubrica r) {
		List<Voce> lista = vDao.leggiTutteLeVoci(r);

		return lista;
	}

	// Eliminazione voce
	
	public boolean eliminaVoce(Rubrica r, String nome, String cognome) {
		Voce v = vDao.leggiVoce(r.getId_Rubrica(), nome, cognome);
		boolean result = vDao.eliminaVoce(v);
		return result;
	}
	
	public boolean eliminaVoce(Rubrica r, long id) {
		Voce v = vDao.leggiVoceConId(id);
		boolean result = vDao.eliminaVoce(v);
		return result;
	}
	
	// Creazione BustaPaga
	public boolean creaBustaPaga(BustaPaga b){
		return bDao.creaBustaPaga(b);
	}
	
	// Lista Buste paga
	public List<BustaPaga> getListBuste(Dipendente d){
		
		List<BustaPaga> buste=bDao.leggiTutteBustePaga(d);
		return buste;
	}
	
	

}
