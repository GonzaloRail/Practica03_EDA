import java.util.ArrayList;

    public class MaxHeap<T extends Comparable<T>> {
        private ArrayList<T> heap; // ArrayList para almacenar los elementos del heap

        public MaxHeap() {
            heap = new ArrayList<>(); // Constructor que inicializa el ArrayList vacío
        }
        public int size() {
            return heap.size();
        }

        public T get(int index) {
            if (index >= 0 && index < heap.size()) {
                return heap.get(index);
            } else {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }
        public void insert(T element) {
            heap.add(element); // Agregar el elemento al final del ArrayList
            heapifyUp(heap.size() - 1); // Restaurar las propiedades del heap hacia arriba
        }

        public T removeMax() {
            if (isEmpty()) {
                return null;
            }

            T max = heap.get(0); // Obtener el elemento máximo (la raíz del heap)
            T lastElement = heap.remove(heap.size() - 1); // Obtener el último elemento del heap

            if (!isEmpty()) {
                heap.set(0, lastElement); // Reemplazar la raíz con el último elemento
                heapifyDown(0); // Restaurar las propiedades del heap hacia abajo
            }

            return max; // Devolver el elemento máximo
        }

        public boolean isEmpty() {
            return heap.isEmpty(); // Verificar si el heap está vacío
        }

        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2; // Obtener el índice del padre

            // Mover el elemento hacia arriba mientras sea mayor que su padre
            while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex); // Intercambiar el elemento con su padre
                index = parentIndex; // Actualizar el índice al del padre
                parentIndex = (index - 1) / 2; // Calcular el nuevo índice del padre
            }
        }

        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;  // Calcula el índice del hijo izquierdo
            int rightChildIndex = 2 * index + 2;  // Calcula el índice del hijo derecho
            int largestIndex = index;  // Inicialmente, asume que el nodo actual es el más grande

            // Comprueba si el hijo izquierdo existe y si es mayor que el nodo actual
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = leftChildIndex;  // Actualiza el índice del nodo más grande
            }

            // Comprueba si el hijo derecho existe y si es mayor que el nodo actual o el hijo izquierdo
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = rightChildIndex;  // Actualiza el índice del nodo más grande
            }

            // Si el índice del nodo más grande ha cambiado, intercambia el nodo actual con el nodo más grande y realiza heapifyDown en el nuevo índice
            if (largestIndex != index) {
                swap(index, largestIndex);
                heapifyDown(largestIndex);
            }
        }

        private void swap(int i, int j) {
            T temp = heap.get(i); // Obtener el elemento en la posición i
            heap.set(i, heap.get(j)); // Reemplazar el elemento en la posición i con el de la posición j
            heap.set(j, temp); // Reemplazar el elemento en la posición j con el temporal
        }
    }
