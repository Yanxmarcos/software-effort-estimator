package proyectotopicos;

final class EntradaNumerica {

    private EntradaNumerica() {
    }

    static double noNegativa(String texto, String campo) {
        double valor;
        try {
            valor = Double.parseDouble(texto.trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(campo + ": ingresa un número válido.");
        }
        if (!Double.isFinite(valor) || valor < 0) {
            throw new IllegalArgumentException(campo + ": ingresa un número finito mayor o igual a cero.");
        }
        return valor;
    }

    static long cantidad(String texto, String campo) {
        double valor = noNegativa(texto, campo);
        if (valor != Math.floor(valor) || valor > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(campo + ": ingresa una cantidad entera válida.");
        }
        return (long) valor;
    }
}
