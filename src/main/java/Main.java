import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.addtoLinkedList( "romomu", 1);
        hashMap.addtoLinkedList( "tom0", 100);
        hashMap.addtoLinkedList( "ohh", 1);
        hashMap.addtoLinkedList( "0 uu", 100);
        hashMap.addtoLinkedList( "o   mu", 1);
        hashMap.addtoLinkedList( "0 yu", 100);
        hashMap.addtoLinkedList( "domu", 1);
        hashMap.addtoLinkedList( "tt10uu", 100);
        hashMap.addtoLinkedList( "rrr2omu", 1);
        hashMap.addtoLinkedList( "30uu", 100);
        hashMap.addtoLinkedList( "i4omu", 1);
        hashMap.addtoLinkedList( "o   50uu", 100);
        hashMap.addtoLinkedList( "6omu", 1);
        hashMap.addtoLinkedList( "70uu", 100);
        hashMap.remove("0uu");

        int counter = 1;
        LinkedList<KeyValue>[] buckets  = hashMap.getAll();
        for(LinkedList<KeyValue> bucket : buckets){
            System.out.println("bucket "+counter+": "+bucket);
            counter++;
        }

        System.out.println("\n");
        System.out.println( hashMap.getValue("romomu") );
        System.out.println( hashMap.getValue("tt10uu") );

        hashMap.clearAll();

        int counter2 = 1;
        LinkedList<KeyValue>[] buckets2  = hashMap.getAll();
        System.out.println("\n");
        for(LinkedList<KeyValue> bucket : buckets2){
            System.out.println("bucket "+counter2+": "+bucket);
            counter2++;
        }

    }
}
