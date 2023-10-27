package store.view;

import store.controller.ControllerUtil;

public class ViewStoreUI {

    public static void menu() {

        System.out.println("Por favor, introduzca una opción disponible:");
        divider('-');
        System.out.println(" ");
        System.out.println("1 - Comprar productos disponibles ");
        System.out.println("2 - Ver lista de productos disponibles");
        System.out.println("3 - Mostrar detalle de la venta");
        System.out.println("4 - Agregar producto en la tienda");
        System.out.println("5 - Salir del programa");
        System.out.println("6 - Finalizar Venta Actual");
        System.out.println("7 - Registrar usuario");
        System.out.println("8 - Ver lista de usuario");
        System.out.println("9 - Reporte (listas de datos almacenadas)");
        System.out.println("10 - Registrar otra cosa....");
        System.out.println(" ");
    }

    public static void title(String title) {
        System.out.println(" ");
        divider('=');
        System.out.println(" ");
        System.out.println(title);
        divider('_');
        System.out.println(" ");
    }
    
    public static void message(String message){
        System.out.println(" ");
        divider('*');
        System.out.println(" ");
        System.out.println(message);
        System.out.println(" ");
        divider('*');
        System.out.println(" ");
    }


    private static void divider(char simbol) {
        System.out.println(String.format("%70s", "").replace(' ', simbol));
    }

    public static void getListMonth() {
        Integer contador = 0;
        for (String string : ControllerUtil.MES) {
            contador = contador + 1;
            System.out.println(contador.toString() + " - " + string);
        }
    }

}
