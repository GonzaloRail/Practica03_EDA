import java.util.ArrayList;

public class PriorityQueueHeap<T extends Comparable<T>> {
    private MaxHeap<T> heap; // Utilizamos la clase MaxHeap para almacenar los elementos

    public PriorityQueueHeap() {
        heap = new MaxHeap<>(); // Creamos una instancia del MaxHeap
    }

    public void enqueue(T element) {
        heap.insert(element); // Insertamos el elemento en el heap (sin considerar la prioridad)
        // No es necesario reubicar el elemento según su prioridad ya que MaxHeap se encargará de mantener el orden máximo.
    }

    public T dequeue() {
        return heap.removeMax(); // Eliminamos el elemento de mayor prioridad (máximo) del heap
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0); // Obtenemos el elemento de mayor prioridad (máximo) del heap
    }

    public T back() {
        if (isEmpty()) {
            return null;
        }

        int lastIndex = heap.size() - 1;
        T minAgeElement = heap.get(0); // Obtener el primer elemento como el de menor edad

        for (int i = 1; i <= lastIndex; i++) {
            T currentElement = heap.get(i);
            if (currentElement.compareTo(minAgeElement) < 0) {
                minAgeElement = currentElement;
            }
        }

        return minAgeElement;
    }
    
    
    
    
    
    

    public boolean isEmpty() {
        return heap.isEmpty(); // Verificamos si el heap está vacío
    }
}
