import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {

    private static final String NOMBRE_ARCHIVO = "operaciones.json";

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private final Type LISTA_OPERACION_TYPE = new TypeToken<List<Operacion>>() {}.getType();

    public void guardarOperacion(Operacion operacion) {
        List<Operacion> listaOperaciones = leerOperaciones();

        listaOperaciones.add(operacion);

        escribirOperaciones(listaOperaciones);
    }

    private List<Operacion> leerOperaciones() {
        List<Operacion> lista = new ArrayList<>();

        try (FileReader reader = new FileReader(NOMBRE_ARCHIVO)) {
            lista = gson.fromJson(reader, LISTA_OPERACION_TYPE);

            if (lista == null) {
                lista = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de operaciones.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer el archivo de operaciones.");
        }

        return lista;
    }

    private void escribirOperaciones(List<Operacion> listaOperaciones) {
        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO)) {
            gson.toJson(listaOperaciones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
