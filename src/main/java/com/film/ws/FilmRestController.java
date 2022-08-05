package com.film.ws;

import java.util.ArrayList;
import java.util.List;

import com.film.dao.FilmDao;
import com.film.daoimpl.FilmDaoImpl;
import com.film.model.Film;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/film")
@Api(value = "FilmRest", tags = "Servizio Rest Per I Film ")
public class FilmRestController {
	List<Film> filmslist = new ArrayList<Film>();

	@ApiOperation(value = "Registrazione Nuovo Film", notes = "Permette la Registrazione di un Nuovo Film", response = String.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Inserimento Effettuato!") })
	@PostMapping("/insert")
	public ResponseEntity<String> save(@RequestBody Film f) {
		filmslist.add(f);
		FilmDao filmDao = new FilmDaoImpl();
		filmDao.save(f);
		return new ResponseEntity<String>("Inserimento effettuato", HttpStatus.OK);
	}

	
	@ApiOperation(value = "Ricerca di tutti i film", notes = "Permette la Ricerca di tutti i film prodotti da un determinato regista", response = String.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ricerca effettuato!") })
	@GetMapping("/findbyregista/{producer}")
	public ResponseEntity<List<Film>> findByProducer(@PathVariable String producer) {
		FilmDao filmDao = new FilmDaoImpl();
		List<Film> f = filmDao.getByProducer(producer);
		return new ResponseEntity<List<Film>>(f, HttpStatus.OK);
	}

	@ApiOperation(value = "Eliminazione di un film", notes = "Permette l'eliminazione di un film conoscendo il suo id", response = String.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "film eliminato con successo!") })
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id) {
		FilmDao filmDao = new FilmDaoImpl();
		filmDao.deleteFilm(id);
		return new ResponseEntity<String>("Eliminazione effettuata con successo", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateFilm(@RequestBody Film f,@PathVariable Long id){
		FilmDao filmDao=new FilmDaoImpl();
		filmDao.updateFilm(f,id);
		return new ResponseEntity<String>("Aggiornamento effettuato",HttpStatus.ACCEPTED);
		
	}

}
