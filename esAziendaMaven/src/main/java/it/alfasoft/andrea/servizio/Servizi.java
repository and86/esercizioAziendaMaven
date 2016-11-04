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
	BustaPagaDao bDao = new BustaPagaDao();

	// Metodi di registrazione di utente,cliente, dipendente
	public boolean registraUtente(Utente u) {
		return uDao.creaUtente(u);
	}

	public boolean registraCliente(Cliente c) {
		return cDao.creaCliente(c);
	}

	public boolean registraDipendente(Dipendente d) {
		return dDao.creaDipendente(d);
	}

	// Metodi di lettura da username
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
	
	public Utente getUtenteConId(long id_u) {
		Utente u = uDao.leggiUtenteConId(id_u);
		return u;
	}

	// Liste Clienti e Dipendenti
	public List<Cliente> getListClienti() {
		return cDao.leggiTuttiClienti();
	}

	public List<Dipendente> getListDipendenti() {
		return dDao.leggiTuttiDipendenti();
	}

	// metodo per eliminare un utente
	public boolean eliminaUtente(Utente u) {
		if (u.getRuolo() != 'a') {
			return uDao.eliminaUtente(u);
		} else {
			return false;
		}
	}

	public boolean eliminaUtenteConId(long id_u) {
		return uDao.eliminaUtenteConId(id_u);
	}

	// Metodo codifica password
	public String codificaPass(String pass) {
		return CodificationOfPassword.codificatePass(pass);
	}

	// BUSTA PAGA
	// Creazione BustaPaga
	public boolean creaBustaPaga(BustaPaga b) {
		return bDao.creaBustaPaga(b);
	}

	// Lista Buste paga dipendente
	public List<BustaPaga> getListBuste(Dipendente d) {
		List<BustaPaga> buste = bDao.leggiTutteBustePaga(d);
		return buste;
	}

	// Lista tutte Buste paga
	public List<BustaPaga> getListBuste() {
		List<BustaPaga> buste = bDao.leggiTutteBustePaga();
		return buste;
	}

	// Eliminazione Buste paga
	public boolean eliminaBustaPagaConId(long id_b) {
		BustaPaga b = bDao.leggiBustaConId(id_b);
		return bDao.eliminaBustaPaga(b);
	}

	// RUBRICA
	// Creazione rubrica
	public boolean registraRubrica(String username) {
		Rubrica r = new Rubrica(username);
		return rDao.creaRubrica(r);
	}

	// Cerca rubrica con user
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

	// Lista Voci
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

}