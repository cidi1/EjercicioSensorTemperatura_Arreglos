import java.util.Scanner;
static int leerIndice(Scanner sc, int cantidad) {
    if (cantidad == 0) {
        System.out.println("Aún no hay sensores ingresados.");
        return -1;
    }
    System.out.print("Ingrese el índice (0 a " + (cantidad - 1) + "): ");
    int i = Integer.parseInt(sc.nextLine());
    if (i < 0 || i >= cantidad) {
        System.out.println("Índice fuera de rango.");
        return -1;
    }
    return i;
}
void main(String[] args) {
    final int MAX = 3;
    SensorTemperatura sensores[] = new SensorTemperatura[MAX];
    Scanner sc = new Scanner(System.in);
    int indice = 0;
    int opc, i;

    do {
        System.out.println("\n--- SENSORES DE TEMPERATURA ---");
        System.out.println("1. Agregar un sensor");
        System.out.println("2. Cambiar valor actual");
        System.out.println("3. Cambiar unidad");
        System.out.println("4. Mostrar lectura de un sensor");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc) {
            case 1:
                if (indice < MAX) {
                    System.out.print("ID del sensor: ");
                    String id = sc.nextLine();
                    System.out.print("Valor actual: ");
                    double valor = Double.parseDouble(sc.nextLine());
                    System.out.print("Unidad (°C / °F / K): ");
                    String unidad = sc.nextLine();
                    sensores[indice++] = new SensorTemperatura(id, valor, unidad);
                } else System.out.println("No hay más memoria");
                break;
            case 2:
                i = leerIndice(sc, indice);
                if (i != -1) {
                    System.out.print("Nuevo valor: ");
                    sensores[i].setValorActual(Double.parseDouble(sc.nextLine()));
                }
                break;
            case 3:
                i = leerIndice(sc, indice);
                if (i != -1) {
                    System.out.print("Nueva unidad: ");
                    sensores[i].setUnidad(sc.nextLine());
                }
                break;
            case 4:
                i = leerIndice(sc, indice);
                if (i != -1) sensores[i].mostrarLectura();
                break;
            case 0: System.out.println("Fin del programa."); break;
            default: System.out.println("Opción inválida.");
        }
    } while (opc != 0);
}
