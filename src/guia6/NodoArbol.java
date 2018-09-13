

package guia6;



public class NodoArbol <AnyType extends Comparable>
{
    private NodoArbol izq;
    private NodoArbol der;
    private AnyType dato;

    public NodoArbol(AnyType dato ) {
        this.dato = dato;
        this.izq=null;
        this.der=null;
    }
    
    

    public NodoArbol<AnyType> getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol<AnyType> izq) {
        this.izq = izq;
    }

    public NodoArbol<AnyType> getDer() {
        return der;
    }

    public void setDer(NodoArbol<AnyType> der) {
        this.der = der;
    }

    public AnyType getDato() {
        return dato;
    }

    public void setDato(AnyType dato) {
        this.dato = dato;
    }
    
    
    
    
    
}
