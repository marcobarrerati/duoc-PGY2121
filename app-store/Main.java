package store;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

import store.controller.ControllerStore;
import store.controller.ControllerUtil;
import store.model.Product;
import store.model.Sale;
import store.view.ViewStoreUI;

import java.awt.Toolkit;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] arg) {

        boolean storeUp = true;
        String inputTextKeyboard;
        Scanner objScanner = new Scanner(System.in);

        Product product = new Product();
        Sale sale = new Sale();
        ControllerStore store = new ControllerStore(product, sale);

        store.getProduct().addProduct(new Product("pc-1", "notebook", 800000, 50));
        store.getProduct().addProduct(new Product("tel-1", "teléfono", 180000, 30));

        System.out.println(" ");

        while (storeUp) {

            ViewStoreUI.title("Bienvenido a la Tienda Virtual");
            System.out.println("Versión 20211016, Puerto Montt, Chile");
            System.out.println(" ");
            ViewStoreUI.menu();

            inputTextKeyboard = objScanner.nextLine();

            try {

                switch (parseInt(inputTextKeyboard)) {
                    
                    case 5: 

                        storeUp = false;
                        ViewStoreUI.title("Hasta pronto !!");
                        objScanner.close();
                        break;

                    case 1: 

                        ViewStoreUI.title("Comprar Producto");
                        ViewStoreUI.message(
                                "Para elegir producto presione la tecla s, para volver el menú presione otra tecla");

                        store.printProduct();

                        String comprar = objScanner.nextLine();

                        while ("s".equals(comprar)) {

                            Boolean isProduct = false;
                            Product productoModificable = new Product();

                            System.out.println("Ingresa el código del producto");
                            String codigoIngresado = objScanner.nextLine();

                            for (Product prod : store.getProduct().getProducts()) {

                                if (prod.getCode().equals(codigoIngresado)) {
                                    isProduct = true;
                                    productoModificable = prod;
                                    break;
                                }

                            }

                            if (isProduct) {

                                System.out.println("Ingresa la cantidad que necesitas");
                                String quantity = objScanner.nextLine();

                                if (productoModificable.getStock() < parseInt(quantity)) {

                                    ViewStoreUI.title("La cantidad solicitada del producto : "
                                            + productoModificable.getName() + " supera el stock, solo quedan : "
                                            + productoModificable.getStock());

                                } else {

                                    productoModificable.updateStock(parseInt(quantity));
                                    Sale nuevaVenta = new Sale(productoModificable, parseInt(quantity));
                                    store.getSale().addSale(nuevaVenta);
                                    ViewStoreUI.message("Producto registrado en carro virtual");

                                }

                            } else {

                                ViewStoreUI
                                        .message("Producto no existe :( intenta con un código de producto disponible");
                                store.printProduct();

                            }

                            ViewStoreUI.message(
                                    "¿Necesita otro producto? presione la tecla s, para omitir presione otra tecla ");

                            comprar = objScanner.nextLine();

                            if ("s".equals(comprar)) {
                                store.printProduct();
                            }

                        }

                        break;

                    case 2: 

                        ViewStoreUI.title("Opción 2 - Producto  en la tienda");
                        store.printProduct();

                        break;
                    case 3: 

                        ViewStoreUI.title("Opción 3 - Detalle de la Venta");
                        store.printSale();

                        break;

                    case 4: 

                        Boolean productoValido = false;
                        ViewStoreUI.title("Opción 4 - Registrar producto");
                        Product newProduct = new Product();

                        while (!productoValido) {

                            try {

                                System.out.println("Código( texto y números)");
                                newProduct.setCode(objScanner.nextLine());
                                System.out.println("Nombre( texto y número)");
                                newProduct.setName(objScanner.nextLine());
                                System.out.println("Precio( solo números )");
                                newProduct.setPrice(parseInt(objScanner.nextLine()));
                                System.out.println("Stock del producto ( solo números )");
                                newProduct.setStock(parseInt(objScanner.nextLine()));
                                store.getProduct().addProduct(newProduct);
                                System.out.println(" ");
                                ViewStoreUI.message("Producto registrado en la tienda");
                                productoValido = true;

                            } catch (Exception e) {

                                ViewStoreUI
                                        .message("Algo esta mal intentalo respetando los tipos de datos solicitados4");
                                Toolkit.getDefaultToolkit().beep();

                            }

                        }

                        break;

                    case 6:

                        Boolean monthOk = false;
                        ViewStoreUI.title("Opción 6 - Cerrar venta actual");
                        ViewStoreUI.message("Ingresa el número del mes");
                        ViewStoreUI.getListMonth();

                        while (!monthOk) {

                            try {

                                inputTextKeyboard = objScanner.nextLine();

                                Integer monthIn = parseInt(inputTextKeyboard);
                                
                                if ("x".equals(inputTextKeyboard)) {
                                    monthOk = true;
                                    break;
                                }


                                if (monthIn >= 1 && monthIn <= 12) {

                                    store.getSale().setMonth(monthIn);

                                    System.out.println(ControllerUtil.MES[monthIn - 1]);

                                    monthOk = true;
                                    // continue...
                                    // cerrar la venta y almacenar para usar en reportes

                                } else {

                                    ViewStoreUI.message("Solo debes ingresar números entre el 1 y el 12");

                                }

                            } catch (Exception e) {

                                ViewStoreUI.message("Ingresa el número del mes o presiona x para cancelar");
                                Toolkit.getDefaultToolkit().beep();

                            }

                            ViewStoreUI.message("Todo: por implementar...");
                        }

                        break;

                    case 7:
                        ViewStoreUI.title("Opción 7 - Registrar Usuario");
                        ViewStoreUI.message("todo : por implementar");
                        break;
                    case 8:
                        ViewStoreUI.title("Opción 8 - Ver usuarios registrados");
                        ViewStoreUI.message("todo : por implementar");
                        break;
                    case 9:
                        ViewStoreUI.title("Opción 9 - Reportes (listas de datos almacenados) ");
                        ViewStoreUI.message("todo : por implementar");
                        break;
                    case 10:
                        ViewStoreUI.title("Opción 10 - Registrar otra cosa.... ");
                        ViewStoreUI.message("todo : por implementar");
                        break;

                    default:
                        
                }

            } catch (NumberFormatException e) {

                ViewStoreUI.message("Ingresa un número del menú");
                Toolkit.getDefaultToolkit().beep();

            }

            if (storeUp) {

                ViewStoreUI.message("Presiona una tecla para continuar");
                objScanner.nextLine();

            }

        }

    }    

}
