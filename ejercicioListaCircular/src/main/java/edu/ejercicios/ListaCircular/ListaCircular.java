package edu.ejercicios.ListaCircular;

public class ListaCircular {
    Nodo inicio;
    Nodo fin;
    int numDatos;

    public ListaCircular()
    {
        this.inicio=null;
        this.fin=null;
        this.numDatos=0;
    }

    public boolean estaVacia()
    {
        return inicio==null && fin==null;
    }

    public void agregarInicio(int dato)
    {
        if (estaVacia())
        {
            inicio= fin = new Nodo(dato, inicio);  //si esta vacia se crea el nodo al principio, y decimos que ese nodo apunta a inicio
        }
        else
        {
            inicio= new Nodo(dato, inicio); //decimos que inicio sera un nuevo nodo y apuntara al inicio
        }
        fin.setSiguiente(inicio); //aca decimos que fin apunte al inicio, de esta forma se completa el circulo
        numDatos++;
    }

    public void agregarAlFinal(int dato)
    {
        if (estaVacia())
        {
            inicio= fin = new Nodo(dato, inicio);  //si esta vacia se crea el nodo al principio, y decimos que ese nodo apunta a inicio
        }
        else
        {
            Nodo nuevo = new Nodo(dato, inicio);  //creamos el nuevo nodo y decimos que apunte al inicio
            fin.setSiguiente(nuevo); //ahora decimos que fin apunte al nuevo nodo creado
            fin=nuevo; //y por ultimo decimos que ahora fin sera el nuevo
        }
        numDatos++;
    }

    public String mostarInicio()
    {
        String salida="";
        if(! estaVacia())
        {
            Nodo aux= inicio;  //creamos el nodo auxiliar para recorrer la lista
            do {
                salida+= aux.getDato() + "\t";  //almacenamos el dato en el auxiliar y mostramos la salida
                aux= aux.getSiguiente();   //el auxiliar ira saltando al siguiente hasta llegar al fin
            }while(aux!=inicio);
        }
        return salida;
    }


    public void eleiminarInicio()
    {
        if (!estaVacia())
        {
            if(inicio==fin)  //significa que solo hay un nodo, por lo tanto procedemos a eliminarlo
            {
                inicio= fin= null;
            }
            else
            {
                inicio= inicio.getSiguiente(); //ahora el inicio sera el que estaba siguiente del inicio inicial
                fin.setSiguiente(inicio); //apuntamos al inicio nuevo
            }
            numDatos --;
        }
    }

    public boolean tieneCiclo(int posicion)
    {
        if (estaVacia() || posicion < 0 || posicion >= numDatos)
        {
            return false;  // retornara false porque la lista está vacía o la posición no es válida
        }
        Nodo turtle= inicio; //creamos 2 nodos auxiliares que nos serviran para recorrer la lista
        Nodo rabbit= inicio; //movemos los 2 nodos auxiliares al inicio
        for (int i = 0; i < posicion; i++)  //el nodo rabbit se posicionara en la posicon indicada
        {
            rabbit = rabbit.getSiguiente();
        }
        while (rabbit != null && rabbit.getSiguiente() != null) { // el nodo auxiliar "rabbit" debe ir 2 posiciones por delante del turtle
            turtle = turtle.getSiguiente();                       // (si existe ciclo deberan juntarse en algun momento)
            rabbit = rabbit.getSiguiente().getSiguiente();
            if (turtle == rabbit)   // Si los nodos auxiliares se llegan a enlazar significa que si hay ciclo
            {
                return true;
            }
        }
        return false;   // Si el nodo auxiliar "rabbit" alcanza el final de la lista no hay ciclo
    }

    public int getNumDatos() {
        return numDatos;
    }

    public void setNumDatos(int numDatos) {
        this.numDatos = numDatos;
    }
}