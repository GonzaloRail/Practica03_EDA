import java.util.ArrayList;
import java.util.NoSuchElementException;

// Implementación del TAD Heap genérico
class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;
    
    public Heap() {
        heap = new ArrayList<>();
    }
    
    public void insert(T item) {
        heap.add(item); // Agrega el elemento al final del ArrayList
        siftUp(heap.size() - 1); // Reubica el elemento en el heap para mantener las propiedades del heap máximo
    }
    
    public T delete() {
        if (isEmpty()) {
            return null;
        }
        
        T root = heap.get(0); // El elemento de mayor prioridad es la raíz del heap
        T lastItem = heap.remove(heap.size() - 1); // Elimina el último elemento del ArrayList
        
        if (!isEmpty()) {
            heap.set(0, lastItem); // Coloca el último elemento como raíz del heap
            siftDown(0); // Reubica el elemento en el heap para mantener las propiedades del heap máximo
        }
        
        return root;
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        
        return heap.get(0); // Devuelve el elemento de mayor prioridad (raíz del heap)
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2; // Obtiene el índice del padre del elemento en la posición dada
        
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            // Mientras el elemento actual sea mayor que su padre, se intercambian y se actualizan los índices
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    
    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1; // Obtiene el índice del hijo izquierdo del elemento en la posición dada
        int rightChildIndex = 2 * index + 2; // Obtiene el índice del hijo derecho del elemento en la posición dada
        int largestChildIndex = index;
        
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestChildIndex)) > 0) {
            // Si el hijo izquierdo existe y es mayor que el elemento actual, se actualiza el índice del hijo mayor
            largestChildIndex = leftChildIndex;
        }
        
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestChildIndex)) > 0) {
            // Si el hijo derecho existe y es mayor que el elemento actual o el hijo izquierdo, se actualiza el índice del hijo mayor
            largestChildIndex = rightChildIndex;
        }
        
        if (largestChildIndex != index) {
            // Si el hijo mayor es distinto al elemento actual, se intercambian y se continúa reubicando
            swap(index, largestChildIndex);
            siftDown(largestChildIndex);
        }
    }
    
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}