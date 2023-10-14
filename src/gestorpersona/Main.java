/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorpersona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author sergi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        //ArrayList Personas
        ArrayList<Persona> personas = new ArrayList<Persona>();
        //Solamente 1 ArrayList para dia, mes, año
        ArrayList<Integer> fecha = new ArrayList<Integer>();




        //Menu

        //Cantidad de personas
        System.out.println("Ingrese la cantidad de personas que desea agregar: ");
        int cantidadPersonas = keyboard.nextInt();

        //Agregar personas
        for(int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese el nombre de la persona: ");
            String nombre = keyboard.next();

            System.out.println("Ingrese el apellido de la persona: ");
            String apellidos = keyboard.next();

            System.out.println("Ingrese la fecha de nacimiento de la persona: ");
            String fechaNacimiento = keyboard.next();
            int day = Integer.parseInt(fechaNacimiento.substring(0, 2));
            int month = Integer.parseInt(fechaNacimiento.substring(3, 5));
            int year = Integer.parseInt(fechaNacimiento.substring(6, 10));

            fecha.add(day);
            fecha.add(month);
            fecha.add(year);



            



            int sexo;
            do {
                System.out.println("Ingrese el sexo de la persona: " + nombre + " " + apellidos);
                System.out.println("1. Masculino");
                System.out.println("2. Femenino");
                sexo = keyboard.nextInt();
                
                if(sexo != 1 && sexo != 2) {
                    System.out.println("El sexo ingresado no es valido");
                    System.out.println("Por favor, ingrese un sexo valido");
                }
            } while(sexo != 1 && sexo != 2);

            personas.add(new Persona(nombre, apellidos, formatFecha(fechaNacimiento), sexo));

            }

        while(true) {
            System.out.println("Welcome to the Person Manager");
            System.out.println("1. Mostrar informacion de las personas");
            System.out.println("2. Mostrar informacion de las personas mayores de edad");
            System.out.println("3. Mostrar informacion de las personas menores de edad");
            System.out.println("4. Mostrar informacion de las personas de sexo masculino");
            System.out.println("5. Mostrar informacion de las personas de sexo femenino");
            System.out.println("6. Exit");


            int option = keyboard.nextInt();

            switch(option) {

                case 1:
                    System.out.println("Mostrar informacion de las personas");
                    for(int i = 0; i < personas.size(); i++) {
                        System.out.println("Nombre: " + personas.get(i).getNombre());
                        System.out.println("Apellidos: " + personas.get(i).getApellidos());
                        System.out.println("Fecha de nacimiento: " + personas.get(i).getFechaNacimiento());
                        System.out.println("Sexo: " + personas.get(i).getSexo());
                    }
                    break;

                case 2:
                    System.out.println("Mostrar informacion de las personas mayores de edad");
                    



                    break;
                    
                case 3:
                    System.out.println("Mostrar informacion de las personas menores de edad");
                    break;

                case 4:
                    System.out.println("Mostrar informacion de las personas de sexo masculino");
                    for(int i = 0; i < personas.size(); i++) {
                        if(personas.get(i).getSexo() == 1) {
                            System.out.println("Nombre: " + personas.get(i).getNombre());
                            System.out.println("Apellidos: " + personas.get(i).getApellidos());
                            System.out.println("Fecha de nacimiento: " + personas.get(i).getFechaNacimiento());
                            System.out.println("Sexo: " + personas.get(i).getSexo());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Mostrar informacion de las personas de sexo femenino");
                    for(int i = 0; i < personas.size(); i++) {
                        if(personas.get(i).getSexo() == 2) {
                            System.out.println("Nombre: " + personas.get(i).getNombre());
                            System.out.println("Apellidos: " + personas.get(i).getApellidos());
                            System.out.println("Fecha de nacimiento: " + personas.get(i).getFechaNacimiento());
                            System.out.println("Sexo: " + personas.get(i).getSexo());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
                    System.out.println("Please, select a valid option");
                    break;
            }
        }

        }

        //Formatear fecha
        static Date formatFecha(String fecha) {
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                return formatoFecha.parse(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("La fecha ingresada no es valida");
                System.out.println("Por favor, ingrese una fecha valida en el formato dd/MM/yyyy");
                return null;
            }

        
        // TODO code application logic here
    }
    
}
