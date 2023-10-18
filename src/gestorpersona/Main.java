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
import java.util.Calendar;
import java.util.Locale;

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
                        
                        // Calcular la edad con la fecha de nacimiento
                        System.out.println("Edad: " + calcularEdad(personas.get(i).getFechaNacimiento()));
                        
                        System.out.println("Sexo: " + personas.get(i).getSexo());
                    }
                    break;

                case 2:
                    System.out.println("Mostrar informacion de las personas mayores de edad");
                    for(int i = 0; i < personas.size(); i++) {
                        if(isAdult(personas.get(i).getFechaNacimiento(), new Date())) {
                            System.out.println("Nombre: " + personas.get(i).getNombre());
                            System.out.println("Apellidos: " + personas.get(i).getApellidos());
                            System.out.println("Fecha de nacimiento: " + personas.get(i).getFechaNacimiento());
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(personas.get(i).getFechaNacimiento());
                            

                            System.out.println("Sexo: " + personas.get(i).getSexo());
                        }
                    }
                    



                    break;
                    
                case 3:
                    System.out.println("Mostrar informacion de las personas menores de edad");
                    for(int i = 0; i < personas.size(); i++) {
                        if(!isAdult(personas.get(i).getFechaNacimiento(), new Date())) {
                            System.out.println("Nombre: " + personas.get(i).getNombre());
                            System.out.println("Apellidos: " + personas.get(i).getApellidos());
                            System.out.println("Fecha de nacimiento: " + personas.get(i).getFechaNacimiento());
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(personas.get(i).getFechaNacimiento());
                            

                            System.out.println("Sexo: " + personas.get(i).getSexo());
                        }
                    }

                    break;

                case 4:
                    System.out.println("Mostrar informacion de las personas de sexo masculino");
                    for(int i = 0; i < personas.size(); i++) {
                        if(personas.get(i).getSexo() == 1) {
                            System.out.println("Nombre: " + personas.get(i).getNombre());
                            System.out.println("Apellidos: " + personas.get(i).getApellidos());
                            System.out.println("Fecha de nacimiento: " + personas.get(i).getFechaNacimiento());
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(personas.get(i).getFechaNacimiento());
                            System.out.println("Sexo Masculino: " + personas.get(i).getSexo());
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
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(personas.get(i).getFechaNacimiento());
                            System.out.println("Sexo Femenino: " + personas.get(i).getSexo());
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

        
        //Validar fecha
        static boolean isValidDate(int day, int month, int year) {
            if(day < 1 || day > 31) {
                return false;
            }

            if(month < 1 || month > 12) {
                return false;
            }

            if(year < 1900 || year > 2021) {
                return false;
            }

            return true;
        }

        //Validar año bisiesto

        static boolean isLeapYear(int year) {
            if(year % 4 == 0) {
                if(year % 100 == 0) {
                    if(year % 400 == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }

        //Validar si es mayor de edad

        static boolean isAdult(Date fechaNacimiento, Date now) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaNacimiento);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            calendar.setTime(now);
            int nowYear = calendar.get(Calendar.YEAR);
            int nowMonth = calendar.get(Calendar.MONTH);
            int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

            if(nowYear - year > 18) {
                return true;
            } else if(nowYear - year == 18) {
                if(nowMonth > month) {
                    return true;
                } else if(nowMonth == month) {
                    if(nowDay >= day) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }

        //Validar si es menor de edad



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

    // Calcular la edad con la fecha de nacimiento
    static int calcularEdad(Date fechaNacimiento) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaNacimiento);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(new Date());
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

        int edad = nowYear - year;

        if(nowMonth < month) {
            edad--;
        } else if(nowMonth == month) {
            if(nowDay < day) {
                edad--;
            }
        }

        return edad;
    }
    
}
