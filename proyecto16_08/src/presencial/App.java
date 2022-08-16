package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    //CREAMOS EL OBJETO LOGGER
    private static final Logger logger = Logger.getLogger(App.class);

    // creamos la lista de enteros. Una lista de integer que se llama listaEnteros
    private List<Integer> listaEnteros;

    // creamos el constructor de tipo público que crea nuevos objetos de tipo ArrayList()
    public App(){
        listaEnteros= new ArrayList<>();
    }

    // creamos el metodo para agregar enteros a la listaEnteros
     public void agregarEntero(Integer numero){
        listaEnteros.add(numero);
        // si tiene más de 5 elementos vamos a emitir un logger de tipo info
        if (listaEnteros.size()>5){
            //usamos el logger
            logger.info("La lista tiene más de cinco elementos. Tiene: "
                    + listaEnteros.size() + " elementos");
        }
     }

}
