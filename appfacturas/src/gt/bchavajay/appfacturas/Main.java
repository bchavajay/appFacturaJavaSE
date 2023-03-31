package gt.bchavajay.appfacturas;

import gt.bchavajay.appfacturas.modelo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNit("12345678");
        cliente.setNombre("Bernabé");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura: ");
        Factura factura = new Factura(scanner.nextLine(),cliente);

        Producto producto;


        for (int i = 0; i < 2; i++) {
            producto = new Producto();
            System.out.print("Ingrese nombre del producto # " + producto.getCodigo() + ": ");
            producto.setNombre(scanner.nextLine());

            System.out.print("Ingrese precio del producto: ");
            producto.setPrecio(scanner.nextFloat());

            System.out.print("Ingrese cantidad: ");

            factura.addItemFactura(new ItemFactura(scanner.nextInt(),producto));

            System.out.println();

            scanner.nextLine();
        }

        System.out.println(factura.generarDetalle());
    }
}
