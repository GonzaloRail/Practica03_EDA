public class TestClass {
    public static void main(String[] args) {
        // Crear el PriorityQueueHeap de tipo Persona
        PriorityQueueHeap<Persona> priorityQueue = new PriorityQueueHeap<>();

        // Crear diez personas con edades desordenadas
        Persona p1 = new Persona("Juan", "Perez", 25);
        Persona p2 = new Persona("Maria", "Gomez", 30);
        Persona p3 = new Persona("Pedro", "Lopez", 20);
        Persona p4 = new Persona("Laura", "Rodriguez", 35);
        Persona p5 = new Persona("Carlos", "Gonzalez", 28);
        Persona p6 = new Persona("Ana", "Martinez", 22);
        Persona p7 = new Persona("Luis", "Hernandez", 31);
        Persona p8 = new Persona("Sofia", "Sanchez", 27);
        Persona p9 = new Persona("Diego", "Torres", 33);
        Persona p10 = new Persona("Valeria", "Rios", 24);

        // Añadir las personas al PriorityQueueHeap
        priorityQueue.enqueue(p1);
        priorityQueue.enqueue(p2);
        priorityQueue.enqueue(p3);
        priorityQueue.enqueue(p4);
        priorityQueue.enqueue(p5);
        priorityQueue.enqueue(p6);
        priorityQueue.enqueue(p7);
        priorityQueue.enqueue(p8);
        priorityQueue.enqueue(p9);
        priorityQueue.enqueue(p10);

        // Probar los métodos de PriorityQueueHeap
        System.out.println("Elemento de mayor prioridad: " + priorityQueue.front());
        System.out.println("Elemento de menor prioridad: " + priorityQueue.back());

        System.out.println("Desencolando elementos:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.dequeue());
        }
    }
}
