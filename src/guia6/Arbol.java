package guia6;


public class Arbol <AnyType extends Comparable>
{
    private NodoArbol<AnyType> raiz;
    private int cont=0;
    
    
    public void insertar(AnyType d) throws Exception
    {
        if(raiz==null)
             raiz=new NodoArbol<AnyType>(d);
        insertar(d,raiz);
    }
    
    private void insertar(AnyType d,NodoArbol r) throws Exception
    {
        if(d.compareTo(r.getDato())>0)
        {
            if(r.getDer()!=null)
                insertar(d,r.getDer());
            
            else
            {
            r.setDer(new NodoArbol<AnyType>(d));
            
            }
            
        }
        
        else if(d.compareTo(r.getDato())<0)
        {
                if(r.getIzq()!=null)
                    insertar(d,r.getIzq());
                
                else
                    r.setIzq(new NodoArbol <AnyType>(d));
        }
         
        else
        {
          throw new Exception("El nodo ya existe");      
        }
        
    }
    
    public AnyType buscar(AnyType d) throws Exception
    {
        return buscar(d,raiz);
       
    }
    
    private AnyType buscar(AnyType d, NodoArbol<AnyType> r) throws Exception
    {
        if(r==null)
            throw new Exception("404");
        
        int comp=d.compareTo(r.getDato());
        if(comp==0)
        
            return r.getDato();
        
        if(comp>0)
            return buscar(d,r.getDer());
        
        else
        return buscar(d,r.getIzq());
    }
    
    public void borrar(AnyType d) throws Exception
    {
        borrar(d,raiz);
    }
    
    private NodoArbol<AnyType> borrar(AnyType d,NodoArbol<AnyType> r) throws Exception
    {
        if(r==null)
            throw new Exception("404");
        
        int comp=d.compareTo(r.getDato());
        if(comp==0)
        {
            insertar(r.getDer(),r.getIzq());
            return r.getDer();
        }
       
        if(comp>0)
        {
            r.setDer(borrar(d,r.getDer()));
            return r;
        }
            
        
        else
        {
            r.setIzq(borrar(d,r.getIzq()));
            return r;
        }
            
    }
    
    private void insertar(NodoArbol<AnyType> r, NodoArbol<AnyType> h ) throws Exception
    {
        int comp=r.getDato().compareTo(h.getDato());
        if(comp>0)
        {
            if(r.getDer()!=null)
                insertar(r.getDer(),h);
            else
                r.setDer(h);
            
            return;
        }
        
        else if(comp<0)
        {
                if(h.getIzq()!=null)
                    insertar(r.getIzq(),h);
                
                else
                    r.setIzq(h);
                
                return;
        }
         else
        
          throw new Exception("El nodo ya existe");      
          
    }
    
    public int altura()
    {
        return altura(raiz);
       
    }
    
   /* public int profundidad(AnyType d)
    {
        return profundidad(d,raiz);
    }
    */
    public int altura(NodoArbol <AnyType> raiz)
    {
        if(raiz.getDato()==null)
            return 0;
        
        int aizq=altura(raiz.getIzq());
        int ader=altura(raiz.getDer());
        
        if(aizq>ader)
           return 1+aizq;
        else
            return 1+ader;
        
    }
    
    public void inOrder()
    {
        inOrder(raiz);
    }
    
    public void preOrder()
    {
        preOrder(raiz);
    }
    
    public void postOrder()
    {
        postOrder(raiz);
    } 
    
    private void inOrder(NodoArbol <AnyType> r)
    {
        if(r==null)
            return;
        
        
        inOrder(r.getIzq());
        System.out.println(r.getDato());
        inOrder(r.getDer());
        
        
    }
    
    private void preOrder(NodoArbol<AnyType> r)
    {
        if(r==null)
            return;
        
        System.out.println(r.getDato());
        preOrder(r.getIzq());
        preOrder(r.getDer());
        
        
    }
    
     private void postOrder(NodoArbol<AnyType> r)
    {
        if(r==null)
            return;
        
        preOrder(r.getIzq());
        preOrder(r.getDer());
        System.out.println(r.getDato());
        
    }
            
}
