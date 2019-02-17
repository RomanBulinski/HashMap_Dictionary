import java.util.Arrays;
import java.util.LinkedList;

public class HashMap<K, V> {

    private int bucketsSize = 6;

    // This holds all the data. Its a primitive array where every element is a Linked List.
    // They Linked List holds buckets of type KeyValue
    private LinkedList<KeyValue>[] buckets = new LinkedList[bucketsSize];

    public void addtoLinkedList(K key,V value) {
        int position = getHash(key);
        LinkedList<KeyValue> bucket = buckets[position];

        if(bucket==null){
            LinkedList<KeyValue> newbucket = new LinkedList<KeyValue>();
            newbucket.add(new KeyValue(key,value));
            buckets[position] = newbucket;
        }
        if(bucket!=null) {
            for (int i=0; i<bucket.size(); i++) {
                KeyValue element = bucket.get(i);
                if ( element.getKeyOfkv() == key) {
                    throw new IllegalArgumentException("key already exists error"); // or update this record
                }
                KeyValue newkv  = new KeyValue(key, value);
                bucket.add(newkv);
                break;
            }
        }
        resizeIfNeeded();
    }


    public V getValue( K key ) {
        V result=null;
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<KeyValue> bucket = buckets[i];
            if( bucket != null ){
                for (KeyValue kv : bucket) {
                    K tempKey = (K) kv.getKeyOfkv();
                    if (tempKey.equals(key)) {
                        result = (V)kv.getValueOfkv();
                    }
                }
            }
        }
        return result;
    }


    private int getHash(K key) {
        int N = bucketsSize-1;
        int uniqInt = key.hashCode() % N;
        int uniqIntABS = Math.abs(uniqInt);
        return uniqIntABS;
    }

    private void resizeIfNeeded(){
        int volume=0;
        for( LinkedList<KeyValue> bucket : buckets){
            if(bucket!= null){
                volume++;
            }
        }
        if (  (bucketsSize*3)/4 < volume ){
            bucketsSize = bucketsSize*2;
            buckets = Arrays.copyOf(buckets, buckets.length * 2 );
        }
//        if (  (bucketsSize*3)/4 > volume ){
//            bucketsSize = bucketsSize*2;
//            buckets = Arrays.copyOf(buckets, buckets.length / 2 );
//        }
    }

    public void remove(K key){
        for(int i =0; i<buckets.length; i++){
            LinkedList<KeyValue> bucket = buckets[i];
            if(bucket!=null){
                for (KeyValue kv : bucket) {
                    K tempKey = (K)kv.getKeyOfkv();
                    if (tempKey.equals( key )){
                        bucket.remove(kv);
                        System.out.println(" Object with  key : "+key+", was removed.");
                    }
                }
            }
        }
    }

    public void clearAll(){
        for(int i =0; i<buckets.length; i++){
            buckets[i]=null;
        }
    }

    public LinkedList<KeyValue>[] getAll(){
        return buckets;
    }

}
