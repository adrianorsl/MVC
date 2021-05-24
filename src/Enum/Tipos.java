package Enum;
import com.classes.Persistencia;
import com.classes.Json;
import com.classes.XML;
import com.classes.CSV;
import com.classes.AlunoBO;

public enum Tipos  {

	JSON (new Json()), 
	XML (new XML()),
	CSV (new CSV()),
	BD (new AlunoBO());
	
	
	private Persistencia persistencia;
	
	private Tipos(Persistencia persistencia) {
		this.persistencia = persistencia;
	}


	public Persistencia getPersistencia() {
		return persistencia;
	}
}
