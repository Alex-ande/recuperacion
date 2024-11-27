package Controllers;
import Models.Persona;

/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
 
 public class PersonaController {
 
     
     public void ordenarPorEdadDesc(Persona[] personas) {
         for (int i = 0; i < personas.length - 1; i++) {
             int minimo = i;
             for (int j = i + 1; j < personas.length; j++) {
                 if (personas[j].getEdad() > personas[minimo].getEdad()) {
                     minimo = j;
                 }
             }
             // Intercambiar
             Persona temp = personas[i];
             personas[i] = personas[minimo];
             personas[minimo] = temp;
         }
     }
 
     
     public int buscarPorEdad(Persona[] personas, int edad) {
         int inicio = 0, fin = personas.length - 1;
         while (inicio <= fin) {
             int medio = inicio + (fin - inicio) / 2;
             if (personas[medio].getEdad() == edad) {
                 return medio;
             } else if (personas[medio].getEdad() > edad) {
                 inicio = medio + 1;
             } else {
                 fin = medio - 1;
             }
         }
         return -1; 
     }
 
     
     public void ordenarPorNombreAsc(Persona[] personas) {
         for (int i = 1; i < personas.length; i++) {
             Persona key = personas[i];
             int j = i - 1;
             while (j >= 0 && personas[j].getNombre().compareTo(key.getNombre()) > 0) {
                 personas[j + 1] = personas[j];
                 j--;
             }
             personas[j + 1] = key;
         }
     }
 
     
     public int buscarPorNombre(Persona[] personas, String nombre) {
         int inicio = 0, fin = personas.length - 1;
         while (inicio <= fin) {
             int medio = inicio + (fin - inicio) / 2;
             int comparacion = personas[medio].getNombre().compareTo(nombre);
             if (comparacion == 0) {
                 return medio;
             } else if (comparacion < 0) {
                 inicio = medio + 1;
             } else {
                 fin = medio - 1;
             }
         }
         return -1; 
     }
 }
 
